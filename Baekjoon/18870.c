#include<stdio.h>
#include<stdlib.h>

typedef struct
{
    int number;
    int index;
    int order;
}num;

num* sort;

void mergeSort(num arr[], int first, int last,int sign);
void merge(num arr[], int first, int mid, int last, int sign);
void minus(num x[],int n);

int main(void)
{
    int n;
    num* x;
    scanf("%d",&n);

    x = (num*)malloc(n*sizeof(num));
    sort = (num*)malloc(n*sizeof(num));

    for(int i = 0;i<n;i++) {
        scanf("%d", &x[i].number);
        x[i].index = i;
    }

    mergeSort(x,0,n-1,0);
    
    minus(x,n);

    mergeSort(x,0,n-1,1);
    for(int i=0;i<n;i++)
        printf("%d ",x[i].order);

    free(x);
    free(sort);
    return 0;
}


void mergeSort(num arr[], int first, int last,int sign)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid,sign);
        mergeSort(arr,mid+1,last,sign);
        merge(arr,first,mid,last,sign);
    }
}

void merge(num arr[], int first, int mid, int last,int sign)
{
    int i = first;
    int j = mid+1;
    int k =first;
    if(sign==0) {
        while (i <= mid && j <= last) {
            if (arr[i].number < arr[j].number)
                sort[k++] = arr[i++];
            else
                sort[k++] = arr[j++];
        }
        if (i > mid) {
            while (j <= last)
                sort[k++] = arr[j++];
        } else {
            while (i <= mid)
                sort[k++] = arr[i++];
        }
    }
    else
    {
        while (i <= mid && j <= last) {
            if (arr[i].index < arr[j].index)
                sort[k++] = arr[i++];
            else
                sort[k++] = arr[j++];
        }
        if (i > mid) {
            while (j <= last)
                sort[k++] = arr[j++];
        } else {
            while (i <= mid)
                sort[k++] = arr[i++];
        }
    }
    for(i = first;i<=last;i++)
        arr[i] = sort[i];

}

void minus(num arr[],int n)
{
    for(int i=0;i<n;i++)
        arr[i].order = i;

    int cnt = 0;
    for(int i =1;i<n;i++)
    {
        if(arr[i].number == arr[i-1].number)
            cnt++;
        arr[i].order -=cnt;
    }

}