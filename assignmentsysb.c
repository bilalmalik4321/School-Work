#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main (int argc, char *argv[]){

    int fd1 = open(argv[1],O_RDONLY);
    int fd2 = open(argv[2],O_RDONLY);

    char type_1[3], width_1[5], length_1[5], type_2[3], width_2[5], length_2[5];

    int size_1=7;
    read(fd1,type_1,2);
    lseek(fd1, 1, SEEK_CUR);

    for(int i=0; i<5;i++){
        size_1++;
        read(fd1,width_1 + i,1);

        if(width_1[i]==" "){
            width_1[i]="\0";
            break;
        }
    }

    lseek(fd1, 4, SEEK_SET);

    for(int i=0; i<5;i++){
        size_1++;
        read(fd1, length_1 + i,1);

        if(length_1[i]==" "){
            length_1[i]="\0";
            break;
        }
    }

    int size_2=7;
    read(fd2, type_2,2);
    lseek(fd2, 1, SEEK_CUR);
    for(int i=0; i<5;i++){
        size_2++;
        read(fd2,width_2 + i,1);

        if(width_2[i]==" "){
            width_2[i]="\0";
            break;
        }
    }

    for(int i=0; i<5;i++){
        size_2++;
        read(fd2, length_2 + i,1);

        if(length_2[i]==" "){
            length_2[i]="\0";
            break;
        }
    }

    lseek(fd2, 4, SEEK_SET);

    int w_1=atoi(width_1);
    int h_1=atoi(length_1);
    int w_2=atoi(width_2);
    int h_2=atoi(length_2);

    printf("height1 %i %i height2 %i %i",w_1,h_1,w_2,h_2);

    if( w_1<w_2 || h_1<h_2 || strcmp(type_1, "P6") != 0 || strcmp(type_2, "P6") != 0){

    }

    int fd3 = open(argv[3],O_WRONLY|O_CREAT|O_TRUNC,0777);

    char tmp[size_1];
	lseek(fd1, 0, SEEK_SET);
	read(fd1, tmp, size_len_1);
	write(fd3, tmp, size_len_1);

    for(){


    }

    return 0;

}
