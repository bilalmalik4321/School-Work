#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
void parent(int*, char*[]);
void child(int*, char*[]);
int main(int argc, char *argv[]) {
int fd[2];
if (pipe(fd) == -1)
exit(1);
if (fork() > 0)
parent(fd, argv);
else
child(fd, argv);
}
void parent(int *fd, char *argv[]) {
close(fd[0]);
dup2(fd[1], STDOUT_FILENO);
close(fd[1]);
execlp(argv[1], argv[1], NULL);
}
void child(int *fd, char *argv[]) {
close(fd[1]);
dup2(fd[0], STDIN_FILENO);
close(fd[0]);
execlp(argv[2], argv[2], NULL);
}
