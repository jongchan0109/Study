#include<stdio.h>
#include<stdlib.h>

int* sort;
void merge(int arr[], int first, int mid, int last);
void mergeSort(int arr[], int first, int last);

int main(void)
{
    int n,k;
    int* p;
    scanf("%d%d",&n,&k);

    p = (int*)malloc(n*sizeof(int));
    sort = (int*)malloc(n*sizeof(int));

    for(int i=0;i<n;i++)
        scanf("%d",p+i);


    mergeSort(p,0,n-1);

    printf("%d\n",p[k-1]);


    free(p);
    free(sort);
    return 0;
}

void merge(int arr[], int first, int mid, int last)
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
    else
    {
        while(i<=mid)
            sort[k++] = arr[i++];
    }


    for(i = first;i<=last;i++)
        arr[i] = sort[i];
}

void mergeSort(int arr[], int first, int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}