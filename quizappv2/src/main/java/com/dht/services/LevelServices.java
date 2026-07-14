/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

import com.dht.pojo.Category;
import com.dht.pojo.Level;
import com.dht.utils.MyConnSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class LevelServices extends QueryServiceBase<Level>{
    
    
    @Override
    public List<Level> getResultSet(ResultSet rs) {
        
         List<Level> levels = new ArrayList<>();
        try {
            while (rs.next()) {
                try {
                    levels.add(new Level(rs.getInt("id"), rs.getString("name")));
                } catch (SQLException ex) {
                    Logger.getLogger(LevelServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LevelServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return levels;
    }

    @Override
    public PreparedStatement getStm() {
        try {
            String sql = "SELECT * FROM level";
            return MyConnSingleton.getInstance().connect().prepareCall(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LevelServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
       
    }
}
