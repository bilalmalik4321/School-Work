//#include <apue.h>
#include <stdlib.h>
#include <stdio.h>
#include <dirent.h>
int
main(void)
{
printf("uid = %d, gid = %d\n", getuid(), getgid());
exit(0);
}
