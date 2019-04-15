/*  Name:Ziyi Xu
 *  USC NetID:ziyix
 *  CS 455 Fall 2018
 *
 *  See ecListFuncs.h for specification of each function.
 *
 *  NOTE: remove the print statements below as you implement each function
 *  or you will receive no credit for that function.
 *
 */

#include <iostream>
#include <vector>

#include "ecListFuncs.h"

using namespace std;

ListType vectorToList(const vector<int> & nums) {
   ListType n;
   ListType list;
   
   if(nums.size() == 0){
      list = NULL;
   }
   else{
      n = new Node(nums[0], NULL);
      list = n;
      for(vector<int>::size_type i = 1; i < nums.size(); i++){
         n -> next = new Node(nums[i],NULL);
         n = n -> next;
      }   
   } 
   return list;
   
}



int countRuns(ListType list) {
   
   ListType n = list;
   int run = 0;
   int count;
   int temp;

   while(n != NULL){
      temp = n -> data;
      count = 1;
      
      while(n -> next != NULL && n -> next -> data == temp){
         n = n -> next;
         count += 1;
      }
      
      if(count > 1){
         run += 1;
      }
      
      n = n -> next;
   }
   
   return run; 

}



ListType reverse(ListType list) {

   vector<int> temp;
   ListType n = list;
   ListType m = NULL;
   
   while(n != NULL){
      temp.push_back(n -> data);
      n = n -> next;
   }
   
   for(vector<int>::size_type i = 0; i < temp.size(); i++){
      m = new Node(temp[i], m);
   }
   
   delete n;
   vector<int> ().swap(temp);
   
   return m; 

}



void removeMiddle(ListType &list) {
   ListType n = list;
   ListType temp;
   int count = 0;
   int num;
      
   while(n != NULL){
      count += 1;
      n = n -> next;
   }
   
   delete n;
   n = list;
   
   if(count % 2 == 0){
      num = count / 2;
   }
   else{
      num = (count + 1) / 2;
   }
   
   if(list != NULL){   
      if(num == 1){
         temp = list -> next;
         delete list;
         list = temp;
      }
      else{
         for(int i = 1; i < num - 1; i++){
            n = n -> next;
         }
         
         temp = n -> next -> next;
         n -> next = temp;
      }
   }
}
    




void split(ListType &list, int splitVal, ListType &a, ListType &b) {
   if(list == NULL){
      a = NULL;
      b = NULL;
   }
   else if(list -> data == splitVal){
      a = NULL;
      b = list -> next;
   }
   else{
      a = list;
      while(list -> next != NULL){
         if(list -> next -> data != splitVal){
            list = list -> next;
         }
         else{
            break;
         }
      }
      if(list -> next == NULL){
         b = NULL;
      }
      else{
         b = list -> next -> next;
         list -> next = NULL;  
      }
   }
      list = NULL;
      
}

         
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      


   
      
      
