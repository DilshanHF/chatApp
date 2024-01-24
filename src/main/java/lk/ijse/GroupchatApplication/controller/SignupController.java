package lk.ijse.GroupchatApplication.controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class SignupController {
    public ImageView themeView;
    @FXML
    private Pane pane;

    @FXML
    private AnchorPane root;



    public void theamViewOnAction(MouseEvent mouseEvent) {
        if(themeView.getImage().getUrl().equals(new Image("img/light.png").getUrl())){
            root.setStyle("-fx-background-color: #fefae0;");
            /*textArea.getStyleClass().removeAll("dark-text");
            textArea.getStyleClass().add("light-text");*/
            pane.setStyle("-fx-background-color: #2a9a84;");
            themeView.setImage(new Image("img/dark.png"));
        }else{
            root.setStyle("-fx-background-color:  #2f3e46;");
            /*textArea.getStyleClass().removeAll("light-text");
            textArea.getStyleClass().add("dark-text");*/
            pane.setStyle("-fx-background-color: transparent;");
            themeView.setImage(new Image("img/light.png"));;
        }

    }
}
