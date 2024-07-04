package practice.Strings;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            anagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);

        }

        return new ArrayList<>(anagramMap.values());
    }
}
