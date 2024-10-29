package com.javamonk;

import java.util.Base64;
public class Base64EncodingDecoding {
    /*
    * Java 8 introduced a built-in Base64 class for encoding and decoding,
    * which previously required third-party libraries.
    * */
    public static void main(String[] args) {
        String originalString = "Java 8 Features";
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        System.out.println(encodedString); // Outputs encoded string

        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        System.out.println(decodedString); // Outputs "Java 8 Features"
    }
}



