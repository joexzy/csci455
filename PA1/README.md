CS 455 Programming Assignment 1
===============================
Introduction
-------------

In this assignment you will write a graphics-based program to simulate someone tossing a pair of coins some number of times, and display the results. So for example the user may request 10 trials. For each trial two coins are tossed. The program reports in bar graph form how many times the result was two heads, how many times it was two tails, and how many times it was one of each.
This assignment will give you practice with creating and implementing classes, using loops, using the java library for random number generation, doing console-based IO, and drawing to a graphics window. Also you'll get practice in general program development.
Resources
-------------
•	Horstmann, Section 2.9, 2.10, 3.8, How-to 3.2 Programs that draw stuff
•	Horstmann, Chapter 3, Implementing Classes
•	Horstmann, Section 4.3.1, Reading input
•	Horstmann, Section 6.9.1, Random numbers and Simulations
The programming environment for this assignment
--------------------------------------------------
In the normal Vocareum configuration, you have a Linux terminal, but no way to run a program with a graphical user interface (GUI). For this assignment we are using a different Vocareum configuration that will allow you to open multiple windows, including a separate one to run your GUI program. With this configuration, when you start up Vocareum for this assignment, it will not start up a terminal in the workbench window (i.e., the usual one you use), but you use a virtual Linux desktop instead.
How to start up a virtual Linux Desktop in Vocareum 
----------------------------------------------------
The way you get to a virtual linux desktop in this assignment is to go to a menu that's on the upper right of the workbench window: choose Actions--> Applications --> Desktop.
That will open a linux desktop in another tab in your browser. If it starts with a pop-up dialog, choose "Use default configuration." There are few ways to open a terminal window in this desktop. It may show an icon at the bottom of the screen that you can click to start up a terminal window. If that's not an option, you can right click anywhere on the desktop, and choose "Open Terminal Here".
Warning: depending on how you started up terminal, it might not start out in your home directory (i.e., "work"), but rather starts in the root directory ("/") or somewhere else. So the first thing you should do is
cd
to get into your home directory. (One way to check if you are in your home directory is you will see the ~ (tilde) right before the $ in the shell prompt.)
Your home directory will be populated with the starter files we are providing you. Part of what we provided is source code for a complete sample Java GUI program there, so you can try out compiling and running such a program in this environment before you write code for your own program. Compile and run this program:
javac CarViewer.java
java CarViewer
More about this car example (from Section 3.8 of the textbook) later.
You can switch between these two tabs in your browser to switch between editing (normal Vocareum window), and compiling and running (Linux desktop). To make it easier to see your compile errors at the same time as you view your source code, you can put the Vocareum tab in a different browser window altogether.
Another option with the desktop is to use one of the other editors available within the desktop itself. I saw emacs and vim (Rt-click on desktop-->Applications-->Accessories). I'm not sure how fast these work on this platform, so if you end up using one of these, let me know how it goes. (I only opened emacs there briefly once; it started up pretty fast, so that's a good sign.) Both emacs and vim are a little different than other editors you are used to, so you probably would want to take a look at an online tutorial on the web before using them.
One caveat: this Linux desktop is a newer feature of Vocareum, and it's a bit of a moving target. If it gets wedged you might have to restart the desktop. You can disconnect from it by closing the tab, or in the main Vocareum window (upper right) do: Actions-->Applications-->Stop App. Then you can restart the same way you did earlier.
The assignment files
---------------------
The files in bold below are ones you create and/or modify and submit. The ones not in bold are files you will use, but that you should not modify. The ones with a * to the left are starter files we provided.
•	* CarViewer.java, CarComponent.java, and Car.java. The code for the example in Section 3.8 of the textbook. For more about why these are in the starter files, see the section on class design.
•	* CoinTossSimulator.java Your CoinTossSimulator class. The public interface is provided. You will be completing the implementation and a test driver for it.
•	* Bar.java A Bar class. The public interface is provided. You will be completing the implementation of it.
•	CoinSimViewer.java Your CoinSimViewer class. You create this file and class.
•	CoinSimComponent.java Your CoinSimComponent class. You create this file and class.
•	CoinTossSimulatorTester.java Your unit test program (a.k.a., test driver) for your CoinTossSimulator class. You create this file and class.
•	* CoinSimViewer.list A list of the .java files for compiling the CoinSimViewer program. For more information about this, see the subsection on compiling multi-file programs.
•	* README for more about what goes in this file, see the section on README file. Before you start the assignment please read the following statement which you will be "signing" in the README:
"I certify that the work submitted for this assignment does not violate USC's student conduct code. In particular, the work is my own, not a collaboration, and does not involve code created by other people, with the exception of the resources explicitly mentioned in the CS 455 Course Syllabus. And I did not share my solution or parts of it with other students in the course."
