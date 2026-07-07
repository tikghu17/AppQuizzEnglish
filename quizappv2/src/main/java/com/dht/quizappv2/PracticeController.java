/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizappv2;

import com.dht.pojo.Category;
import com.dht.pojo.Level;
import com.dht.pojo.Question;
import com.dht.pojo.QuestionQueyBuilder;
import com.dht.services.questions.QuestionServices;
import com.dht.utils.Configs;
import java.io.ObjectInputFilter;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author admin
 */
public class PracticeController implements Initializable {
    @FXML private ComboBox<Category> dscat;
    @FXML private ComboBox<Level> dslevel;
    private List<Question> questons;
    @FXML private Label lblcontent;
@FXML TextField txtLimit;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.dscat.setItems(FXCollections.observableList(Configs.ct.getCase()));
            this.dslevel.setItems(FXCollections.observableList(Configs.levelServices.getCase()));
        } catch (SQLException ex) {
            Logger.getLogger(PracticeController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }    
    public void start(ActionEvent e) throws SQLException{
        QuestionQueyBuilder query = new QuestionQueyBuilder().setLimit(this.txtLimit.getText()).
                widthCategory(this.dscat.getSelectionModel().getSelectedItem()).widthLevel(this.dslevel.getSelectionModel().getSelectedItem());
        Configs.questionServices.setQuery(query);
        this.questons = Configs.questionServices.getQuestionServices();
           
        
    }
    
}
