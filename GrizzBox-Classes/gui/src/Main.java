import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javafx.application.Application.launch;

public class Main extends Application {
    public void start(Stage stage) throws Exception {
        FileInputStream s=  new FileInputStream("Start Screen.jpg");
        Image image = new Image(s);
        ImageView iv = new ImageView();
        iv.setImage(image);

        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));//load resources from fxml file
        Scene scene = new Scene(root);//get scene from root
        stage.setTitle("GrizzBox");//set title to grizzbox
        stage.setScene(scene);//set scene
        stage.show();//show stage

    }
    public static void main(String[] args) throws FileNotFoundException {
        GrizzBox gb = new GrizzBox();
        launch(args);
    }
}