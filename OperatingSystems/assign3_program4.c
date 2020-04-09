/*
    Name: Bilal Malik
    Program: COMP 3300 Assignment 1 Program 4
    Date: 13/02/2020
 */

// compile with g++ -fopenmp assign3_program4.c

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <omp.h>
#define NUM_OF_POINTS 1000000


int diff_num_of_slaves(int NUM_OF_SLAVES);

int circle_count = 0; // points in the circle

/* Generates a double precision random number */
double random_double()
{
    return (random() / ((double)RAND_MAX + 1)); // generates a double precision random number

}

int main(int argc, const char *argv[])
{

	int slave_value = 0;

	printf("Enter the number of slaves: ");
	scanf("%d", &slave_value);
	printf("OpenMP race condition simulation with slave = %d\n", slave_value);
	diff_num_of_slaves(slave_value);




return 0;
}


int diff_num_of_slaves(int NUM_OF_SLAVES)
{
    int i;

    double PI;

    /* seed the random number generator*/

    srandom((unsigned)time(NULL));
    clock_t begin = clock();

#pragma omp parallel //using omp library, the following block runs in parallel
    {
        int hit_count = 0, i;
        double x,y;


            for(i = 0; i < NUM_OF_POINTS; i++)
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

#pragma omp critical //using the omp library, the following block is treated as a critical piece of code and only executed once at a time
        {
            circle_count += hit_count;
        }

    }
    // estimate the PI value using Monte Carlo's theorem

    PI = (4.0 * circle_count / (NUM_OF_POINTS * omp_get_num_procs()));
    clock_t end = clock();
    double time_spent = (double) (end - begin) / CLOCKS_PER_SEC;
    printf("Number of Points = %d\n", NUM_OF_POINTS);
    printf("Number of Slaves = %d\n", NUM_OF_SLAVES);
    printf("PI = %f\n", PI);
    printf("time = %f\n", time_spent /(1024 * NUM_OF_SLAVES));



}

