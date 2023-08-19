#include<stdio.h>

void SelectionSort(int arr[], int n);

int main(void)
{
    int arr[4] = {3,2,4,1};

    SelectionSort(arr,sizeof(arr)/sizeof(int));

    for(int i=0;i<4;i++)
        printf("%d ",arr[i]);

    return 0;
}

void SelectionSort(int arr[], int n)
{
    int temp;
    for(int i=0;i<n-1;i++)
    {
        for(int j=i+1;j<n;j++)
        {
            if(arr[j]<arr[i])
            {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
    }

}
