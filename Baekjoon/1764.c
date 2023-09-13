#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct
{
    char name[21];
}string;

string* sort;

void merge(string arr[], int first, int mid, int last);
void mergeSort(string arr[], int first, int last);


int main(void)
{
    int n,m;
    int count = 0,x=0,y=0;
    string* a;
    string* b;
    string* set;
    scanf("%d %d",&n,&m);

    a = (string*)malloc(n*sizeof(string));
    b = (string*)malloc(m*sizeof(string));
    sort = (string*)malloc((n>m?n:m)*sizeof(string));
    set = (string*)malloc((n>m?n:m)*sizeof(string));

    for(int i=0;i<n;i++)
        scanf("%s",a[i].name);
    for(int i=0;i<m;i++)
        scanf("%s",b[i].name);

    mergeSort(a,0,n-1);
    mergeSort(b,0,m-1);

    while(x<n && y<m)
    {
        if(strcmp(a[x].name,b[y].name)==0)
        {
            set[count++] = a[x];
            x++;y++;
        }
        else if(strcmp(a[x].name,b[y].name)<0)
        {
            x++;
        }
        else
            y++;
    }
    printf("%d\n",count);
    for(int i=0;i<count;i++)
        printf("%s\n",set[i].name);

    free(a);
    free(b);
    free(sort);
    free(set);
    return 0;
}


void merge(string arr[], int first, int mid, int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i<=mid && j <=last)
    {
        if(strcmp(arr[i].name,arr[j].name)<0)
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

void mergeSort(string arr[], int first, int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}