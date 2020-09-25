import java.io.IOException;

public class Duke {
    public static boolean isAwake =true;
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    /**
     * This is the Duke Class
     * It initialises the program
     */

    public Duke(String filePath){
        ui = new Ui();
        try{
            storage = new Storage(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tasks = new TaskList(storage.loadData());


    }

    public void run() {
        while (isAwake) {
            new Parser(ui.getInput(),tasks);
            storage.saveData(tasks.getTaskList());


        }
        Ui.sayGoodbye();

    }

    public static void main(String[] args) {
        new Duke("savedata.txt").run();
    }
}
