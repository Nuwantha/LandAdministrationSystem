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
import las.models.Land;
import las.models.Lot;

/**
 *
 * @author Gimhani
 */
public class LandController {

    public static boolean addNewLand(Land land) throws ClassNotFoundException, SQLException {
        boolean returnValue = true;
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        try {
            String sql = "Insert into Land Values('" + land.getPlanNumber() + "','" + land.getLandName() + "','" + land.getDivisionNumber() + "','" + land.getWestBound() + "','" + land.getEastBound() + "','" + land.getNorthBound() + "','" + land.getSouthBound() + "')";
            int returnInt = DBHandler.setData(conn, sql);
            if (returnInt > 0) {
                System.out.println("land add");
                ArrayList<Lot> lotList = land.getLotList();
                for (Lot lot : lotList) {
                    System.out.println("lot added");
                    boolean addNewLot = LotController.addNewLot(lot);
                    if (!addNewLot) {
                        returnValue = false;
                        conn.rollback();
                        break;
                    }
                }
            } else {
                returnValue = false;
                conn.rollback();
            }
            if (returnValue) {
                conn.commit();
            }
        } catch (SQLException error) {
            error.printStackTrace();
            returnValue = false;
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return returnValue;
    }

  /*  public static boolean updateClient(Land land) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Update  Client Set  landName='" + land.getLandName() + "', DivisionNumber='" + land.getDivisionNumber() + "',WestBound='" + land.getWestBound() + "', EastBound='" + land.getEastBound() + "', NorthBound='" + land.getNorthBound() + "', SounthBound='" + land.getSouthBound() + "' where PlanNumber ='" + land.getPlanNumber() + "'";
        int res = DBHandler.setData(conn, sql);
        return res > 0;
    }
*/
    //to create next plan number
    public static Land getLastAddedLand() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From Land order by PlanNumber Desc limit 1";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Land land = new Land(rst.getString("PlanNumber"), rst.getString("LandName"), rst.getString("DivisionNumber"), rst.getString("WestBound"), rst.getString("EastBound"), rst.getString("NorthBound"), rst.getString("SouthBound"));
            return land;
        } else {
            return null;
        }
    }

    public static Land searchLand(String PlanNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From Land where PlanNumber = '" + PlanNumber + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            ArrayList<Lot> searchLotOfLand = LotController.searchLotOfLand(PlanNumber);
            Land land = new Land(rst.getString("PlanNumber"), rst.getString("LandName"), rst.getString("DivisionNumber"), rst.getString("WestBound"), rst.getString("EastBound"), rst.getString("NorthBound"), rst.getString("SouthBound"), searchLotOfLand);
            return land;
        } else {
            return null;
        }

    }

    public static ArrayList<Land> getAllLandDetail() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select PlanNumber,LandName,DivisionNumber,WestBound,EastBound,SouthBound,NorthBound,count(LotNumber) as NumberOfLots  From Land natural join lot group by PlanNumber";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Land> landlist = new ArrayList<>();
        while (rst.next()) {
            Land land = new Land(rst.getString("PlanNumber"), rst.getString("LandName"), rst.getString("DivisionNumber"), rst.getString("WestBound"), rst.getString("EastBound"), rst.getString("NorthBound"), rst.getString("SouthBound"), rst.getInt("NumberOfLots"));
            landlist.add(land);
        }
        return landlist;
    }

    public static ArrayList<Land> getSimmilarPlanNumbers(String planNumberPart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From land where planNumber like '" + planNumberPart + "%'  order by planNumber limit 10";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Land> landList = new ArrayList<>();
        while (rst.next()) {
            Land GND = new Land(rst.getString("planNumber"), rst.getString("landName"), rst.getString("DivisionNumber"), rst.getString("WestBound"), rst.getString("EastBound"), rst.getString("NorthBound"), rst.getString("SouthBound"));
            landList.add(GND);
        }
        return landList;
    }

    public static boolean updateLand(Land land) throws ClassNotFoundException, SQLException {
        boolean returnValue = true;
        Connection conn = DBConnection.getDBConnection().getConnection();
        conn.setAutoCommit(false);
        try {
            String sql = "Update  Land Set  LandName='" + land.getLandName() + "', DivisionNumber='" + land.getDivisionNumber() + "',EastBound='" + land.getEastBound() + "',WestBound='" + land.getWestBound() + "',NorthBound='" + land.getNorthBound() + "',SouthBound='" + land.getSouthBound() + "' Where  PlanNumber='" + land.getPlanNumber() + "'";
            int returnInt = DBHandler.setData(conn, sql);
            if (returnInt > 0) {
                System.out.println("land update");
                ArrayList<Lot> lotList = land.getLotList();
                for (Lot lot : lotList) {
                    System.out.println("lot update");
                    boolean updateLot = LotController.updateLot(lot);
                    if (!updateLot) {
                        returnValue = false;
                        conn.rollback();
                        break;
                    }
                }
            } else {
                returnValue = false;
                conn.rollback();
            }
            if (returnValue) {
                conn.commit();
            }
        } catch (SQLException error) {
            error.printStackTrace();
            returnValue = false;
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }

        return returnValue;
    }
}
