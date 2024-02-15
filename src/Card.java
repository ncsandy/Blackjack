import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {

    @Getter @Setter
    Suite suite;

    @Getter @Setter
    Face face;

    @Getter @Setter
    int value;

    @Getter @Setter
    boolean ace;
    public Card() {
    }
}
