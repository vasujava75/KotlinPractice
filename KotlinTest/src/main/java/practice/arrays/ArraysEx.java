package practice.arrays;

import java.util.Arrays;

public class ArraysEx {

    public static void main(String[] args) {
        int x[] = {40, 4, 50, 1, 2, 13, 9, 3, 29,5,51,52,53,54,55,14,15,16,17,18,19,20};

        Arrays.sort(x);
        System.out.println(Arrays.toString(x));
        int start = 1,end=0;
        for (int i = 0; i < x.length; i++) {
            if(i+1<x.length && ++x[i]==x[i+1]){
                start++;
            }else{
                end= Math.max(end,start);
                start=1;
            }
        }
        System.out.println(end);

       // Arrays.stream(x).sorted().
    }
}
