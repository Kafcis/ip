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
            String input = in.nextLine();
            String[] command = input.split(" ");
            switch (command[0]) {
            case "bye": {
                System.out.println("Goodbye");
                isAwake=false;
                break;
            }
            case "list": {
                System.out.println("Here is the list of tasks");
                for (int i = 0; i < listCounter; i++) {
                    System.out.println(String.valueOf(i + 1) + "." + getCheck(i)  + " "+list[i]);
                }
                break;
            }
            case "done":{
                System.out.println("Nice! I've marked this task as done: ");
                int value=Integer.parseInt(command[1]);
                setCheck(value-1);
                System.out.println(String.valueOf(value) + "." + getCheck(value-1)  + " "+list[value-1]);
                break;
            }
            default: {
                include(input);
                System.out.println("Added: " + input);
            }
            }
        }
    }
    public static void include(String args){
        list[listCounter]=args;
        checklist[listCounter]=false;
        listCounter++;
        }
    public static void setCheck(int arg){
        checklist[arg]=true;
    }
    public static String getCheck(int arg){
        if(checklist[arg]){
            return "[✓]";
        }
        else{
            return "[✗]";
        }
    }





}
