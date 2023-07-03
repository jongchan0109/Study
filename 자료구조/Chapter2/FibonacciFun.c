#include<stdio.h>

int fibonacci(int n);

int main(void)
{
    for(int i=1;i<15;i++)
        printf("%d ", fibonacci(i));
    return 0;
}

int fibonacci(int n)
{
    if(n==1)
        return 0;
    else if(n==2)
        return 1;
    else
        return fibonacci(n-1)+ fibonacci(n-2);
}