#include<stdio.h>

#define MAX 100000

typedef struct
{
    int one;
    int two;
}people;

people sort[MAX];

void merge(people arr[], int first, int mid, int last);
void mergeSort(people arr[], int first, int last);
int count(people arr[], int n);

int main(void)
{
    int t;
    scanf("%d",&t);
    people arr[MAX];
    while(t--)
    {
        int n;
        scanf("%d",&n);
        for(int i=0;i<n;i++)
            scanf("%d%d",&arr[i].one,&arr[i].two);
        mergeSort(arr,0,n-1);

        printf("%d\n",count(arr,n));
    }
    return 0;
}

void merge(people arr[], int first, int mid, int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i].one<arr[j].one)
        {
            sort[k++] = arr[i++];
        }
        else
            sort[k++] = arr[j++];
    }
    if(i>mid)
    {
        while(j<=last)
            sort[k++] = arr[j++];
    }
    else
    {
        while(i<=mid)
            sort[k++] = arr[i++];
    }
    for(i=first;i<=last;i++)
        arr[i] = sort[i];
}

void mergeSort(people arr[], int first, int last)
{
    int mid = (first+last)/2;

    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}

int count(people arr[], int n)
{
    int cnt = 1;
    int min_two = arr[0].two;

    for(int i=1;i<n;i++)
    {
        if(arr[i].two < min_two) {
            cnt++;
            min_two = arr[i].two;
        }

    }
    return cnt;
}