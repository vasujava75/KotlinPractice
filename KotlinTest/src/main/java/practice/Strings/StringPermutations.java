package practice.Strings;

public class StringPermutations {

    static void printPermutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        boolean[] used = new boolean[26]; // To track
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            //printPermutations(remaining, ans + ch);
            if (!used[ch - 'a']) {
                printPermutations(remaining, ans + ch);
                used[ch - 'a'] = true;
            }
        }
    }

    public static void main(String[] args) {
        String input = "abb";
        printPermutations(input, "");
    }
}
