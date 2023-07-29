## Chapter3 연결리스트(Linked List)1
  + 03-1 추상 자료형(Abstract Data Type)
    
          + 구체적인 기능의 완성과정을 언급하지 않고, 순수하게 기능이 무엇인지를 나열한 것을 가리켜 '추상 자료형' 또는 간단히 ADT라고 한다.
  + 03-2 배열을 이용한 리스트의 구현
    + 리스트라는 자료구조는 구현 방법에 따라 순차 리스트와 연결 리스트로 나뉜다.

### 리스트 자료구조의 ADT
    + void ListInit(List *plist);
      - 초기화할 리스트의 주소값을 인자로 전달한다.
      - 리스트 생성 후 제일 먼저 호출되어야 하는 함수이다.
    + void LInsert(List *plist, LData data);
      - 리스트에 데이터를 저장한다. 매개변수 data에 전달된 값을 저장한다.
    + int LFirst(List *plist, LData *pdata);
      - 첫 번째 데이터가 pdata가 가리키는 메모리에 저장된다.
      - 데이터의 참조를 위한 초기화가 진행된다.
      - 참조 성공시 TRUE(1), 실패 시 FALSE(0) 반환
    + int LNext(List *plist, LData *pdata);
      - 참조된 데이터의 다음 데이터가 pdata가 가리키는 메모리에 저장된다.
      - 순차적인 참조를 위해서 반복 호출이 가능하다.
      - 참조를 새로 시작하려면 먼저 LFirst 함수를 호출해야 한다.
      - 참조 성공 시 TRUE(1), 실패 시 FALSE(0) 반환
    + int LRemove(List *plist);
      - LFirst 또는 LNext 함수의 마지막 반환 데이터를 삭제한다.
      - 삭제된 데이터는 반환된다.
      - 마지막 반환 데이터를 삭제하므로 연이은 반복 호출을 허용하지 않는다.
    + int LCount(List *plist);
      - 리스트에 저장되어 있는 데이터의 수를 반환한다.
      
+ Code
  + ArrayList 
    + ArrayList.h
    + ArrayList.c
    + ListMain.c
