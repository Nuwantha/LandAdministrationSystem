/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import las.db_utilities.DBConnection;
import las.db_utilities.DBHandler;
import las.models.Client;
import las.models.Grant;
import las.models.Lot;
import las.models.NominatedSuccessor;
import las.models.Permit;

/**
 *
 * @author Gimhani
 */
public class GrantController {

    public static Grant searchGrant(String grantNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Grant where grantNumber='" + grantNumber + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Permit searchPermit = PermitController.searchPermit(rst.getString("permitnumber"));
            Client client = ClientController.searchClient(rst.getString("NIC"));
            Lot searchLot = LotController.searchLot(rst.getString("LotNumber"));
            NominatedSuccessor searchNominateSuccessor = NominatedSuccessorController.searchNominateSuccessor("NICS");
            Grant grant = new Grant(rst.getString("GrantNumber"), rst.getString("GrantIssueDate"), searchPermit, searchLot, client, searchNominateSuccessor);
            return grant;
        } else {
            return null;
        }
    }

    public static boolean addNewGrant(Grant grant) throws ClassNotFoundException, SQLException {

        boolean returnStatue;
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        try {
            String sql = "Insert into permit Values('" + grant.getGrantNumber() + "','" + grant.getGrantIssueDate() + "','" + grant.getPermit().getPermitNumber() + "','" + grant.getLot().getLotNumber() + "','" + grant.getClient().getNIC() + "','" + grant.getNominatedSuccessor().getNIC_S() + "')";
            int returnGrantInsert = DBHandler.setData(conn, sql);
            if (returnGrantInsert > 0) {
                Client client = grant.getClient();
                int position = ClientController.getnextOwnershiPositionGrant(grant.getGrantNumber());
                client.setPermitOwnershipPosition(position);
                int updateClient = ClientController.updateClient(client);
                if (updateClient > 0) {
                    returnStatue = true;
                } else {
                    returnStatue = false;
                    conn.rollback();
                }
            } else {
                returnStatue = false;
                conn.rollback();
            }
            if (returnStatue) {
                conn.commit();
            }
        } catch (SQLException sqlExeption) {
            returnStatue = false;
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }
        return returnStatue;
    }

    
    public static int getPermitCountOfDivision(String divisionNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "select count(distinct permitNumber) as permitCount from permit natural join lot natural join land where divisionNumber ='" + divisionNumber + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        int permitCount = 0;
        if (rst.next()) {
            permitCount = rst.getInt("permitCount");

        }
        return permitCount;
    }

    public static ArrayList<Permit> getSimmilarPlanNumbers(String permitNumberPart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From permit where permitNumber like '" + permitNumberPart + "%'  order by permitNumber limit 10";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Permit> permitList = new ArrayList<>();
        while (rst.next()) {
            Client searchClient = ClientController.searchClient(rst.getString("NIC"));
            Lot searchLot = LotController.searchLot(rst.getString("LotNumber"));
            NominatedSuccessor searchNominateSuccessor = NominatedSuccessorController.searchNominateSuccessor(rst.getString("NIC_Successor"));
            Permit permit = new Permit(rst.getString("PermitNumber"), rst.getString("PermitIssueDate"), searchLot, searchClient, searchNominateSuccessor);
            permitList.add(permit);
        }
        return permitList;
    }

}
