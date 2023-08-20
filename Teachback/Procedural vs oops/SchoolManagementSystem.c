//Sample code of a simple school management system using procedural C language.
#include <stdio.h>

#include <string.h>


struct Student {

char name[50];

int age;

float grade;

};

 

struct Teacher {

char name[50];

int age;

char qualification[50];

char subject[50];

};

 

void addStudent(struct Student students[], int count) {

printf("Enter student name: ");

scanf("%s", students[count].name);

printf("Enter student age: ");

scanf("%d", &students[count].age);

printf("Enter student grade: ");

scanf("%f", &students[count].grade);

}

 

void addTeacher(struct Teacher teachers[], int count) {

printf("Enter teacher name: ");

scanf("%s", teachers[count].name);

printf("Enter teacher age: ");

scanf("%d", &teachers[count].age);

printf("Enter teacher qualification: ");

scanf("%s", teachers[count].qualification);

printf("Enter teacher subject: ");

scanf("%s", teachers[count].subject);

}

int main() {

struct Student students[100];

struct Teacher teachers[50];

int studentCount = 0;

int teacherCount = 0;

 

printf("School Management System\n");

 

char choice;

do {

     printf("1. Add Student\n2. Add Teacher\n3. Exit\n");

     printf("Enter your choice: ");

        scanf(" %c", &choice);

 

     switch(choice) {

         case '1':

             addStudent(students, studentCount);

             studentCount++;

             break;

         case '2':

             addTeacher(teachers, teacherCount);

             teacherCount++;

             break;

         case '3':

                printf("Exiting...\n");

             break;

         default:

             printf("Invalid choice\n");

     }

} while(choice != '3');

 

return 0;

}

