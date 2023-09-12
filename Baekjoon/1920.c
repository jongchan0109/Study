#include<stdio.h>

#define MAX 100000

int sort[MAX];

void merge(int arr[],int first, int mid, int last);
void mergeSort(int arr[], int first, int last);
int binarySearch(int arr[], int left, int right,int target);

int main(void)
{
    int n,m,num;
    int p[MAX];

    scanf("%d",&n);

    for(int i=0;i<n;i++)
        scanf("%d",&p[i]);
    mergeSort(p,0,n-1);

    scanf("%d",&m);
    for(int i=0;i<m;i++)
    {
        scanf("%d",&num);
        printf("%d\n", binarySearch(p,0,n-1,num));
    }

    return 0;
}


void merge(int arr[],int first, int mid, int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i]<arr[j])
        {
            sort[k++] = arr[i++];
        }
        else
        {
            sort[k++] = arr[j++];
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
    for(i=first;i<=last;i++)
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
int binarySearch(int arr[], int left, int right,int target)
{
    if(left<=right)
    {
        int mid = (left+right)/2;
        if(target == arr[mid])
        {
            return 1;
        }
        else if(target>arr[mid])
        {
            return binarySearch(arr,mid+1,right,target);
        }
        else
        {
            return binarySearch(arr,left,mid-1,target);
        }

    }
    else
        return 0;
}