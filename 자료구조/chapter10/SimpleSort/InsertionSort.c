#include<stdio.h>

void InsertionSort(int arr[], int n);

int main(void)
{
    int arr[4] = {3,2,4,1};

    InsertionSort(arr,sizeof(arr)/sizeof(int));

    for(int i=0;i<4;i++)
        printf("%d ",arr[i]);

    return 0;
}

void InsertionSort(int arr[], int n)
{
    int insData;
    int j;
    for(int i=1;i<n;i++)
    {
        insData = arr[i];

        for(j = i-1;j>=0;j--)
        {
            if(arr[j]<insData)
                break;

            arr[j+1] = arr[j];
        }
        arr[j+1] = insData;

    }

}
