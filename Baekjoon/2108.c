#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int* sort;

typedef struct
{
    int number;
    int cnt;
}num;


void merge(int arr[], int first, int mid, int last);
void mergeSort(int arr[], int first, int last);

int main(void)
{
    int n,sum=0,average;
    double ave;
    int* p;
    int count[8002]={0,};
    num k[8001];
    num temp;
    scanf("%d",&n);

    p = (int*)malloc(n*sizeof(int));
    sort = (int*)malloc(n*sizeof(int));

    for(int i=0;i<n;i++) {
        scanf("%d", p + i);
        sum += *(p+i);
        count[*(p+i)+4000]++;
    }

    for(int t=0;t<8001;t++)
    {
        k[t].number = t-4000;
        k[t].cnt = count[t];
    }

    for(int t=0;t<8000;t++)
    {
        for(int j=t+1;j<8001;j++)
        {
            if(k[t].cnt < k[j].cnt)
            {
                temp = k[t];
                k[t] = k[j];
                k[j] = temp;
            }
            else if(k[t].cnt == k[j].cnt&& k[t].number> k[j].number)
            {
                temp = k[t];
                k[t] = k[j];
                k[j] = temp;
            }
        }
    }


    ave = (double)sum/n;
    average = round(ave);

    mergeSort(p,0,n-1);



    printf("%d\n",average);
    printf("%d\n",p[n/2]);
    if(k[0].cnt == k[1].cnt)
        printf("%d\n",k[1].number);
    else
        printf("%d\n",k[0].number);
    printf("%d\n",p[n-1]-p[0]);


    free(sort);
    free(p);
    return 0;
}

void merge(int arr[], int first, int mid, int last)
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