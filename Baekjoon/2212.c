#include<stdio.h>

#define MAX 10000


int sort[MAX];

void merge(int arr[],int first,int mid,int last);
void mergeSort(int arr[],int first,int last);

int main(void)
{
    int n,k,sum=0,ind;
    int arr[MAX];
    int diff[MAX];
    scanf("%d%d",&n,&k);

    for(int i=0;i<n;i++)
        scanf("%d",&arr[i]);

    if(k>=n) { // k가 n보다 큰 경우 종료
        printf("%d\n", 0);
        return 0;
    }

    mergeSort(arr,0,n-1);



    for(int i=0;i<n-1;i++)
    {
        diff[i] = arr[i+1]-arr[i];
    }

    mergeSort(diff,0,n-2);


    for(int i=0;i<n-k;i++)
        sum += diff[i];

    printf("%d\n",sum);

    return 0;
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
    while(i<=mid)
        sort[k++] = arr[i++];
    while(j<=last)
        sort[k++] = arr[j++];

    for(i = first;i<=last;i++)
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


