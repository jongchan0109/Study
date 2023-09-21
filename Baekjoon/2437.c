#include<stdio.h>

#define MAX 1000

int sort[MAX];
void merge(int arr[],int first,int mid,int last);
void mergeSort(int arr[],int first,int last);

int main(void)
{
    int n;
    int arr[MAX];
    int sum=1;
    scanf("%d",&n);

    for(int i=0;i<n;i++)
        scanf("%d",&arr[i]);

    mergeSort(arr,0,n-1);

    for(int i=0;i<n;i++)
    {
        if(arr[i]>sum)
            break;
        sum +=arr[i];
    }
    printf("%d\n",sum);

    return 0;
}


void merge(int arr[],int first,int mid,int last)
{
    int i =first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i]<arr[j])
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


void mergeSort(int arr[],int first,int last)
{
    if(first<last)
    {
        int mid = (first+last)/2;
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }

}