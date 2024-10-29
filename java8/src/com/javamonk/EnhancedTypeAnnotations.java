package com.javamonk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class EnhancedTypeAnnotations {
    private List<@NonNull String> names;

    public void setNames(List<@NonNull String> names) {
        this.names = names;
    }

    public void setName(@NonNull String name) {
        // Do something with name
        System.out.println("name = " + name);
    }

    public static void main(String[] args) {
        EnhancedTypeAnnotations obj = new EnhancedTypeAnnotations();
//        ArrayList<String> al = new ArrayList<>();
//        al.add("one");
//        al.add(null);
//        obj.setNames(null);
        obj.setName(null);
    }
}



@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@interface NonNull {}