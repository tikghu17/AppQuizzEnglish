/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizappv2;

import com.dht.exam.ExamTypes;
import com.dht.exam.PercificExam;
import com.dht.pojo.Question;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class LuyenthiController implements Initializable {

    @FXML private ComboBox<ExamTypes> cbExamTypes;
    @FXML private  ListView<Question> lvQuestions;
    private List<Question> dsQuestion;
    @FXML private TextField txtNum;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbExamTypes.setItems(FXCollections.observableArrayList(ExamTypes.values()));
    }    
    public void start(ActionEvent e){
        
    }
    
}
