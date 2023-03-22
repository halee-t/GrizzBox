import javafx.css.converter.StringConverter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Controller {
    @FXML
    public TextField respond;
    @FXML
    public Button submit;
    @FXML
    public Label title;
    @FXML
    public Button join;
    @FXML
    public Button start;
    @FXML
    public Text prompt = new Text();
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    Prompt prompts = new Prompt();

    public Controller() throws FileNotFoundException {
    }



    @FXML
    public void returnToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void create(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("lobbyPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void start(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("response.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void show(ActionEvent event){
        prompt.setText(prompts.getPrompt());

    }
}
