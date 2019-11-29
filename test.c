#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdlib.h>

int main(){
    char buf = 'a';
    read(STDIN_FILENO, &buf, 1);
    printf("%c\n", buf);
    read(STDIN_FILENO, &buf, 1);
    printf("%c\n", buf);
}
