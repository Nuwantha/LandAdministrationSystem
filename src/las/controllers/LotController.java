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
public class LotController {
     public static boolean addNewLot(Lot lot) throws ClassNotFoundException, SQLException {
        Connection conn=DBConnection.getDBConnection().getConnection();
        String sql = "Insert into Lot Values('" + lot.getLotNumber() + "','" + lot.getNumberOfAcres() + "','" + lot.getNumberOfPerches() + "','" + lot.getNumberofRoods() + "','" + lot.getLand().getPlanNumber() + "')" ;  
        int returnValue = DBHandler.setData(conn, sql);         
        return returnValue>0;
    }
    
    
    public static Lot searchLot(String lotNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Lot where LotNumber='" + lotNumber+ "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Land searchLand = LandController.searchLand(rst.getString("PlanNumber"));
            Lot lot = new Lot(rst.getString("LotNumber"), rst.getInt("NumberOfAcres"), rst.getInt("NumberOfRoods"), rst.getInt("NumberOfPerches"), searchLand);
            return lot;
        } else {
            return null;
        }
    }
    
    public static ArrayList<Lot> searchLotOfLand(String planNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Lot where planNumber='" + planNumber+ "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Lot> lotList=new ArrayList();
        while(rst.next()) {
            Lot lot = new Lot(rst.getString("LotNumber"), rst.getInt("NumberOfAcres"), rst.getInt("NumberOfRoods"), rst.getInt("NumberOfPerches"));
            lotList.add(lot);
        } 
        return lotList;
    }
    
     public static boolean updateLot(Lot lot) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Update  Lot Set  NumberOfAcres='"+lot.getNumberOfAcres()+"', NumberOfPerches='"+lot.getNumberOfPerches()+"',NumberofRoods='"+lot.getNumberofRoods()+"' Where  LotNumber='"+lot.getLotNumber()+"'";
        int res = DBHandler.setData(conn, sql);
        return res>0;
    }
    
      public static Lot getLastAddedLot() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From Lot order by lotNumber Desc limit 1";
        ResultSet rst = DBHandler.getData(conn, sql);
        if(rst.next()){
            Land Land = LandController.searchLand(rst.getString("PlanNumber"));
            Lot lot = new Lot(rst.getString("LotNumber"), rst.getInt("NumberOfAcres"), rst.getInt("NumberOfPerches"), rst.getInt("NumberOfRoods"),Land);
            return lot;
        }else{
            return null;
        }
      }
    
}
