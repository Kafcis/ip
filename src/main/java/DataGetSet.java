import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public  class DataGetSet {
    public static final String filepath ="C:/Users/kafci/Documents/ip/text-ui-test/savedata.txt";
    private ArrayList<Task> savedTaskList = new ArrayList<>();
    public static void saveData(ArrayList<Task> taskList) {
        try {
            FileWriter myWriter = new FileWriter(filepath);
            myWriter.write("LOG:\n");
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for( Task record : taskList){
            String message;
            if(record instanceof Todo){
                message= "T | "+ record.toString();
            }else if(record instanceof Deadline){
                message= "D | "+ record.toString();
            }else if(record instanceof Event){
                message= "E | "+ record.toString();
            }else{
                break;
            }
            try{
                FileWriter myWriter = new FileWriter(filepath,true);
                myWriter.write(message+"\n");
                myWriter.close();
            }catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        System.out.println("Successfully wrote to the file.");
    }

}
