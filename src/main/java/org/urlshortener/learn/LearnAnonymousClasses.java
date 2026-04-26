package org.urlshortener.learn;

/**
 * What is an anonymous class?
 * A class that is declared and instantiated at the same time — with no name. You define it right where you need it.
 * Use it when you need a one-off implementation of an interface or abstract class and it's not worth creating a separate file for it.
 */
public class LearnAnonymousClasses {

    public static void main(String[] args) {
        // Normal approach — separate named class
        Animal a = new Dog();


        // Anonymous class — same thing, no name, inline
        Animal anon = new Animal() {
            public void speak() { System.out.println("Woof"); }
        };


        Tool hammer = new Tool() {
        @Override
        void use() {
            System.out.println("Use the hammer");
        }
        };
        hammer.use();
    }
}




class Dog implements Animal {
    public void speak() { System.out.println("Woof"); }
}
interface Animal {}


abstract class Tool {
    abstract void use();
}

