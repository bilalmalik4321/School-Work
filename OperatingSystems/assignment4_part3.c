/*
    Names: Bilal Malik and Hasan Malik
    Student ID: 104435995 and 10461046
    Date: 03/06/2020
    Course: 3300 Operating Systems, University of Windsor
    Program: Assignment 4 part 3

 */

#include <time.h>
#include <string.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>


#define ONE_Kilo 1024

int main(int argc, char *argv[])
{

    int pageNumber;
    int offset;
    int value=1;
    int counter=0;
    int i=0;

    unsigned int addr=0;
    unsigned int addrSpace=0;
    unsigned int pageSize=0;
    unsigned int pageOffsetBit=0;

    //check the number of command line arguments is four, thus three arguments passed
    if(argc != 4)
    {
        printf("%s <address-space> <page size> <address>\n", argv[0]);
        return -1;
    }

    //read the addres space, page size and address into integers through atoi()
    addrSpace = (unsigned int)atoi(argv[1]);
    pageSize = (unsigned int)atoi(argv[2]);
    addr = (unsigned int)atoi(argv[3]);

    //ensure inputs are positive values
    if ( addrSpace <= 0 || pageSize <= 0 || addr <= 0)
    {
        printf("Wrong inputs for page size, address space, and address, please input values that are not negative.\n");
        return -1;
    }

    // check to see if the address space and page size are powers of 2
    if ( !((addrSpace != 0) && ((addrSpace & (addrSpace- 1)) == 0)) )
    {
        printf("Address space must be a power of two.\n");
        return -1;
    }

    if ( !((pageSize != 0) && ((pageSize & (pageSize- 1)) == 0)) )
    {
        printf("Page size must be a power of two.\n");
        return -1;
    }

    //check if page size is less then address space
    if(pageSize>=addrSpace){
        printf("Page size value is greater then given address space.\n");
        return -1;
    }

    pageSize = pageSize * ONE_Kilo;

    while (value != pageSize)
    {
        value=2*value;
        counter++;
    }

    printf("The address %d contains:\n", addr);

    for (i=0; i<counter; i++)
    {
        int initial = 1;
        initial = initial << i;
        pageOffsetBit = pageOffsetBit | initial;
    }

    //right shift of count, address gives the page number
    pageNumber = addr >> counter;
    //now address and pageOffsetBit gives, offset value
    offset = addr & pageOffsetBit;

    //outputs the program as instructed

    printf("Page Number = %d\n", pageNumber);
    printf("Offset = %d\n", offset);

    return 0;

}


