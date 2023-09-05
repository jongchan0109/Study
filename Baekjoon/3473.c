#include<stdio.h>

int main(void)
{
    int t;
    scanf("%d",&t);

    while(t--)
    {
        int n;
        int count_5 = 0;
        scanf("%d",&n);

        for(int i=5;i<=n;i*=5)
        {
            count_5 += n/i;
        }
        printf("%d\n",count_5);
    }

    return 0;
}
