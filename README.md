# MagicBoardSolver

This program creates a random 20x20 board with integers ranging from 1-20. It will then randomly
choose a single position to be the goal position (changing the integer to zero). The program will choose	
a random corner as the start position and then travel through the board trying to reach the goal position.
The game has a few rules it must follow. The number of the position it starts and lands on is the amount of
space it can travel. Any direction is ok as long as it doesn't go out of bounds and it doesn't travel to a space
it has already been before. If it is possible to reach the goal position within these rules the program will
output true, and if not, false.

The goal of this program is to show the difference between iterative (stacks) and recursion and determine if
one is better than the other in terms of program speed.