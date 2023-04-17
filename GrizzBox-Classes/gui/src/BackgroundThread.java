import javafx.concurrent.Task;

public class BackgroundThread extends Task<String> {
    int usersJoined;

    public BackgroundThread(int s){
        this.usersJoined=s;


    }



    String [] responses = new String[usersJoined];


    int [] userPoints = new int[usersJoined];
    int [] responseVotes = new int[usersJoined];

    public void addResponse(String s, int i){
        if(i<responses.length){
            responses[i]=s;
        }

    }


    @Override
    protected String call() throws Exception {

        return "L";
    }
}
