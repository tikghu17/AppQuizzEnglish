/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

import com.dht.pojo.Category;
import com.dht.utils.MyConnSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CategoryServices extends QueryServiceBase<Category>{
   

    @Override
    public List<Category> getResultSet(ResultSet rs) {
        try {
            List<Category> cates = new ArrayList<>();
            while (rs.next()) {
                try {
                    cates.add(new Category(rs.getInt("id"), rs.getString("name")));
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryServices.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            return cates;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public PreparedStatement getStm() {
        try {
            String sql = "Select * from category ";
            return MyConnSingleton.getInstance().connect().prepareCall(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
