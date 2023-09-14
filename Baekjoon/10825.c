#include<stdio.h>
#include<string.h>

#define MAX 100000

typedef struct
{
    char name[11];
    int kor;
    int eng;
    int math;
}student;

student sort[MAX];

void mergeSort(student arr[], int first, int last);
void merge(student arr[], int first, int mid, int last);
void input(student arr[], int n);
void print(student arr[], int n);

int main(void)
{
    int n;
    student arr[MAX];
    scanf("%d",&n);
    input(arr,n);

    mergeSort(arr,0,n-1);
    print(arr,n);

    return 0;
}

void mergeSort(student arr[], int first, int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}

void merge(student arr[], int first, int mid, int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i].kor>arr[j].kor)
            sort[k++] = arr[i++];
        else if(arr[i].kor == arr[j].kor && arr[i].eng<arr[j].eng)
            sort[k++] = arr[i++];
        else if(arr[i].kor == arr[j].kor && arr[i].eng == arr[j].eng && arr[i].math >arr[j].math)
            sort[k++] = arr[i++];
        else if(arr[i].kor == arr[j].kor && arr[i].eng == arr[j].eng &&arr[i].math == arr[j].math && strcmp(arr[i].name,arr[j].name)<0)
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

void input(student arr[], int n)
{
    for(int i=0;i<n;i++)
        scanf("%s %d %d %d",arr[i].name, &arr[i].kor,&arr[i].eng,&arr[i].math);
}
void print(student arr[], int n)
{
    for(int i=0;i<n;i++)
        printf("%s\n",arr[i].name);
}
