public class Formatter {
    public int convertToInt(String playerInput) {
        int parsedNumber = 0;
        try {
           parsedNumber = Integer.parseInt(playerInput);
        }catch (NumberFormatException e) {
            System.out.println("Failed to parse input into an integer, please enter a proper number! " + e.getMessage());
        }
        return parsedNumber;
    }
}
