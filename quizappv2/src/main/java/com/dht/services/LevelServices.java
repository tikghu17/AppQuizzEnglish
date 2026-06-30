/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

import com.dht.pojo.Level;
import com.dht.utils.MyConnectSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelServices {
     public List<Level> getCase() throws SQLException{
        String sql= "Select * from level";
        Statement st = MyConnectSingleton.getInstance().connect().createStatement();
        ResultSet rs= st.executeQuery(sql);
        List<Level> ds = new ArrayList<>();
        while(rs.next())
        {
            ds.add(new Level(rs.getInt(1),rs.getString(2)));
            
        }
        return ds;
    }
}
