class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(duplicatesNotFound(s.substring(i, j).toCharArray())){
                    length= Math.max(s.substring(i, j).length(),length);
                }
            }

        }
        return length;
    }
    public boolean duplicatesNotFound(char[] s){
        if(s.length==1){
            return true;
        }else{
            for(int i=0;i<s.length;i++){
                for(int j=i+1;j<s.length;j++){
                    if(s[i]==s[j]){
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
