package practice.Strings;

import java.util.Set;
import java.util.TreeSet;

public class StringExamples {

    public static void main(String[] args) {
        //&quot;haIhMpO&quot;
        //&quot;hIOhMpa&quot;

       /* String s ="haIhMpO";//hIOhMpa
        char[] chars = s.toCharArray();
        char[] charsfinal = new char[s.length()];
        for (int i = 0; i < chars.length; i++) {
            char c=chars[i];
            if(c!='a' || c!='e' || c!='i' || c!='o' || c!='u' ){
                charsfinal[i]=c;
            }else{

            }
        }*/
    Set set = new TreeSet<Character>();
        set.add('i');
        set.add('u');
    set.add('a');
    set.add('e');

    set.add('o');
        set.add('I');
        set.add('U');
        set.add('A');
        set.add('E');

        set.add('O');


    System.out.println(set);

    }
}
