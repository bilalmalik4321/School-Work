#include<fcntl.h>
#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>

int main(int argc, char *argv[]){

  int p_one, p_two, p_three, p_four, p_five, p_six, p_seven;

  if(argc != 8)
    printf("Incorrect number of arguments\n");

  if((p_one = fork()) > 0){        // process #1
    sleep(atoi(argv[1]));
    printf("process 1 terminated. pid=%d\n", getpid());
    exit(1);
  }
  else{
    if ((p_two = fork()) > 0){     // process #2
      sleep(atoi(argv[2]));
      printf("process 2 terminated. pid=%d\n", getpid());
      exit(1);
    }
    else{
      if ((p_four = fork()) > 0){  // process #4
        sleep(atoi(argv[4]));
        printf("process 4 terminated. pid=%d\n", getpid());
        exit(1);
      }
      if ((p_five = fork()) > 0){  // process #5
        sleep(atoi(argv[5]));
        printf("process 5 terminated. pid=%d\n", getpid());
        exit(1);
      }
    }
    if ((p_three = fork()) > 0){   // process #3
      sleep(atoi(argv[3]));
      printf("process 3 terminated. pid=%d\n", getpid());
      exit(1);
    }
    else{
      if ((p_six = fork()) > 0){   // process #6
        sleep(atoi(argv[6]));
        printf("process 6 terminated. pid=%d\n", getpid());
        exit(1);
      }
      if ((p_seven = fork()) > 0){ // process #7
        sleep(atoi(argv[7]));
        printf("process 7 terminated. pid=%d\n", getpid());
        exit(1);
      }
    }
  }
}
