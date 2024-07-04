import practice.collections.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

   /*     DefatultInterface df = (t,k)-> {
            String toal = t+k;
            System.out.println(toal);
        };

        df.test("ab","cd");

        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.add(12);
        integerHashSet.add(11);
        integerHashSet.add(35);
        integerHashSet.add(3);
        System.out.println(integerHashSet);
        integerHashSet.stream().sorted();
        System.out.println(integerHashSet);*/

        String str = "I am doing interview at ePAM I work for EPAM bla bla Bla" ;

        String[] array=   str.split(" ");

        Map<String,Long> m =     Arrays.stream(array)
               // .map(w -> w.replaceAll("[^a-zA-Z]", "").trim())
                .filter(w -> w.length() > 0)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println(m);
        List<Employee> employees = new ArrayList<>(); employees.add(new Employee("A", "A@google.com")); employees.add(new Employee("b", "b@gmail.com")); employees.add(new Employee("C", "C@google.com")); employees.add(new Employee("D", "D@yahoo.com"));
        Map<String,Long> m1 = employees.stream().map(data->data.getName().split("@")[1]).collect(Collectors.groupingBy(name->name,Collectors.counting()));
        System.out.println(m1);
    }
}