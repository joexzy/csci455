// Name:Ziyi Xu
// USC NetID:ziyix
// CSCI 455 PA5
// Fall 2018


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

//Node class definition.
Node::Node(const string &theKey, int theValue) {
   key = theKey;
   value = theValue;
   next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
   key = theKey;
   value = theValue;
   next = n;
}




//*************************************************************************
// put the function definitions for your list functions below
//see the comments of following functions in listFuncs.h
bool insertList(ListType &list, string theKey, int theValue){
   Node *n = list;

   while(n != NULL){
      if(n -> key == theKey){
         return false;
      }
      n = n -> next;
   }
   
   n = new Node(theKey, theValue, list);
   
   list = n;
   return true;
}     

bool changeList(ListType &list, string theKey, int newValue){
   Node *n = list;
   
   while(n != NULL){
      if(n -> key == theKey){
         n -> value = newValue;
         return true;
      }
      n = n -> next;
   }
   
   return false;
}
      
bool lookUpList(ListType list, string theKey){
   Node *n = list;
   
   while(n != NULL){
      if(n -> key == theKey){
         return true;
      }
      n = n -> next;
   }
   
   return false;
}

bool removeList(ListType &list, string theKey){
   Node *n = list;
   Node *temp;
   
   if(n -> key == theKey){
      temp = n -> next;
      list = temp;
      return true;
   }
      
   while(n != NULL){
      if(n -> next -> key == theKey){
         temp = n -> next -> next;
         n -> next = temp;
         return true;
      }
      n = n -> next;
   }
   
   return false;
}

int sizeOf(ListType list){
   Node *n = list;
   int size = 0;
   
   while(n != NULL){
      size ++;
      n = n -> next;
   }
   
   return size;
}
   

void printList(ListType list){
   Node *n = list;
   
   while(n != NULL){
      cout << n -> key << " " << n -> value << endl;
      n = n -> next;
   }
   
}

int * getValue(ListType list, string theKey){
   Node *n = list;
   
   while(n != NULL){
      if(n -> key == theKey){
         return &(n -> value);
      }
      n = n -> next;
   }
   return NULL;
}
      
   
   

