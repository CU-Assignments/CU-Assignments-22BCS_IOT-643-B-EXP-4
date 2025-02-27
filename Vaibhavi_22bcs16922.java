import java.util.*;

class PlayingCard {
    private String suit;
    private int value;

    public PlayingCard(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "[Suit: " + suit + ", Value: " + value + "]";
    }
}

public class CardCollection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<PlayingCard>> cardGroups = new TreeMap<>();

        System.out.print("Enter the number of cards: ");
        int cardCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= cardCount; i++) {
            System.out.println("Enter details for card " + i + ":");
            System.out.print("Suit: ");
            String suit = scanner.nextLine();
            System.out.print("Value: ");
            int value = scanner.nextInt();
            scanner.nextLine();

            cardGroups.computeIfAbsent(suit, k -> new ArrayList<>()).add(new PlayingCard(suit, value));
        }

        displayCardDetails(cardGroups);
        scanner.close();
    }

    private static void displayCardDetails(Map<String, List<PlayingCard>> cardGroups) {
        System.out.println("\nUnique Suits and Their Card Details:");
        for (Map.Entry<String, List<PlayingCard>> entry : cardGroups.entrySet()) {
            String suit = entry.getKey();
            List<PlayingCard> cards = entry.getValue();
            int totalValue = cards.stream().mapToInt(PlayingCard::getValue).sum();
            
            System.out.println("Suit: " + suit);
            cards.forEach(System.out::println);
            System.out.println("Total Cards: " + cards.size());
            System.out.println("Sum of Values: " + totalValue);
        }
    }
}
