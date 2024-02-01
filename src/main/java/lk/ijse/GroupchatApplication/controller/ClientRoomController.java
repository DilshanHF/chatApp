package lk.ijse.GroupchatApplication.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.GroupchatApplication.client.Client;

public class ClientRoomController {

    @FXML
    private AnchorPane emojiAnchorpane;

    @FXML
    private GridPane emojiGridpane;

    @FXML
    private Label lblName;

    @FXML
    private Label lblName1;

    @FXML
    private Pane pane;

    @FXML
    private Pane pane1;

    @FXML
    private ImageView profileView;

    @FXML
    private AnchorPane root;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ImageView themeView;

    @FXML
    private VBox vBox;
    @FXML
    private TextField txtMsgArea;

    public static void leaveChat() {
    }

    @FXML
    void btnEmojiOnAction(ActionEvent event) {

    }

    @FXML
    void btnImageOnClick(ActionEvent event) {

    }

    @FXML
    void btnOnSendMsg(ActionEvent event) {

    }

    @FXML
    void themeViewOnAction(MouseEvent event) {

    }

    public void writeMessage(String message) {
    }

    public void setClient(Client client) {
    }

    public void setImage(byte[] bytes, String utf) {
    }
}
