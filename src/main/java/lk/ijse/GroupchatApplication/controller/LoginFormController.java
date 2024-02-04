package lk.ijse.GroupchatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lk.ijse.GroupchatApplication.client.Client;
import lk.ijse.GroupchatApplication.model.UserModel;
import lk.ijse.GroupchatApplication.server.Server;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {

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
                if(isExist) {

                    Client client = new Client(username);
                    Thread thread = new Thread(client);
                    thread.start();
                    txtUserName.clear();

                }else{
                    new Alert(Alert.AlertType.ERROR,"user not exist");
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

    @SneakyThrows
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Server server = Server.getServerSocket();
        Thread thread = new Thread(server);
        thread.start();
    }
}
