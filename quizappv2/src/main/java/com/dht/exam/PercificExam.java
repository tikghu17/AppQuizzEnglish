/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.exam;

import com.dht.pojo.Question;
import com.dht.pojo.QuestionQueryBuilder;
import com.dht.services.questions.QuestionFacade;


import java.sql.SQLException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class PercificExam  implements  ExamStrategy{

    private int num;

    public PercificExam(int num) {
        this.num = num;
    }
    public PercificExam(String num) {
        this(Integer.parseInt(num));
    }
    @Override
    public List<Question> getQuestion() {
        try {
            QuestionQueryBuilder query = new QuestionQueryBuilder().setLimit(this.num).setOrderBy(" rand() ");
            return QuestionFacade.getQuestions(query);
        } catch (SQLException ex) {
            Logger.getLogger(PercificExam.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
