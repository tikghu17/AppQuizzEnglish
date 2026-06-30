/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services.questions;

import com.dht.utils.MyConnectSingleton;
import com.dht.pojo.Question;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServices {
    public List<Question> getQuestionServices() throws SQLException{
        List<Question> ds = new ArrayList<>();
        String sql = "Select * From question";
        Statement st = MyConnectSingleton.getInstance().connect().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            ds.add(new Question.QuestionBuilder().setID(rs.getInt(1)).setContent(rs.getString(2)).build());
        }
        return ds;
        
    }
}
