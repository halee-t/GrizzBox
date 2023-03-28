import java.io.*;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;

/*
    This class should be called as soon as the "submit" button is pressed
    Response will get the players response and store it in an array
 */
public class Responses {

     String response;
    //private String[] responseArray;
    int vote;
    private final int responseArraySize = 6;  //the max amount of players for our game is 6, each response will be stored at an index
     int responseIndex = 0;
    private Scanner inFS = null;
    private FileInputStream fileStringStream = null; //File input stream


    private boolean submitted = false;          //lets us know if the player has submitted their response or not
    /*
     idea: maybe do a submission count instead? when the count==#ofPlayers, then we are all set and the timer can stop
     increment submission count every time a response is stored
     might be easier to actually keep track
     have it work with whatever keeps track of the timer
     private int submission = 0;
  */

    String [] responses;

    public Responses(){
        this.responses=new String[6];

    }
    public void storeResponse(String response) {
        /*
            we might have to send the array as a parameter?
         */
        responses[responseIndex]=response;
        responseIndex++;


    }

    public String getResponse(int t) {



        return responses[t];
    }
    public void writeResponse(String respo){
        try {
            String data = " Tutorials Point is a best website in the world";
            File f1 = new File("Responses.txt");
            if(!f1.exists()) {
                f1.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(f1.getName(),true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(respo+"\n");
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void convertFileresponses() throws FileNotFoundException {
        int i =0;
        fileStringStream = new FileInputStream("Responses.txt");
        inFS = new Scanner(fileStringStream); //scanner to read text file

        while(inFS.hasNext()) { //iterates through file until no new text lines exist
            responses[i]=inFS.nextLine();
        }
    }
    public String getResponse(){
        return responses[0];

    }


}



