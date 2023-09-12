#include<stdio.h>

#define MAX 100000

typedef struct
{
    char name[201];
    int age;
    int order;
}people;

people sort[MAX];

void merge(people arr[], int first, int mid,int last);
void mergeSort(people arr[], int first, int last);

int main(void)
{
    int n;
    people arr[MAX];

    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        scanf("%d %s",&arr[i].age,arr[i].name);
        arr[i].order = i;
    }
    mergeSort(arr,0,n-1);

    for(int i=0;i<n;i++)
        printf("%d %s\n",arr[i].age,arr[i].name);
    return 0;
}

void merge(people arr[], int first, int mid,int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<= last)
    {
        if(arr[i].age<arr[j].age)
        {
            sort[k++] = arr[i++];
        }
        else if(arr[i].age>arr[j].age)
        {
            sort[k++] = arr[j++];
        }
        else
        {
            if(arr[i].order<arr[j].order)
            {
                sort[k++] = arr[i++];
            }
            else
            {
                sort[k++] = arr[j++];
            }
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
    for(int i=first;i<=last;i++)
        arr[i] = sort[i];

}

void mergeSort(people arr[], int first, int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }

}