## Chapter5 연결 리스트3

+ 5.1 원형 연결 리스트(Circular Linked List)
  + Chapter4에서 구현한 연결 리스트의 마지막 노드는 NULL을 가르켰는데, 이 마지막 노드가 첫 번째 노드를 가르키게 하면 '원형 연결 리스트'가 된다.
  + 일반 연결 리스트와 달리 원형 연결 리스트는 Lnext 함수가 무한 반복 호출이 가능하며, 리스트의 끝에 도달할 경우 첫 번째 노드부터 다시 조회가 시작된다.
 
+ 5.2 양방향 연결 리스트(Doubly Linked List)
  + 양방향 연결 리스트 또는 이중 연결 리스트라고 불리는 자료구조는 이름이 의미하듯이 노드가 양쪽 방향으로 연결된 구조의 리스트이다.
  + 양쪽 방향으로 이동할 수 있기 때문에 단방향 연결 리스트에서는 어렵게 구현했던 것이 쉽게 구현되기도 한다.

  
+ Code
  + CLinkedList
    + CLinkedList.h
    + CLinkedList.c
    + CLinkedListMain.c
  
  + DBLinkedList 
    + DBLinkedList.h
    + DBLinkedList.c
    + DBLinkedListMain.c
