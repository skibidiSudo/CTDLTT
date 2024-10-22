package Hw1_23001908_VuQuangNam.ex3;

import Hw1_23001908_VuQuangNam.ex2.Ex2;

public class Comparable {
    public static void main(String[] args) {
        Card[] deck = App.create();
        System.out.println("Before sorting:");
        for (Card card : deck) {
            System.out.println(card);
        }

        Ex2 ex2 = new Ex2();
        ex2.selectionSort(deck);

        System.out.println("\nAfter sorting:");
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
