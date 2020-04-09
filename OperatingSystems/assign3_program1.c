/*
    Name: Bilal Malik
    Program: COMP 3300 Assignment 1 Program 1
    Date: 13/02/2020
 */

// compile this with  gcc -pthread assign3_program1.c -lm

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <pthread.h>

#define NUM_OF_THREADS 2

void *runner(void *param);

int num_of_points_calc(int NUM_OF_POINTS);

int circle_count = 0; // points in the circle

/* Generates a double precision random number */
double random_double()
{
    return (random() / ((double)RAND_MAX + 1)); // generates a double precision random number

}

int main(int argc, const char *argv[])
{

	int num_points = 0;
	printf("Enter the number of points: ");
	scanf("%d", &num_points);
	printf("Multi-threading simulation for point %d\n", num_points);
	num_of_points_calc(num_points);
	return 0;

}




int num_of_points_calc(int NUM_OF_POINTS)
{
	int points_per_thread = NUM_OF_POINTS /NUM_OF_THREADS;

    double PI;

    pthread_t workers[NUM_OF_THREADS];

    /* seed the random number generator*/

    srandom((unsigned)time(NULL));
    clock_t begin = clock();
    for(int i = 0; i < NUM_OF_THREADS; i++)
    {
        pthread_create(&workers[i], 0, runner, &points_per_thread);
    }

    for(int i = 0; i < NUM_OF_THREADS; i++)
    {
        pthread_join(workers[i], NULL);
    }

    // estimate the PI value using Monte Carlo's theorem

    PI = (4.0 * circle_count )/NUM_OF_POINTS;
    clock_t end = clock();
    double time_spent = (double) (end - begin) / CLOCKS_PER_SEC;
    printf("Number of Points = %d\n", NUM_OF_POINTS);
    printf("PI = %f\n", PI);
    printf("time = %f\n", time_spent );


   }

void *runner(void *param)
{
    int POINTS;
    POINTS = *((int *)param);
    double x,y;
    int i, hit_count = 0;

    for(i = 0; i < POINTS; i++)
    {
        /* generate random numbers between -1.0 and +1.0, the size of the plane to obtain a random (x,y) point*/

        x = random_double() * 2.0 - 1.0;
        y  = random_double() * 2.0 - 1.0;

        /* to check is (x,y) point within the circle by seeing if less then size of circle radius*/
        if(sqrt(x*x + y*y)< 1.0)
        {
            ++hit_count;
        }
    }


    circle_count += hit_count;

    pthread_exit(0);
}
