package practice;

public class Testing {

    public static void main(String[] args) {
        FunctionTest functionTest = (data)-> System.out.println("------"+data);
        functionTest.print("asfasda");
    }
}

interface FunctionTest{
   void print(String data);
}
