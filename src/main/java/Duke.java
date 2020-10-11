import java.io.IOException;

public class Duke {
    public static boolean isAwake = true;
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    /**
     * This is the Duke Class
     * It initialises the program
     */

    public Duke(String filePath) {
        this.ui = new Ui();
        try {
            this.storage = new Storage(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.tasks = new TaskList(storage.loadData());
    }

    public void run() {
        ui.greet();
        while (isAwake) {
            int taskSize = tasks.getListCounter();
            new Parser(ui.getInput(), tasks);
            if(tasks.getListCounter()>taskSize) {
                storage.saveData(tasks.getTaskList());
            }
        }
        Ui.sayGoodbye();
    }

    public static void main(String[] args) {
        new Duke("savedata.txt").run();
    }
}
