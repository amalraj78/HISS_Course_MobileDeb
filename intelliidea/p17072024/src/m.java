interface test{
    void print(); //public abstract void print();
}

interface test1{
    void print1();
    int var1 = 3;
}

abstract class test3{
    abstract void print3();
}

class test2 extends test3 implements test, test1 {
    public void print()
        System.out.println
}

public class m {
    public static void main(String[] args){
        test2 t2= new test2();
        t2.print(); //abc
        t2.print1(); //Def
        t2.print3(); //qwe //do not modify
    }
}
