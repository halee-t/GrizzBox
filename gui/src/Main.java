import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

import static javafx.application.Application.launch;

public class Main extends Application {
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));//load resources from fxml file
        Scene scene = new Scene(root);//get scene from root
        stage.setTitle("GrizzBox");//set title to calculator
        stage.setScene(scene);//set scene
        stage.show();//show stage

    }
    public static void main(String[] args) throws FileNotFoundException {
        launch(args);
    }
}