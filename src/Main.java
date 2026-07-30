import java.util.Scanner;

/**
 * The main roulette game using the martingale strategy
 */
public class Main {

    // Params
    private static double bankroll = 0.0;
    private static double maxBet = 0.0;
    private static double initialBet = 0.0;
    private static boolean betOnBlack;
    private static String response;

    // Game variables
    private static double currentBet;
    private static int roundNumber = 1;
    private static Object[] result; // Holds number and color (i.e Black 35)
    private static double highestAmmount = 0.0;
 
    // Scanner for user input
    private static Scanner scanner = new Scanner(System.in);

    /*
     * Gets input from the user
     */
    public static void getInput(){

        // Get input for bankroll and ensure it meets the parameters
        if (bankroll <= 0.0){
            System.out.print("Please enter your bankroll amount: ");

            // Check that the next line is a double
            if(scanner.hasNextDouble()){
                bankroll = scanner.nextDouble();

                // Check that the double is postive
                if (bankroll <= 0.0){
                    System.out.println("You must enter a positive number!");
                    getInput();
                }

            // The user did not enter a number and should try again
            } else {
                System.out.println("You must enter a positive number!");
                scanner.next();

                getInput();
            } 
        }

        // Get input for max bet and ensure it meets the parameters
        if (maxBet <= 0.0){
            System.out.print("Please enter the max bet for the table: ");

            if(scanner.hasNextDouble()){
                maxBet = scanner.nextDouble();

                  // Check that the double is postive
                if (maxBet <= 0.0){
                    System.out.println("You must enter a positive number!");
                    getInput();
                }
            } else {
                System.out.println("You must enter a positive number!");
                scanner.next();

                getInput();
            } 
        }

        // Get input for initial bet and ensure it meets the parameters
        if (initialBet < 2.0){
                System.out.print("Please enter your starting bet amount (>=2): ");

                if(scanner.hasNextDouble()){
                    initialBet = scanner.nextDouble();

                    // Check that the double is postive
                    if (initialBet < 2.0){
                        System.out.println("You must have a positive number >= 2!");
                        getInput();
                    }
                } else {
                    System.out.println("You must enter a positive number >= 2!");
                    scanner.next();

                    getInput();
                } 
        }


        // Determine if we want to bet on black or red
        System.out.print("Bet on black or red (Type: b or r): ");
        if (scanner.hasNext()) {
              response = scanner.next();

            switch (response) {
            case "b":
                betOnBlack = true;
                break;
        
            case "r":
                betOnBlack = false;
                break;
            default:
                // Check for invalid response
                response = null;
                getInput();             
        }
        }
        
    }

    /**
     * Simulates a real life game of roulette with martingale
     */
    public static void runSimulation(){

        // Generate the roulette wheel
        Wheel.generateNumbersOnWheel();
        currentBet = initialBet; // Make sure we are starting with our initial bet

        while (bankroll > 0 && currentBet <= bankroll && currentBet <= maxBet) {
            System.out.println("Round: " + roundNumber);
            System.out.println("Current bet: " + "$" + currentBet);
            System.out.println("Bankroll: " + "$"+ bankroll);
            bankroll = bankroll - currentBet;
            result = Wheel.spinWheel();

            // Print round result
            System.out.print("Result: " + result[0] + " ");
            System.out.println(result[1]);

            if (betOnBlack && result[0].equals("Black")){
                System.out.println("You win this round!\n");
                bankroll = bankroll + currentBet * 2;
                currentBet = initialBet;
            } else if(!betOnBlack && result[0].equals("Red")){
                System.out.println("You win this round!\n");
                bankroll = bankroll + currentBet * 2;
                currentBet = initialBet;
            } else {
                System.out.println("You did not win this round\n");
                currentBet = currentBet * 2; // Increase the bet by x2
            }

            if (bankroll > highestAmmount){
                highestAmmount = bankroll;
            }

          
            roundNumber ++; // Go to the next round
        }   

        roundNumber = roundNumber - 1; // The previous round was the round lost at

        // Final results
        System.out.println("You played for " + roundNumber + " rounds!");
        System.out.println("You got your bankroll up to " + "$" + highestAmmount  + " during this game!");


    }

    /**
     * The entry point of the program
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
      
        // Get user params
        getInput();

        // Display params to user
        System.out.println("Your bankroll: " + bankroll);
        System.out.println("Max table bet: " + maxBet);
        
        // Determine if we are betting on black or red
        if (betOnBlack){
            System.out.println("You are betting on black\n");
        } else {
            System.out.println("You are betting on red\n");
        }

        // Begin the similation
        runSimulation();

    }
}
