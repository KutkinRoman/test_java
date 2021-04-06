package Chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    protected static Stage primaryStage;
    protected static Stage dialog;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        this.primaryStage = primaryStage;
        Scene s = new Scene(root);
        s.setFill(Color.TRANSPARENT);
        primaryStage.setScene(s);
        primaryStage.show();
        primaryStage.setOpacity(0.4);


        Stage dialog = new Stage();
        this.dialog = dialog;
        Parent rootdialog = FXMLLoader.load(getClass().getResource("dialog.fxml"));
        Scene d = new Scene(rootdialog);
        d.setFill(Color.TRANSPARENT);
        dialog.setScene(d);
        dialog.initStyle(StageStyle.TRANSPARENT);
        dialog.initOwner(primaryStage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
        dialog.setOpacity(0.9);



    }
    public static void main(String[] args) {
        launch(args);
    }

}
