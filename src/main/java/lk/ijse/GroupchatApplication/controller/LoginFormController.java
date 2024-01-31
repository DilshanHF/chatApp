package lk.ijse.GroupchatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lk.ijse.GroupchatApplication.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;

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

    public static String username = "";

    @FXML
    void btnOnLogin(ActionEvent event) throws IOException {
            if(!txtUserName.getText().isEmpty()){
                username = txtUserName.getText();
                boolean isExist = false;
                try {
                     isExist = UserModel.existUser(username);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(isExist){
                   Stage stage = (Stage) txtUserName.getScene().getWindow();
                   stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/chatRoom.fxml"))));
                   stage.setTitle(username + "'s chat");
                  // stage.getIcons()
                    stage.setOnCloseRequest(windowEvent -> chatRoomController.leaveChat());
                    stage.show();
                }

            }



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

    public void txtOnAction(ActionEvent event) throws IOException {
        btnOnLogin(event);

    }
}
