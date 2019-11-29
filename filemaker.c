#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main(int argc, char *argv[]){

int fd;
fd =open("fileone.txt",O_RDONLY);
int fd1 = open("filetwo.txt",O_WRONLY|O_CREAT|O_EXCL,733);

if (fd1==-1||fd==-1){
printf("one file was unable to open.");
return -1;
}

char c;
int bytes;

while((bytes=read(fd,&c, sizeof(c))) >0){
	if (c=='.'){
		c='!';
	}
	write (fd1,&c,sizeof(c));
}
close (fd1);
close (fd);
}