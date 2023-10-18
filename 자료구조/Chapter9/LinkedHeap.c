#include<stdio.h>
#include<stdlib.h>

#define TRUE 1
#define FALSE 0

typedef struct _node
{
    int data;
    struct _node* left;
    struct _node* right;
    struct _node* parent;
}Node;

typedef struct _heap
{
    Node* root;
    Node* last;
    int num_of_data;
}Heap;

void heapInit(Heap* heap);
void advancedLast(Heap* heap);
void expandExternal(Node* z);
void reduceExternal(Heap* heap,Node* z);
void insertItem(Heap* heap, int item);
void upHeap(Heap* heap,Node* v);
int removeMin(Heap* heap);
void downHeap(Heap* heap, Node* v);
int isExternal(Node* v);
int isInternal(Node* v);
void swapElement(Node* s1, Node* s2);
Node* sibling(Node* node);
void putNode(Node* node);
int isLeftChild(Node* node);
int isRightChild(Node* node);
void retreatLast(Heap* heap);
int isEmpty(Heap* heap);

int main(void)
{
    Heap heap;
    heapInit(&heap);

    for(int i=0;i<10;i++)
        insertItem(&heap,i);
    for(int i=0;i<10;i++)
        insertItem(&heap, i+10);

    while(!isEmpty(&heap))
        printf("%d ",removeMin(&heap));

    return 0;
}


void heapInit(Heap* heap)
{
    heap->num_of_data = 0;
    Node* node = (Node*)malloc(sizeof(Node)); // 외부노드 생성
    expandExternal(node);
    node->parent = NULL;
    heap->root = node;
    heap->last = node;
}

void advancedLast(Heap* heap)
{

    if(heap->num_of_data==0)
        return;
    Node* v = heap->last;

    while(isRightChild(v))
    {
        v = v->parent;
    }
    if(isLeftChild(v))
        v = sibling(v);

    while(isInternal(v))
    {
        v = v->left;
    }
    heap->last = v;
}

void expandExternal(Node* z)
{
    Node* l = (Node*)malloc(sizeof(Node));
    Node* r = (Node*)malloc(sizeof(Node));
    l->left = NULL;
    l->right = NULL;
    r->left = NULL;
    r->right = NULL;
    l->parent = z;
    r->parent = z;
    z->left =l;
    z->right = r;
}
void reduceExternal(Heap* heap,Node* z)
{
    Node* w = z->parent;
    Node* zs = sibling(z);

    if(heap->root == w)
    {
        heap->root = zs;
        zs->parent = NULL;
    }
    else
    {
        Node* g = w->parent;
        if(g->left == w)
        {
            g->left = zs;
            zs->parent = g;
        }
        else
        {
            g->right = zs;
            zs->parent = g;
        }
    }
    putNode(w);
    putNode(z);
}

void insertItem(Heap* heap, int item)
{
    advancedLast(heap);
    Node* z = heap->last;
    z->data = item;
    expandExternal(z);

    upHeap(heap,z);
    heap->num_of_data ++;
}

void swapElement(Node* s1,Node*s2)
{
    int temp = s1->data;
    s1->data = s2->data;
    s2->data = temp;
}

void upHeap(Heap* heap,Node* v)
{
    if(heap->root == v)
        return;
    Node* p = v->parent;
    if(p->data>=v->data)
        swapElement(p,v);
    upHeap(heap,p);
}



int removeMin(Heap* heap)
{

    int k = heap->root->data;

    Node* w = heap->last;
    swapElement(heap->root,w);

    retreatLast(heap);
    Node*z = w->right;
    reduceExternal(heap,z);

    downHeap(heap,heap->root);
    heap->num_of_data--;
    return k;
}

void downHeap(Heap* heap, Node* v)
{
    if(heap->num_of_data == 1)
        return;
    if(isExternal(v->left)&& isExternal(v->right))
        return;

    Node* smaller = v->left;
    if(isInternal(v->right))
    {
        if(smaller->data> v->right->data)
            smaller = v->right;
    }
    if(v->data<smaller->data)
        return;
    swapElement(v,smaller);
    downHeap(heap,smaller);
}

int isExternal(Node* v)
{
    if(v->left==NULL && v->right == NULL)
        return TRUE;
    else
        return FALSE;
}

int isInternal(Node* v)
{
    if(v->left == NULL && v->right == NULL)
        return FALSE;
    else
        return TRUE;
}

Node* sibling(Node* node)
{
    Node* p = node->parent;
    if(p->left == node)
        return p->right;
    else
        return p->left;
}

void putNode(Node* node)
{
    free(node);
}

int isEmpty(Heap* heap)
{
    if(heap->num_of_data == 0)
        return TRUE;
    else
        return FALSE;
}


int isLeftChild(Node* node)
{
    if(node->parent ==NULL)
        return FALSE;
    Node* parent = node->parent;
    if(parent->left == node)
        return TRUE;
    else
        return FALSE;
}

int isRightChild(Node* node)
{
    if(node->parent ==NULL)
        return FALSE;
    Node* parent = node->parent;
    if(parent->right == node)
        return TRUE;
    else
        return FALSE;
}


void retreatLast(Heap* heap)
{
    if (heap->num_of_data == 0)
        return;
    Node* v = heap->last;

    while (isLeftChild(v))
    {
        v = v->parent;
    }

    if (isRightChild(v))
    {
        v = sibling(v);
    }

    while (isInternal(v))
    {
        if(isExternal(v->right))
            break;
        v = v->right;
    }
    heap->last = v;

}