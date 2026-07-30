import java.util.HashMap;

/*
 * An abstract representation of a roulette wheel
 */
public class Wheel {

    private static long timeDelay = 100; // The ammount of time between each round
    
    private static HashMap<Integer, String> numbers = new HashMap<>(); // Hold number data

    /**
     * Puts the numbers on a roulette wheel into a hash map
     */
    public static void generateNumbersOnWheel(){

      // Assign the numbers to either red or black
      // 1-10
        for (int i = 1; i <= 10; i++){
            if (i % 2 == 0){
                numbers.put(i, "Black");
            } else{
                numbers.put(i, "Red");
            }
         
        }
        // 11-18
        for (int i = 11; i <= 18; i++){
            if (i % 2 == 0){
                numbers.put(i, "Red");
            } else {
                numbers.put(i, "Black");
            }
        }

        // 19-28
        for (int i = 19; i <= 28; i++){
            if (i % 2 == 0){
                numbers.put(i, "Black");
            } else {
                numbers.put(i, "Red");
            }
        }

        // 29-36
        for(int i = 29; i <= 36; i++){
            if (i % 2 == 0){
                numbers.put(i, "Red");
            } else {
                numbers.put(i, "Black");
            }
        }

        // Single and double 0
        for (int i = 0; i <= 2; i++){
            if (i == 0) {
                numbers.put(37, "Green");
            } else {
                numbers.put(38, "Green");
            }
        }
        
    }


    /**
     * Replectates spinning a real roulette wheel by generating a
     * random number
     * @return
     */
    public static Object[] spinWheel(){
        int randomResult = 1 + (int) (Math.random() * ((38 - 1) + 1));

        try {
            Thread.sleep(timeDelay);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        Object[] resultMap = new Object[2];

        // Handle the green numbers
        if (randomResult == 37){
            resultMap[1] = 0;
        } else if(randomResult == 38){
            resultMap[1] = 00;
        } else {
            // All other numbers
            resultMap[1] = randomResult;
        }
            resultMap[0] = numbers.get(randomResult); // Gets the color of the number

        return resultMap;
    }
}
