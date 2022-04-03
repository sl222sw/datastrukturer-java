package Laboration2;

import java.util.NoSuchElementException;

public class Kedjetest {
    public static void main(String[] args) throws NoSuchElementException {
        Kedja<String> enKedja = new Kedja<>();
        enKedja.addFirst ("Itzamna");
        enKedja.addFirst("Kinich Ahau");
        enKedja.addFirst("Chaac");
        enKedja.addFirst("Bolon Dzacab");
        enKedja.addLast("Bacabs");
        enKedja.addAt(4,"Ek Chuah");
        System.out.println(enKedja.getFirst());
        System.out.println();
        for (String s: enKedja) {
            System.out.println(s);
        }
        System.out.println("Storlek: " + enKedja.size());
        enKedja.removeAt(4);
        System.out.println();
        for(String s: enKedja) {
            System.out.println(s);
        }
        System.out.println("Storlek: " + enKedja.size());
    }
}