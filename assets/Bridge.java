import java.util.ArrayList;

/**
 * <h1>ArrayList Assignment - Bridge</h1>
 * <h2>Course Info:</h2>
 * ICS4U0 with V. Krasteva
 *
 * @version 03.07.2023
 * @author Aidan Wang
 */
public class Bridge {
    private String deckString;
    private ArrayList<String> deck, player1, player2, player3, player4;

    /**
     * Class constructor reads deck ArrayList from String and initializes ArrayLists for four players
     */
    public Bridge() {
        deckString = "AS2S3S4S5S6S7S8S9STSJSQSKSAH2H3H4H5H6H7H8H9HTHJHQHKH" +
                     "AD2D3D4D5D6D7D8D9DTDJDQDKDAC2C3C4C5C6C7C8C9CTCJCQCKC";
        player1 = new ArrayList<>();
        player2 = new ArrayList<>();
        player3 = new ArrayList<>();
        player4 = new ArrayList<>();
        deck = new ArrayList<>();
        for (int i = 0; i < deckString.length(); i += 2)
            deck.add(deckString.substring(i, i + 2));
    }

    /**
     * Calls all other methods in class to simulated one round of Bridge
     * Displays hands and scores of each player, along with winner's score
     */
    public void play() {
        this.shuffle();
        this.dealCards();

        int[] scores = new int[4];
        System.out.println("Player 1:");
        scores[0] = displayScore(player1);
        System.out.println("Player 2:");
        scores[1] = displayScore(player2);
        System.out.println("Player 3:");
        scores[2] = displayScore(player3);
        System.out.println("Player 4:");
        scores[3] = displayScore(player4);

        int winner = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > scores[winner])
                winner = i;
        }

        System.out.println("The winner is Player " + (winner + 1) + " with a score of " + scores[winner] + "!");
    }

    /**
     * Shuffles cards in deck by transferring elements into new list with randomized order
     */
    public void shuffle() {
        ArrayList<String> shuffledDeck = new ArrayList<>();
        int i;
        while (!deck.isEmpty()) {
            i = (int)(Math.random() * deck.size());
            shuffledDeck.add(deck.get(i));
            deck.remove(i);
        }
        deck = shuffledDeck;
    }

    /**
     * Deals cards in deck evenly among four players, removing from main list to prevent duplicates
     */
    public void dealCards() {
        while (!deck.isEmpty()) {
            player1.add(deck.get(0));
            deck.remove(0);
            player2.add(deck.get(0));
            deck.remove(0);
            player3.add(deck.get(0));
            deck.remove(0);
            player4.add(deck.get(0));
            deck.remove(0);
        }
    }

    /**
     * Displays cards in a specified player's hand, organized by suit, and their total score
     *
     * @param player ArrayList of the player to display info of
     * @return int value for player's score
     */
    public int displayScore(ArrayList<String> player) {
        int score = 0;
        char denomination, suit;

        ArrayList<String> spades = new ArrayList<>();
        ArrayList<String> hearts = new ArrayList<>();
        ArrayList<String> diamonds = new ArrayList<>();
        ArrayList<String> clubs = new ArrayList<>();

        for (String card : player) {
            denomination = card.charAt(0);
            suit = card.charAt(1);

            if (denomination == 'A')
                score += 4;
            else if (denomination == 'K')
                score += 3;
            else if (denomination == 'Q')
                score += 2;
            else if (denomination == 'J')
                score += 1;

            if (suit == 'S')
                spades.add(card);
            else if (suit == 'H')
                hearts.add(card);
            else if (suit == 'D')
                diamonds.add(card);
            else if (suit == 'C')
                clubs.add(card);
        }

        for (int i = 0; i < 3; i++) {
            if (spades.size() == i)
                score += 3 - i;
            if (hearts.size() == i)
                score += 3 - i;
            if (diamonds.size() == i)
                score += 3 - i;
            if (clubs.size() == i)
                score += 3 - i;
        }

        for (String spade : spades) System.out.print(spade + " ");
        if (!spades.isEmpty()) System.out.println();

        for (String heart : hearts) System.out.print(heart + " ");
        if (!hearts.isEmpty()) System.out.println();

        for (String diamond : diamonds) System.out.print(diamond + " ");
        if (!diamonds.isEmpty()) System.out.println();

        for (String club : clubs) System.out.print(club + " ");
        if (!clubs.isEmpty()) System.out.println();

        System.out.println("Score: " + score + "\n");
        return score;
    }

    public static void main(String[] args) {
        System.out.println("Bridge Game:\n");
        Bridge game = new Bridge();
        game.play();
    }
}
