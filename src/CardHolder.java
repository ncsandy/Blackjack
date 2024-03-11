public interface CardHolder {
    void addCard(Card card);
    void clearHand();
    int getScore();
    void readHand(Formatter formatter);
}
