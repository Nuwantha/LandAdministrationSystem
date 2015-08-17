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
                String sql = "Insert into permit Values('" + permit.getPermitNumber() + "','" + permit.getPermitIssueDate() + "','" + permit.getLot().getLotNumber() + "','" + permit.getClient().getNIC() + "','" + permit.getNominatedSuccessor().getNIC_S() + "','" + permit.getHaveGrant() + "')";
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

    public static boolean changeNominatedSuccessorPermit(Permit permit, NominatedSuccessor newSuccessor) throws ClassNotFoundException, SQLException {

        boolean returnStatue = true;
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        try {
            boolean addNewNominateSuccessor = NominatedSuccessorController.addNewNominateSuccessor(newSuccessor);
            if (addNewNominateSuccessor) {
                System.err.println("new successor added");
                String sql = "Update permit set NIC_Successor ='" + newSuccessor.getNIC_S() + "' where permitNumber = '" + permit.getPermitNumber() + "'";
                int returnPermitDelete = DBHandler.setData(conn, sql);
                if (returnPermitDelete > 0) {
                    System.out.println("permit update");
                    NominatedSuccessor nominatedSuccessor = permit.getNominatedSuccessor();

                    boolean DeleteNominatedSuccessor = NominatedSuccessorController.DeleteNominatedSuccessor(nominatedSuccessor.getNIC_S());
                    if (DeleteNominatedSuccessor) {
                        System.out.println("old successsor deleted");

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
                    NominatedSuccessor nominatedSuccessor = permit.getNominatedSuccessor();
                    boolean cancelPermit = NominatedSuccessorController.DeleteNominatedSuccessor(nominatedSuccessor.getNIC_S());
                    if (cancelPermit) {
                        System.out.println("succer delete");
                        Lot lot = permit.getLot();
                        lot.setIsAvilable(0);
                        boolean updateLot = LotController.updateLot(lot);
                        if (updateLot) {
                            System.out.println("lotUpdated");
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

    public static Permit searchPermit(String permitNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Permit natural join client where PermitNumber='" + permitNumber + "' order by permitOwnershipPosition desc";
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

    public static Permit searchPermitByClient(String NIC) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Permit where NIC='" + NIC + "'";
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

    public static ArrayList<Permit> getSimilarPermitsByName(String namepart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from client right join permit on client.NIC=permit.NIC where ClientName like '%" + namepart + "%'";
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

    public static ArrayList<Permit> getSimilarPermitsByNIC(String nicpart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from client right join permit on client.NIC=permit.NIC where client.NIC like '%" + nicpart + "%'";
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

    public static ArrayList<Permit> getGrantHaventPermit(String permitNumberPart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From permit where haveGrant =0 and permitNumber like '" + permitNumberPart + "%'  order by permitNumber limit 10";
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
    public static boolean changePermitOwnership(Permit permit) throws ClassNotFoundException, SQLException {
        boolean returnStatue = true;
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        try {
            boolean addNewClient = ClientController.addNewClient(permit.getClient());
            if (addNewClient) {
                System.err.println("new client added");
                String sql = "Insert into permit Values('" + permit.getPermitNumber() + "','" + permit.getPermitIssueDate() + "','" + permit.getLot().getLotNumber() + "','" + permit.getClient().getNIC() + "','" + permit.getNominatedSuccessor().getNIC_S() + "','" + permit.getHaveGrant() + "')";
                int returnPermitInsert = DBHandler.setData(conn, sql);
                if (returnPermitInsert > 0) {
                    System.out.println("permit aded");

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
