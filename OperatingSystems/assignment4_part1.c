/*
    Names: Bilal Malik and Hasan Malik
    Student ID: 104435995 and 10461046
    Date: 03/06/2020
    Course: 3300 Operating Systems, University of Windsor
    Program: Assignment 4 Part 1

 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define PAGE_NUM 0xFFFFF000

int main (int argc, char *argv[])
{

    unsigned long pNum;
    unsigned long offset;
    unsigned long addr;
    //get the command line argument and convert from string to long long integer
    addr = atoll(argv[1]);

    if(argc != 2)
    {
        fprintf(stderr, "Please enter: ./assignment4_part1.c followed by the virtual address in decimal\n");
        return -1;
    }

    // mask the page number value
    pNum = addr >> 12; // right shifts operator
    offset = addr & 0xfff;

    // prints the output as instructed

    printf("The address %lu contains: \n", addr);
    printf("Page Number = %lu\n", pNum);
    printf("offset = %lu\n", offset);


    return 0;
}
