package Programs;

//Define an interface for tasks
interface Task {
 void assignTask(String assignee);
 void completeTask();
 String getTaskDetails();
}

//Implement a class for managing tasks
class TaskManager {
 private Task[] tasks;

 public TaskManager(int capacity) {
     tasks = new Task[capacity];
 }

 public void addTask(Task task, int index) {
     if (index >= 1 && index < tasks.length) {
         tasks[index] = task;
     } else {
         System.out.println("Invalid task index.");
     }
 }

 public void listTasks() {
     for (int i = 1; i < tasks.length; i++) {
         if (tasks[i] != null) {
             System.out.println("Task " + i + ": " + tasks[i].getTaskDetails());
         } else {
             System.out.println("Task " + i + ": Empty");
         }
     }
 }
}

//Implement a concrete task class
class CollaborativeTask implements Task {
 private String taskName;
 private String assignee;
 private boolean isCompleted;

 public CollaborativeTask(String taskName) {
     this.taskName = taskName;
     this.isCompleted = false;
 }

 @Override
 public void assignTask(String assignee) {
     this.assignee = assignee;
 }

 @Override
 public void completeTask() {
     this.isCompleted = true;
 }

 @Override
 public String getTaskDetails() {
     return "Task Name: " + taskName + ", Assignee: " + assignee + ", Completed: " + isCompleted;
 }
}

public class Main {
 public static void main(String[] args) {
     TaskManager taskManager = new TaskManager(5);

     Task task1 = new CollaborativeTask("Design UI");
     Task task2 = new CollaborativeTask("Implement Backend");
     Task task3 = new CollaborativeTask("Include Database");

     task1.assignTask("John");
     task2.assignTask("Alice");
     task3.assignTask("Nida");

     taskManager.addTask(task1, 1);
     taskManager.addTask(task2, 2);
     taskManager.addTask(task3, 3);

     taskManager.listTasks();

     task1.completeTask();

     System.out.println("After completion of task 1:");
     taskManager.listTasks();
 }
}
