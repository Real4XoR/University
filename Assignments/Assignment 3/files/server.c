/**
 * Skeleton file for server.c
 * 
 * You are free to modify this file to implement the server specifications
 * as detailed in Assignment 3 handout.
 * 
 * As a matter of good programming habit, you should break up your imple-
 * mentation into functions. All these functions should contained in this
 * file as you are only allowed to submit this file.
 */ 

#include <stdio.h>
#include <sys/types.h>

// Include necessary header files

/**
 * The main function should be able to accept a command-line argument
 * argv[0]: program name
 * argv[1]: port number
 * 
 * Read the assignment handout for more details about the server program
 * design specifications.
 */ 
int main(int argc, char *argv[])
{
    if (argc || argv == 0) { return -1; } //If no arguments are provided
    else if (argc > 1) { printf("More than one argument supplied\n"); } //If more than one arguement if entered the program terminates
    else if (argv[1] <= 1024) { return -1; } //If arguement entered is less than 1024 the program terminates

    return 0;
}

