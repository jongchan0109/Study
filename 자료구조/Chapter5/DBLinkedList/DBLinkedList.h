#ifndef DBLINKEDLIST_DBLINKEDLIST_H
#define DBLINKEDLIST_DBLINKEDLIST_H


#define TRUE 1
#define FALSE 0

typedef int Data;

typedef struct _node
{
    Data data;
    struct _node* next;
    struct _node* prev;
}Node;

typedef struct _DLinkedList
{
    Node *head;
    Node *tail;
    Node *cur;
    int numOfData;
}DBLinkedList;

typedef DBLinkedList List;

void ListInit(List *plist);
void LInsert(List *plist, Data data);

int LFirst(List* plist, Data* pdata);
int LNext(List* plist, Data* pdata);
int LPrevious(List* plist, Data* pdata);

Data LRemove(List *plist);
int LCount(List *plist);



#endif //DBLINKEDLIST_DBLINKEDLIST_H
