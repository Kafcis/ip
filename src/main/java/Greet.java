import java.util.Scanner;

public class Greet {
    private static int MAX_TASK_SIZE = 100;
    private static Task[] taskList = new Task[100];
    private static int listCounter = 0;
    private static boolean isAwake =true;
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
                listTask();
                break;
            }
            case "done":{
                doTask(command);
                break;
            }
            default: {
                includeTask(input);
            }
            }
        }
    }

    private static void listTask() {
        System.out.println("Here is the list of tasks");
        for (int i = 0; i < listCounter; i++) {
            System.out.println( i+1 + ". " + taskList[i].toString());
        }
        System.out.println("there are "+ (listCounter) +" tasks in the list");
    }

    private static void doTask(String[] command) {
        if (command.length<2){
            System.out.println("index required");
            return;
        }
        int value=Integer.parseInt(command[1]);
        taskList[value-1].setDone(true);
        System.out.println("Nice! I've marked this task as done: "+ taskList[value-1].toString());
    }

    public static void includeTask(String args){
        String[] sections = args.split(" ");
        int descriptionStart = args.indexOf(" ")+1;
        String description=args;
        switch (sections[0]){
        case "deadline":{
            int dividerPosition = args.indexOf("/");
            description= args.substring(descriptionStart,dividerPosition-1);
            taskList[listCounter] = new Deadline(description,args.substring(dividerPosition+4));
            break;
        }
        case "todo":{
            description=args.substring(descriptionStart);
            taskList[listCounter] = new Todo(description);
            break;
        }
        case "event":{
            int dividerPosition = args.indexOf("/");
            description= args.substring(descriptionStart,dividerPosition-1);
            taskList[listCounter] = new Event(description,args.substring(dividerPosition+4));
            break;
        }
        default: {
            taskList[listCounter] = new Task(args);
        }

        }
        System.out.println("Added: " + description);
        listCounter++;
        }

}








