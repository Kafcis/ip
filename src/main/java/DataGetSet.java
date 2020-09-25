import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;

public class DataGetSet {
    private static String filepath = "savedata.txt";
    private ArrayList<Task> savedTaskList = new ArrayList<>();


    public static void setFilepath(String filepath) {
        DataGetSet.filepath = filepath;
    }

    public static void saveData(ArrayList<Task> taskList) {
        int listCounter = 0;
        try {
            FileWriter myWriter = new FileWriter(filepath);
            myWriter.write("LOG:");
            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for( Task record : taskList){
            String message;
            message=record.getConstruct();
            listCounter++;


            try{
                FileWriter myWriter = new FileWriter(filepath,true);

                myWriter.write("\n"+message);
                if(record.isDone()){
                    myWriter.write("\ndone "+ listCounter);

                }
                myWriter.close();
            }catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        System.out.println("Successfully wrote to the file.");
    }

    public static ArrayList<Task> loadData(ArrayList<Task> taskList, TaskList tasks) throws IOException{
            try {
                BufferedReader input = new BufferedReader( new FileReader(filepath));
                String line;
                while ((line = input.readLine()) != null) {

                    if ((line.substring(0,4)).equals("LOG:")){
                        System.out.println("Commencing data transfer");
                    }else if((line.substring(0,4)).equals("done")){
                        taskList.get(Integer.parseInt(line.substring(5))-1).setDone(true);
                    }else{
                        tasks.includeTask(line);
                    }
                }




                System.out.println("Ending data transfer");

                // Closes the reader
                input.close();
            }

            catch(Exception e) {
                e.getStackTrace();


            }
        return taskList;


        }




    }


