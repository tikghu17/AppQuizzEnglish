/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.utils;

import com.dht.services.CategoryServices;
import com.dht.services.LevelServices;
import com.dht.services.questions.QuestionServices;
import com.dht.services.questions.UpdateQuestionServices;

/**
 *
 * @author admin
 */
public class Configs {
    public static final CategoryServices cateService = new CategoryServices();
    public static final LevelServices lvlService = new LevelServices();
    public static final QuestionServices questionService = new QuestionServices();
    public static final  UpdateQuestionServices uQuestionService = new UpdateQuestionServices();
     public static final String Cate_key = "categories"; 
     public static final String Lvl_key = "Levels";
     public static final double [] DoKho={0.4,0.4,0.4};
     public static final int SoLuongCau=10;

}
