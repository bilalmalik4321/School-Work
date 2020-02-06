//
//  Lab6.c
//  


#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char * argv[]){
    int pid;
    int i=0;
    
    for(i = 1; i < argc; i = i+2){
        //pid = fork();
        if(pid == fork()){
            printf("pid process is %d\n", getpid());
            execlp(argv[i],argv[i],argv[i+1], (char*)0);
            printf("Error\n");
        }
    }
}
