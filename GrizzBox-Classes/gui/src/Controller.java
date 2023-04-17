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

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Controller extends Responses{
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
    public Label response1= new Label();
    public Button show;
    public Button voting;
    public Button ahhh;
    public Label code=new Label();
    public Button addUser;
    public Label response2;
    public Label response3;
    public Label response4;
    public Label response5;
    public Label response6;
    public Label userprompt= new Label();
    public Button vote1;
    public Button vote2;
    public Button vote3;
    public Button vote4;
    public Button vote5;
    public Button vote6;
    public Button endGame;      //this is a change halee made in case it breaks :)
    public Label voteprompt;
    public Label first= new Label("");
    public Label second= new Label("");
    public Label third= new Label("");
    public Label fourth= new Label("");
    public Label fifth= new Label("");
    public Label sixth= new Label("");
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
    int [] votes= new int[6];
    int [] scores = new int[6];
    int [] leaderboard = new int[6];
    int iterator=1;


    BackgroundThread backgroundThread;
    int users = 0;
    Thread gameThread;


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

    public void addition(ActionEvent event){
        users++;
    }



    @FXML
    public void returnToMain(ActionEvent event) throws IOException {


        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void endGame(ActionEvent event) throws IOException {
        clearFile("RoundWinners.txt");
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
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
        //String c = gb.getcode();
       // code.setText(c);




    }
        @FXML
    public void start(ActionEvent event) throws IOException {
        backgroundThread = new BackgroundThread(users);
        gameThread = new Thread(backgroundThread);

        Parent root = FXMLLoader.load(getClass().getResource("response.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.show();
        userprompt.setText("user1 respond");



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
    public void show(ActionEvent event){
        String s = gb.prompts.getPrompt();
        prompt.setText(s);


    }
    @FXML
    public void store(ActionEvent event) throws IOException {
        iterator++;

        String s = respond.getText();
        responses[responseIndex] = s;
        writeResponse(s);
        userprompt.setText("user"+iterator+" respond");

        if(iterator==7) {
            root = FXMLLoader.load(getClass().getResource("vote.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
            stage.show();


        }
    }
    @FXML
    public void EndGame(ActionEvent event){

    }

    @FXML
    public void vote(ActionEvent event) throws IOException {
        iterator++;

        Node e =(Node)  event.getSource();
        String s = e.getId();
        System.out.println(s);
        switch(s){
            case "vote1":
                votes[0]++;
                break;
            case "vote2":
                votes[1]++;
                break;
            case"vote3":
                votes[2]++;
                break;
            case"vote4":
                votes[3]++;
                break;
            case "vote5":
                votes[4]++;
                break;
            case "vote6":
                votes[5]++;
                break;
        }
        voteprompt.setText("user"+iterator+" vote");
        if(iterator==7) {
            int l = findIndexOfMax(votes);
            l+=1;
            writeRoundWinner(l);
            System.out.println("winner of round: user"+(l));

            root = FXMLLoader.load(getClass().getResource("FinalScore.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
            stage.show();
            first.setText("user"+findWinner());



        }
    }
    public int countNumberOccurrences(int number) throws IOException {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("RoundWinners.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String n : numbers) {
                    if (Integer.parseInt(n) == number) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
    public static int[] sortAndGetIndices(int[] arr) {
        int[] indices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indices[i] = i;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    temp = indices[i];
                    indices[i] = indices[j];
                    indices[j] = temp;
                }
            }
        }
        return indices;
    }


    public void leaderboard() throws IOException {
        scores[0]=countNumberOccurrences(1);
        scores[1]=countNumberOccurrences(2);
        scores[2]=countNumberOccurrences(3);
        scores[3]=countNumberOccurrences(4);
        scores[4]=countNumberOccurrences(5);
        scores[5]=countNumberOccurrences(6);
        leaderboard=sortAndGetIndices(scores);
        first.setText("user"+(leaderboard[0]+1));
        second.setText("user"+(leaderboard[1]+1));
        third.setText("user"+(leaderboard[2]+1));
        fourth.setText("user"+(leaderboard[3]+1));
        fifth.setText("user"+(leaderboard[4]+1));
        sixth.setText("user"+(leaderboard[5]+1));


    }
    public int findWinner() throws IOException {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("RoundWinners.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String number : numbers) {
                    int n = Integer.parseInt(number);
                    frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
                }
            }
        }
        int mostFrequentNumber = Integer.MIN_VALUE;
        int maxFrequency = 0;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentNumber = entry.getKey();
            }
        }

        return mostFrequentNumber;
    }




    public int findIndexOfMax(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    @FXML
    public void dis(ActionEvent event) throws IOException {
        convertFileresponses();
        String s = removeAndReturnFirstLine();
        response1.setText(s);
        s = removeAndReturnFirstLine();
        response2.setText(s);
        s = removeAndReturnFirstLine();
        response3.setText(s);
        s = removeAndReturnFirstLine();
        response4.setText(s);
        s = removeAndReturnFirstLine();
        response5.setText(s);
        s = removeAndReturnFirstLine();
        response6.setText(s);

    }
    public static void clearFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
}
