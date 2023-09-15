#include<stdio.h>
#include<stdlib.h>

int* sort;

void mergeSort(int arr[], int first, int last);
void merge(int arr[],int first, int mid, int last);
int count(int arr[],int n,int target);

int main(void)
{
    int n,num;
    int* p;
    scanf("%d",&n);
    p = (int*)malloc(n*sizeof(int));
    sort = (int*)malloc(n*sizeof(int));

    for(int i=0;i<n;i++)
        scanf("%d",p+i);
    scanf("%d",&num);

    mergeSort(p,0,n-1);
    printf("%d",count(p,n,num));

    free(sort);
    free(p);
    return 0;
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

void merge(int arr[],int first, int mid, int last)
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


int count(int arr[],int n,int target)
{
    int cnt = 0,sum;
    int i = 0;
    int j = n-1;

    while(i<j)
    {
        sum = arr[i]+arr[j];
        if(sum == target)
        {
            cnt++;
            i++;
            j--;
        }
        else if(sum>target)
        {
            j--;
        }
        else
            i++;
    }
    return cnt;

}