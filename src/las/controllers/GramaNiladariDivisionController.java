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
import las.models.GramaNiladariDivision;

/**
 *
 * @author Gimhani
 */
public class GramaNiladariDivisionController {
    
        
    public static boolean addNewGND(GramaNiladariDivision GND) throws ClassNotFoundException, SQLException { 
        Connection conn=DBConnection.getDBConnection().getConnection();
        String sql = "Insert into GND Values('" + GND.getDivisionNumber() + "','" + GND.getDivisionName() + "','" + GND.getGramaNilardariName() + "','" + GND.getZoneName() + "'"; 
        int returnValue = DBHandler.setData(conn, sql);        
        return returnValue>0;
    }
    public static GramaNiladariDivision searchGND(String DivisionNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from GND where DivisionNumber='" + DivisionNumber+ "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            GramaNiladariDivision GND = new GramaNiladariDivision(rst.getString("DivisionNumber"), rst.getString("DivisionName"), rst.getString("ZoneName"), rst.getString("GramaNiladariName"));
             return GND;
        } else {
            return null;
        }
    }
    
    public static ArrayList<GramaNiladariDivision> getSimmilarGndDivisionNumbers(String divisionNumberPart) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From GND where divisionNumber like '"+divisionNumberPart+"%'  order by divisionNumber limit 10";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<GramaNiladariDivision> GNDList = new ArrayList<>();
        while (rst.next()) {
            GramaNiladariDivision GND = new GramaNiladariDivision(rst.getString("DivisionNumber"), rst.getString("DivisionName"), rst.getString("ZoneName"), rst.getString("GramaNiladariName"));
            GNDList.add(GND);
        }
        return GNDList;
    }

    
    
    
    public static boolean updateGND(GramaNiladariDivision GND) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getDBConnection().getConnection();
        String sql ="Update GND set DivisionName='"+GND.getDivisionName()+"', GramaNiladariName= '"+GND.getGramaNilardariName()+"',ZoneName='"+GND.getZoneName()+"' Where DivisionNumber ='"+GND.getDivisionNumber()+"'";
        int returnV = DBHandler.setData(connection, sql);
        return returnV>0;
               
    }
    
    public static ArrayList<GramaNiladariDivision> getAllGNDDetail() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From GND";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<GramaNiladariDivision> GNDList = new ArrayList<>();
        while (rst.next()) {
            GramaNiladariDivision GND = new GramaNiladariDivision(rst.getString("DivisionNumber"), rst.getString("DivisionName"), rst.getString("ZoneName"), rst.getString("GramaNiladariName"));
            GNDList.add(GND);
        }
        return GNDList;
    }

}
