//
//  Lab5.c
//  
//
//  Created by Zain Mustafa on 2017-10-25.
//

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

int main(int argc, char*argv[]){
    
    int n1 = atoi(argv[1]);
    int n2 = atoi(argv[2]);
    int n3 = atoi(argv[3]);
    int n4 = atoi(argv[4]);
    int n5 = atoi(argv[5]);
    int n6 = atoi(argv[6]);
    int n7 = atoi(argv[7]);
    
    
    printf("\n\nInputs Selected are: \n");
    printf("%d %d %d %d %d %d %d\n\n", n1, n2, n3, n4, n5, n6, n7);
    
    printf("Let the forking begin!\n");
    printf("Process 1 Terminated. pid: %d\n", getpid());
    
    if(fork() == 0){ //Process 2
        sleep(n2);
        printf("Process 2 Terminated. pid: %d\n", getpid());
        //Beginning of Process 4 and 5
        if(fork() == 0){ //Process 4
            sleep(n4);
            printf("Process 4 Terminated. pid: %d\n", getpid());
            
            //Beginning of Process 6 and 7
            if(fork() == 0){ // Process 6
                sleep(n6);
                printf("Process 6 Terminated. pid: %d\n", getpid());
            }
            else { //Process 7
                sleep(n7);
                printf("Process 7 Terminated. pid: %d\n", getpid());
            }
            
        }
        else { // Process 5
            sleep(n5);
            printf("Process 5 Terminated. pid: %d\n", getpid());
        }
    }
    else { //Process 3
        sleep(n3);
        printf("Process 3 Terminated. pid: %d\n", getpid());
    }
    
    
    return 0;
}
