#include<stdio.h>
#include<pthread.h>
#include<stdlib.h>

void * thread1()
{
    printf("Hello World!!\n");

    for(int i=2; i<101; i+=2)
    {
        printf("%d\n", i);
    }
    return NULL;
}

int main()
{
    int n;
    printf("Enter the number : ");
    scanf("%d", &n);

    for(int i = 0; i<=n; i++)
    {
        printf("%d\n", i);
    }

    pthread_t tid1, tid2;
    pthread_create(&tid1, NULL, thread1 , NULL);
    pthread_create(&tid2, NULL, thread1 , NULL);

    pthread_join(tid1, NULL);
    pthread_join(tid2, NULL);

    return 0;
}