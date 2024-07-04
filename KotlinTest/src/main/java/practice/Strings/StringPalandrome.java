package practice.Strings;

public class StringPalandrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

        public static boolean isPalindrome(String s) {
            if(s.length()==1){
                return true;
            }else{
                s= s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
               StringBuilder sb = new StringBuilder(s);
                System.out.println(sb.reverse());
                System.out.println(s);
               if(sb.reverse().toString().equals(s)){
                   return true;
               }
            }
            return false;
        }
}
