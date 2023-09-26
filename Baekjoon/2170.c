#include<stdio.h>

#define MAX 10000

typedef struct
{
    int start;
    int end;
}line;

line sort[MAX];

void mergeSort(line arr[],int first,int last);
void merge(line arr[],int first,int mid,int last);

int main(void)
{
    int n;
    int index=0;
    int length=0;
    line arr[MAX];
    line sum[MAX];
    line l;

    scanf("%d",&n);

    for(int i=0;i<n;i++)
        scanf("%d%d",&arr[i].start,&arr[i].end);

    mergeSort(arr,0,n-1);

    l = arr[0];

    for(int i=1;i<n;i++)
    {
        if(l.end >= arr[i].start && l.end <=arr[i].end)
            l.end = arr[i].end;
        else if(l.start<= arr[i].start && l.end >=arr[i].start)
        {}
        else
        {
            sum[index++] = l;
            l = arr[i];
        }
    }

    sum[index++] = l;

    for(int i=0;i<index;i++)
        length += sum[i].end - sum[i].start;


    printf("%d\n",length);

    return 0;
}


void mergeSort(line arr[],int first,int last)
{
    if(first<last)
    {
        int mid = (first+last)/2;
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}

void merge(line arr[],int first,int mid,int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i].start<arr[j].start)
            sort[k++] = arr[i++];
        else
            sort[k++] = arr[j++];
    }
    while(i<=mid)
        sort[k++] = arr[i++];
    while(j<=last)
        sort[k++] = arr[j++];

    for(i=first;i<=last;i++)
        arr[i] = sort[i];
}