import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {

    @Setter
    Suite suite;

    @Setter
    Face face;

    @Setter
    int value;

    @Setter
    boolean ace;
    public Card() {
    }
}
