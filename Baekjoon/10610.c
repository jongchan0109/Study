#include<stdio.h>
#include<string.h>
#define MAX 100000

int sort[MAX];

void merge(int arr[], int first, int mid, int last);
void mergeSort(int arr[], int first, int last);

int main(void)
{
    char str[MAX];
    int len,cnt=0,sum=0;
    int arr[MAX];
    scanf("%s",str);

    len = strlen(str);
    for(int i=0;i<len;i++)
        arr[i] = str[i]-'0';
    for(int i=0;i<len;i++)
    {
        sum += arr[i];
        if(arr[i]==0)
            cnt++;
    }
    if(cnt==0 || sum%3 !=0)
    {
        printf("%d\n",-1);
        return 0;
    }
    mergeSort(arr,0,len-1);
    for(int i=0;i<len;i++)
        printf("%d",arr[i]);
    return 0;
}

void merge(int arr[], int first, int mid, int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i]>arr[j])
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
    for(i = first; i<=last ; i++)
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