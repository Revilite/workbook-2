public class Dice {
    public static int roll(){
        int randomNumber = (int)(Math.random() * 6) + 1;
        return randomNumber;
    }
}
