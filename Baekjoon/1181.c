#include<stdio.h>
#include<string.h>

#define MAX 20000

typedef struct _str
{
    char string[51];
    int length;
}str;

str sorted[MAX];

void merge(str* arr, int first, int mid,int last);
void merge_sort(str*arr, int first, int last);

int main(void)
{
    str arr[MAX];

    int n;

    scanf("%d",&n);
    for(int i=0;i<n;i++) {
        scanf("%s", arr[i].string);
        arr[i].length = strlen(arr[i].string);
    }
    merge_sort(arr,0,n-1);

    printf("%s\n",arr[0].string);

    for(int i=1;i<n;i++) {
        if(strcmp(arr[i-1].string,arr[i].string)!=0)
            printf("%s\n", arr[i].string);
    }
    return 0;
}


void merge(str* arr, int first, int mid,int last)
{
    int i = first;
    int j = mid + 1;
    int k = first;

    while(i<=mid && j<=last)
    {
        if(arr[i].length<arr[j].length)
        {
            sorted[k++] = arr[i++];
        }
        else if(arr[i].length>arr[j].length)
        {
            sorted[k++] = arr[j++];
        }
        else {
            if (strcmp(arr[i].string, arr[j].string) < 0) {
                sorted[k++] = arr[i++];
            }
            else {
                sorted[k++] = arr[j++];
            }
        }
    }
    if (i > mid) {
        while (j <= last)
            sorted[k++] = arr[j++];
    }
    else {
        while (i <= mid)
            sorted[k++] = arr[i++];
    }
    for (k = first; k <= last; k++)
        arr[k] = sorted[k];
}

void merge_sort(str*arr, int first, int last)
{
    int mid = (first+last)/2;
    if(last>first)
    {
        merge_sort(arr,first,mid);
        merge_sort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}