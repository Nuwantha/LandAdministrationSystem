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
import java.util.logging.Level;
import java.util.logging.Logger;
import las.db_utilities.DBConnection;
import las.db_utilities.DBHandler;
import las.models.Client;

/**
 *
 * @author Gimhani
 */
public class ClientController {

    public static int addNewClient(Client client) throws ClassNotFoundException {
        int returnvalue = 0;
        try {
            
            int result;
            DBConnection dbconn;
            Connection conn = null;
            
            dbconn = DBConnection.getDBConnection();
            conn = dbconn.getConnection();
            
            //conn.setAutoCommit(false);
            
            String sql = "Insert into Client Values('" + client.getNIC() + "','" + client.getClientName() + "','" + client.getBirthday() + "','" + client.getTelephone() + "','" + client.getAddress() + "','" + client.getAnnualIncome() + "','" + client.getGrantOwnershipPosition() + "','" + client.getPermitOwnershipPosition() + "','" + client.getNumberOfMarriedSons() + "','" + client.getNumberOfUnmarriedSons() + "');";
            
            result = DBHandler.setData(conn, sql);
            if (result > 0) {
               // conn.commit();
                returnvalue = 1;
            } else {
                //conn.rollback();
                returnvalue = 0;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnvalue;
    }

    public static Client searchClient(String NIC) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Client where NIC='" + NIC+ "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        if (rst.next()) {
            Client client = new Client(rst.getString("NIC"), rst.getString("ClientName"), rst.getString("Birthday"), rst.getString("Telephone"), rst.getString("Address"), rst.getDouble("AnnualIncome"), rst.getInt("GrantOwnershipPosition"),rst.getInt("PermitOwnershipPosition"),rst.getBoolean("MarriedStatus"),rst.getInt("NumberOfMarriedSons"),rst.getInt("NumberOfUnmarriedSons"));
            return client;
        } else {
            return null;
        }
    }


    public static boolean isAClient(String NIC) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from Client where NIC='" + NIC + "'";
        ResultSet rst = DBHandler.getData(conn, sql);
        boolean bool;
        Client client = null;
        if (rst.next()) {
            client = new Client(rst.getString("NIC"), rst.getString("ClientName"), rst.getString("Birthday"), rst.getString("Telephone"), rst.getString("Address"), rst.getDouble("AnnualIncome"), rst.getInt("GrantOwnershipPosition"),rst.getInt("PermitOwnershipPosition"),rst.getBoolean("MarriedStatus"),rst.getInt("NumberOfMarriedSons"),rst.getInt("NumberOfUnmarriedSons"));
            if (client != null) {
                bool = true;
            } else {
                bool = false;
            }
        } else {
            bool = false;
        }
        return bool;
    }

    public static int updateClient(Client client) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Update  Client Set NIC='"+client.getNIC()+"', clientName='"+client.getClientName()+"', Birthday='"+client.getBirthday()+"',Telephone='"+client.getTelephone()+"', Address='"+client.getAddress()+"', AnnualIncome='"+client.getAnnualIncome()+"', GrantOwnershipPosition='"+client.getGrantOwnershipPosition()+"',PermitOwnershipPosition='"+client.getPermitOwnershipPosition()+"',MarriedStatus='"+client.isMarried()+"',NumberOfMarriedSons='"+client.getNumberOfMarriedSons()+"',NumberOfUnmarriedSons='"+client.getNumberOfUnmarriedSons()+"'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static ArrayList<Client> getAllClients() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * From Student";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<Client> clientList = new ArrayList<>();
        while (rst.next()) {
            Client client = new Client(rst.getString("NIC"), rst.getString("ClientName"), rst.getString("Birthday"), rst.getString("Telephone"), rst.getString("Address"), rst.getDouble("AnnualIncome"), rst.getInt("GrantOwnershipPosition"),rst.getInt("PermitOwnershipPosition"),rst.getBoolean("MarriedStatus"),rst.getInt("NumberOfMarriedSons"),rst.getInt("NumberOfUnmarriedSons"));
            clientList.add(client);
        }
        return clientList;
    }

}
