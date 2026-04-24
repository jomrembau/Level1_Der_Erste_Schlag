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
        
        int playerBlock = 0;
        int enemyBlock = 0;
        boolean continueGame = true;
        Character attacker = player;
        Character defender = enemy;

        while (continueGame) {
            playerStats(playerName, player.getLebensPunkte(), player.getAusdauer(), player.getInventar());
            enemyStats("Dark Spiegel", enemy.getLebensPunkte(), enemy.getAusdauer(), enemy.getInventar());
            
            int playerMove = 0;

            while (playerMove < 1 || playerMove >3) {

                System.out.println("\nWhat do you want to do?");
                System.out.println("[1] Attack.");
                System.out.println("[2] Block.");
                System.out.println("[3] Use Potion. ");
                playerMove = scan.nextInt();
            }

            switch (playerMove) {
                case 1:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    if (attacker.getAusdauer() >= 5) {
                        attacker.setAusdauer(attacker.getAusdauer() - 5);
                        if (enemyBlock == 0) {
                            defender.setLebensPunkte(defender.getLebensPunkte() - 10);
                        } else {
                            defender.setLebensPunkte(defender.getLebensPunkte() - 5);
                        }
                    } else {
                        System.out.println(playerName + " does not have enough stamina.");
                    }
                    enemyBlock = 0;
                    break;

                case 2:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println(playerName + " will absorb 50% of damage on next attack.");
                    playerBlock = 1;
                    break;

                case 3:
                    
                    break;
            
                default:
                    System.out.println("Error");
                    break;

            }
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

