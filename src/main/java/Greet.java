import java.util.*;

public class Greet {

    private static String[] list= new String[100];
    private static boolean[] checklist= new boolean[100];
    private static int listCounter= 0;
    private static boolean isAwake=true;

    public static void main(String[] args) {
        System.out.println("Salutations! my name is Duke\nHow may I help you today?\n");
        while (isAwake) {
            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            switch (command) {
            case "bye": {
                System.out.println("Goodbye");
                isAwake=false;
                break;
            }
            case "list": {
                for (int i = 0; i < listCounter; i++) {
                    System.out.println(String.valueOf(i + 1) + ". " + list[i]);
                }
                break;
            }
            default: {
                include(command);
                System.out.println("Added: " + command);
            }
            }
        }
    }
    public static void include(String args){
        list[listCounter]=args;
        listCounter++;
        }
    public static void setCheck(int arg){
        checklist[arg]=true;
    }
    public static boolean isCheck(int arg){
        return checklist[arg];
    }





}
