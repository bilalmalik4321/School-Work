// Author: Bilal Malik Student-id: 104435995 Date: January 24, 2021

#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>


int main(int argc, char *argv[]){
    //declare all necessary variables before hand
	int k = 10000;
	char srcfile[k];
	char modfile[k];
	char destfile[k];
	int fd1,fd2;
	int last;
	char c[k];
	char winit[] = "Please input the complete name of the source file (this file should exist in the current directory):\n";
    char init[] = "The source file failed to open or doesn't exist.\n";
    char bit[] = "The destinition file failed to open.\n";
    char denit[] = "Please input the destination file, for the contents of the source file to be written to (this file should not already exist):\n";
    char red[]= "Error attempting to read from file. \n";
    char writ[]= "Error attempting to write to file. \n";
    char zil[] = "File already exists. \n";

    //prompt user for name of sourse file and read the name into srcfile array
	write(STDOUT_FILENO, winit, sizeof(winit));
	int nread = read(STDIN_FILENO, srcfile, k);

	//as read does not include the null terminating \0, we account for it seperately by finding the size of the array
	for (int i=0; srcfile[i] != '\n'; i++) {
		modfile[i] = srcfile[i];
		last = i+1;
	}

	//the \0 is terminating
	modfile[last] = '\0';

	//open the soursefile, if this task fails, return a statement to the user before exiting the code
	if((fd1 = open(modfile,O_RDONLY))<0){
		write(STDOUT_FILENO,init,sizeof(init));
		return 1;
	}

	//prompt the user for the name of the file being created, as well \O is implemented
	write(STDOUT_FILENO,denit,sizeof(denit));
	nread = read(STDOUT_FILENO,destfile,k);
	destfile[nread-1] = '\0';


	//open the destination file with a combination of access() and creat(), both are systm calls
	//if access returns 0 then the file to be written into already exists, and the program is aborted
	if(access(destfile,W_OK)==0){
        write(STDOUT_FILENO,zil,sizeof(zil));
        return 1;
	}

	//if a previous file doesnt exist with the same name, open this file
	fd2=creat(destfile,0777);
    if(fd2<0){
        write(STDOUT_FILENO,bit,sizeof(bit));
    }

    //read in 10,000 bits at a time into char array c, until the entirety has been read and write c into the new file
	if((nread = read(fd1, c, k))<0) {
        write(STDOUT_FILENO,red,sizeof(red));
        return 1;
	}

	if((write(fd2, c, nread))<0) {
        write(STDOUT_FILENO,writ,sizeof(writ));
        return 1;
	}

	//close the file descriptors, such that the contents are written properly
	close(fd1);
	close(fd2);

}
