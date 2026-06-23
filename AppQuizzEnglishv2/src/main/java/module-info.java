module com.thanh.appquizzenglishv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.thanh to javafx.fxml;
    exports com.thanh.appquizzenglishv2;
}
