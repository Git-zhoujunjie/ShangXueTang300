package DesignPattern.Singleton;

public class Test {
    public static void main(String[] args) {
        Demo04 s1 = Demo04.getInstance();
        Demo04 s2 = Demo04.getInstance();
        System.out.println(s1);
        System.out.println(s2);


        Demo05 s3 = Demo05.INSTANCE;
        Demo05 s4 = Demo05.INSTANCE;
        System.out.println(s3 == s4);

    }
}
