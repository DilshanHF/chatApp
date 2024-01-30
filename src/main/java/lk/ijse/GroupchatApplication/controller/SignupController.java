package lk.ijse.GroupchatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import lk.ijse.GroupchatApplication.dto.UserDto;
import lk.ijse.GroupchatApplication.model.UserModel;
import lk.ijse.GroupchatApplication.utill.SystemAlert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    public ImageView themeView;
    public Pane pane1;
    public ImageView imageView;
    public TextField txtId;
    public TextField txtUserName;
    public Label label1;
    public Label label2;
    @FXML
    private Pane pane;

    @FXML
    private AnchorPane root;

    private File file;






    public void themeViewOnAction(MouseEvent mouseEvent) {
        if(themeView.getImage().getUrl().equals(new Image("img/dark.png").getUrl())){
            root.setStyle("-fx-background-color: #193948;");
            pane.setStyle("-fx-background-color: #2f3e46;");
            pane1.setStyle("-fx-background-color: #193948;");
            label1.setTextFill(Color.web("#ffffff")); // This also sets the font color to white
            label2.setTextFill(Color.web("#ffffff")); // This also sets the font color to white
            themeView.setImage(new Image("img/light.png"));
        }else {
            root.setStyle("-fx-background-color:  #ffffff;");
            pane.setStyle("-fx-background-color:   #2f3e46;");
            pane1.setStyle("-fx-background-color:  #ffffff ;");
            themeView.setImage(new Image("img/dark.png"));;
        }
    }

    public void btnOnImageChoose(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select the image");
        FileChooser.ExtensionFilter imageFilter =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png", "*.gif", "*.bmp");
        fileChooser.getExtensionFilters().add(imageFilter);
        file = fileChooser.showOpenDialog(txtId.getScene().getWindow());
        if (file != null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                imageView.setImage(new Image(fileInputStream));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setImageView();
    }
    private void setImageView() {
        double cornerRadius = 20.20; // Set the desired corner radius
        Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip.setArcWidth(cornerRadius);
        clip.setArcHeight(cornerRadius);
        imageView.setClip(clip);
    }

    public void btnOnSignUp(ActionEvent actionEvent) {
        if(!(txtId.getText().isEmpty() || txtUserName.getText().isEmpty())){
            try {
                String id = txtId.getText();
                String name = txtUserName.getText();

                boolean isExist = UserModel.existUser(id,name);
                if(!isExist){
                    boolean isSaved;
                    if(file != null){
                        InputStream inputStream = new FileInputStream(file);
                        isSaved = UserModel.saveUser(new UserDto(id,name,inputStream));

                    }else {
                        isSaved = UserModel.saveUser(new UserDto(id,name,null));
                    }
                    if (isSaved){
                        new SystemAlert(Alert.AlertType.CONFIRMATION,"Confirmation","Signup successfully completed!", ButtonType.OK).show();
                    }else {
                        new SystemAlert(Alert.AlertType.WARNING,"Warning","Account is already exists",ButtonType.OK).show();
                    }

                }else {
                    new SystemAlert(Alert.AlertType.WARNING,"Warning","Please fill all details",ButtonType.OK).show();
                }
            } catch (SQLException | FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
