import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Setter
@Getter
public class DeckCreator {

    ArrayList<Card> deck;
    public ArrayList<Card> dealerDeck(int decks) {
        return IntStream.range(0, decks)
                .mapToObj(i -> createDeck())
                .flatMap(ArrayList::stream)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Card> createDeck() {
        ArrayList<Card> deck = new ArrayList<>();

        for (Suite suite : Suite.values()) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card();
                card.setSuite(suite);
                card.setValue(i);
                card.setAce(i == 1);

                if (i >= 11) {
                    creatSuite(suite, deck);
                    break;
                }

                deck.add(card);
            }
        }
        return deck;
    }
    public void creatSuite(Suite suite, ArrayList<Card> deck) {
        for (Face face : Face.values()) {
            Card card = new Card();
            card.setSuite(suite);
            card.setFace(face);
            card.setValue(10);
            deck.add(card);
        }
    }
    public ArrayList<Card> shuffleDeck(ArrayList<Card> deck){
        Collections.shuffle(deck);
        return deck;
    }

    public DeckCreator(int numberDecks) {
       ArrayList <Card> deck;
       deck = dealerDeck(numberDecks);
       shuffleDeck(deck);
       this.deck = deck;
    }
}
