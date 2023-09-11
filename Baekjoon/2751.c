#include<stdio.h>
#include<stdlib.h>

#define MAX 1000001

typedef struct _heap
{
    int arr[MAX];
    int num_of_data;
}Heap;

void heap_init(Heap* ph);
void heap_insert(Heap* ph, int data);
int heap_delete(Heap*ph);
void heap_sort(int arr[], int n);

void print(int arr[],int n);

int main(void)
{
    int n;
    int* p;
    scanf("%d",&n);
    p = (int*)malloc(n*sizeof(int));

    for(int i=0;i<n;i++)
        scanf("%d",p+i);

    heap_sort(p,n);
    print(p,n);

    free(p);
    return 0;
}

void heap_sort(int arr[], int n)
{
    Heap heap;
    heap_init(&heap);

    for(int i=0;i<n;i++)
        heap_insert(&heap,arr[i]);
    for(int i=0;i<n;i++)
    {
        arr[i] = heap_delete(&heap);
    }
}


void heap_init(Heap* ph)
{
    ph->num_of_data = 0;
}

void heap_insert(Heap* ph, int data)
{
    if(ph->num_of_data>=MAX)
        return;
    int index = ph->num_of_data +1;

    ph->arr[index] = data;

    while(index!=1)
    {
        if(data < ph->arr[index/2])
        {
            ph->arr[index] = ph->arr[index/2];
            index = index/2;
        }
        else
            break;
    }
    ph->arr[index] = data;
    ph->num_of_data += 1;
}

int getChild(Heap*ph, int index)
{
    if(index *2 >ph->num_of_data)
        return 0;
    else if(index * 2 == ph->num_of_data)
        return index*2;
    else
    {
        if(ph->arr[2*index]<ph->arr[2*index+1])
            return 2*index;
        else
            return 2*index+1;
    }
}

int heap_delete(Heap*ph)
{
    int rData = ph->arr[1];
    int lastElem = ph->arr[ph->num_of_data];
    int parentIdx = 1;
    int childIdx;

    while(childIdx = getChild(ph,parentIdx))
    {
        if(ph->arr[childIdx]>lastElem)
            break;
        ph->arr[parentIdx] = ph->arr[childIdx];
        parentIdx = childIdx;
    }
    ph->arr[parentIdx] = lastElem;
    ph->num_of_data--;
    return rData;
}

void print(int arr[],int n)
{
    for(int i=0;i<n;i++)
        printf("%d\n",arr[i]);
}