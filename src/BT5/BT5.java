package BT5;

import java.util.Arrays;
import java.util.List;

public class BT5 {
    public static void main(String[] args) {
        String filename = "input.txt";
        List<String> playerNames = Arrays.asList(
                "Lionel Messi",
                "Cristiano Ronaldo",
                "Neymar Jr",
                "Kylian Mbappe",
                "Robert Lewandowski"
        );

        FileHandler.writeToFile(filename, playerNames);

        List<String> namesFromFile = FileHandler.readFromFile(filename);
        String longestName = LongestNameFinder.findLongestName(namesFromFile);

        if (!longestName.isEmpty()) {
            System.out.println("Tên cầu thủ dài nhất: " + longestName);
            System.out.println("Độ dài của tên: " + longestName.length());
        }
    }
}
