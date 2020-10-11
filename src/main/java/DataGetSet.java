import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataGetSet {
    private static String filepath = "savedata.txt";
    private ArrayList<Task> savedTaskList = new ArrayList<>();

    public static void setFilepath(String filepath) {
        DataGetSet.filepath = filepath;
    }

    /**
     * This method "saveData" is used to read data from the text file
     *
     * @param taskList TaskList that stores the tasks of Duke
     * @throws IOException exception thrown when there is an error writing to the text file
     */

    public static void saveData(ArrayList<Task> taskList) {
        int listCounter = 0;
        try {
            FileWriter myWriter = new FileWriter(filepath);
            myWriter.write("LOG:");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (Task record : taskList) {
            String message;
            message = record.getConstruct();
            listCounter++;
            try {
                FileWriter myWriter = new FileWriter(filepath, true);
                myWriter.write("\n" + message);
                if (record.isDone()) {
                    myWriter.write("\ndone " + listCounter);
                }
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        System.out.println("Successfully wrote to the file.");
    }

    /**
     * This method "loadData" is used to read data from the text file
     *
     * @param taskList TaskList that stores the tasks of Duke and tasks TaskList that uses TaskList methods
     * @return taskList with the tasks from the save file
     * @throws IOException exception thrown when there is an error reading the text file
     */
    public static ArrayList<Task> loadData(ArrayList<Task> taskList, TaskList tasks) throws IOException {
        try {
            BufferedReader input = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = input.readLine()) != null) {

                if ((line.substring(0, 4)).equals("LOG:")) {
                    System.out.println("Commencing data transfer");
                } else if ((line.substring(0, 4)).equals("done")) {
                    taskList.get(Integer.parseInt(line.substring(5)) - 1).setDone(true);
                } else {
                    tasks.includeTask(line);
                }
            }
            System.out.println("Ending data transfer");
            input.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        return taskList;
    }
}


