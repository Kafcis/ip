import java.util.Scanner;

public class Greet {


    public static void main(String[] args) {
        System.out.println("Salutations! my name is Duke\nHow may I help you today?\n");
        while (true) {
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            if (command.equals("bye")){
                System.out.println("Goodbye");
                break;
            }
            else{
                System.out.println("Echoing: "+command);

            }
        }
    }




}
