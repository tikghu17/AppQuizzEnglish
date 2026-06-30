/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.dht.quizappv2;

import com.dht.pojo.Category;
import com.dht.pojo.Choice;
import com.dht.pojo.Level;
import com.dht.pojo.Question;
import com.dht.services.CategoryServices;
import com.dht.services.LevelServices;
import com.dht.services.questions.QuestionServices;
import com.dht.utils.Configs;
import java.net.URL;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;




/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {
        @FXML private TextArea txt;
        @FXML private TableView<Question>dsQuestion; 
        @FXML private ComboBox<Category> cbCates;
        @FXML private ComboBox<Level> cbLv;

        @FXML private VBox vchoices;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
           this.loadColumns();
          
            try {
                this.cbLv.setItems(FXCollections.observableList(Configs.levelServices.getCase()));
            } catch (SQLException ex) {
                Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                this.cbCates.setItems(FXCollections.observableList(Configs.ct.getCase()));
            } catch (SQLException ex) {
                Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try { 
                this.dsQuestion.setItems(FXCollections.observableList(Configs.questionServices.getQuestionServices()));
            } catch (SQLException ex) {
                Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
            }

            
     
        
    }    
    public void loadColumns(){
        
        TableColumn coldI= new TableColumn("Id");
        coldI.setCellValueFactory(new PropertyValueFactory("id"));
        coldI.setPrefWidth(80);
        TableColumn colContent= new TableColumn("Noi dung cau hoi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(80);
        this.dsQuestion.getColumns().addAll(coldI,colContent);
    }
    
    public void addChoice(){
        HBox h = new HBox();
        h.getStylesheets().add(".Containers");
        RadioButton rdo = new RadioButton();
        TextField txt = new TextField();
        txt.getStylesheets().add(".Input");
        h.getChildren().addAll(rdo,txt);
        this.vchoices.getChildren().add(h);
    }
    
    public void addQuestion(ActionEvent e) throws SQLException{
        Question q= new Question.QuestionBuilder().setContent(txt.getText()).
                setCategory(cbCates.getSelectionModel().getSelectedItem()).setLevel(
                cbLv.getSelectionModel().getSelectedItem())
                .build();
        List<Choice> dsChoice= new ArrayList<>();
        for (var hBox: this.vchoices.getChildren())
        {
            HBox h= (HBox) hBox;
            RadioButton rdb = (RadioButton) h.getChildren().get(0);
            TextField txtf= (TextField) h.getChildren().get(1);
            dsChoice.add(new Choice(txtf.getText(),rdb.isSelected()));
        }
       
             Configs.updateQuestonServices.addQuestions(q, dsChoice);
        
            
       
            
       
       
    }
}
