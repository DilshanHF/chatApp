package lk.ijse.GroupchatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Pane pane;

    @FXML
    private Pane pane1;

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView themeView;

    @FXML
    private TextField txtUserName;

    @FXML
    void btnOnLogin(ActionEvent event) {

    }

    @FXML
    void themeViewOnAction(MouseEvent event) {
        if(themeView.getImage().getUrl().equals(new Image("img/dark.png").getUrl())){
            root.setStyle("-fx-background-color: #193948;");
            pane1.setStyle("-fx-background-color: #193948;");
            pane.setStyle("-fx-background-color: #2f3e46;");
            label1.setTextFill(Color.web("#ffffff")); // This also sets the font color to white
            label2.setTextFill(Color.web("#ffffff")); // This also sets the font color to white
            themeView.setImage(new Image("img/light.png"));
        }else {
            root.setStyle("-fx-background-color:  #ffffff;");
            pane1.setStyle("-fx-background-color:  #ffffff ;");
            pane.setStyle("-fx-background-color:   #2f3e46;");
            label1.setTextFill(Color.web("#193948")); // This also sets the font color to white
            label2.setTextFill(Color.web("#193948"));
            themeView.setImage(new Image("img/dark.png"));;
        }
    }

    public void btnOnSignup(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(getClass().getResource("/view/signup.fxml")));
    }
}
