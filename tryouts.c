#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

int main(int argc, char * argv[]){
    //char contents[];
    int fd = open(STDIN_FILENO, 0_RDWR | O_APPEND | O_CREAT,755);

    if (fd==-1){
        printf("error opening file");
    }

    write(fd,"Yeehaww",14);
    close(fd);
}
