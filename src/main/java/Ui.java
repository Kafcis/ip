import java.util.Scanner;

public class Ui {
    private static String input;
    /**
     * This method "greet" is used to print the greeting
     */
    public static void greet() {
        System.out.println("Salutations! my name is Duke\nHow may I help you today?\n");
    }
    /**
     * This method "getInput" is used get user command
     * @return a String that represents the user command
     */
    public static String getInput() {
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        return input;
    }
    /**
     * This method "sayGoodbye" is used to print the greeting
     */
    public static void sayGoodbye(){
        System.out.println("Goodbye");
    }
    /**
     * This method "loading" is used to print the greeting
     */
    public static void loading(){
        System.out.println("Loading data...");
    }
}
