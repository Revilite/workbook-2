public class App {
    public static void main(String[] args) {
       Dice dice = new Dice();
       int roll1;
       int roll2;
       int twoCounter = 0;
       int fourCounter = 0;
       int sixCounter = 0;
       int sevenCounter = 0;

        for (int i = 0; i <= 100; i++) {
            roll1 = dice.roll();
            roll2 = dice.roll();
            int sum = roll1 + roll2;

            System.out.println("Roll " + i + ":  " + roll1 + "  -  " + roll2 + "   Sum:   " + sum);
            switch (sum){
                case 2: twoCounter++;
                case 4: fourCounter++;
                case 6: sixCounter++;
                case 7: sevenCounter++;
            }
        }
        System.out.println("The two rolls added to 2 " + twoCounter + " times");
        System.out.println("The two rolls added to 4 " + fourCounter + " times");
        System.out.println("The two rolls added to 6 " + sixCounter + " times");
        System.out.println("The two rolls added to 7 " + sevenCounter + " times");



    }
}
