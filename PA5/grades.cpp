// Name:Ziyi Xu
// USC NetID:ziyix
// CSCI 455 PA5
// Fall 2018

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"


// cstdlib needed for call to atoi
#include <cstdlib>
#include <iostream>

using namespace std;
// the help function declaration.You can see their introduction below.
void commandHandle(Table * grades, string com);
void helpCommand();

int main(int argc, char * argv[]) {

   // gets the hash table size from the command line

   int hashSize = Table::HASH_SIZE;

   Table * grades;  // Table is dynamically allocated below, so we can call
   // different constructors depending on input from the user.

   if (argc > 1) {
      hashSize = atoi(argv[1]);  // atoi converts c-string to int

      if (hashSize < 1) {
         cout << "Command line argument (hashSize) must be a positive number" 
              << endl;
         return 1;
      }

      grades = new Table(hashSize);

   }
   else {   // no command line args given -- use default table size
      grades = new Table();
   }


   grades->hashStats(cout);
   
   // add more code here
   // Reminder: use -> when calling Table methods, since grades is type Table*
   
   cout << "cmd>";
   string command;
   
   //in this loop, we type the commands and get the output
   // this loop will always continue until the client typed "quit"
   while(true){  
      cin >> command;
      if(command == "quit"){ //"quit" is a signal to terminate this program
         break;
      }
      if(command == "print"){
         grades -> printAll();
      }
      else if(command == "size"){
         cout << "The number of entries is: " << grades -> numEntries() << endl;
      }
      else if(command == "stats"){
         grades -> hashStats(cout);
      }
      else if(command == "help"){
         helpCommand();
      }
      else{
         commandHandle(grades, command);
      }  
      cout << "cmd>";
   }
      
      
   return 0;
}

//the help function to handle the command "insert", "change", "lookup",
//"remove" and the error command.
//param@ grades a Table* in which to do the commands
//param@ com the command we should handle
void commandHandle(Table * grades, string com){
   string name;
   int score;
   if(com == "insert"){
      cin >> name;
      cin >> score;
      
      if(!grades -> insert(name, score)){
         cout << "The student's score has been stored." << endl;
      }
   }
   
   else if(com == "change"){
      cin >> name;
      cin >> score;
      int *val = grades -> lookup(name);
      if(val == NULL){
         cout << "Student not found." << endl;
      }
      else{
         *val = score;
      }
   }
   
   else if(com == "lookup"){
      cin >> name;
      int *val = grades -> lookup(name);
      if(val == NULL){
         cout << "Student not found." << endl;
      }
      else{
         cout << "His or her score is: " << *val << endl;
      }
   }  
   
   else if(com == "remove"){
      cin >> name;
      int *val = grades -> lookup(name);
      if(val == NULL){
         cout << "Student not found." << endl;
      }
      else{
         grades -> remove(name);
      }
   }
      
   else{
      cout << "ERROR: invalid command" << endl;
      helpCommand();
   }
   
}

//the help function to print out the help
//information. When the client typed help
//or some incorrect commands. The information
//below will be given to the client.
void helpCommand(){
   cout << "Commands in this program" << endl;
   cout << "insert name score: add a student's score" << endl;
   cout << "change name score: change a student's score" << endl;
   cout << "lookup name: look up a student's score" << endl;
   cout << "remove name: remove a student's score" << endl;
   cout << "print; print out all student's name and score" << endl;
   cout << "size: print out the number of entries" << endl;
   cout << "stats: print out statics about the hash table" << endl;
   cout << "help: get command summary like this." << endl;
   cout << "quit: exit this program" << endl;
}


   
   
      
   
   
      
      
  
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
