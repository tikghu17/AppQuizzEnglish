module com.thanh.appquizzenglishv2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.thanh.appquizzenglishv2 to javafx.fxml;
    exports com.thanh.appquizzenglishv2;
}
