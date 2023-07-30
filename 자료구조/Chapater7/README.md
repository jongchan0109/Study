## Chapter7 큐(Queue)
  + 1 큐의 이해와 ADT 정의
    + 큐는 먼저 들어간 것이 먼저 나오는 선입선출(FIFO: First In First Out)구조이다.
      
### 큐 자료구조의 ADT
    void QueueInit(Queue* pq);
      - 큐의 초기화를 진행한다.
      - 큐 생성 후 제일 먼저 호출되어야 하는 함수이다.

    int QIsEmpty(Queue* pq);
      - 큐가 빈 경우 TRUE(1)을, 그렇지 않은 경우 FALSE(0)을 반환한다.
      
    void Enqueue(Queue* pq, Data data);
      - 큐에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
    
    Data Dequeue(Queue* pq);
      - 저장순서가 가장 앞선 데이터를 삭제한다.
      - 삭제된 데이터는 반환이 된다.
      - 본 함수의 호출을 위해서는 데이터가 하나 이상 존재함이 보장되어야 한다.
      
    Data QPeek(Queue* pq);
      - 저장순서가 가장 앞선 데이터를 반환하되 삭제하지 않는다.
      - 본 함수의 호출을 위해서는 데이터가 하나 이상 존재함이 보장되어야 한다.

+ 2,3 큐의 배열, 연결리스트 기반 구현

+ 4 큐의 활용
  + 시뮬레이션 프로그램 작성
 
+ 5 덱(Deque)의 이해와 구현
  + 덱의 이해와 ADT 정의

    ### 큐 자료구조의 ADT
        void DequeInit(Deque* pdeq);
          - 큐의 초기화를 진행한다.
          - 큐 생성 후 제일 먼저 호출되어야 하는 함수이다.
    
        int DQIsEmpty(Deque* pdeq);
          - 큐가 빈 경우 TRUE(1)을, 그렇지 않은 경우 FALSE(0)을 반환한다.

        void DQAddFirst(Deque* pdeq, Data data);
          - 덱의 머리에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.

        void DQAddLast(Deque* pdeq, Data data);
          - 덱의 꼬리에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.

        Data DQRemoveFirst(Deque* pdeq);
          - 덱의 머리에 위치한 데이터를 반환 및 소멸한다.

        Data DQRemoveLast(Deque* pdeq);
          - 덱의 꼬리에 위치한 데이터를 반환 및 소멸한다.

        Data DQGetFirst(Deque* pdeq);
          - 덱의 머리에 위치한 데이터를 소멸하지 않고 반환한다.

        Data DQGetLast(Deque* pdeq);
          - 덱의 꼬리에 위치한 데이터를 소멸하지 않고 반환한다.
    
    
+ Code
  + CircularQueue
    + CircularQueue.h
    + CircularQueue.c
    + CircularQueueMain.c

  + ListBaseQueue
    + ListBaseQueue.h
    + ListBaseQueue.c
    + ListBaseQueueMain.c

  + Deque
    + Deque.h
    + Deque.c
    + DequeMain.c
