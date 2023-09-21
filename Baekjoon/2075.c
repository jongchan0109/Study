#include <stdio.h>

#define MAX 1501

typedef struct
{
    int x, y;
    int value;
} point;

point heap[MAX];
int n = 0; // n을 0으로 초기화

void insertItem(point p);
void removeMax();
point top();
void upHeap(int i);
int getHighPriorityChild(int i);
void downHeap(int i);
int isEmpty();

int main(void)
{
    int num;
    point p;
    scanf("%d", &num);
    int arr[150][150];
    for (int i = 0; i < num; i++)
    {
        for (int j = 0; j < num; j++)
            scanf("%d", &arr[i][j]);
    }

    for (int i = 0; i < num; i++)
    {
        p.x = num-1;
        p.y = i;
        p.value = arr[num-1][i];
        insertItem(p);
    }

    int cnt = 0;



    while (!isEmpty())
    {
        if (cnt == num - 1)
            break;
        int x = top().x; // 수정: x는 행(row)을 나타내도록 수정
        int y = top().y; // 수정: y는 열(column)을 나타내도록 수정

        removeMax();

        if (x != 0)
        {
            p.x = x-1;
            p.y = y; // 수정: 열(column)을 1 감소시킴
            p.value = arr[x-1][y]; // 수정: 열(column)을 1 감소한 위치의 값을 가져옴
            insertItem(p);
        }
        cnt++;
    }
    printf("%d\n",top().value);


    return 0;
}

int isEmpty()
{
    if (n == 0)
        return 1;
    else
        return 0;
}

void insertItem(point p)
{
    n++;
    heap[n] = p;
    upHeap(n);
}

void removeMax()
{
    point p = heap[1];
    heap[1] = heap[n];
    n--;
    downHeap(1);
}

point top()
{
    return heap[1];
}

void upHeap(int i)
{
    point last = heap[i];

    while (i != 1)
    {
        if (heap[i / 2].value < last.value)
        {
            heap[i] = heap[i / 2];
            i /= 2;
        }
        else
            break;
    }
    heap[i] = last;
}

int getHighPriorityChild(int i)
{
    int leftChildIdx = 2 * i;
    int rightChildIdx = 2 * i + 1;

    if (leftChildIdx > n)
        return leftChildIdx;
    if (rightChildIdx > n || heap[leftChildIdx].value > heap[rightChildIdx].value)
        return leftChildIdx;
    return rightChildIdx;
}

void downHeap(int i)
{
    int child;
    point element = heap[i];
    while ((child = getHighPriorityChild(i)) <= n)
    {
        if (heap[child].value > element.value)
        {
            heap[i] = heap[child];
            i = child;
        }
        else
            break;
    }
    heap[i] = element;
}
