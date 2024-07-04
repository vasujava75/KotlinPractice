package practice.Strings;

import java.util.HashMap;

public class StringIsomorphic {


    static boolean areIsomorphic(String str1, String str2)
    {

        HashMap<Character, Character> charCount
                = new HashMap();
        char c = 'a';
        for (int i = 0; i < str1.length(); i++) {
            if (charCount.containsKey(str1.charAt(i))) {
                c = charCount.get(str1.charAt(i));
                if (c != str2.charAt(i))
                    return false;
            }
            else if (!charCount.containsValue(
                    str2.charAt(i))) {
                charCount.put(str1.charAt(i),
                        str2.charAt(i));
            }
            else {
                return false;
            }
        }
        return true;
    }

    /* Driver code*/
    public static void main(String[] args)
    {

        String str1 = "aac";
        String str2 = "xxy";

        // Function Call
        if (str1.length() == str2.length()
                && areIsomorphic(str1, str2))
            System.out.println("True");
        else
            System.out.println("False");
    }
}
