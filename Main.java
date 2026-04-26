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
                        System.out.println("\n" + playerName + " attacks. Spent 5 stamina.");
                        if (enemyBlock == 0) {
                            defender.setLebensPunkte(defender.getLebensPunkte() - 10);
                            System.out.println(enemy.getName() + " took 10 damage.\n");
                        } else {
                            defender.setLebensPunkte(defender.getLebensPunkte() - 5);
                            System.out.println(enemy.getName() + " blocks 50% damage. -5 health. \n");
                        }
                    } else {
                        System.out.println("\n" + playerName + " does not have enough stamina.\n");
                    }
                    enemyBlock = 0;

                    if (defender.getLebensPunkte() <= 0) {
                        playerWins();
                        continueGame = false;
                        System.exit(0);
                    }
                    break;

                case 2:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("\n" + playerName + " prepares to block");
                    playerBlock = 1;
                    break;

                case 3:
                    
                    break;
            
                default:
                    System.out.println("Error");
                    break;
            }
            
            if (!continueGame) {
                break;
}
            attacker = enemy;
            defender = player;
            int enemyMove = randomNumber();

            switch (enemyMove) {
                case 1:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    if (attacker.getAusdauer() >= 5) {
                        attacker.setAusdauer(attacker.getAusdauer() - 5);
                        System.out.println("\n" + enemy.getName() + " attacks. Spent 5 stamina.");
                        if (playerBlock == 0) {
                            defender.setLebensPunkte(defender.getLebensPunkte() - 10);
                            System.out.println(playerName + " took 10 damage.\n");
                        } else {
                            defender.setLebensPunkte(defender.getLebensPunkte() - 5);
                            System.out.println(playerName + " blocks 50% damage. -5 health. \n");
                        }
                    } else {
                        System.out.println("\n" + enemy.getName() + " does not have enough stamina.\n");
                    }
                    playerBlock = 0;

                    if (defender.getLebensPunkte() <= 0) {
                        enemyWins();
                        continueGame = false;
                    }
                    break;

                case 2:
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.println("\n" + enemy.getName() + " prepares to block");
                    enemyBlock = 1;
                    break;

                case 3:
                    
                    break;
            
                default:
                    System.out.println("Error");
                    break;
            }

            attacker = player;
            defender = enemy;
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

    public static void playerWins() {
        System.out.println("\nWith one final strike, Dark Spiegel fades into nothing. You have defeated your own reflection.");
    }

    public static void enemyWins() {
        System.out.println("\nYou try to stand, but your strength fades.");
        System.out.println("Your mirror image watches silently as you fall.");
        System.out.println("Dark Spiegel has defeated you.");
        System.out.println("Game Over.");
    }

    public static int randomNumber() {
        double value = Math.random() * 3;
        return (int)(value + 1);
    }

}

