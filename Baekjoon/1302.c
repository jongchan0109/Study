#include<stdio.h>
#include<string.h>

#define MAX 1000
typedef struct
{
    char string[51];
}str;

str sort[MAX];

void merge(str arr[], int first, int mid, int last);
void mergeSort(str arr[], int first, int last);

int main(void)
{
    str arr[MAX];
    int n;
    int sum=0,ind=0,max=0;

    scanf("%d",&n);
    for(int i=0;i<n;i++)
        scanf("%s",arr[i].string);

    mergeSort(arr,0,n-1);

    for(int i=0;i<n-1;i++)
    {
        if(strcmp(arr[i].string,arr[i+1].string)==0) {
            sum++;
            if(sum>max)
            {
                max = sum;
                ind = i;
            }
        }
        else
            sum = 0;
    }
    printf("%s\n",arr[ind].string);
    return 0;
}

void merge(str arr[], int first, int mid, int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(strcmp(arr[i].string,arr[j].string)<0)
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
    for(i=first;i<=last;i++)
        arr[i] = sort[i];
}

void mergeSort(str arr[], int first, int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}