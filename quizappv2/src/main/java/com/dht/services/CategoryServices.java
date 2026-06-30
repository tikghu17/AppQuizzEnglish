/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

import com.dht.utils.MyConnectSingleton;
import com.dht.pojo.Category;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class CategoryServices {
   
    public List<Category> getCase() throws SQLException{
        String sql= "Select * from category";
        Statement st = MyConnectSingleton.getInstance().connect().createStatement();
        ResultSet rs= st.executeQuery(sql);
        List<Category> ds = new ArrayList<>();
        while(rs.next())
        {
            ds.add(new Category(rs.getInt("id"),rs.getString("name")));
            
        }
        return ds;
    }
    
    
}
