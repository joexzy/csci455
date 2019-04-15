CS 455 Programming Assignment 5
================================

Introduction and Background
-----------------------------

In this assignment you will use C++ linked lists to implement a data structure we have studied in this class: a hash table. The hash table is in a class called Table (what you know as a map). To make it more interesting, we're going to test our class in two different programs: one is a command-based test driver you will write (a program to maintain student names and scores), and the other is a C++ version of the concordance program we wrote in lab 10. We wrote the concordance program for you.
Note that there is a very short time-line on this assignment: there's a little less than two weeks to complete it. We recommend you start immediately. To help you complete the program successfully and on time we have included some development hints and a suggested milestone later in this document. This Milestone is also lab 13, so you can get credit for completing it.

As we have mentioned previously, we recommend you do all your C++ development for this course on Vocareum. If you choose not to do this, please leave yourself at least a few days to port your code (i.e., start testing it on Vocareum a few days before it's due so you have time to fix any bugs.) The Vocareum g++ compiler and environment is the one we will be using for grading your assignment.

To be able to use a C++ class in multiple programs, but not end up with multiple versions of our Table class code, these are going to be multi-file programs that use separate compilation and a Makefile. We will be discussing these topics more in lecture soon. However, we wrote the Makefile for you, and put all the necessary include statements in the source files so as to make this aspect of the assignment as painless as possible for you. Note: it will not work to use the regular g++ command to compile this program. There are more specifics about this in the File Organization section below.

