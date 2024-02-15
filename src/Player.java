import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Player {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int money;

    @Getter @Setter
    private ArrayList<Card> hand;

    Player(String name) {
        this.name = name;
    }

}
