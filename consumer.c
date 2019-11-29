#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>


int main() {
	char num[2], n_num[3], buf[100];
	int k;

	int fd = open("storage", O_RDWR);
	read(fd, num, 2);

	k = atoi(num);
	k -= 3;

	sprintf(n_num, "%d", k);

	lseek(fd, 0, SEEK_SET);
	write(fd, n_num, strlen(n_num));

	sprintf(buf, "From consumer: total is %s\n", n_num);
	write(STDOUT_FILENO, buf, strlen(buf));
	close(fd);

	execlp("./producer", "./producer", (char*)0);

	return 0;
}
