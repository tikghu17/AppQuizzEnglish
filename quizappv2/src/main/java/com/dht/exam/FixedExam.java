/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.exam;

import com.dht.pojo.Question;
import com.dht.pojo.QuestionQueryBuilder;
import com.dht.services.questions.QuestionFacade;
import com.dht.utils.Configs;
import java.io.ObjectInputFilter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class FixedExam implements ExamStrategy{

    @Override
    public List<Question> getQuestion() {
        List<Question> ds = new ArrayList<>();
        for(int i=0;i<Configs.DoKho.length;i++){
            try {
                QuestionQueryBuilder query = new QuestionQueryBuilder().setLimit((int)Configs.DoKho[i] * Configs.SoLuongCau ).setOrderBy("rand () ")
                        .widthLevel(i+1);
                ds.addAll(QuestionFacade.getQuestions(query));
            } catch (SQLException ex) {
                Logger.getLogger(FixedExam.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    return ds;
    }
    
}
