#include<stdio.h>

#define MAX 50

int sort[MAX];

void merge(int arr[],int first,int mid,int last);
void mergeSort(int arr[],int first,int last);

int main(void)
{
    int n;
    int arr[MAX];
    int sum = 0;
    int index=0;
    int ne=0,po = 0;
    scanf("%d",&n);

    for(int i=0;i<n;i++)
        scanf("%d",&arr[i]);

    mergeSort(arr,0,n-1);

    for(int i=0;i<n;i++)
    {
        if(arr[i]<0)
            ne++;
        else if(arr[i]>1)
            po ++;
    }

    if(ne%2==1)
    {
        while(index<ne-1)
        {
            sum += arr[index]* arr[index+1];
            arr[index] = 0;
            arr[index+1] = 0;
            index +=2;
        }
        if (arr[index + 1] == 0 && n - 1 == index);	// input에 음수만 있는 경우
        else if (arr[index + 1] == 0)	// 남은 음수 다음의 원소가 0일 때
            arr[index] = 0;
    }
    else if (ne != 0) {	//
        while (index < ne) {
            sum += arr[index] * arr[index + 1];
            arr[index] = 0;
            arr[index + 1] = 0;
            index += 2;
        }
    }

    index = 0;
    if(po %2 ==1)
    {
        while(index<po-1)
        {
            sum += arr[n-index-1]* arr[n - index - 2];
            arr[n-index-1] = 0;
            arr[n-index-2] = 0;
            index +=2;
        }
    }
    else if(po!=0)
    {
        while(index<po)
        {
            sum += arr[n-index-1]*arr[n-index-2];
            arr[n-index-1]=0;
            arr[n-index-2]=0;
            index+=2;
        }
    }

    for(int i=0;i<n;i++)
        sum+=arr[i];
    printf("%d\n",sum);
    return 0;
}

void merge(int arr[],int first,int mid,int last)
{
    int i = first;
    int j = mid+1;
    int k = first;

    while(i <= mid && j<= last)
    {
        if(arr[i]<arr[j])
            sort[k++] = arr[i++];
        else
            sort[k++] = arr[j++];
    }
        while(j<=last)
            sort[k++] = arr[j++];

        while(i<=mid)
            sort[k++] = arr[i++];

    for(i=first;i<=last;i++)
        arr[i]= sort[i];
}

void mergeSort(int arr[],int first,int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}
