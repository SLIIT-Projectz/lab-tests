#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

void * thread1()
{
	printf("Hello World!!\n");
	printf("Square numbers\n");

	for(int i = 1; i*i<101; i++)
	{
		 

		printf("%d\n"  , i*i );
	} 
}

void * thread2()
{
	printf("Hello World!!2\n");
	printf("Cubic numbers\n" );
	
	for(int i = 1; i*i*i<101; i++)
	{

		printf("%d\n", i*i*i);
	} 
}

int main()
{
	pthread_t tid1;
	pthread_t tid2; 
	pthread_create(&tid1, NULL, thread1, NULL);
	pthread_create(&tid2, NULL, thread2, NULL); 
	pthread_join(tid1, NULL);
	pthread_join(tid2, NULL);
 
 
	return 0;
}


   
