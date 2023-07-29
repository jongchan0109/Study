## Chapter6 스택(Stack)
  + 1 스택의 이해와 ADT 정의
    + 스택은 나중에 들어간 것이 먼저 나오는 후입선출(LIFO: Last In First Out)구조이다.
      
### 스택 자료구조의 ADT
    void StackInit(Stack* *pstack);
      - 스택의 초기화를 진행한다.
      - 스택생성 후 제일 먼저 호출되어야 하는 함수이다.

    int SIsEmpty(Stack* pstack);
      - 스택이 빈 경우 TRUE(1)을, 그렇지 않은 경우 FALSE(0)을 반환한다.
      
    void SPush(Stack* pstack, Data data);
      - 스택에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
    
    Data SPop(Stack* pstack);
      - 마지막에 저장된 요소를 삭제한다.
      - 삭제된 데이터는 반환이 된다.
      - 본 함수의 호출을 위해서는 데이터가 하나 이상 존재함이 보장되어야 한다.
      
    Data SPeek(Stack* pstack);
      - 마지막에 저장된 요소를 반환하되 삭제하지 않는다.
      - 본 함수의 호출을 위해서는 데이터가 하나 이상 존재함이 보장되어야 한다.

+ 2,3 스택의 배열, 연결 리스트 기반 구현

      
+ Code
  + ArrayBaseStack 
    + ArrayBaseStack.h
    + ArrayBaseStack.c
    + ArrayBaseStackMain.c

  + ListBaseStack 
    + ListBaseStack.h
    + ListBaseStack.c
    + ListBaseStackMain.c

