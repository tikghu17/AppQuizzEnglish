/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.utils;

import com.dht.services.CategoryServices;
import com.dht.services.LevelServices;
import com.dht.services.questions.QuestionServices;
import com.dht.services.questions.UpdateQuestonServices;

/**
 *
 * @author admin
 */
public class Configs {
  public static CategoryServices ct  = new CategoryServices();
        public static   LevelServices levelServices = new LevelServices();
           public static  QuestionServices questionServices = new QuestionServices();
           public  static UpdateQuestonServices updateQuestonServices = new UpdateQuestonServices();
}
