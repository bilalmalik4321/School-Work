#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>


char* changeShade(char *shade);
void processManager(int n){};

int main(int agrc, char* args[])
{
	char *shd1 = changeShade(args[2]);
	char *shd2 = changeShade(args[3]);
	char *shd3 = changeShade(args[4]);
	char *shd4 = changeShade(args[5]);
	char *shd5 = changeShade(args[6]);

	int fdw = open(args[1], O_WRONLY | O_CREAT | O_TRUNC, 0777);
	char bf1[] = "P6\n1000 1000\n255\n";
	write(fdw, bf1, sizeof(bf1));
	lseek(fdw, 17, SEEK_SET);

	int o, npid[10], pid;

	for(int i = 0; i < 10; i++)
	{
		if((pid = fork()) == 0)
		{
			npid[i] = getpid();
			signal(SIGALRM, processManager);
			pause();

			if(i < 5)
			{
				for(int y = i*100; y < (i+1)*100; y++)
				{
					if((o = y-250) < 0)
					{
						for (int x = 0; x < 1000; x++)
						{
							if(x >= 500)
								write(fdw, shd3, 3);
							else
								write(fdw, shd2, 3);
						}
					}

					else
					{
						int x=0;
						for(; x < 500-o; x++)
						{
							write(fdw, shd2, 3);
						}


						for(; x < 500+o; x++)
						{
							write(fdw, shd1, 3);
						}

						for(; x < 1000; x++)
						{
							write(fdw, shd3, 3);
						}
					}
				}
			}

			else if (i >= 5 && i < 10)
			{
				for(int y = i*100; y < (i+1)*100; y++)
				{
					if((o =750-y) < 0)
					{
						for(int x = 0; x < 1000; x++)
						{
							if(x >= 500)
								write(fdw, shd5, 3);
							else
								write(fdw, shd4, 3);
						}
					}

					else
					{
						int x = 0;
						for(; x < 500 - o; x++)
							write(fdw, shd4, 3);
						for(; x < 500 + o; x++)
							write(fdw, shd1, 3);
						for(; x < 1000; x++)
							write(fdw, shd5, 3);
					}
				}
			}
			kill(getppid(), SIGALRM);
			break;
		}
		else
			npid[i] = pid;
	}

	if(pid > 0)
	{
		for(int j = 0; j < 10; j++)
		{
			kill(npid[j], SIGALRM);
			signal(SIGALRM, processManager);
			pause();
		}
		close(fdw);
	}
}

char* changeShade(char *shade)
{
	char *shader = (char *) malloc(sizeof(char) * 3);
	if(strcmp(shade,"red") == 0)
		shader[0] = 255, shader[1] = 0, shader[2] = 0;
	else if(strcmp(shade,"green") == 0)
		shader[0] = 0, shader[1] = 128, shader[2] = 0;
	else if(strcmp(shade,"blue") == 0)
		shader[0] = 0, shader[1] = 0, shader[2] = 255;
	else if(strcmp(shade,"yellow") == 0)
		shader[0] = 255, shader[1] = 255, shader[2] = 0;
	else if(strcmp(shade,"orange") == 0)
		shader[0] = 255, shader[1] = 165, shader[2] = 0;
	else if(strcmp(shade,"cyan") == 0)
		shader[0] = 0, shader[1] = 255, shader[2] = 255;
	else if(strcmp(shade,"magenta") == 0)
		shader[0] = 255, shader[1] = 0, shader[2] = 255;
	else if(strcmp(shade,"ocean") == 0)
		shader[0] = 66, shader[1] = 105, shader[2] = 225;
	else if(strcmp(shade,"violet") == 0)
		shader[0] = 138, shader[1] = 43, shader[2] = 226;

	return shader;
}


