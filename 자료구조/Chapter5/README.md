## Chapter5 연결 리스트3

+ 5.1 원형 연결 리스트(Circular Linked List)
  + Chapter4에서 구현한 연결 리스트의 마지막 노드는 NULL을 가르켰는데, 이 마지막 노드가 첫 번째 노드를 가르키게 하면 '원형 연결 리스트'가 된다.
  + 일반 연결 리스트와 달리 원형 연결 리스트는 Lnext 함수가 무한 반복 호출이 가능하며, 리스트의 끝에 도달할 경우 첫 번째 노드부터 다시 조회가 시작된다.

+ Code
  + CLinkedList
    + CLinkedList.h
    + CLinkedList.c
    + CLinkedListMain.c
  
  + DLinkedListSort 
    + DLinkedList.h
    + DLinkedList.c
    + DLinkedListSortMain.c
