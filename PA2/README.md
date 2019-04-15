CS 455 Programming Assignment 2
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
[Note: recall you are using the -ea argument for assertion-checking. The arguments after the program name are the ones that get sent to your program.]
There are more details about exactly what your output should look like in each of these operation modes in the section on the BulgarianSolitaireSimulator program.

Some of the requirements for the program relate to efficiency, testing, and style/design, as well as functionality. They are described in detail in the following sections of the document, and then summarized near the end of the document.

BulgarianSolitaireSimulator program
-------------------------------------
Please take a look at this example for what your output must look like. This shows (part of) a run of the program with the -u option turned on (-u stands for user input mode.) It also illustrates the error-checking. User input is shown in bold and the ". . ." below represents some steps not shown here.
Number of total cards is 45
You will be entering the initial configuration of the cards (i.e., how many in each pile).
Please enter a space-separated list of positive integers followed by newline:
40   1  1 1 1
ERROR: Each pile must have at least one card and the total number of cards must be 45
Please enter a space-separated list of positive integers followed by newline:
  44 b 1 x
ERROR: Each pile must have at least one card and the total number of cards must be 45
Please enter a space-separated list of positive integers followed by newline:
100 -55
ERROR: Each pile must have at least one card and the total number of cards must be 45
Please enter a space-separated list of positive integers followed by newline:
0 45
ERROR: Each pile must have at least one card and the total number of cards must be 45
Please enter a space-separated list of positive integers followed by newline:
40 1 1 1 1 1
Initial configuration: 40 1 1 1 1 1
[1] Current configuration: 39 6
[2] Current configuration: 38 5 2
[3] Current configuration: 37 4 1 3
. . .
[30] Current configuration: 10 2 3 4 5 6 7 8
[31] Current configuration: 9 1 2 3 4 5 6 7 8
Done!
Note that we're not forcing the user to enter exactly one space between the numbers entered for the initial configuration. E.g., if the call to in.nextLine() resulted in the following String, it should be accepted as valid input by your program:
"    40     1     1 1    1 1    "
Tabs are ok as whitespace too but we can't show them easily here.
Here is an example of what your output should look like with the -s option turned on (-s stands for single step mode). The -u option is not set in this example, so it uses a random initial configuration. Again, only part of the run is shown here. After each "<Type return...>" the program blocks until the user hits the return key.

Initial configuration: 9 4 6 26
[1] Current configuration: 8 3 5 25 4
<Type return to continue>
[2] Current configuration: 7 2 4 24 3 5
<Type return to continue>
[3] Current configuration: 6 1 3 23 2 4 6
<Type return to continue>
. . .
[26] Current configuration: 2 3 4 5 6 7 8 10
<Type return to continue>
[27] Current configuration: 1 2 3 4 5 6 7 9 8
<Type return to continue>
Done!
If neither argument is set, then the program will take no user input, and just show the initial configuration followed by the numbered result of each round until it finishes (i.e., output like the second example above, but without the lines that say "<Type return...>").
A correct program will always terminate. For some values of SolitaireBoard.CARD_TOTAL a game won't terminate; so do not change the initialization expression that sets this value based on the current value of SolitaireBoard.NUM_FINAL_PILES (the code to do that is already present in the starter version); this way it should still terminate even if you change NUM_FINAL_PILES to some other positive value.

Your output for a particular input must match what's shown above character-by-character (e.g., the messages displayed and the error handling should be the same), so we can automate our tests when we grade your program. This means the new piles must appear in the particular order shown, not only in how they are printed, but the order of the numbers in the String returned by the SolitaireBoard's configString method. Of course, this does not include the ". . ." for the parts we left out in our example runs: yours would show the missing rounds instead.

The submit script will do a few of the automated tests (and give you are report on the results), thus we recommend you try your first submit early, so you would have time to still fix your code and resubmit before the final deadline. See the section on submitting for more details about this.
