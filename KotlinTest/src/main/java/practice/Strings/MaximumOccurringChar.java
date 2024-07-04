package practice.Strings;

import java.util.HashMap;
import java.util.Map;

public class MaximumOccurringChar {
    public static char getMaxOccurringChar(String str) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        char maxChar = '\0'; // Initialize with null character
        int maxCount = 0;

        for (char ch : str.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
            if (charFrequency.get(ch) > maxCount) {
                maxCount = charFrequency.get(ch);
                maxChar = ch;
            }
        }

        return maxChar;
    }

    public static void main(String[] args) {
        String input = "geeksforgeeks";
        char result = getMaxOccurringChar(input);
        System.out.println("Max occurring character is: " + result);
    }
}
