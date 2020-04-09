/*
Author: Bilal Malik
Date: February 4, 2020
*/
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>


int main(int argc, char *argv[]){
    int child_pid;
    child_pid = fork();
    if(child_pid==0){
        int k=getpid();

        printf("child pid:%i \n",k);

        exit(1);


    }
    else{
        sleep(10);
    }
    return 0;
}
