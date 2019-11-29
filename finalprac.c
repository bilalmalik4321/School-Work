#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>


int main(int argc, char *argv[])
{
    pid_t pid;
    int mypipefd[2];
    int ret;
    char buf[20];

    ret = pipe(mypipefd);

    if(ret == -1){
        perror("pipe");
        exit(1);
    }

    pid=fork();

    if(pid==0){
        printf("In child process\n");
        close(mypipefd[0]);
        write(mypipefd[1],"Hello World!", 12);
    }else{
        printf("In parent process\n");
        close(mypipefd[1]);
        read(mypipefd[0],buf,15);
        printf("Child says:%s",buf);
    }

    return 0;
}
