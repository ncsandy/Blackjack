

public class Formatter {
    int convertToInt(String playerInput) {
        int parsedNumber = 0;
        try {
            parsedNumber = Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            System.out.println("Failed to parse input into an integer, please enter a proper number! " + e.getMessage());
        }
        return parsedNumber;
    }

    void getCardInfo(Card card) {

        String cardInfo = "";

        if (card.isAce()) {
            cardInfo += "Ace";
        } else if (card.getFace() != null) {
            cardInfo += card.getFace().getFaceName();
        } else {
            cardInfo += card.getValue();
        }

        cardInfo += " of " + card.getSuite().getSuiteName();
        System.out.println(cardInfo);
    }

}
