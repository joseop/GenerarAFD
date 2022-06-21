module com.generarafd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.generarafd to javafx.fxml;
    exports com.generarafd;
}