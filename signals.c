#include <unistd.h>
#include <signal.h>
#include <stdlib.h>

void handler(int num){
    write(STDOUT_FILENO, "I won't die\n",13);
}

int main(int argc, char *argv[]){
    void *oldHandler)();
    signal(SIGINT, handler);
    signal(SIGTERM, handler);

    for(int i=0;i<7;i++){
        printf("wasting your cycles %d\n",getpid());
    }

    signal(SIGINT,oldHandler);
    for(int i=0;i<7;i++){
        printf("wasting your cycles %d\n",getpid());
    }

}
