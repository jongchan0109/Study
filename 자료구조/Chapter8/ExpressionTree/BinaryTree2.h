#ifndef EXPRESSIONTREE_BINARYTREE2_H
#define EXPRESSIONTREE_BINARYTREE2_H

typedef int BTData;

typedef struct _bTreeNode
{
    BTData data;
    struct _bTreeNode* left;
    struct _bTreeNode* right;
}BTreeNode;

BTreeNode* MakeBTreeNode(void);
BTData GetData(BTreeNode* bt);
void SetData(BTreeNode*bt, BTData data);

BTreeNode* GetLeftSubTree(BTreeNode* bt);
BTreeNode* GetRightSubTree(BTreeNode* bt);

void MakeLeftSubTree(BTreeNode* main, BTreeNode* sub);
void MakeRightSubTree(BTreeNode* main, BTreeNode* sub);

typedef void (*VisitFuncPtr)(BTData data);

void PreorderTraverse(BTreeNode* bt, VisitFuncPtr action);
void InorderTraverse(BTreeNode* bt, VisitFuncPtr action);
void PostorderTraverse(BTreeNode* bt, VisitFuncPtr action);


#endif //EXPRESSIONTREE_BINARYTREE2_H
