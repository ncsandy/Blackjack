public class Messages {
    public void getWelcomeMessage(){
        System.out.println( "\nWelcome to Blackjack!\n" +
                "Dealer counts their Ace as 11\n" +
                "Dealer hits on 16 and below and stands on 17 and above\n");
    }
    public void getPlayerAction(){
        System.out.println("\nWould you like to hit or stay?\n" +
                "1. Hit\n" +
                "2. Stay");
    }

}
