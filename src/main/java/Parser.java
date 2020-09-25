public class Parser {

    public Parser(String input, TaskList tasks) {
        String[] command = input.split(" ");
        switch (command[0]) {
        case "bye": {
            Duke.isAwake = false;
            break;
        }
        case "list": {
            tasks.listTask();
            break;
        }
        case "done": {
            tasks.doTask(command);
            break;
        }
        case "delete": {
            tasks.doDelete(command);
            break;
        }
        case "find":{
            tasks.findWord(command);
            break;
        }
        default: {
            tasks.includeTask(input);
        }
        }
    }
}

