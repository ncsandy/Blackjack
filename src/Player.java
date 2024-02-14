import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Player {

    @Getter @Setter
    private String name;

    public ArrayList<Card> playerHand (Card card) {
        return new ArrayList<>();
    }
    Player(String name) {
        this.name = name;
    }

}
