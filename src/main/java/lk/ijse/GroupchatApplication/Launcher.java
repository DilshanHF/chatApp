package lk.ijse.GroupchatApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/login.fxml"))));
        stage.setTitle("login");
       // stage.getIcons().add(new Image("img/logo.png"));
        stage.centerOnScreen();
        stage.show();
    }
}
