import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ScoreBoard {
    public ScoreBoard() throws FileNotFoundException {
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
}
