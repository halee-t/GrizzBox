import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class GrizzBox {

    ArrayList<String> codes = new ArrayList<>();
    Prompt prompts;
    int codeIndex=0;




    public GrizzBox() throws FileNotFoundException {
        this.prompts=new Prompt();
        //convertFileToCodes();

    }
    /*public void convertFileToCodes() throws FileNotFoundException {
        FileInputStream fileStringStream = new FileInputStream("Codes.txt");
        Scanner inFS = new Scanner(fileStringStream); //scanner to read text file

        while(inFS.hasNext()) { //iterates through file until no new text lines exist
            codes.add(inFS.nextLine());
        }
        Collections.shuffle(codes); //shuffles array so there is a random order each time
    }*/
    /*public String getcode() { //returns prompt based off of shuffled arraylist
        String c = codes.get(codeIndex);
        codeIndex ++;

        return c;
    }*/




}
