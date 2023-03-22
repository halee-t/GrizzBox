import java.util.Scanner;
/*
    This class should be called as soon as the "submit" button is pressed
    Response will get the players response and store it in an array
 */
public class Response {

    private String response;
    //private String[] responseArray; gonna define this somewhere else now, delete when we do
    private final int responseArraySize = 6;  //the max amount of players for our game is 6, each response will be stored at an index
    private int responseIndex = 0;
    private boolean submitted = false;          //lets us know if the player has submitted their response or not
    /*
     idea: maybe do a submission count instead? when the count==#ofPlayers, then we are all set and the timer can stop
     increment submission count every time a response is stored
     might be easier to actually keep track
     have it work with whatever keeps track of the timer
     private int submission = 0;
  */
    Scanner scanner = new Scanner(System.in);

    public String getResponse() {

        if (!scanner.hasNextLine()){
            return null;
        }

        while(scanner.hasNextLine()) {
            response += scanner.nextLine();     //in case their response is multiple lines
        }

        submitted = true;
        //submission++;     if we go with other idea for submission

        return response;
    }

    public void storeResponse(String response, String[] responseArray) {
        /*
            we might have to send the array as a parameter?
         */
        if (responseIndex < responseArraySize) {
            responseArray[responseIndex] = response;
            responseIndex++;
        }
    }


}
