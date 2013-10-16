Take a 2d array as input and print it in spiral order (clockwise) towards the middle.
Command line file argument.
File should look like this: rows;columns;data (whitespace delimited)
example: 4;4; 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
ex output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
^^Visual:
1  2  3  4
5  6  7  8
9  10 11 12
13 14 15 16

This works with all the test cases I can throw at it, but I know it is not foolproof.
Example: It works with some imbalanced arrays, but I know this is tricky. My only mission was to have it work on a balanced array. 
Still you can test and see success with 2 by 10, 3by4 or 4by3.  
I believe the biggest issue is involved with how the algorithm handles the final, innermost traversal on an array which demands an odd number of elements.
Line 100 cures this issue for the 3 by 3 array..3x3 will fail without it.

While it works with all test cases I think up, I *know* there are some, very complicated ones that it will fail on.

