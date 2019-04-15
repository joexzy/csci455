CS 455 Programming Assignment 1
===============================
Introduction
-------------
In this assignment you will write a graphics-based program to simulate someone tossing a pair of coins some number of times, and display the results. So for example the user may request 10 trials. For each trial two coins are tossed. The program reports in bar graph form how many times the result was two heads, how many times it was two tails, and how many times it was one of each.
This assignment will give you practice with creating and implementing classes, using loops, using the java library for random number generation, doing console-based IO, and drawing to a graphics window. Also you'll get practice in general program development.

The assignment
----------------
Initially your program will prompt for the number of trials to simulate (a trial is two coin tosses) on the console, error checking that a positive value is entered. (More details about error checking here.) This part of the program will be console-based, to keep things simpler.
Then it will run the simulation and display a 500 tall by 800 wide pixel window with the results of that simulation. The results will consist of three labeled bars, each a different color, to show how many trials had the specified outcome. The label will show what the outcome was (e.g., Two Heads), the number of trials that had that result, and the percentage of trials that had that result (rounded to the nearest one percent). Because the simulation uses random coin tosses (simulated using a random-number generator) subsequent runs with the same input will produce different results.
