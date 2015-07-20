/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import las.db_utilities.DBConnection;
import las.db_utilities.DBHandler;
import las.models.NominatedSuccessor;

/**
 *
 * @author Gimhani
 */
public class NominatedSuccessorController {
    public static NominatedSuccessor searchNominateSuccessor(String NICS) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from NominatedSuccessor where NIC_S='" + NICS+ "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            NominatedSuccessor nominateSuccessor = new NominatedSuccessor(rst.getString("NIC_S"), rst.getString("Name"), rst.getString("Address"));
            return nominateSuccessor;
        } else {
            return null;
        }
    }
}
