import java.util.*;

public class Greet {

    private static String[] list= new String[100];
    private static int listCounter= 0;

    public static void main(String[] args) {
        System.out.println("Salutations! my name is Duke\nHow may I help you today?\n");
        while (true) {
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            if (command.equals("bye")) {
                System.out.println("Goodbye");
                break;
            }
            else if (command.equals("list")){
                for(int i=0; i<listCounter;i++){
                    System.out.println(String.valueOf(i+1)+". "+list[i]);
                }
            }
            else {
                include(command);
                System.out.println("Added: " + command);
            }

        }
    }
    public static void include(String args){
        list[listCounter]=args;
        listCounter++;

        }





}
