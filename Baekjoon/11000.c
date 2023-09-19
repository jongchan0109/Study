#include<stdio.h>

#define MAX 200000
#define TRUE 1
#define FALSE 0

typedef struct
{
    int start;
    int end;
}class;

typedef struct
{
    int arr[MAX];
    int num_of_data;
}PQueue;

class sort[MAX];

void merge(class arr[],int first, int mid, int last);
void mergeSort(class arr[], int first, int last);
void PQInit(PQueue * pq);
int PQIsEmpty(PQueue* pq);
void enqueue(PQueue* pq, int data);
void dequeue(PQueue* pq);
int top(PQueue* pq);
int num(PQueue* pq);

int main(void)
{
    int n;
    class input;
    class data;
    class arr[MAX];
    scanf("%d",&n);

    PQueue queue;
    PQInit(&queue);

    for(int i=0;i<n;i++)
    {
        scanf("%d%d",&input.start,&input.end);
        arr[i] = input;
    }
    mergeSort(arr,0,n-1);

    enqueue(&queue,arr[0].end);

    for(int i=1;i<n;i++)
    {
        if(top(&queue)<=arr[i].start)
        {
            dequeue(&queue);
            enqueue(&queue,arr[i].end);
        }
        else
        {
            enqueue(&queue,arr[i].end);
        }
    }


    printf("%d\n",num(&queue));
    return 0;
}



void PQInit(PQueue * pq)
{
    pq->num_of_data = 0;
}

int PQIsEmpty(PQueue* pq)
{
    if(pq->num_of_data ==0)
        return TRUE;
    else
        return FALSE;
}

int getParent(int idx)
{
    return idx/2;
}
int lChild(int idx)
{
    return 2*idx;
}
int rChild(int idx)
{
    return 2*idx+1;
}

void enqueue(PQueue* pq, int data)
{
    int idx = pq->num_of_data +1;
    int pIdx;
    while(idx!=1) {
        pIdx = getParent(idx);
        if (pq->arr[pIdx] > data) {
            pq->arr[idx] = pq->arr[pIdx];
            idx = pIdx;
        }
        else {
                break;
            }
        }

    pq->arr[idx] = data;
    pq->num_of_data++;
}

int getHigh(PQueue* pq, int idx)
{
    if(pq->num_of_data < lChild(idx))
        return 0;
    else if(pq->num_of_data == lChild(idx))
        return lChild(idx);
    else
    {
        if(pq->arr[lChild(idx)] < pq->arr[rChild(idx)])
            return lChild(idx);

        else
            return rChild(idx);
    }
}

void dequeue(PQueue* pq)
{
    int lData = pq->arr[pq->num_of_data];
    int pIdx = 1;
    int cIdx;

    while(cIdx = getHigh(pq,pIdx))
    {
        if(pq->arr[cIdx] < lData) {
            pq->arr[pIdx] = pq->arr[cIdx];
            pIdx = cIdx;
        }
        else
            break;
    }
    pq->arr[pIdx] = lData;
    pq->num_of_data--;
}

int top(PQueue* pq)
{
    return pq->arr[1];
}

int num(PQueue* pq)
{
    return pq->num_of_data;
}


class sort[MAX]; // 전역 변수로 선언된 sort 배열

void merge(class arr[], int first, int mid, int last)
{
    int i = first;
    int j = mid + 1;
    int k = first;

    while (i <= mid && j <= last)
    {
        if (arr[i].start < arr[j].start)
            sort[k++] = arr[i++];
        else if (arr[i].start == arr[j].start && arr[i].end < arr[j].end)
            sort[k++] = arr[i++];
        else
            sort[k++] = arr[j++];
    }

    while (i <= mid)
        sort[k++] = arr[i++];

    while (j <= last)
        sort[k++] = arr[j++];

    // 원래 배열로 복사
    for (k = first; k <= last; k++)
        arr[k] = sort[k];
}


void mergeSort(class arr[], int first, int last)
{
    int mid = (first+last)/2;
    if(first<last)
    {
        mergeSort(arr,first,mid);
        mergeSort(arr,mid+1,last);
        merge(arr,first,mid,last);
    }
}