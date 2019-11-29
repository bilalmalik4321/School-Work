#include<stdio.h>
#include<stdlib.h>

int main(){
    if(fork()==0){
        execl("./lab3bsh","lab3bsh",(char *)0);
        printf("exec failed...\n");
        exit(0);
    }
    sleep(1);
    printf("STUDY!STUDY!STUDY!");
    return 0;
}
