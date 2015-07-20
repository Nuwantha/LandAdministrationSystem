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
import las.models.Client;
import las.models.Lot;
import las.models.NominatedSuccessor;
import las.models.Permit;

/**
 *
 * @author Gimhani
 */
public class PermitController {
    public static Permit searchPermit(String permitNumber) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Permit where PermitNumber='" +permitNumber+ "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Client client = ClientController.searchClient(rst.getString("NIC"));
            Lot searchLot = LotController.searchLot(rst.getString("LotNumber"));
            NominatedSuccessor searchNominateSuccessor = NominatedSuccessorController.searchNominateSuccessor("NICS");
            Permit permit = new Permit(rst.getString("PermitNumber"), rst.getString("PermitIssueDate"), searchLot,client, searchNominateSuccessor);
            return permit;
        } else {
            return null;
        }
    }
}
