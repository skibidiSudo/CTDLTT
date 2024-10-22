package Hw1_23001908_VuQuangNam.ex3;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.List;

public class Card implements Comparable<Card> {
    private String rank, suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    private static final List<String> RANK_ORDER = Arrays.asList("3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2");
    private static final List<String> SUIT_ORDER = Arrays.asList("Spades", "Clubs", "Diamonds", "Hearts");

    @Override
    public int compareTo(Card o) {
        int suitComparison = Integer.compare(SUIT_ORDER.indexOf(this.getSuit()), SUIT_ORDER.indexOf(o.getSuit()));
        if (suitComparison != 0) {
            return suitComparison;
        }
        return Integer.compare(RANK_ORDER.indexOf(this.getRank()), RANK_ORDER.indexOf(o.getRank()));
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}
