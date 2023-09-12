#include<stdio.h>

#define MAX 100000

typedef struct
{
    int start;
    int end;
}time;

time sort[MAX];

void merge(time arr[], int first, int mid, int last);
void mergeSort(time arr[], int first, int last);


int main(void)
{
    int n,count = 0,i,j;
    scanf("%d",&n);
    time arr[MAX];

    for(i=0;i<n;i++)
        scanf("%d%d",&arr[i].start,&arr[i].end);
    mergeSort(arr,0,n-1);

    i = 0;
    j = 1;
    count = 1;
    while(j<n)
    {
        if(arr[i].end <=arr[j].start) {
            i=j;
            count++;
        }
        j++;
    }
    printf("%d\n",count);
    return 0;
}


void merge(time arr[], int first, int mid, int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i].end < arr[j].end)
        {
            sort[k++] = arr[i++];
        }
        else if(arr[i].end>arr[j].end)
        {
            sort[k++] = arr[j++];
        }
        else
        {
            if(arr[i].start<arr[j].start)
                sort[k++] = arr[i++];
            else
                sort[k++] = arr[j++];
        }
    }
    if(i>mid)
    {
        while(j<=last)
        {
            sort[k++] = arr[j++];
        }
    }
    else
    {
        while(i<=mid)
        {
            sort[k++] = arr[i++];
        }
    }
    for(int i=first;i<=last;i++)
        arr[i] = sort[i];

}


void mergeSort(time arr[], int first, int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}