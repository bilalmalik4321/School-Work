#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int Header(int fd, char type[3], char width[5], char height[5]);

int main(int arg_c, char *arg_v[]) {
	if (arg_c != 4) return -1;

    int fd1 = open(arg_v[1], O_RDONLY, 0777);
	int fd2 = open(arg_v[2], O_RDONLY, 0777);

	char type_1[3], width_1[5], height_1[5], type_2[3], width_2[5], height_2[5];

	int size_1 = Header(fd1, type_1, width_1, height_1);
	int size_2 = Header(fd2, type_2, width_2, height_2);
    int fd3 = open(arg_v[3], O_WRONLY | O_CREAT | O_TRUNC, 0777);

	int w_1 = atoi(width_1);
	int h_1 = atoi(height_1);
	int w_2 = atoi(width_2);
	int h_2 = atoi(height_2);

	if ( h_1 < h_2 || w_1 < w_2 || strcmp(type_1, "P6") != 0 || strcmp(type_2, "P6") != 0){
            perror("Error: first image was smaller then second or image was not in P6 format");
	}

	char temp[size_1];
	lseek(fd1, 0, SEEK_SET);
	read(fd1, temp, size_1);
	write(fd3, temp, size_1);

	for (int i = 0; i < h_1; i++) {
		char buff[w_1 * 3];
		read(fd1, buff, w_1 * 3);
		write(fd3, buff, w_1 * 3);
	}

	lseek(fd3, size_1, SEEK_SET);
	lseek(fd2, size_2, SEEK_SET);

	for (int i = 0; i < h_2; i++) {
		lseek(fd3, (w_1 * 3) - (w_2 * 3), SEEK_CUR);
		char buff[w_1 * 3];
		read(fd2, buff, w_2 * 3);
		write(fd3, buff, w_2 * 3);
	}

	close(fd1);
	close(fd2);
	close(fd3);

	return 0;
}

int Header(int fd, char type[3], char width[5], char height[5]) {
	int counter = 7;
	read(fd, type, 2);
	lseek(fd, 1, SEEK_CUR);

	for (int i = 0; i < 5; i++) {
		counter++;
		read(fd, width + i, 1);

		if (width[i] == ' ') {
			width[i] = '\0';
			break;
		}
	}

	for (int i = 0; i < 5; i++) {
		counter++;
		read(fd, height + i, 1);

		if (height[i] == ' ') {
			height[i] = '\0';
			break;
		}
	}

	lseek(fd, 4, SEEK_SET);

	return count;
}
