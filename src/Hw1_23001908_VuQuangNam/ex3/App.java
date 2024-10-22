package Hw1_23001908_VuQuangNam.ex3;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Card[] cards = create();
        Arrays.sort(cards, new CompareCard());
        print(cards);
    }

    public static Card[] create() {
        Card[] cards = new Card[52];
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Diamonds", "Hearts", "Clubs", "Spades"};

        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                cards[index++] = new Card(rank, suit);
            }
        }

        return cards;
    }

    public static void print(Card[] cards) {
        for (int i = 0; i < 52; i++) {
            System.out.println(cards[i].toString());
        }
    }
}
