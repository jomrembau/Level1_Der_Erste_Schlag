import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your hero's name:");
        String playerName = scan.nextLine();

        Character player = new Character(playerName, 100, 50, new String[]{"Heiltrank", "Ausdauertrank"});
        Character enemy = new Character(    "Dark Spiegel", 100,50, new String[]{"Heiltrank", "Ausdauertrank"});

        System.out.println("\nYou wake up in a dark arena. In front of you stands your mirror image — a foe with the same power as you. Only one of you will survive. Choose your actions wisely and win the fight.");
        System.out.println("Press Enter to Continue.");
        scan.nextLine();
        
        boolean continueGame = true;

        while (continueGame) {
            playerStats(playerName, player.getLebensPunkte(), player.getAusdauer(), player.getInventar());
            enemyStats("Dark Spiegel", enemy.getLebensPunkte(), enemy.getAusdauer(), enemy.getInventar());
            
            System.out.println("\nWhat do you want to do?");
            System.out.println("[1] Attack.");
            System.out.println("[2] Block.");
            System.out.println("[3] Use Potion");
            continueGame = false;
        }
        

        scan.close();
    }
    public static void playerStats(String name, int health, int stamina, String[] inventory) {
        System.out.println("Player: " + name);
        System.out.println("Health: " + health);
        System.out.println("Stamina: " + stamina);
        System.out.println("Inventory: " + Arrays.toString(inventory));
    }

    public static void enemyStats(String name, int health, int stamina, String[] inventory) {
        System.out.println("\nPlayer: " + name);
        System.out.println("Health: " + health);
        System.out.println("Stamina: " + stamina);
        System.out.println("Inventory: " + Arrays.toString(inventory));
    }
}

