import java.util.ArrayList;

public interface CardHolder {
    void addCard(Card card);
    void clearHand();
    int getScore(ArrayList<Card> hand);
    void readHand();
}
