// Name:Ziyi Xu
// USC NetID:ziyix
// CSCI 455 PA5
// Fall 2018

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>

using namespace std;


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

//you can see the comments of following functions in Table.h
Table::Table() {
   hashSize = HASH_SIZE;
   hashTable = new ListType[hashSize]();

}


Table::Table(unsigned int hSize) {
   hashSize = hSize;
   hashTable = new ListType[hashSize]();

}


int * Table::lookup(const string &key) {
   int hashNum = hashCode(key);
   
   if(lookUpList(hashTable[hashNum], key)){
      int *value = getValue(hashTable[hashNum], key);
      return value;
   }
   
   return NULL;   
}

bool Table::remove(const string &key) {
   int hashNum = hashCode(key);
   if(removeList(hashTable[hashNum], key)){
      return true;
   }
   return false; 
}

bool Table::insert(const string &key, int value) {
   int hashNum = hashCode(key);
   if(insertList(hashTable[hashNum], key, value)){
      return true;
   }
   return false;  
}

int Table::numEntries() const {
   int numEtry = 0;
   for(int i = 0; i < hashSize; i++){
      numEtry += sizeOf(hashTable[i]);
   }
   return numEtry;      
}


void Table::printAll() const {
   for(int i = 0; i < hashSize; i++){
      printList(hashTable[i]);
   }

}

void Table::hashStats(ostream &out) const {
   int numNonBuk = 0;
   //to compute the number of non-empty buckets
   for(int i = 0; i < hashSize; i++){
      if(sizeOf(hashTable[i]) > 0){
         numNonBuk ++;
      }
   }
   
   cout << "number of buckets: " << hashSize << endl;
   cout << "number of entries: " << numEntries() << endl;
   cout << "number of non-empty buckets: " << numNonBuk << endl;
   cout << "longest chain: " << LonChain() << endl;
   
  
}


// add definitions for your private methods here
int Table::LonChain() const{
   int max = 0;
   
   for(int i = 0; i < hashSize; i++){
      if(sizeOf(hashTable[i]) > max){
         max = sizeOf(hashTable[i]);
      }
   }
   return max;
}
                      