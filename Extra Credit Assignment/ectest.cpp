// ectest.cpp
// CSCI 455 Fall 2018, Extra Credit assignment

// Note: this uses separate compilation.  You put your code in ecListFuncs.cpp
// Code in this file calls those funcs.
// You do not need to modify or submit this file.

// ectest.cpp
// a command-based program to manipulate lists.
// to run it use the command:   ectest
//


#include <vector>
#include <iostream>
#include <cctype>
#include <cassert>
#include <string>

// for istringstream
#include <sstream>

#include "ecListFuncs.h"

using namespace std;


int promptForInt (string prompt);
void doBuildList(ListType & theList);
void doHelp();
void add10(ListType list);
void doReverse(ListType list);
void doSplit(ListType & list);
bool readAndDispatchCommand(ListType & theList);

//*************************************************************************


/* a little test program */

int main ()
{

   bool keepgoing = true;

   ListType theList = NULL;

   doHelp();

   do {

      keepgoing = readAndDispatchCommand(theList);

      cout << "The list: ";
      printList (theList);

   } while (keepgoing);

   return 0;
}


/*
 * reads a command and executes it.
 * The command execution updates and/or uses theList, thus it's passed
 * by reference here.
 * Returns false iff the command entered was q (quit)
 */
bool readAndDispatchCommand(ListType & theList) {

   char cmd;

   string lineStr;

   cout << "\nPlease enter a command [b, i, s, n, r, m, p, h, q]: ";
   cin >> cmd;
   getline(cin, lineStr);  // consume and ignore the rest of the line

   if (cmd == 'b') {
      doBuildList(theList);
   }
   else if (cmd == 'i') {
      int val = promptForInt ("Value to insert");
      insertFront (theList, val);
   }
   else if (cmd == 's') {
      doSplit(theList);
   } 
   else if (cmd == 'n') {
      cout << "The number of runs in the list is: " << countRuns(theList) << endl;
   }
   else if (cmd == 'm') {
      removeMiddle(theList);
   }
   else if (cmd == 'r') {
      doReverse(theList);
   }
   else if (cmd == 'p') {
      cout << "Print list: " << endl;
      printList(theList); cout << endl;
   }
   else if (cmd == 'q') {
      return false;
   }
   else {
      doHelp();
   }
    
   return true;
    
}


/*
 * promptForInt: Prompts for and reads an integer.
 */
int promptForInt (string prompt)
{
   int value;

   cout << prompt << ": ";
   cin >> value;
   return value;
}


// reads the numbers from next line in cin into a vector
// Note: this code uses istringstream: this is the analogous feature
//     to using a Scanner on a String in Java.
void readNums(vector<int> & nums) {

   nums.clear();  // empty out any previous values
                             
   string lineStr;

   getline(cin, lineStr);

   if (lineStr.empty()) {
      return;
   }

   istringstream istr(lineStr);

   int num;

   while (istr >> num) { // comes out false if we reach end of string (i.e., eoln)
      nums.push_back(num);
   }
}




// prints a command summary
void doHelp() {
   cout << "Valid commands are" << endl;
   cout << "         b(uild new list), i(nsert in front), s(plit on a value)" << endl;
   cout << "         n(umber of runs), r(everse copy) " <<endl;
   cout << "         m(remove Middle element), p(rint), h(elp), q(uit)." << endl;
}


// adds 10 to all elements in the list
void add10(ListType list) {
   Node *p = list;
   while (p != NULL) {
      p->data += 10;
      p = p->next;
   }
}


// prompts for and reads in values from user into a vector
// and builds a list of those values from the vector
// (Note: it does not require O(n) space to build a list,
// but this is to test your vectorToList function).
void doBuildList(ListType & list) {
   vector<int> nums;
   
   clearList(list);
   cout << "Please enter a sequence of ints followed by <nl> (e.g:1 2 3): ";
   readNums(nums);
   list = vectorToList(nums);
}


// makes a reverse copy of the list.  Prints out the copy,
// modifies the copy, and then prints the copy.
// (when used with the main program, you will be able to see that
//  the original is unchanged if reverse works correctly)
void doReverse(ListType list) {
   ListType revCopy = reverse(list);

   cout << "The reverse copy: ";
   printList(revCopy);
   cout << "Add 10 to all elements in the copy only: ";
   add10(revCopy);
   printList(revCopy);
}


// test split function on list and print results
void doSplit(ListType & list) {
   ListType list1 = NULL;
   ListType list2 = NULL;

   int val = promptForInt("Value to split on");

   split(list, val, list1, list2);
   cout << "Elements before the split: ";
   printList(list1);
   cout << "Elements after the split: ";
   printList(list2);
   cout << "(The list should be empty now.)" << endl;
}




//*****************************************************************
// utility list funcs and Node methods
// (function comments for these are in ecListFuncs.h)

void insertFront(ListType &list, int val) {
   list = new Node(val, list);
}


void printList(ListType list) {

   if (list == NULL) {
      cout << "<empty>";
   }

   Node *p = list;
   while (p != NULL) {
      cout << p->data << " ";
      p = p->next;
   }
   cout << endl;
}


void clearList(ListType &list) {

   Node *rest = list;

   while (list != NULL) {
      rest = list->next;  // rest is all but the first element
      delete list;  // reclaims one node only
      list = rest;
   }

}

Node::Node(int item) { 
   data = item;
   next = NULL;
}

Node::Node(int item, Node *n) {
   data = item;
   next = n;
}
