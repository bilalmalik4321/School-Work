/*
Author: Bilal Malik
Date: February 4, 2020
*/
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main(int argc, char *argv[]){
    system("./task1.exe &");
    system("ps -l");
    sleep(3);
    system("kill -9 $(ps -l|grep -w defunct|tr -s ' '|cut -d ' ' -f 5)");
    sleep(5);
    printf("\n\nnew list after omitting zombies:\n\n");
    system("ps -l");
    return (0);
}

