#include <fcntl.h>
#include <unistd.h>
int main(){
alarm(5);
int pid = fork();
while (1) {
if (pid == 0)
printf("I am the child\n");
else
printf("I am the parent\n");
sleep(1);
}
}
