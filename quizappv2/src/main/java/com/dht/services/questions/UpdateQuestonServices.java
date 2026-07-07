/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services.questions;

import com.dht.pojo.Choice;
import com.dht.pojo.Question;
import com.dht.utils.MyConnectSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author admin
 */
public class UpdateQuestonServices {
    public void addQuestions(Question q , List<Choice> choices) throws SQLException{
        
       Connection conn= MyConnectSingleton.getInstance().connect();
       conn.setAutoCommit(false);
       String sql = "Insert Into question(content, category_id,level_id) Values(?,?,?)";
       PreparedStatement stm= conn.prepareCall(sql);
       stm.setString(1 , q.getContent());
       stm.setInt(2, q.getCategory().getId());
       stm.setInt(3, q.getLevel().getId());
       int r = stm.executeUpdate();
       if(r >0){
           ResultSet rs = stm.getGeneratedKeys();
           if(rs.next()){
               int qId= rs.getInt(1);
                sql = "Insert Into choice(content, is_correct,question_id) Values(?,?,?)";
                stm = conn.prepareCall(sql);
                for(var c:choices)
                {
                    stm.setString(1, c.getContent());
                    stm.setBoolean(2, c.isIsCorrect());
                    stm.setInt(3, qId);
                    stm.executeUpdate();
                } 
                conn.commit();
           }
       
       }
          
    }
}
