// Name:Ziyi Xu
// USC NetID:ziyix
// CS 455 PA5
// Fall 2018

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {
   
   ListType a = NULL;
   
   if(!insertList(a, "joe", 100)){
      cout << "shi bai" << endl;
   }
   if(!insertList(a, "alex", 97)){
      cout << "shi bai" << endl;
   }
   if(!insertList(a, "mary", 80)){
   cout << "shi bai" << endl;
   }
   cout <<"after inserting: "<<endl;
   cout << sizeOf(a) << endl;
   printList(a);
   
   if(lookUpList(a, "abe")){
      cout << "abe Found"<<endl;
   }
   if(lookUpList(a, "mary")){
      cout << "mary Found"<<endl;
   }
   if(lookUpList(a, "alex")){
      cout << "alex Found"<<endl;
   }
   
   if(!changeList(a, "alex", 68)){
      cout <<"Not Found alex"<<endl;
   }
   if(!changeList(a, "joe", 101)){
      cout <<"Not Found joe "<<endl;
   }
   if(!changeList(a, "kpii", 68)){
      cout <<"Not Found kpii"<<endl;
   }
   cout <<"after changing: "<<endl;
   cout << sizeOf(a) << endl;
   printList(a);
   
   removeList(a, "alex");
   cout <<"after removing: "<<endl;
   cout << sizeOf(a) << endl;
   printList(a);
   
   int *x = getValue(a, "mary");
   int *y = getValue(a, "joe");
   cout << *x << " " << *y << endl;
  
   return 0;
}
