// Name:Ziyi Xu
// USC NetID:ziyix
// CSCI 455 PA5
// Fall 2018


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.

// Note2: it's good practice to not put "using" statement in header files.  Thus
// here, things from std libary appear as, for example, std::string

#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H

/**
   Node class definition. There are two constructors in it. One lineked
   to next node, and the other doesn't have the next node or its next node's
   address in NULL. Each node has its key, value and a pointer points to its
   next node.
*/

struct Node {
   std::string key;
   int value;

   Node *next;

   Node(const std::string &theKey, int theValue);

   Node(const std::string &theKey, int theValue, Node *n);
};


typedef Node * ListType;  //ListType a equals to Node * a

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.

/**
   insert thekey and theValue into the list. If theKey exists, return false
   and do not do the inserting. If not, insert it and return true.
   param@ list where the element will be inserted 
   param@ theKey the string will be inserted
   param@ theValue the value with the string will be inserted
   return@ if the string will be inserted exists in list return false
   otherwise return true
   PRE: list must be a well-formed list.
   
*/
bool insertList(ListType &list, std::string theKey, int theValue);

/**
   change the value of a certain string(key). If this string didn't exist in the
   list return false and do nothing. Otherwise change the value of the string with newValue
   and return true
   param@ list where the value will be changed
   param@ theKey the string whose value will be changed
   param@ newValue the value will be assigned to the string
   return@ if the string existed in the list, do the changine and
   return true. otherwise, do nothing and return false.
   PRE: list must be a well-formed list.
*/
bool changeList(ListType &list, std::string theKey, int newValue);

/**
   lookup the string in the list. If you can find it in 
   the list, return true. If not, return false.
   param@ list where the element will be looked up
   param@ theKey the string will be looked up in the list
   return@ if you can find the string, return true.
   Otherwise, return false.
   PRE: list must be a well-formed list.
*/
bool lookUpList(ListType list, std::string theKey);

/**
   remove the element in the list. If this element exists, remove its key
   and value and return true. Otherwise, return false and do nothing.
   param@ list where the element will be removed
   param@ theKey the string(key) of the element will be removed
   return@ return true if theKey exists in the list and do the removal.
   Otherwise, return false.
   PRE: list must be a well-formed list.
*/
bool removeList(ListType &list, std::string theKey);

/**
   tell the client the number of the elements in the list
   param@ list where to count the elements
   return@ the number of elements in the list
   PRE: list must be a well-formed list.
*/
int sizeOf(ListType list);

/**
   print out each element's key and value in the list.
   PRE: list must be a well-formed list.
*/
void printList(ListType list);

/**
   get the value of the key in the list.
   param@list where to find the element's value
   param@ theKey use it as the key of the element to find
   its value
   return@ the element's value with key "theKey"
   PRE: list must be a well-formed list.
      lookUpList(list, theKey);
*/
int * getValue(ListType list, std::string theKey);
// keep the following line at the end of the file
#endif
