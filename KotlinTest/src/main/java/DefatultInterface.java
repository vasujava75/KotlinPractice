@FunctionalInterface
public interface DefatultInterface {

    void test(String t,String x);
    default void printme(String t){
        System.out.println("print me "+t);
    }
}
