#include<stdio.h>
#include<stdlib.h>
#include"BinaryTree2.h"

BTreeNode* MakeBTreeNode(void)
{
    BTreeNode* nd = (BTreeNode*)malloc(sizeof(BTreeNode));
    nd->right = NULL;
    nd->left = NULL;
    return nd;
}

BTData GetData(BTreeNode* bt)
{
    return bt->data;
}

void SetData(BTreeNode*bt, BTData data)
{
    bt->data = data;
}

BTreeNode* GetLeftSubTree(BTreeNode* bt)
{
    return bt->left;
}

BTreeNode* GetRightSubTree(BTreeNode* bt)
{
    return bt->right;
}

void MakeLeftSubTree(BTreeNode* main, BTreeNode* sub)
{
    main->left = sub;
}

void MakeRightSubTree(BTreeNode* main, BTreeNode* sub)
{
    main->right = sub;
}

void PreorderTraverse(BTreeNode* bt, VisitFuncPtr action)
{
    if(bt==NULL)
        return;
    action(GetData(bt));
    PreorderTraverse(bt->left,action);
    PreorderTraverse(bt->right,action);
}

void InorderTraverse(BTreeNode* bt, VisitFuncPtr action)
{
    if(bt==NULL)
        return;
    InorderTraverse(bt->left,action);
    action(GetData(bt));
    InorderTraverse(bt->right,action);
}

void PostorderTraverse(BTreeNode* bt, VisitFuncPtr action)
{
    if(bt==NULL)
        return;
    PostorderTraverse(bt->left,action);
    PostorderTraverse(bt->right,action);
    action(GetData(bt));
}