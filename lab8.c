#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>
#include<fcntl.h>
#include<sys/wait.h>
#include<string.h>

void child(int *fd, char *arg[]);
void parent(int *fd, char *args[]);

int main(int argc, char *argv[])
{
	int fd[2],pid,status;
	pipe(fd);
    pid = fork();

	if(pid > 0)
	{
		wait(&status);
		parent(fd, argv);
	}
	else if(pid == 0)
	{
		child(fd, argv);
	}
}

void child(int *fd1, char *arg[])
{
	close(fd1[0]);
	dup2(fd1[1],STDOUT_FILENO);
	execlp(arg[1],arg[1],NULL);
	close(fd1[1]);
}

void parent(int *fd2, char *args[])
{
	int fdw, c;
	char arr[200];

	close(fd2[1]);
	dup2(fd2[0],STDIN_FILENO);
	read(fd2[0],arr,sizeof(arr));
	c = strlen(arr);
	fdw = open("result.txt",O_WRONLY | O_CREAT | O_TRUNC,0777);
	write(fdw,arr,c);
	printf("The result of %s is written into result.txt with total %d bytes.\n",args[1],c);
	close(fdw);
	close(fd2[0]);
	close(fd2[1]);
}
