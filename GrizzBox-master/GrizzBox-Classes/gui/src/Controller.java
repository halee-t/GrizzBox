import javafx.css.converter.StringConverter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;


public class Controller extends Responses{
    @FXML
    public TextField respond;
    @FXML
    private Button Finish;
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
    public Label response1= new Label();
    public Button show;
    public Button voting;
    public Button ahhh;
    public Label code=new Label();
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    //Prompt prompts = new Prompt();
    GrizzBox gb = new GrizzBox();
    String Resp1;
    String Resp2;


    public Controller() throws FileNotFoundException {
    }

    public  String codegenerator() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;}



    @FXML
    public void returnToMain(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    public void EndGame(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("lobbyPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void create(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("lobbyPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
        String c = gb.getcode();
        code.setText(c);




    }
    @FXML
    public void start(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("response.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void beginVote(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("vote.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Finish(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("FinalScore.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    public void show(ActionEvent event){
        String s = gb.prompts.getPrompt();
        prompt.setText(s);


    }
    @FXML
    public void store(ActionEvent event) throws IOException {
        String s = respond.getText();

        responses[responseIndex]=s;
        writeResponse(s);
        root = FXMLLoader.load(getClass().getResource("vote.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();



    }
    @FXML
    public void dis(ActionEvent event) throws FileNotFoundException {
        convertFileresponses();
        String s = getResponse();
        response1.setText(s);
        
    }
}


