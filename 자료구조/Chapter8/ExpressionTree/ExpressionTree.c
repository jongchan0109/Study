#include<stdio.h>
#include<string.h>
#include<ctype.h>
#include"ExpressionTree.h"
#include"ListBaseStack.h"

BTreeNode* MakeExpTree(char exp[])
{
    Stack stack;
    BTreeNode* pnode;
    int len = strlen(exp);

    StackInit(&stack);

    for(int i=0;i<len;i++)
    {
        pnode = MakeBTreeNode();
        if(isdigit(exp[i]))
        {
            SetData(pnode,exp[i]-'0');
        }
        else
        {
            MakeRightSubTree(pnode,SPop(&stack));
            MakeLeftSubTree(pnode, SPop(&stack));
            SetData(pnode,exp[i]);
        }
        SPush(&stack,pnode);
    }
    return SPop(&stack);
}

int EvaluateExpTree(BTreeNode* bt)
{
    int op1,op2;

    if(GetLeftSubTree(bt)==NULL && GetRightSubTree(bt)==NULL)
        return GetData(bt);

    op1 = EvaluateExpTree(bt->left);
    op2 = EvaluateExpTree(bt->right);

    switch(GetData(bt))
    {
        case '+':
            return op1+op2;
        case '-':
            return op1-op2;
        case '*':
            return op1*op2;
        case '/':
            return op1/op2;
    }

}


void ShowNodeData(int data)
{
    if(0<=data && data<=9)
        printf("%d ", data);
    else
        printf("%c ", data);
}

void ShowPrefixTypeExp(BTreeNode * bt)
{
    PreorderTraverse(bt, ShowNodeData);
}

void ShowInfixTypeExp(BTreeNode * bt)
{
    if(bt==NULL)
        return;
    if(bt->left!=NULL || bt->right !=NULL)
        printf(" ( ");

    ShowInfixTypeExp(bt->left);
    ShowNodeData(bt->data);
    ShowInfixTypeExp(bt->right);

    if(bt->left != NULL || bt->right !=NULL)
        printf(" ) ");
}

void ShowPostfixTypeExp(BTreeNode * bt)
{
    PostorderTraverse(bt, ShowNodeData);
}
