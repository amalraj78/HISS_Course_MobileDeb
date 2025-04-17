import java.awt.*;

class abc{
    abc getad(){
        return this;
    }
}

public class exam {
    public static void main(String args[]){
        int a=5;
        System.out.println(a);
        abc ab = new abc();
        System.out.println(ab);
        System.out.println(ab.getad());
    }
}
