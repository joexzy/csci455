CS 455 Programming Assignment 4 —— Find Scrabble words
======================================================

Introduction and Background
----------------------------

In this assignment you will get a chance to use some of the Collection classes and methods we have covered recently. This will enable you to write a faster-running program with less effort than you would otherwise. In this assignment you will also get an opportunity to do your own design; the design outline we provided you is less constrained than in past assignments: you will be deciding on the exact interface and representation for your most of your classes. You'll also get some practice with command-line arguments and text file processing.
This assignment concerns the game of Scrabble. You may know the game of Scrabble better as Words with Friends. If you want to try out Words with Friends yourself you can download the free app for your smartphone. However, the programming assignment is not to create the game itself, but to write a console-based program that finds all possible words that can be made from a rack of Scrabble tiles (so it could help someone playing Scrabble). We'll elaborate on the exact requirements of this assignment in the section on the assignment below.

The assignment
----------------

You will be implementing a program that when given letters that could comprise a Scrabble rack, creates a list of all legal words that can be formed from the letters on that rack. To solve the problem you will also need a scrabble dictionary (we'll provide that for you). Some particulars of the Scrabble dictionary: it only has words of length two or more, and it includes all forms of a word as separate entries, e.g., singular plus plural, verb conjugations.
For example, if your rack had the letters C M A L you could rearrange the letters to form the words calm or clam, but you could also form shorter words from a subset of the letters, e.g., lam or ma. It's generally difficult to figure out all such sequences of the letters that form real words (unless you are a tournament Scrabble competitor who knows the Scrabble dictionary very well).

For your program, you will display all such words, with the corresponding Scrabble score for each word, in decreasing order by score. For words with the same scrabble score, the words must appear in alphabetical order. Here are the results for a rack consisting of "cmal" (using the sowpods dictionary) in the output format you will be using for your program (user input is shown in italics):

Rack? cmal
We can make 11 words from "cmal"
All of the words with their scores (sorted by score):
8: calm
8: clam
7: cam
7: mac
5: lac
5: lam
5: mal
4: am
4: ma
2: al
2: la

