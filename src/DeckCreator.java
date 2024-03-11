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
    public ArrayList<Card> createDecks(int decks) {
        return IntStream.range(0, decks)
                .mapToObj(i -> createDeck())
                .flatMap(ArrayList::stream)
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public ArrayList<Card> createDeck() {
        ArrayList<Card> deck = new ArrayList<>();

        for (Suite suite : Suite.values()) {
            for (int i = 2; i <= 14; i++) {
                Card card = new Card();
                card.setSuite(suite);
                card.setValue(i);
                card.setAce(i == 11);

                if (i >= 12) {
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
    public void shuffleDeck(ArrayList<Card> deck){
        Collections.shuffle(deck);
    }

    public ArrayList<Card> tableDeck(int numberDecks) {
        this.deck = createDecks(numberDecks);
        shuffleDeck(this.deck);
        return this.deck;
    }

    public DeckCreator() {}
}
