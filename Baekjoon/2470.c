#include<stdio.h>

#define MAX 100000
int sort[MAX];

void mergeSort(int arr[],int first,int last);
void merge(int arr[],int first,int mid,int last);
void find(int arr[], int n);


int main(void)
{
    int n;
    int arr[MAX];
    scanf("%d",&n);

    for(int i=0;i<n;i++)
        scanf("%d",&arr[i]);

    mergeSort(arr,0,n-1);


    find(arr,n);

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
    else
    {
        while(i<=mid)
            sort[k++] = arr[i++];
    }
    for(i = first;i<=last;i++)
        arr[i] = sort[i];

}

int abs(int k)
{
    return k > 0 ? k : -k;
}

void find(int arr[], int n)
{

    int min = abs(arr[0]+arr[1]);
    int ind1 =0, ind2 = 1;
    int i = 0,j=n-1,sum;


    while(i<j)
    {
        sum = abs(arr[i]+arr[j]);
        if(sum == 0)
        {
            ind1 = i;
            ind2 = j;
            break;
        }
        else if(sum<min)
        {
            ind1 = i;
            ind2 = j;
            min = sum;
        }
        if(abs(arr[i+1]+arr[j])<abs(arr[i]+arr[j-1]))
            i++;
        else
            j--;
    }
    printf("%d %d\n",arr[ind1],arr[ind2]);
}