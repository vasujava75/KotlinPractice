package practice.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringsEx {

    public static void main(String[] args) {
        String str = "wwwwaaadexxxxxxywww";
        gen_compressed_str(str);
        System.out.println();
        System.out.println(sort("xyzcba"));
        permutation("123");

        countDuplicates("javavavas").forEach((k,v)->{
            System.out.println(k +""+v);
        });
    }

    static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    static boolean stringPermutation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return sort(s1).equals(sort(s2));
        } else {
            return false;
        }

    }

    public boolean duplicatesNotFound(char[] s){
        if(s.length==1){
            return true;
        }else{
            for(int i=0;i<=s.length;i++){
                for(int j=1;j<=s.length;j++){
                    if(s[i]==s[j]){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static int longestUniqueSubsttr(String str) {
        int n = str.length();
        int res = 0; // result
        int i = 0;

        // Creating a hash map to store the last positions of occurrence
        HashMap<Character, Integer> lastIndex = new HashMap<>();

        // Starting from the beginning of the string
        for (int j = 0; j < n; j++) {
            // If this character is seen before, then update i
            if (lastIndex.containsKey(str.charAt(j))) {
                i = Math.max(i, lastIndex.get(str.charAt(j)) + 1);
            }

            // Update result if needed
            res = Math.max(res, j - i + 1);

            // Update the last occurrence of the current character
            lastIndex.put(str.charAt(j), j);
        }
        return res;
    }

    static int longestUniqueSubsttring(String str) {
        int n = str.length();
        int res = 0; // result
        int i = 0;

        // Creating a hash map to store the last positions of occurrence
        HashMap<Character, Integer> lastIndex = new HashMap<>();

        // Starting from the beginning of the string
        for (int j = 0; j < n; j++) {
            // If this character is seen before, then update i
            if (lastIndex.containsKey(str.charAt(j))) {
                i = Math.max(i, lastIndex.get(str.charAt(j)) + 1);
            }

            // Update result if needed
            res = Math.max(res, j - i + 1);

            // Update the last occurrence of the current character
            lastIndex.put(str.charAt(j), j);
        }
        return res;
    }

    // Function to print all substring
    public static void SubString(String str, int n)
    {
        for (int i = 0; i < n; i++)
            for (int j = i+1; j <= n; j++)

                // Please refer below article for details
                // of substr in Java
                // https://www.geeksforgeeks.org/java-lang-string-substring-java/
                System.out.println(str.substring(i, j));
    }

    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (char key : map.keySet()) {
            count += map.get(key) % 2;
        }
        return count <= 1;
    }

    public static void permutation(String input) {
        permutation("", input);
    }

    /* * Recursive method which actually prints all permutations * of given String, but since we are passing an empty String * as current permutation to start with, * I have made this method private and didn't exposed it to client. */
    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.err.println(perm + word);

        } else {
            for (int i = 0; i < word.length();i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
            }
        }
    }

    public static int factorial(int number){
        //base case
        if(number == 0){
            return 1;
        }
        return number*factorial(number -1); //is this tail-recursion?
    }
    public static int fact(int number){
        int result = 1;
        while(number != 0){
            result = result*number;
            number--;
        }

        return result;
    }

    boolean oneEditAway(String first, String second) {
        if (first.length() == second.length())
            return replace(first, second);
        else if (first.length() + 1 == second.length())
            return insert(first, second);
        else if (first.length() == second.length() + 1)
            return insert(second, first);
        return false;
    }

    boolean replace(String s1, String s2) {
        boolean oneEdit = false;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (oneEdit)
                    return false;
                oneEdit = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into s1 to make s2 */
    boolean insert(String s1, String s2) {
        int index1 = 0, index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2)
                    return false;
                ++index2;
            } else
                ++index1;
            ++index2;
        }
        return true;
    }

    static void gen_compressed_str(String str) {
        int n = str.length();
        for (int i = 0; i < n; i++) {

            // Count occurrences of current character
            int count = 1;
            while (i < n - 1 &&
                    str.charAt(i) == str.charAt(i + 1)) {
                count++;
                i++;
            }

            if (count == 1) {
                System.out.print(str.charAt(i));
            } else {
                System.out.print(str.charAt(i));
                System.out.print(count);
            }
        }
    }

    void replaceSpaces(char[] str, int trueLength) {

    }

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {//Already found this char in string
                return false;
            }
            char_set[val] = true;
        }

        return true;
    }

    public static Map<Character,Long> countDuplicates(String str){
       return str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(data->data,Collectors.counting()));
    }
}