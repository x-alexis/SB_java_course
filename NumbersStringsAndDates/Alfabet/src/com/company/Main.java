package com.company;

public class Main {

    public static void main(String[] args) {
        int A = 'A';
        int Z = 'Z';
        while (A <= Z){
            System.out.println("Code of symbol " + String.valueOf(Character.toChars(A)) + " is " + A);
            A++;
        }
        int a = 'a';
        int z = 'z';
        while (a <= z){
            System.out.println("Code of symbol " + String.valueOf(Character.toChars(a)) + " is " + a);
            a++;
        }
    }
}
