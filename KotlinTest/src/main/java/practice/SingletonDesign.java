package practice;

public class SingletonDesign {

    private SingletonDesign(){
        //restrict
    }
    private static SingletonDesign singletonDesign=null;

    public static SingletonDesign getSingletonDesign(){
        if(singletonDesign==null){
            synchronized(SingletonDesign.class){
                if(singletonDesign==null) {
                    singletonDesign = new SingletonDesign();
                }
            }
        }
        return singletonDesign;
    }
}

// Book, Author
//select b.bookname, a.autohername from Book b inner join on Author a a.autohid=b.authorid;
//select a.autohername from Author a groupby a.books having a.books>5;



