package org.urlshortener.learn;

import java.util.List;



// Basics → OOP → Collections → Generics → Exceptions
// → Anonymous classes → Functional Interface → Lambda
// → Optional → Streams → Threads → Sealed classes


class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

/**
 * What are Generics?
 * Generics let you write a class or method once and use it with any type — while keeping full type safety at compile time.
 * Without generics you'd write a StringBox, an IntBox, an AnimalBox… With generics: just one Box<T>.
 * T is just a placeholder name (convention: T, E, K, V). The real type is passed when you use the class.
 */
public class LearnGenerics {

    public static void main(String[] args) {
        // Usage — compiler knows the exact type
        Box<String> strBox = new Box<>("hello");
        Box<Integer> intBox = new Box<>(42);
        String s = strBox.get();  // no cast needed ✓
        int n = intBox.get();  // no cast needed ✓
        // strBox.get().length() — works fine
        // intBox.get().length() — compile ERROR ✓ caught early!


        Response<User> userRes = new Response<>(new User("Admin"), 200);
        User user = userRes.getData();
    }


    //Example
    public void copyData(List<? extends Number> source, List<? super Number> dest) {
        for (Number n : source) {
            dest.add(n);
        }
    }
}


class Response<T> {
    private T data;
    private int status;

    public Response(T data, int status) {
        this.data = data;
        this.status = status;
    }

    public T getData() { return data; }
}

class User {
    private String name;
    public User(String name) {
        this.name = name;
    }
    public String getName() { return name; }
}