package BT5;

import java.util.List;

public class LongestNameFinder {
    public static String findLongestName(List<String> names) {
        String longestName = "";
        for (String name : names) {
            if (name.length() > longestName.length()) {
                longestName = name;
            }
        }
        return longestName;
    }
}
