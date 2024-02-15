import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
public class Dealer {

    @Getter @Setter
    private ArrayList<Card> hand;
}
