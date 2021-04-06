package Chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private VBox Window;
    @FXML
    private TextField log;
    @FXML
    private PasswordField pass;

    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private ListView listContacts;


    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    private static final String ADDRESS = "localhost";
    public static final int PORT = 8000;



    public void chatExit(ActionEvent actionEvent) {
        Main.primaryStage.close();
    }

    public void rollUp(ActionEvent actionEvent) throws InterruptedException {

        Main.primaryStage.setIconified(true);
    }


    public void listCon(ActionEvent actionEvent) {

        if (listContacts.getPrefWidth()==0){
            textArea.setPrefWidth(400);
            listContacts.setPrefWidth(190);
            listContacts.getItems().add("testCon");
        } else {
            listContacts.getItems().clear();
            textArea.setPrefWidth(590);
            listContacts.setPrefWidth(0);

        }

    }


    public void sendMsg(ActionEvent actionEvent) {
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void win() {
        Main.primaryStage.setX(Main.primaryStage.getX()+ 200);
        Main.primaryStage.setOpacity(0.8);
//        Main.primaryStage.setY(Main.primaryStage.getY()+ 10);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            socket = new Socket(ADDRESS, PORT);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() ->{
                    try {
                        while (true){
                            String str = in.readUTF();
                            if ("serveClosed".equals(str)){
                                break;
                            }
                            textArea.appendText(str + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void singIn(ActionEvent actionEvent) {
        log.setStyle("-fx-background-color: #800000");
        pass.setStyle("-fx-background-color: #800000");
        Main.dialog.setOpacity(1);
        System.out.println(log.getText() + "  " + pass.getText());
    }

    public void colorBtn(MouseEvent mouseEvent) {
        log.setStyle("-fx-background-color: #696969");
        pass.setStyle("-fx-background-color: #696969");
        Main.dialog.setOpacity(0.9);

    }

    public void testExit() {
        Main.dialog.close();
        Main.primaryStage.setOpacity(1);
    }
}
