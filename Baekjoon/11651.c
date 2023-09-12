#include<stdio.h>

#define MAX 100000

typedef struct
{
    int x;
    int y;
}point;

point sort[MAX];

void merge(point arr[], int first, int mid, int last);
void mergeSort(point arr[], int first, int last);

int main(void)
{
    int n;
    point arr[MAX];
    scanf("%d",&n);

    for(int i=0;i<n;i++)
    {
        scanf("%d%d",&arr[i].x,&arr[i].y);
    }
    mergeSort(arr,0,n-1);

    for(int i=0;i<n;i++)
        printf("%d %d\n",arr[i].x,arr[i].y);

    return 0;
}


void merge(point arr[], int first, int mid, int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i].y<arr[j].y)
        {
            sort[k++]= arr[i++];
        }
        else if(arr[i].y>arr[j].y)
        {
            sort[k++]= arr[j++];
        }
        else
        {
            if(arr[i].x<arr[j].x)
            {
                sort[k++] = arr[i++];
            }
            else
            {
                sort[k++] = arr[j++];
            }
        }
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
    for(int t=first;t<=last;t++)
        arr[t]=sort[t];

}

void mergeSort(point arr[], int first, int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}