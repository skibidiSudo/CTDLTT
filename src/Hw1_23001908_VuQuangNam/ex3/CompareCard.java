package Hw1_23001908_VuQuangNam.ex3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompareCard implements Comparator<Card> {
    private static final List<String> RANK_ORDER = Arrays.asList("3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2");
    private static final List<String> SUIT_ORDER = Arrays.asList("Spades", "Clubs", "Diamonds", "Hearts");

    @Override
    public int compare(Card card1, Card card2) {
        int suitComparison = Integer.compare(SUIT_ORDER.indexOf(card1.getSuit()), SUIT_ORDER.indexOf(card2.getSuit()));
        if (suitComparison != 0) {
            return suitComparison;
        }
        return Integer.compare(RANK_ORDER.indexOf(card1.getRank()), RANK_ORDER.indexOf(card2.getRank()));
    }
}
