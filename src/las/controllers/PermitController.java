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
import las.models.Lot;
import las.models.NominatedSuccessor;
import las.models.Permit;

/**
 * //
 *
 *
 * @author Gimhani
 */
public class PermitController {

    public static boolean addNewPermit(Permit permit) throws ClassNotFoundException, SQLException {

        boolean returnStatue = true;
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        try {
            boolean addNewNominateSuccessor = NominatedSuccessorController.addNewNominateSuccessor(permit.getNominatedSuccessor());
            if (addNewNominateSuccessor) {
                System.out.println("nominate succssor added");
                String sql = "Insert into permit Values('" + permit.getPermitNumber() + "','" + permit.getPermitIssueDate() + "','" + permit.getLot().getLotNumber() + "','" + permit.getClient().getNIC() + "','" + permit.getNominatedSuccessor().getNIC_S() + "')";
                int returnPermitInsert = DBHandler.setData(conn, sql);
                if (returnPermitInsert > 0) {
                    System.out.println("permit added");
                    Client client = permit.getClient();
                    // int position = ClientController.getnextOwnershiPositionPermit(permit.getPermitNumber());
                    client.setPermitOwnershipPosition(1);
                    int updateClient = ClientController.updateClient(client);
                    if (updateClient > 0) {
                        System.out.println("client updated");
                        Lot lot = permit.getLot();
                        // int position = ClientController.getnextOwnershiPositionPermit(permit.getPermitNumber());
                        //1 mean not avialabel
                        lot.setIsAvilable(1);
                        boolean updateLot = LotController.updateLot(lot);
                        if (updateLot) {
                            System.out.println("lot updated");
                            returnStatue = true;
                        } else {
                            returnStatue = false;
                            conn.rollback();
                        }
                    } else {
                        returnStatue = false;
                        conn.rollback();
                    }
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

    public static boolean cancelPermit(Permit permit) throws ClassNotFoundException, SQLException {

        boolean returnStatue = true;
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        try {
            String sql = "Delete  from permit where permitNumber = '" + permit.getPermitNumber() + "'";
            int returnPermitDelete = DBHandler.setData(conn, sql);
            if (returnPermitDelete > 0) {
                System.out.println("permit delete");
                Client client = permit.getClient();
                // int position = ClientController.getnextOwnershiPositionPermit(permit.getPermitNumber());
                client.setPermitOwnershipPosition(0);
                int updateClient = ClientController.updateClient(client);
                if (updateClient > 0) {
                    System.out.println("client updated");

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

    public static Permit searchPermit(String permitNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Permit where PermitNumber='" + permitNumber + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Client client = ClientController.searchClient(rst.getString("NIC"));
            Lot searchLot = LotController.searchLot(rst.getString("LotNumber"));
            NominatedSuccessor searchNominateSuccessor = NominatedSuccessorController.searchNominateSuccessor(rst.getString("NIC_Successor"));
            Permit permit = new Permit(rst.getString("PermitNumber"), rst.getString("PermitIssueDate"), searchLot, client, searchNominateSuccessor);
            return permit;
        } else {
            return null;
        }
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

    public static ArrayList<Permit> getSimilarPermitNumbers(String permitNumberPart) throws ClassNotFoundException, SQLException {
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

    public static ArrayList<Permit> getAllPermit() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From permit";
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

    //*******************************************//
    public static int updatePermit(Permit permit)throws ClassNotFoundException, SQLException {
        //updatePermit in database
        Connection conn = DBConnection.getDBConnection().getConnection();
      /*  String sql = "Update  Permit Set  permitNo='" +permit.getPermitNumber() + "','" + permit.getPermitIssueDate() + "','" + permit.getLot().getLotNumber() + "','" + permit.getClient().getNIC() + "','" + permit.getNominatedSuccessor().getNIC_S() + "')";
        int res = DBHandler.setData(conn, sql);
         */
        int res=0;
        return res;
    }
    
    
    
    
    
    
    
    
    
}
