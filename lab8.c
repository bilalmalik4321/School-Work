#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<string.h>
#include<sys/wait.h>
#include <fcntl.h>
 
int main(int argc, char *argv[])
{
 
    int fd[2]; //Used for pipe ends.
    char buf[118];
    int pid;
    int fd2 = open("result.txt", O_CREAT| O_RDWR, 0755);
    int n;
    
 
    if (pipe(fd)==-1) //checks if pipe executed
    {
        printf("\nPipe Failed\n");
        return 1;
    }

    pid = fork(); // forks
 
    if (pid < 0)
    {
        printf("\nfork Failed\n");
        return 1;
    }
 
   
    else if (pid > 0)
    {
	close(fd[1]);
	n = read(fd[0], buf, sizeof(buf));
    write(fd2, &buf, n);
    
	
	
	printf("\nParent %d writing into file: result.txt\n", pid);
	printf("\nThe result of %s is written into result.txt with %d bytes.\n", argv[1], n);
     
    }
 
  
    else
    {
	close(fd[0]);
	dup2(fd[1], STDOUT_FILENO);
	execlp(argv[1], argv[1], NULL); 
	

	
    }
}
