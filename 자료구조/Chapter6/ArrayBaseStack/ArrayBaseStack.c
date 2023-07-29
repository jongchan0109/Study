#include<stdio.h>
#include<stdlib.h>
#include"ArrayBaseStack.h"


void StackInit(Stack* pstack)
{
    pstack->topIndex = -1;
}

int SIsEmpty(Stack* pstack)
{
    if(pstack->topIndex==-1)
        return TRUE;
    else
        return FALSE;
}

void SPush(Stack* pstack, Data data)
{
    if(STACK_LEN<=pstack->topIndex)
    {
        printf("Stack Overflow\n");
        exit(-1);
    }
    pstack->topIndex+=1;
    pstack->stackArr[pstack->topIndex]=data;
}

Data SPop(Stack* pstack)
{
    Data rData;
    if(SIsEmpty(pstack))
    {
        printf("Stack Memory Error!\n");
        exit(-1);
    }

    rData = pstack->stackArr[pstack->topIndex];
    pstack->topIndex -=1;

    return rData;
}

Data SPeek(Stack* pstack)
{
    if(SIsEmpty(pstack))
    {
        printf("Stack Memory Error!\n");
        exit(-1);
    }

    return pstack->stackArr[pstack->topIndex];
}