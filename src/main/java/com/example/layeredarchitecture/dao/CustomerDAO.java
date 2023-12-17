package com.example.layeredarchitecture.dao;
/* 
    @author Sachi_S_Bandara
    @created 12/16/2023 - 3:23 PM 
*/

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDTO> loadAllCustomers() throws SQLException, ClassNotFoundException;

    public boolean saveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException ;

    public boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    String generateCustomerId() throws SQLException, ClassNotFoundException;
}
