#include<stdio.h>

void QuickSort(int arr[],int left, int right);

int main(void)
{
    int arr[7] = {3,2,4,1,7,6,5};
    int len = sizeof(arr)/sizeof(int);

    QuickSort(arr,0,len-1);

    for(int i=0;i<len;i++)
        printf("%d ",arr[i]);

    printf("\n");

    return 0;
}

void QuickSort(int arr[],int left, int right)
{
    int leftHold = left;
    int rightHold = right;
    int pivotIdx;

    int pivot = arr[left];
    while(left<right) {
        while (arr[right] >= pivot && left < right) {
            right -= 1;
        }
        if (left != right) {
            arr[left] = arr[right];
            left += 1;
        }
        while (arr[left]<=pivot && left<right)
        {
            left +=1;
        }
        if(left !=right)
        {
            arr[right] = arr[left];
            right -=1;
        }
    }

    arr[left] = pivot;
    pivotIdx = left;
    left = leftHold;
    right = rightHold;

    if(left<pivotIdx)
        QuickSort(arr,left,pivotIdx-1);
    if(pivotIdx<right)
        QuickSort(arr,pivotIdx+1,right);

}



