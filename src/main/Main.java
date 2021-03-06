import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    private static int MAX_TASK_SIZE = 100;
    private static ArrayList<Task> taskList = new ArrayList<Task>(100);
    private static int listCounter = 0;
    private static boolean isAwake =true;
    public static void main(String[] args) {
        System.out.println("Salutations! my name is Duke\nHow may I help you today?\n");
        while (isAwake) {
            loadData();
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
            case "delete":{
                doDelete(command);
                break;
            }
            default: {
                includeTask(input);
            }
            }
            DataGetSet.saveData(taskList);
        }
    }

    private static void loadData() {
        if (taskList.size()==0) {
            System.out.println("Loading data...");
            try {
                taskList = DataGetSet.loadData(taskList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void doDelete(String[] command) {
        int value;
        try {
            value=Integer.parseInt(command[1]);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("index required");
            return;
        }
        System.out.println("Nice! I've removed this task : "+ taskList.get(value-1).toString());
        taskList.remove(value-1);
        listCounter--;
    }

    private static void listTask() {
        System.out.println("Here is the list of tasks");
        for (int i = 0; i < listCounter; i++) {
            System.out.println( i+1 + ". " + taskList.get(i).toString());
        }
        System.out.println("there are "+ (listCounter) +" tasks in the list");
    }

    private static void doTask(String[] command) {
        int value;
        try {
            value=Integer.parseInt(command[1]);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("index required");
            return;
        }
        taskList.get(value-1).setDone(true);
        System.out.println("Nice! I've marked this task as done: "+ taskList.get(value-1).toString());
    }

    public static void includeTask(String args){
        String[] sections = args.split(" ");
        int descriptionStart = args.indexOf(" ")+1;
        String description=args;
        switch (sections[0]){
        case "deadline":{
            int dividerPosition = args.indexOf("/");
            try {
                description= args.substring(descriptionStart,dividerPosition-1);
            } catch(StringIndexOutOfBoundsException e){
                System.out.print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of a deadline or the time cannot be empty.\n" +
                        " ____________________________________________________________\n");
                return;
            }
            taskList.add(new Deadline(description,args.substring(dividerPosition+4),args));
            break;
        }
        case "todo":{
            try {
                description=sections[1];
                description=args.substring(descriptionStart);
            } catch(IndexOutOfBoundsException e){
                System.out.print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of a todo cannot be empty.\n" +
                        " ____________________________________________________________\n");
                return;
            }

            taskList.add(new Todo(description,args));
            break;
        }
        case "event":{
            int dividerPosition = args.indexOf("/");
            try {
                description= args.substring(descriptionStart,dividerPosition-1);
            } catch(StringIndexOutOfBoundsException e){
                System.out.print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of an event or the time cannot be empty.\n" +
                        " ____________________________________________________________\n");
                return;
            }

            taskList.add(new Event(description,args.substring(dividerPosition+4),args));
            break;
        }
        default: {
            //taskList[listCounter] = new Task(args);
            System.out.println("Retype that but correctly this time?\nThat command is not recognised\n");
            return;
        }

        }
        System.out.println("Added: " + description);
        listCounter++;
        }

}








