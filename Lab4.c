//
//  Lab4.c
//  
//
//  Created by Zain Mustafa on 2017-10-18.
//

#include <stdio.h>

#include <unistd.h>
#include <stdlib.h>
#include <fcntl.h>

int main(int argc, char*argv[]) {
    int fd;
    int x1 = atoi(argv[1]);
    int i, fact;
    
    fact = 1;
    
    if(fork() == 0)
    {
        if(x1 < 10 && x1 > 1){
        //sleep(1);
        read(fd,&x1,(sizeof(x1)));
        
        for(i = 0; i < x1; i++)
        {
            fact = fact*(x1-i);
        }
        printf("Factorial of %d is %d\n", x1, fact);
        }
    }
    else
    {
        if((x1 < 10 && x1 > 1))
        {
            FILE* fd = fopen("test.txt", "w+");
            //write(fd,x1,(sizeof(x1)));
            //write(fd,&x1,(sizeof(x1)));
            fprintf(fd, "%d \n", x1);
            fclose(fd);
        }
        else
            printf("error\n");
    }
}
