#include<stdio.h>

int BSearchRecur(int ar[],int first,int last,int target);

int main(void)
{
    int arr[]={1,3,5,7,9};
    int idx;

    idx = BSearchRecur(arr,0,4,7);
    if(idx == -1)
        printf("탐색 실패\n");
    else
        printf("타겟 저장 인덱스: %d\n",idx);

    return 0;
}

int BSearchRecur(int ar[],int first,int last,int target)
{
    int mid;
    if(first>last)
        return -1;
    mid = (first+last)/2;

    if(target==ar[mid])
        return mid;
    else if(target<ar[mid])
        return BSearchRecur(ar,first,mid-1,target);
    else
        return BSearchRecur(ar,mid+1,last,target);
}