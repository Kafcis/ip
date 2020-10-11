import java.util.Scanner;

public class Ui {
    private static String input;

    public static void main(String[] args) {
        System.out.println("Salutations! my name is Duke\nHow may I help you today?\n");
    }

    public static String getInput() {
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        return input;
    }

    public static void sayGoodbye() {
        System.out.println("Goodbye");
    }

    public static void loading() {
        System.out.println("Loading data...");
    }


}
