package com.thanh.appquizzenglishv2;

import com.thanh.quizzappv2.MyAlert;
import com.thanh.quizzappv2.theme.themeColor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;



public class PrimaryController  implements Initializable{
    @FXML private  ComboBox<themeColor> themeCl;
    
@Override
    public void initialize(URL url, ResourceBundle rb) {
        this.themeCl.setItems(FXCollections.observableArrayList(themeColor.values()));
    }
   public void manageQuestions(ActionEvent e){
       MyAlert.getInstance().showAlert("Comming soon ...");
   }
    public void practice(ActionEvent e){
              MyAlert.getInstance().showAlert("Comming soon ...");

   } 
    public void exam(ActionEvent e){
              MyAlert.getInstance().showAlert("Comming soon ...");

   }
    public void changTheme(ActionEvent e){
        switch (this.themeCl.getSelectionModel().getSelectedItem()) {
            case DARK:
                this.themeCl.getScene().getRoot().getStylesheets().clear();
                this.themeCl.getScene().getRoot().getStylesheets().add(App.class.getResource("Dark.css").toExternalForm());
                break;
                            case LIGHT:
                this.themeCl.getScene().getRoot().getStylesheets().clear();
                this.themeCl.getScene().getRoot().getStylesheets().add(App.class.getResource("Light.css").toExternalForm());
                break;
            default:
                 this.themeCl.getScene().getRoot().getStylesheets().clear();
                this.themeCl.getScene().getRoot().getStylesheets().add(App.class.getResource("Style.css").toExternalForm());
        }
    }

    
}
