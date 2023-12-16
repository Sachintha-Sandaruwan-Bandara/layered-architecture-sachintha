package com.example.layeredarchitecture.dao;
/* 
    @author Sachi_S_Bandara
    @created 12/16/2023 - 10:50 AM 
*/

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl {
    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

        ArrayList<CustomerDTO> CustomerList = new ArrayList<>();

        while (rst.next()) {
            CustomerList.add(new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")

            ));

        }
        return CustomerList;
    }

    public boolean saveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, customer.getId());
        pstm.setString(2, customer.getName());
        pstm.setString(3, customer.getAddress());

        boolean b = pstm.executeUpdate() > 0;

        return b;


    }
}

