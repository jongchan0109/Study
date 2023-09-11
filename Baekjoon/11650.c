#include<stdio.h>
#define MAX 100000

typedef struct _point
{
    int x;
    int y;
}point;

point sorted[MAX];


void merge_sort(point arr[], int first, int last);
void merge(point arr[], int first, int mid, int last);

int main(void)
{
    int n;
    scanf("%d",&n);
    point arr[MAX];

    for(int i=0;i<n;i++)
        scanf("%d%d",&arr[i].x,&arr[i].y);

    merge_sort(arr,0,n-1);

    for(int i=0;i<n;i++)
        printf("%d %d\n",arr[i].x, arr[i].y);

    return 0;
}

void merge_sort(point arr[], int first, int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        merge_sort(arr,first,mid);
        merge_sort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}

void merge(point arr[], int first, int mid, int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i].x<arr[j].x)
            sorted[k++] = arr[i++];
        else if(arr[i].x>arr[j].x)
            sorted[k++] = arr[j++];
        else
        {
            if(arr[i].y<arr[j].y)
                sorted[k++] = arr[i++];
            else
                sorted[k++] = arr[j++];
        }
    }
    if(i>mid)
    {
        while(j<=last)
            sorted[k++] = arr[j++];
    }
    else
    {
        while(i<=mid)
            sorted[k++] = arr[i++];
    }
    for(int t = first;t<=last;t++)
        arr[t] = sorted[t];

}