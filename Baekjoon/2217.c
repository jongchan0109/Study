#include<stdio.h>
#include<stdlib.h>

int* sort;
void merge(int arr[], int first, int mid, int last);
void mergeSort(int arr[], int first, int last);
int findMax(int arr[], int n);

int main(void)
{
    int n;
    int* p;
    scanf("%d",&n);

    p = (int*)malloc(n*sizeof(int));
    sort = (int*)malloc(n*sizeof(int));

    for(int i=0;i<n;i++)
        scanf("%d",p+i);

    mergeSort(p,0,n-1);

    printf("%d\n", findMax(p,n));

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

int findMax(int arr[], int n)
{
    int max = arr[0];

    for(int i=0;i<n;i++)
    {
        if(max< arr[i]*(n-i))
            max = arr[i]*(n-i);
    }
    return max;
}