#include<stdio.h>

#define MAX 1000

void selection_sort(int arr[], int n);
int main(void)
{

    int n,sum=0;
    int arr[MAX];
    scanf("%d",&n);

    for(int i=0;i<n;i++)
        scanf("%d",&arr[i]);

    selection_sort(arr,n);
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<=i;j++)
            sum+=arr[j];
    }
    printf("%d\n",sum);
    return 0;
}

void selection_sort(int arr[], int n)
{
    int temp;
    for(int i=0;i<n-1;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(arr[i]>arr[j])
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}