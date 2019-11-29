#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/stat.h>

int main(int argc, char *argv[]) {

 int fd1, fd2;
 pid_t pid;
 char ch;
 char blanks[55]=" | ";
 int writeblanks = 1;

 unlink("/tmp/name0");
 unlink("/tmp/name1");
 if ( mkfifo("/tmp/name0", 0777) || mkfifo("/tmp/name1", 0777)) {
    perror("fifo");
    exit(1);
 }
 chmod("/tmp/name0", 0777);
 chmod("/tmp/name1", 0777);

 while (1) {
    printf("\nWaiting for connection...\n");
    fd1 = open("/tmp/name0", O_RDONLY);
    fd2 = open("/tmp/name1", O_WRONLY);
    printf("\n my messages (server) received messages (client) \n");
    printf("-------------------------------------------------------------------------------\n");

    if ( (pid = fork()) == -1 ) {
        perror("fork");
        exit(1);
    }

    if ( pid == 0 )
        while (1) {
            ……..
    }
    while ( read(fd1, &ch, 1) == 1 ) {
        if ( writeblanks == 1 )
            write(1, blanks, sizeof(blanks));
        write(1, &ch, 1);
        ……..
    }

    close(fd1);
    close(fd2);
    printf("\nClient left.\n\n\n");
    kill(pid, SIGTERM);

    }
}
