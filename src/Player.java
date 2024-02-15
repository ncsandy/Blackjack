import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

import java.util.ArrayList;

public class Player implements CardHolder {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int money;
    private final ArrayList<Card> hand;

    Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }
    @Override
    public void addCard(Card card) {
        this.hand.add(card);
    }
    @Override
    public void clearHand() {
        this.hand.clear();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

}