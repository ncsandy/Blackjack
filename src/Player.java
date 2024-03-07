import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class Player implements CardHolder {

    @Setter
    private String name;

    @Setter
    private int money;
    private final ArrayList<Card> hand;

    @Getter @Setter
    private int score;

    Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }
    @Override
    public void addCard(Card card) {
        this.hand.add(card);
    }
    @Override
    public void clearHand() {
        this.hand.clear();
    }

}