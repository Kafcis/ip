
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
# User Guide

## Features 

### Feature 1 
Adding, deleting and marking tasks as done
### Feature 2 
Autosaving documents
### Feature 3
Three different types of tasks to choose from

# Files


DUKE stores your files in your project folder, which means all your files are automatically saved locally and are accessible 


## Add a todo task
### `todo` - Include a todo in the list

Type in a todo task to add and it will show you the task you have added

Example of usage: 

`todo (task)`

Expected outcome:

    todo task
    Added: task
    Successfully wrote to the file.`

## Add a deadline task
### `deadline` - Include a deadline in the list

Type in a deadline task to add and it will show you the task you have added

Example of usage: 

`deadline (task) /by (time)` 

Expected outcome:

    deadline task /by time
    Added: task
    Successfully wrote to the file.


## Add a event task
### `event` - Include a event in the list

Type in a event task to add and it will show you the task you have added

Example of usage: 

`event (task) /at (place)`

Expected outcome:

    event task /at place
    Added: task
    Successfully wrote to the file.



## List tasks
### `list` - Displays a list of all tasks

Shows a numbered list of all tasks, together with its type, completion status, descriptor and any other relevant information in input order

Example of usage: 

`list`

Expected outcome:

    list
    Here is the list of tasks
    1. [T][N] task
    2. [D][N] task (by: time)
    3. [E][N] task (at: place)
    there are 3 tasks in the list
    Successfully wrote to the file.


## Find tasks
### `find` - Locates and displays tasks

You can list all task containing the word in a similar format to the `list` command

Example of usage: 

`find word`

Expected outcome:

    find word
    Here are the matching tasks in your list:
    1. [T][N] word
    there are 1 tasks in the list
    Successfully wrote to the file.



## Delete a task
### `delete` - Remove a task from the list

It permanently removes the task from the list and shifts the rest of the tasks down in the numerical order

Example of usage: 

`delete index`

Expected outcome:

    delete 1
    Nice! I've removed this task : [T][N] task
    Successfully wrote to the file.`


## Mark a task as done
### `done` - Sets the completion status as done

It changes the icon in the second square brackets to Y to denote that it has been completed

Example of usage: 

`done index`

Expected outcome:

    done 3
    Nice! I've marked this task as done: [T][Y] word
    Successfully wrote to the file.`

You can mark a task as done by typing `done"index"` where index is the number next to the task when accessed from the list command


## Save a task list

Files are saved automatically as "savedata.txt" in the project folder

