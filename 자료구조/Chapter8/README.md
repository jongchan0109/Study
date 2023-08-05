## Chapter8 트리(Tree)
### 1. 트리의 개요
  + 트리는 계층적 관계를 표현하는 자료구조이다.
  + 트리 관련 용어
    + 노드(node): 트리의 구성요소
    + 간선(edge): 노드와 느도를 연결하는 연결선
    + 루트 노드(root node): 트리 구조에서 최상위에 존재하는 노드
    + 단말 노드(terminal node): 아래로 또 다른 노드가 연결되어 있지 않은 노드
    + 내부 노드(internal node): 단말 노드를 제외한 모든 노드
    + 부모(parent), 자식(child), 형제(sibling)
    + 레벨(level): 각 층별로 숫자를 매겨서 트리의 레벨이라 함
    + 높이(height): 트리의 최고 레벨
  + 이진 트리(Binary Tree)
    + 루트 노드를 중심으로 두 개의 서브 트리로 나뉘어짐
    + 나뉘어진 두 트리도 모두 이진 트리어야 함
  + 포화 이진 트리(Full Binary Tree)
    + 모든 레벨이 꽉 찬 이진 트리
  + 완전 이진 트리(complete binary tree)
    + 노드가 위에서 아래로, 왼쪽에서 오른쪽의 순서대로 채워져있는 트리
  
### 2.이진 트리의 구현  
### 이진 트리 자료구조의 ADT
    BTreeNode* MakeBTreeNode(void);
      - 이진 트리 노드를 생성하여 그 주소 값을 반환한다.

    BTData GetData(BTreeNode* bt);
      - 노드에 저장된 데이터를 반환한다.

    void setData(BTreeNode* bt, BTData data);
      - 노드에 데이터를 저장한다. data로 전달된 값을 저장한다.

    BTreeNode* GetLeftSubTree(BTreeNode* bt);
      - 왼쪽 서브 트리의 주소 값을 반환한다.

    BTreeNode* GetRightSubTree(BTreeNode* bt);
      - 오른쪽 서브 트리의 주소 값을 반환한다.

    void MakeLeftSubTree(BTreeNode* main, BTreeNode* sub);
      - 왼쪽 서브 트리를 연결한다.

    void MakeRightSubTree(BTreeNode* main, BTreeNode* sub);
      - 오른쪽 서브 트리를 연결한다.


    
+ Code
  + BinaryTree
    + BinaryTree.h
    + BinaryTree.c
    + BinaryTreeMain.c

  + ListBaseQueue
    + ListBaseQueue.h
    + ListBaseQueue.c
    + ListBaseQueueMain.c

  + Deque
    + Deque.h
    + Deque.c
    + DequeMain.c
