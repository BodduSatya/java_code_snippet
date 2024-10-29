package com.javamonk.default_static_methods_nterfaces;

public class Test1 implements GreetingsInterface{
    @Override
    public void greetElders() {
        System.out.println("Namaste " );
    }

    @Override
    public void sayHello() {
//        GreetingsInterface.super.sayHello();
        System.out.println("sayHello() method definition from Implementation class .");
    }

    public static void main(String[] args) {
        Test1 obj = new Test1();
        obj.greetElders();
        obj.sayHello();
        GreetingsInterface.sayHello("Satya");

        /*Output :
        Namaste
        sayHello() method definition from Implementation class .
        Hello Satya*/
    }
}

interface GreetingsInterface {

    void greetElders();

    default void sayHello() {               // optional to implement in implemented classes
        System.out.println("sayHello() method definition from Interface .");
    }

    static void sayHello(String name) {  // this method can be used in it's implemented classes but not overridden ( can't change the definition )
        System.out.println("Hello " + name);
    }
}
