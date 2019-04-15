CS 455 Programming Assignment 2 —— Bulgarian Solitaire
===============================
Introduction
------------
In this assignment you will get practice working with Java arrays, more practice implementing your own classes, and practice creating a procedural design in Java (in the BulgarianSolitaireSimulator class). Like you did in assignment 1 and lab 4, you will be implementing a class whose specification we have given you, in this case a class called SolitaireBoard, to represent the board configuration for a specific type of solitaire game described further below. You will also be using tools to help develop correct code, such as assert statements along with code to verify that your class implementation is consistent.

The assignment
--------------
You will be implementing a program to model the game Bulgarian Solitaire. This program will run in the console window and will not have a GUI. This is problem P7.4 from our textbook Big Java: Early Objects, 6th Edition, by Cay Horstmann. Here is his description of the problem (second paragraph is a paraphrase):
The game starts with 45 cards. (They need not be playing cards. Unmarked index cards work just as well.) Randomly divide them into some number of piles of random size. For example, you might start with piles of size 20, 5, 1, 9, and 10. In each round you take one card from each pile, forming a new pile with these cards. For example, the starting configuration would be transformed into piles of size 19, 4, 8, 9, and 5. The solitaire is over when the piles have size 1, 2, 3, 4, 5, 6, 7, 8, and 9, in some order. (It can be shown that you always end up with such a configuration.)
In the normal mode of operation your program will produce a random starting configuration and print it. It then keeps applying the solitaire step and printing the results, and stops when the final configuration is reached.

We recommend you finish playing Horstmann's example game, started above, to see how it comes out (you can do it with just pencil and paper). (Save your work because it's part of the associated lab assignment.)

To make it easier to test your code, your program will be able to be run in a few different modes, each of these controlled by a command-line argument. The user may supply one or both of the arguments, or neither.

-u

Prompts for the initial configuration from the user, instead of generating a random configuration.

-s

Stops between every round of the game. The game only continues when the user hits enter (a.k.a., return).
Command-line argument processing is discussed in section 11.3 of the Horstmann text. But to make things a little easier, we wrote the code for processing the command-line arguments for you. It appears in starter code you get in the main method in BulgarianSolitaireSimulator.java. Here are a few examples of ways to run the program in the Linux shell:

java -ea BulgarianSolitaireSimulator -u

java -ea BulgarianSolitaireSimulator -u -s

java -ea BulgarianSolitaireSimulator
