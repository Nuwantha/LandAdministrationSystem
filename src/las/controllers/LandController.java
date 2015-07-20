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

/**
 *
 * @author Gimhani
 */
public class LandController {
    public static boolean addNewLand(Land land) throws ClassNotFoundException, SQLException {
        
        Connection conn=DBConnection.getDBConnection().getConnection();
        String sql = "Insert into Land Values('" + land.getPlanNumber() + "','" + land.getLandName() + "','" + land.getDivisionNumber() + "','" + land.getWestBound() + "','" + land.getEastBound() + "','" + land.getNorthBound()+ "','" +land.getSouthBound()+ "'" ;
        int returnValue = DBHandler.setData(conn, sql);         
        return returnValue>0;
    }
    
      public static boolean updateClient(Land land) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Update  Client Set  landName='"+land.getLandName()+"', DivisionNumber='"+land.getDivisionNumber()+"',WestBound='"+land.getWestBound()+"', EastBound='"+land.getEastBound()+"', NorthBound='"+land.getNorthBound()+"', SounthBound='"+land.getSouthBound()+"' where PlanNumber ='"+land.getPlanNumber()+"'";
        int res = DBHandler.setData(conn, sql);
        return res>0;
    } 
      //to create next plan number
      public static Land getLastAddedLand() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From Land order by PlanNumber Desc limit 1";
        ResultSet rst = DBHandler.getData(conn, sql);
        if(rst.next()){
            Land land = new Land(rst.getString("PlanNumber"), rst.getString("LandName"), rst.getString("DivisionNumber"), rst.getString("WestBound"), rst.getString("EastBound"), rst.getString("NorthBound"), rst.getString("SouthBound"));
            return land;
        }else{
            return null;
        }
      }
            
    public static Land searchLand(String PlanNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From Land where PlanNumber = '"+PlanNumber+"'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if(rst.next()){
            Land land = new Land(rst.getString("PlanNumber"), rst.getString("LandName"), rst.getString("DivisionNumber"), rst.getString("WestBound"), rst.getString("EastBound"), rst.getString("NorthBound"), rst.getString("SouthBound"));
            return land;
        }else{
            return null;
        }
          
    }
    
    public static ArrayList<Land> allLandDetail() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select PlanNumber,LandName,DivisionNumber,WestBound,EastBound,SouthBound,NorthBound,count(LotNumber) as NumberOfLots  From Land natural join lot group by PlanNumber";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Land> landlist=new ArrayList<>();
        while(rst.next()){
            Land land = new Land(rst.getString("PlanNumber"), rst.getString("LandName"), rst.getString("DivisionNumber"), rst.getString("WestBound"), rst.getString("EastBound"), rst.getString("NorthBound"), rst.getString("SouthBound"),rst.getInt("NumberOfLots"));
            landlist.add(land);
        }
        return landlist;
    }
    
     
}
