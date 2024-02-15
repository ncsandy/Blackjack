import java.util.ArrayList;

public class Dealer implements CardHolder {

    private final ArrayList<Card> hand;

    public Dealer() {
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
