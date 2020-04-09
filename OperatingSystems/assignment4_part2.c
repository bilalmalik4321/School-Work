/*
   Names: Bilal Malik and Hasan Malik
   Student ID: 104435995 and 10461046
   Date: 03/06/2020
   Course: COMP 3300 Operating Systems
   Program: Assignment 4 Part 2
*/


#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>


#define randNum 1000000 // number of random addresses
#define P_NUMBER 0xFFFFF000
#define OFFSET 0x00000FFF

// function for generating a random double

double rando()
{

    return random() / ((double)RAND_MAX + 1);
}

int main(int argc, char *argv[])
{
    unsigned long pNum;
    unsigned long offset;
    unsigned long addr;

    //create sequence of random integers, call clock funtion
    srandom((unsigned)time(NULL));
    clock_t begin = clock();

    for(addr = 0; addr < randNum; addr++)
    {
        //generate the random address

        addr = rando() * randNum; //call random function which returns a random double precision
        pNum = (addr & P_NUMBER) >> 12; // using the right shift operator
        offset = addr & OFFSET;

    }

    clock_t end = clock();//get time at the end of the for loop

    //outputs to the screen as instructed
    double totalTime = (double) (end-begin) /CLOCKS_PER_SEC;
    //subtract time before loop from time after, leaving with time inside of loop, divide by CLOCKS_PER_SEC to get time in seconds
    printf("total CPU time: %f\n", totalTime);


    return 0;
}

