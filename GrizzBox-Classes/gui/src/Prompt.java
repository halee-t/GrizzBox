import java.io.FileNotFoundException;
import java.util.*;
import java.io.FileInputStream;

public class Prompt {
    private int arrayIndex = 0;

    private ArrayList<String> promptChoices = new ArrayList<>(); //main array to hold prompts

    private FileInputStream fileStringStream = null; //File input stream
    private Scanner inFS = null;
    public Prompt() throws FileNotFoundException {
        convertFileToArray();
    }


    public void convertFileToArray() throws FileNotFoundException {
        fileStringStream = new FileInputStream("PromptChoices.txt");
        inFS = new Scanner(fileStringStream); //scanner to read text file

        while(inFS.hasNext()) { //iterates through file until no new text lines exist
            promptChoices.add(inFS.nextLine());
        }
        Collections.shuffle(promptChoices); //shuffles array so there is a random order each time
    }


    public String getPrompt() { //returns prompt based off of shuffled arraylist
        String prompt = promptChoices.get(arrayIndex);
        arrayIndex ++;

        return prompt;
    }



    }

