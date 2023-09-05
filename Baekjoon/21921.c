#include<stdio.h>
#include<stdlib.h>

int main(void)
{
    int n,x,max=0,count=0;
    int* p;

    scanf("%d%d",&n,&x);
    p = (int*)malloc(n*sizeof(int));

    for(int i=0;i<n;i++)
        scanf("%d",p+i);

    int sum = 0;
    for(int i=0;i<n;i++) {
        sum += p[i];

        if (i >= x-1) {
            sum -= p[i-x];
            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max)
                count += 1;
        }
    }

    if(max !=0)
    {
        printf("%d\n%d",max,count);
    }
    else
    {
        printf("SAD\n");
    }

    return 0;
}