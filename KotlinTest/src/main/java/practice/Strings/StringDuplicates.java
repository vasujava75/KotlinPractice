package practice.Strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDuplicates {
    public static void main(String[] args) {

        String inputString = "geeksforgeeks";
        // Create a frequency map using Java 8 streams
        Map<Character, Long> frequencyMap = inputString.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Find the character with maximum frequency
        Optional<Map.Entry<Character, Long>> maxEntry = frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        Set<Character> characterSet = new HashSet<>();
        inputString.chars().mapToObj(ch->{
            if(!characterSet.add((char)ch)){
                System.out.println((char)ch);
            }
            else{
                characterSet.add((char)ch);}
            return (char)ch;
        });
    }
    static void printPermutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            printPermutations(remaining, ans + ch);
        }
    }

    public static int shortestDistance(List<String> words, String word1, String word2) {
        int d1 = -1, d2 = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(word1))
                d1 = i;
            if (words.get(i).equals(word2))
                d2 = i;

            if (d1 != -1 && d2 != -1)
                ans = Math.min(ans, Math.abs(d1 - d2));
        }

        return ans;
    }
}
