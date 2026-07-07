/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services.questions;

import com.dht.pojo.Category;
import com.dht.pojo.Level;
import com.dht.utils.MyConnectSingleton;
import com.dht.pojo.Question;
import com.dht.pojo.QuestionQueyBuilder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServices {
    private QuestionQueyBuilder query;

    public QuestionServices(QuestionQueyBuilder query) {
        this.query = query;
    }

    public QuestionServices() {
    }
    
    
     public List<Question> getQuestionServices() throws SQLException{
//         String sql= "Select * From question Where 1=1";
//         List<Object> params  = new ArrayList<>();
//        
//         
//        
//          PreparedStatement stm = MyConnectSingleton.getInstance().connect().prepareCall(sql);
//          for(int i=0;i<params.size();i++)
//              stm.setObject(i+1, params.get(i));

     PreparedStatement stm  = this.query.build();
        ResultSet rs = stm.executeQuery();
         List<Question> questions = new ArrayList<>();
          while(rs.next()){
            questions.add(new Question.QuestionBuilder().setID(rs.getInt(1)).setContent(rs.getString(2)).build());
        }
          return questions;
     }

    /**
     * @param query the query to set
     */
    public void setQuery(QuestionQueyBuilder query) {
        this.query = query;
    }
}
