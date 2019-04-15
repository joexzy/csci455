#include <string>

using namespace std;

#include <cctype>

#include <algorithm>

#include "Table.h"

int main() {

   Table test;
   
   test.insert("a",1);
   test.insert("b",2);
   test.insert("c",3);
   test.printAll();

   return 0;
}