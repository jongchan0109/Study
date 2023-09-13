#include<stdio.h>
#include<stdlib.h>

int* sort;
void merge(int arr[], int first, int mid, int last);
void mergeSort(int arr[], int first, int last);
int binarySearch(int arr[], int first, int last, int target, int isLeft);

int main(void)
{
    int n,m,num,index;
    int* p;
    scanf("%d",&n);
    p = (int*)malloc(n*sizeof(int));
    sort = (int*)malloc(n*sizeof(int));

    for(int i=0;i<n;i++)
        scanf("%d",p+i);
    mergeSort(p,0,n-1);

    scanf("%d",&m);
    while (m--) {
        scanf("%d", &num);
        int left = binarySearch(p, 0, n - 1, num, 1);
        int right = binarySearch(p, 0, n - 1, num, 0);

        if (left != -1 && right != -1)
            printf("%d ", right - left + 1);
        else
            printf("0 ");
    }

    free(p);
    free(sort);
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
    if(last>first)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }

}
int binarySearch(int arr[], int first, int last, int target, int isLeft) {
    int result = -1;
    while (first <= last) {
        int mid = (first + last) / 2;
        if (arr[mid] == target) {
            result = mid;
            if (isLeft) // 좌측 경계를 찾는 경우
                last = mid - 1;
            else // 우측 경계를 찾는 경우
                first = mid + 1;
        } else if (arr[mid] < target)
            first = mid + 1;
        else
            last = mid - 1;
    }
    return result;
}