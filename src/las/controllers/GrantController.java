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
        String sql = "Select * from Grant1 natural join client where grantNumber='" + grantNumber + "' order by GrantOwnerShipPosition desc ";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Permit searchPermit = PermitController.searchPermit(rst.getString("permitnumber"));
            Client client = ClientController.searchClient(rst.getString("NIC"));
            Lot searchLot = LotController.searchLot(rst.getString("LotNumber"));
            NominatedSuccessor searchNominateSuccessor = NominatedSuccessorController.searchNominateSuccessor(rst.getString("NIC_Successor"));
            Grant grant = new Grant(rst.getString("GrantNumber"), rst.getString("GrantIssueDate"), searchPermit, searchLot, client, searchNominateSuccessor);
            return grant;
        } else {
            return null;
        }
    }

    public static Grant searchGrantByClient(String NIC) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Grant1 where NIC='" +NIC + "'";
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
            String sql = "Insert into GRANT1 Values('" + grant.getGrantNumber() + "','" + grant.getGrantIssueDate() + "','" + grant.getPermit().getPermitNumber() + "','" + grant.getLot().getLotNumber() + "','" + grant.getClient().getNIC() + "','" + grant.getNominatedSuccessor().getNIC_S() + "')";
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

    
    public static int getGrantCountOfDivision(String divisionNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "select count(distinct grantNumber) as grantCount from grant1 natural join lot natural join land where divisionNumber ='" + divisionNumber + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        int grantCount = 0;
        if (rst.next()) {
            grantCount = rst.getInt("grantCount");

        }
        return grantCount;
    }

    public static ArrayList<Grant> getSimilarGrantNumbers(String grantNumberPart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From grant1 where grantNumber like '%" + grantNumberPart + "%'  order by grantNumber limit 10";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Grant> grantList = new ArrayList<>();
        while (rst.next()) {
            Permit searchPermit=PermitController.searchPermit(rst.getString("PermitNumber"));
            Client searchClient = ClientController.searchClient(rst.getString("NIC"));
            Lot searchLot = LotController.searchLot(rst.getString("LotNumber"));
            NominatedSuccessor searchNominateSuccessor = NominatedSuccessorController.searchNominateSuccessor(rst.getString("NIC_Successor"));
            Grant grant = new Grant(rst.getString("GrantNumber"), rst.getString("GrantIssueDate"),searchPermit, searchLot, searchClient, searchNominateSuccessor);
            grantList.add(grant);
        }
        return grantList;
    }
    
    public static ArrayList<Grant> getSimilarPermitNumberGrants(String permitNumberPart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From grant1 left join permit on grant1.permitnumber=permit.permitnumber where permitnumber like '%" + permitNumberPart + "%'  order by grantNumber";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Grant> grantList = new ArrayList<>();
        while (rst.next()) {
            Permit searchPermit=PermitController.searchPermit(rst.getString("PermitNumber"));
            Client searchClient = ClientController.searchClient(rst.getString("NIC"));
            Lot searchLot = LotController.searchLot(rst.getString("LotNumber"));
            NominatedSuccessor searchNominateSuccessor = NominatedSuccessorController.searchNominateSuccessor(rst.getString("NIC_Successor"));
            Grant grant = new Grant(rst.getString("GrantNumber"), rst.getString("GrantIssueDate"),searchPermit, searchLot, searchClient, searchNominateSuccessor);
            grantList.add(grant);
        }
        return grantList;
    }

    public static ArrayList<Grant> getSimilarGrantsByName(String namepart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from client right join grant1 on client.NIC=grant1.NIC where ClientName like '%"+namepart+"%'";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Grant> grantList = new ArrayList<>();
        while (rst.next()) {
            Client searchClient = ClientController.searchClient(rst.getString("NIC"));
            Lot searchLot = LotController.searchLot(rst.getString("LotNumber"));
            NominatedSuccessor searchNominateSuccessor = NominatedSuccessorController.searchNominateSuccessor(rst.getString("NIC_Successor"));
            Permit searchPermit = new Permit(rst.getString("PermitNumber"), rst.getString("PermitIssueDate"), searchLot, searchClient, searchNominateSuccessor);
            Grant grant = new Grant(rst.getString("GrantNumber"), rst.getString("GrantIssueDate"),searchPermit, searchLot, searchClient, searchNominateSuccessor);
            grantList.add(grant);
        }
        return grantList;
    }
    
    public static ArrayList<Grant> getSimilarPermitsByNIC(String nicpart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from client right join grant1 on client.NIC=grant1.NIC where grant1.NIC like '%"+nicpart+"%'";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Grant> grantList = new ArrayList<>();
        while (rst.next()) {
            Client searchClient = ClientController.searchClient(rst.getString("NIC"));
            Lot searchLot = LotController.searchLot(rst.getString("LotNumber"));
            NominatedSuccessor searchNominateSuccessor = NominatedSuccessorController.searchNominateSuccessor(rst.getString("NIC_Successor"));
            Permit searchPermit = new Permit(rst.getString("PermitNumber"), rst.getString("PermitIssueDate"), searchLot, searchClient, searchNominateSuccessor);
            Grant grant = new Grant(rst.getString("GrantNumber"), rst.getString("GrantIssueDate"),searchPermit, searchLot, searchClient, searchNominateSuccessor);
            grantList.add(grant);
        }
        return grantList;
    }
    
    
    
  public static boolean changeGrantOwnership(Grant grant) throws ClassNotFoundException, SQLException {
        boolean returnStatue = true;
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        try {
            boolean addNewClient = ClientController.addNewClient(grant.getClient());
            if (addNewClient) {
                System.err.println("new client added");
                String sql = "Insert into GRANT1 Values('" + grant.getGrantNumber() + "','" + grant.getGrantIssueDate() + "','" + grant.getPermit().getPermitNumber() + "','" + grant.getLot().getLotNumber() + "','" + grant.getClient().getNIC() + "','" + grant.getNominatedSuccessor().getNIC_S() + "')";
                int returnGrantInsert = DBHandler.setData(conn, sql);
                if (returnGrantInsert > 0) {
                    System.out.println("grant aded");

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

    
    
   
    
      
}
