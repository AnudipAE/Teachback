// The OOPs approach using Java to create a simple school management system.

import java.util.Scanner;

class Student {

String name;

int age;

float grade;

}


class Teacher {

String name;
int age;
String qualification;
String subject;
} 

public class SchoolManagementSystem {

public static void addStudent(Student[] students, int count) {

     Scanner scanner = new Scanner(System.in);
     students[count] = new Student();

     System.out.print("Enter student name: ");
     students[count].name = scanner.next();

     System.out.print("Enter student age: ");
     students[count].age = scanner.nextInt();

     System.out.print("Enter student grade: ");
     students[count].grade = scanner.nextFloat();
}

public static void addTeacher(Teacher[] teachers, int count) {

     Scanner scanner = new Scanner(System.in);
     teachers[count] = new Teacher();

    

     System.out.print("Enter teacher name: ");

     teachers[count].name = scanner.next();

     System.out.print("Enter teacher age: ");

     teachers[count].age = scanner.nextInt();

     System.out.print("Enter teacher qualification: ");

     teachers[count].qualification = scanner.next();

          System.out.print("Enter teacher subject: ");

     teachers[count].subject = scanner.next();


}

 

public static void main(String[] args) {

     Student[] students = new Student[100];

     Teacher[] teachers = new Teacher[50];

     int studentCount = 0;

     int teacherCount = 0;

 

     System.out.println("School Management System");

 

     char choice;

     Scanner scanner = new Scanner(System.in);

     do {

         System.out.println("1. Add Student\n2. Add Teacher\n3. Exit");

         System.out.print("Enter your choice: ");

         choice = scanner.next().charAt(0);

 

         switch (choice) {

             case '1':

                 addStudent(students, studentCount);

                 studentCount++;

                 break;

             case '2':

                 addTeacher(teachers, teacherCount);

                 teacherCount++;

                 break;

             case '3':

                    System.out.println("Exiting...");

                 break;

             default:

                    System.out.println("Invalid choice");

         }

     } while (choice != '3');

}

}

