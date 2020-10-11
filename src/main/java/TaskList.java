import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> taskList;
    private static int listCounter = 0;

    public TaskList(ArrayList<Task> loadData) {
        taskList = loadData;
    }

    /**
     * This method "doDelete" is used to remove tasks from TaskList
     *
     * @param command that is used to store information on what to delete
     */

    public static void doDelete(String[] command) {
        int value;
        try {
            value = Integer.parseInt(command[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index required");
            return;
        }
        try {
            System.out.println("Nice! I've removed this task : " + taskList.get(value - 1).toString());
            taskList.remove(value - 1);
            listCounter--;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Task does not exist");
        }
    }

    /**
     * This method "listTask" is used to print tasks from TaskList
     */
    public static void listTask() {
        System.out.println("Here is the list of tasks");
        for (int i = 0; i < listCounter; i++) {
            System.out.println(i + 1 + ". " + taskList.get(i).toString());
        }
        System.out.println("there are " + (listCounter) + " tasks in the list");
    }

    /**
     * This method "doTask" is used to mark tasks from TaskList as done
     *
     * @param command that is used to store information on what to mark as done
     */
    public static void doTask(String[] command) {
        int value;
        try {
            value = Integer.parseInt(command[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index required");
            return;
        }
        try {
            taskList.get(value - 1).setDone(true);
            System.out.println("Nice! I've marked this task as done: " + taskList.get(value - 1).toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Task does not exist");
        }
    }

    /**
     * This method "includeTask" is used to add tasks from TaskList according to its type
     *
     * @param args is a string that contains information about the type of task it is
     */
    public static void includeTask(String args) {
        String[] sections = args.split(" ");
        int descriptionStart = args.indexOf(" ") + 1;
        String description = args;
        switch (sections[0]) {
        case "deadline": {
            int dividerPosition = args.indexOf("/");
            try {
                description = args.substring(descriptionStart, dividerPosition - 1);
                taskList.add(new Deadline(description, args.substring(dividerPosition + 4), args));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of a deadline or the time cannot be empty.\n" +
                        " ____________________________________________________________\n");
                return;
            }
            break;
        }
        case "todo": {
            try {
                description = sections[1];
                description = args.substring(descriptionStart);
                taskList.add(new Todo(description, args));
            } catch (IndexOutOfBoundsException e) {
                System.out.print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of a todo cannot be empty.\n" +
                        " ____________________________________________________________\n");
                return;
            }
            break;
        }
        case "event": {
            int dividerPosition = args.indexOf("/");
            try {
                description = args.substring(descriptionStart, dividerPosition - 1);
                taskList.add(new Event(description, args.substring(dividerPosition + 4), args));
            } catch (StringIndexOutOfBoundsException e) {
                System.out.print("____________________________________________________________\n" +
                        "☹ OOPS!!! The description of an event or the time cannot be empty.\n" +
                        " ____________________________________________________________\n");
                return;
            }
            break;
        }
        default: {
            System.out.println("Retype that but correctly this time?\nThat command is not recognised\n");
            return;
        }
        }
        System.out.println("Added: " + description);
        listCounter++;
    }

    /**
     * This method "getTaskList" is used to save tasks from TaskList to Storage
     */
    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void findWord(String[] command) {
        String word;
        try {
            word = command[1];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("____________________________________________________________\n" +
                    "☹ OOPS!!! The space for the word cannot be empty.\n" +
                    " ____________________________________________________________\n");
            return;
        }
        int counter = 0;
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < listCounter; i++) {
            if (taskList.get(i).getDescription().contains(word)) {
                counter++;
                System.out.println(counter + ". " + taskList.get(i).toString());
            }

        }
        System.out.println("there are " + (counter) + " tasks in the list");

    }

    public static int getListCounter() {
        return listCounter;
    }
}
