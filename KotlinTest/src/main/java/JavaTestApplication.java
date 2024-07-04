import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaTestApplication {

    public static void main(String[] args) {
       /*
       //Creating own functional interface consumer
       DefatultInterface doo =(t,x) -> {
            System.out.println(t+"================"+x);
        };
        doo.test("abc","xyz");
        doo.printme("working");*/

/*      //Thread creation new approach
        Runnable r1 =()->
        {
            for (int i = 0; i < 10; i++) {
                System.out.println("t1-----"+i);
            }
        };
        Runnable r2 =()->
        {
            for (int i = 0; i < 10; i++) {
                System.out.println("t2-----"+i);
            }

        };
        Thread run1 = new Thread(r1);
        Thread run2 = new Thread(r2);
        run1.start();
        run2.start();*/

        List<Integer> l = Arrays.asList(1, 6, 3, 2,2,3, 6,5,8,9);

      /*
      //list to map
      Map<Integer,Integer> map =  l.stream().collect(Collectors.toMap(Integer::intValue,Integer::intValue));
        System.out.println(map);*/

       /* //Sort
         l.sort((o1, o2) -> {
                    if (o1 > o2) return 1;
                    else {
                        return 0;
                    }
                }
        );*/
        //System.out.println(l);
       // l.stream().forEach(t-> System.out.println(t));
       /* l.stream().distinct().forEach(t-> System.out.println(t));
         List i =    l.stream().filter(t->t>3).collect(Collectors.toList());
      //  System.out.println(i);
        Map m= new HashMap();
       l.stream().forEach(data-> {
           m.computeIfAbsent(data,value->data);
       });*/
       // l.stream().collect(Collectors.toMap(Integer::intValue,Integer::byteValue));
        /*l.sort((a,b)->{
            if(a>b){
                return -1;
            }else {
                return 0;
            }
        });*/
       // l.sort(Comparator.naturalOrder());
      //  l.sort(Comparator.reverseOrder());

       // System.out.println( l.stream().sorted(Comparator.comparing(Integer::intValue)).collect(Collectors.toList()));
     /*   l.sort(Comparator.comparing(Integer::intValue));
        System.out.println(l);
        record Datas(String id, String name){};
        Datas datas = new Datas("data","wrokding");
        System.out.println( datas.id());
        String maxOccurent = "abaacaaddddddaa";*/


    }
}


