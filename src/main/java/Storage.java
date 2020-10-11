import java.io.IOException;
import java.util.ArrayList;

public class Storage {
    private static int MAX_TASK_SIZE = 100;
    private static ArrayList<Task> taskList = new ArrayList<Task>(100);
    private static String filepath = "savedata.txt";
    private static TaskList original = new TaskList(taskList);
    /**
     * This constructor "Storage" is used to read data from the designated file path
     * @throws IOException exception thrown when there is an error reading
     */
    public Storage(String filePath) throws IOException {
        DataGetSet.setFilepath(filePath);

        try {
            taskList = DataGetSet.loadData(taskList,original);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * This method "loadData" is used to add tasks from Storage into TaskList
     * @param args is a string that contains information about the type of task it is
     */
    public static ArrayList<Task> loadData() {
        if (taskList.size()==0) {
            Ui.loading();
            try {
                taskList = DataGetSet.loadData(taskList,original);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return taskList;
    }
    /**
     * This method "saveData" is used to store the information from TaskList
     * @param taskList is an ArrayList that contains all the tasks
     */
    public static void saveData(ArrayList<Task> taskList){
        DataGetSet.saveData(taskList);
    }
}
