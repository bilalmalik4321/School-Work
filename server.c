#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/stat.h>
int main(int argc, char *argv[]) {
int fd;
char ch;
unlink("/tmp/server");
if ( mkfifo("/tmp/server", 0777) != 0)
exit(1);
chmod(“/tmp/server”, 0777)
printf("mkfifo successful! trying to connect...\n");
fd = open("/tmp/server", O_RDONLY);
printf("connected! waiting data from writer...\n");
while ( read(fd, &ch, 1) == 1 )
printf("%c", ch);
}
