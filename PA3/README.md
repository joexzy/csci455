CS 455 Programming Assignment 3 —— MineSweeper
===============================

Introduction
-------------

In this program you will get a chance to use recursion to solve a problem that could not be done just as easily or more efficiently with a loop. It is possible to solve this problem without recursion, but it would somewhat more complicated, and would result in the same big-O space and time requirements as a recursive solution.
Depth-first search (DFS) is an algorithm for searching in non-linear data structures. There are a few different ways to implement DFS, but here you're going to implement a recursive DFS as part of a Minesweeper game. We'll discuss more about how to do this recursive search later.

The code for this assignment uses a few features of Java we haven't used in this course before. They are: 2D arrays and inner classes (we already wrote the inner class code for you). Two-dimensional arrays were covered in section 7.6 of the textbook. Inner classes are covered in section 10.5, and their use for Listeners (part of the Java GUI system) is covered in section 10.7.2. Event handling in general is covered in Section 10.7, but we wrote all the event-handling code for you.

Because this program has a GUI, the Vocareum environment is configured so you can open up a Linux desktop, like we had for pa1, so you can test the complete program

The assignment
---------------

Write the main logic of a program to play the game Minesweeper. To keep the scope of this assignment reasonable, we have created the object-oriented design for this program, and have implemented the GUI for you.
Minesweeper is a game where mines are hidden in various random locations in a two-dimensional minefield. The player has to figure out where all the mines are without exploding a mine. They do this by repeatedly uncovering locations, and guessing mine locations, until they uncover all of the non-mine locations (win) or they explode a mine (lose). This is more than a game of chance, because when a non-mine square is uncovered it displays the number of mines adjacent to that square. You can use that information to figure out where the mines are (or at least narrow down their locations).
