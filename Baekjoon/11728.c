#include<stdio.h>
#include<stdlib.h>

int* sort;

void mergeSort(int arr[],int first,int last);
void merge(int arr[],int first,int mid,int last);

int main(void)
{
    int n,m;
    int*p;
    scanf("%d%d",&n,&m);

    p = (int*)malloc(sizeof(int)*(n+m));
    sort = (int*)malloc((n+m)*sizeof(int));

    for(int i=0;i<n+m;i++)
        scanf("%d",p+i);
    mergeSort(p,0,n+m-1);

    for(int i=0;i<n+m;i++)
        printf("%d ",p[i]);

    free(p);
    free(sort);
    return 0;
}


void mergeSort(int arr[],int first,int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}

void merge(int arr[],int first,int mid,int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i]<arr[j])
            sort[k++] = arr[i++];
        else
            sort[k++] = arr[j++];
    }
    if(i>mid)
    {
        while(j<=last)
            sort[k++] = arr[j++];
    }
    else {
        while (i <= mid)
            sort[k++] = arr[i++];
    }
    for(i = first;i<=last;i++)
        arr[i] = sort[i];
}
