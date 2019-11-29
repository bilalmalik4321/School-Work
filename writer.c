#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <fcntl.h>
#include <unistd.h>

int main(int argc, char * argv[]){
char buffer[44]="101   GM\tBuick\t2010\n102   Ford\tLincoln\t2005\n";
int fd1, ret;
open("list1.txt",0_WRONLY|0_CREAT,777);
ret=write(fd1, buffer, sizeof(buffer));
return 0;
}
