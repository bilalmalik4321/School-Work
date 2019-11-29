#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]){
    int fd = open(argv[1],O_WRONLY|O_CREAT|O_TRUNC,0744);

    pid_t pid;
    pid_t pid2;

    char* buf="EXAM!EXAM!EXAM!\n";
    char* buf1="HELP!HELP!HELP!\n";
    char* buf2="STUDY!STUDY!STUDY!\n";

    if((pid=fork())>0){
        pid2=fork();
    }
    if(pid==0){
        write(fd,buf,sizeof(buf));
        sleep(5);
    }
    else if(pid2==0){
        signal(SIG_USR1,);
        pause();
        write(fd,buf1,sizeof(buf1));
        sleep(5);
    }
    else{
        signal(SIG_USR2,);
        pause();
        write(fd,buf2,sizeof(buf2));
    }

    close(fd);

}
