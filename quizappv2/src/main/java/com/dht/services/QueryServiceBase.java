/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.xml.transform.Result;

/**
 *
 * @author admin
 */
public  abstract class QueryServiceBase <T>{
    public List<T> list() throws SQLException{
      PreparedStatement stm = this.getStm();
        ResultSet rs =  stm.executeQuery();
        
        return  this.getResultSet(rs);
    }
    public  abstract List<T> getResultSet (ResultSet rs);
    public  abstract  PreparedStatement getStm();
}
