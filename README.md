# Welcome to DUKE!

It's named after the Java mascot _Duke_. Given below are instructions on how to use it.

## Quick start guide
Prerequisites: JDK 11, update Intellij to the most recent version.

1. Open Intellij (if you are not in the welcome screen, click `File` > `Close Project` to close the existing project dialog first)
2. Set up the correct JDK version, as follows:
   1. Click `Configure` > `Structure for New Projects` and then `Project Settings` > `Project` > `Project SDK`
   1. If JDK 11 is listed in the drop down, select it. If it is not, click `New...` and select the directory where you installed JDK 11
   1. Click `OK`
3. Import the project into Intellij as follows:
   1. Click `Open or Import`.
   1. Select the project directory, and click `OK`
   1. If there are any further prompts, accept the defaults.
4. After the importing is complete, locate the `src/main/java/Duke.java` file, right-click it, and choose `Run Duke.main()`. If the setup is correct, you should see something like the below:

    Loading data...
    Salutations! my name is Duke
    How may I help you today?

# Files

DUKE stores your files in your project folder, which means all your files are automatically saved locally and are accessible 


## Add a task

You can add different types of tasks by typing `todo "task"`, `deadline "task" /by time` or `event "task" /at location`.

## List tasks

You can list all task by typing `list` 

## Find tasks

You can list all task containing the word by typing `list "word"` where word is the word you are looking for 

## Delete a task

You can delete a task by typing `delete "index"` where index is the number next to the task when accessed from the list command

## Mark a task as done

You can mark a task as done by typing `done"index"` where index is the number next to the task when accessed from the list command


## Save a task list

Files are saved automatically as "savedata.txt" in the project folder

