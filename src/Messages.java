import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Messages {
    public void getWelcomeMessage(){
        System.out.println( "\nWelcome to Blackjack!\n" +
                "Dealer counts their Ace as 11\n" +
                "Dealer hits on 16 and below and stand on 17 and above\n");
    }
}
