# 11 컬렉션 프레임웍(collections framework)

## 1. 컬렉션 프레임웍(Collections Framework)
+ 컬렉션 프레임웍이란, '데이터 군을 저장하는 클래스들을 표준화한 설계'를 뜻한다. 컬렉션은 다수의 데이터, 즉 데이터 그룹을, 프레임웍은 표준화된 프로그래밍 방식을 의미한다.

+ 1.1 컬렉션 프레임웍의 핵심 인터페이스
  + 컬렉션 프레임웍에서는 컬렉션데이터 그룹을 크게 3가지 타입이 존재한다고 인식하고 각 컬렉션을 다루는데 필요한 기능을 가진 3개의 인터페이스를 정의하였다.
  + 그러고 인터페이스 List와 Set의 공통된 부분을 다시 뽑아서 새로운 인터페이스인 Collection을 추가로 정의하였다.
  + List: 순서가 있는 데이터의 집합, 데이터의 중복을 허용한다.
  + Set: 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다.
  + Map: 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합, 순서는 유지되지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용한다.
  + Collection 인터페이스
    |메소드|설명|
    |------|---|
    |boolean add(Object o)|지정된 객체(o)를 Collection에 추가한다.|
    |boolean add(Collection c)|지정된 Collection(c)의 객체들을 Collection에 추가한다.|
    |void clear()|Collection의 모든 객체를 삭제한다.|
    |boolean contains(Object o)|지정된 객체(o)가 Collection에 포함되어 있는지 확인한다.|
    |boolean contains(Collection c)|지정된 Collection(c)의 객체들이 Collection에 포함되어 있는지 확인한다.|
    |boolean equals(Object o)|동일한 Collection인지 비교한다.|
    |int hasCode()|Collection의 hash code를 반환한다.|
    |boolean isEmpty()|Collection이 비어있는지 확인한다.|
    |iterator iterator()|Collection의 iterator를 얻어서 반환한다.|
    |boolean remove(Object o)|지정된 객체를 삭제한다.|
    |boolean removeAll(Collection c)|지정된 Collection에 포함된 객체들을 삭제한다.|
    |boolean retainAll(Collection c)|지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제한다. 이 작업으로 인해 Collection에 변화가 있으면 true를 그렇지 않으면 false를 반환한다.|
    |int size()|Collection에 저장된 객체의 개수를 반환한다.|
    |Object[] toArray()|Collection에 저장된 객체를 객체배열(Object[])로 반환한다.|
    |Object[] toArray(Object[] a)|저ㅣ정된 배열에 Collection의 객체를 저장해서 반환한다.|
    
  + List 인터페이스
    |메소드|설명|
    |------|---|
    |void add(int index, Object element)<br>boolean addAll(int index,Collection c)|지정된 위치(index)에 객체(element)또는 컬렉션에 포함된 객체들을 추가한다.|
    |Object get(int index)|지정된 위치(index)에 있는 객체를 반환한다.|
    |int indexOf(Object o)|지정된 객체의 위치(index)를 반환한다.(List의 첫 번째 요소부터 순방향으로 찾는다.)|
    |int lastIndexOf(Object o)|지정된 객체의 위치(index)를 반환한다.(List의 마지막 요소부터 역방향으로 찾는다.)|
    |ListIterator listIterator()<br>ListIterator listIterator(int index)|List의 객체에 접근할 수 있는 ListIterator를 반환한다.|
    |Object remove(int index)|지정된 위치(index)에 있는 객체를 삭제하고 삭제된 객체를 반환한다.|
    |Object set(int index, Object element)|지정된 위치(index)에 객체(element)를 저장한다.|
    |void sort(Comparator c)|지정된 비교자(comparator)로 List를 정렬한다.|
    |List subList(int fromIndex, int toIndex)|지정된 범위(fromIndex부터 toIndex)에 있는 객체를 반환한다.|

  + Map인터페이스
    |메소드|설명|
    |------|---|
    |void clear()|Map의 모든 객체를 삭제한다.|
    |boolean containsKey(Object key)|지정된 key객체와 일치하는 Map의 key객체가 있는지 확인한다.|
    |boolean containsValue(Object value)|지정된 value객체와 일치하는 Map의 value객체가 있는지 확인한다.|
    |Set entrySet()|Map에 저장되어 있는 key-value쌍을 Map.entry타입의 객체로 저장한 Set으로 반환한다.|
    |boolean equals(Object o)|동일한 Map인지 확인한다.|
    |int hashCode()|해시코드를 반환한다.|
    |boolean isEmpty()|Map이 비어있는지 확인한다.|
    |Set keySet()|Map에 저장된 모든 key객체를 반환한다.|
    |Object put(Object key, Object value)|Map에 value객체를 key객체에 연결(mapping)하여 저장한다.|
    |void putAll(Map t)|지정된 Map의 모든 key-value쌍을 추가한다.|
    |Object remove(Object key)|지정한 key객체와 일치하는 key-value객체를 삭제한다.|
    |int size()|Map에 저장된 key-value쌍의 개수를 반환한다.|
    |Collection values()|Map에 저장된 모든 value객체를 반환한다.|

  + Map.Entry인터페이스
    + Map.Entry인터페이스는 Map인터페이스의 내부 인터페이스로, Map에 저장되는 key-value쌍을 다루기 위해 내부적으로 Entry인터페이스를 정의해 놓았다.
    
    |메소드|설명|
    |------|---|
    |boolean equals()|동일한 Entry인지 비교한다.|
    |Object getKey()|Entry의 key객체를 반환한다.|
    |Object getValue()|Entry의 value객체를 반환한다.|
    |int hashCode()|Entry의 해시코드를 반환한다.|
    |Object setValue(Object value)|Entry의 value객체를 지정된 객체로 바꾼다.|

+ 1.2 ArrayList
  + ArrayList는 컬렉션 프레임웍에서 가장 많이 사용되는 컬렉션 클래소로, List인터페이스를 구현하기 때문에 데이터의 저장순서가 유지되고 중복을 허용한다.
  + ArrayList를 생성할 때, 저장할 요소의 개수를 고려해서 실제 저장할 개수보다 약간 여유있는 크기로 하는 것이 좋다. 생성할 때 지정한 크기보다 더 많은 객체롤 저장하면 자동적으로 크기가 늘어나기는 하지만 이 과정에서 처리시간이 많이 소요되기 때문이다.
  + ArrayList나 Vector같이 배열을 이용한 자료구조는 데이터를 읽어오고 저장하는 데는 효율이 좋지만, 용량을 변경해야할 때는 새로운 배열을 생성한 후 기존의 배열로부터 새로 생성된 배열로 데이터를 복사해야하기 때문에 상당히 효율이 떨어진다는 단점을 가지고 있다.

+ 1.3 LinkedList
  + 배열은 가장 기본적인 형태의 자료구조로 구조가 간단하며 사용하기 쉽고 데이터를 읽어 오는데 걸리는 시간이 빠르다는 장점을 가지고 있지만, 크기를 변경할 수 없고, 비순차적인 데이터의 추가 또는 삭제에 시간이 많이 걸린다는 단점도 있다.
  + 이러한 배열의 단점을 보완하기 위해서 링크드 리스트(linked list)라는 자료구조가 고안되었다.
  + 배열은 모든 데이터가 연속적으로 존재하지만 링크드 리스트는 불연속적으로 존재하는 데이터를 서로 연결한 형태로 구성되어 있다.
  + 링크드 리스트에서 데이터 삭제는 삭제하고자 하는 요소의 이전 요소가 삭제하고자 하는 요소의 다음 요소를 참조하도록 변경하기만 하면 된다.
  + 새로운 데이터를 추가할 때는 새로운 요소를 생성한 다음 추가하고자 하는 위치의 이전 요소의 참조를 새로운 요소에 대한 참조로 변경해주고, 새로운 요소가 그 다음 요소를 참조하도록 변경하기만 하면 되므로 처리속도가 매우 빠르다.
  + 링크드 리스트는 이동방향이 단방향이기 때문에 다음 요소에 대한 접근은 쉽지만 이전 요소에 대한 접근은 어렵다. 이 점을 보완한 것이 더블 링크드 리스트(double linked list)이다.
  + 더블 링크드 리스트는 단순히 링크드 리스트에 참조변수를 하나 더 추가하여 다음 요소에 대한 참조뿐 아니라 이전 요소에 대한 참조가 가능하도록 했을 뿐, 그 외에는 링크드 리스트와 같다.
  + 실제로 LinkedList클래스는 이름과 달리 더블 링크드 리스트로 구현되어 있다.

+ 1.4 Stack과 Queue
  + 스택은 마지막에 저장한 데이터를 가장 먼저 꺼내게 되는 LIFO(Last In First Out)구조로 되어 있고, 큐는 처음에 저장한 데이터를 가장 먼저 꺼내게 되는 FIFO(First In First Out)구조로 되어 있다.
  + 순차적으로 데이터를 추가하고 삭제하는 스택에는 ArrayList와 같은 배열기반의 컬렉션 클래스가 적합하고, 항상 첫 번째 저장된 데이터를 삭제하는 Queue는 LinkedList로 구현하는 것이 더 적합하다.
  + 스택의 활용 예 - 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로
  + 큐의 활용 예 - 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)
  + PriorityQueue
    +Queue인터페이스의 구현체 중의 하나로, 저장한 순서에 관계없이 우선순위가 높은 것부터 꺼내게 된다는 특징이 있다.
  + Deque
    + Queue의 변형으로, 한 쪽 끝으로만 추가/삭제할 수 있는 Queue와 같이 Deque은 양쪽 끝에 추가/삭제가 가능하다.
   
+ 1.5 Iterator, ListIterator, Enumeration
  + Iterator, ListIterator, Enumeration은 모두 컬렉션에 저장된 요소를 접근하는데 사용되는 인터페이스이다. Enumeration은 Iterator의 구버전이며, ListIterator는 Iterator의 기능을 향상 시킨 것이다.
  + 컬렉션 프레임웍에서는 컬렉션에 저장되 요소들을 읽어오는 방법을 표준화하였다. 컬렉션에 저장된 각 요소에 접근하는 기능을 가진 Iterator인터페이스를 정의하고, Collection인터페이스에는 Iterator(Iterator를 구현한 클래스의 인스턴스)를 반환하는 iterator()를 정의하고 있다.
  + 컬렉션 클래스에 대해 iterator()를 호출하여 Iterator를 얻은 다음 반복문, 주로 while문을 사용해서 컬렉션 클래스의 요소들을 읽어 올 수 있다.
  + Map인터페이스를 구현한 컬렉션 클래스는 키와 값을 쌍으로 저장하고 있기 때문에 iterator()를 직접 호출할 수 없고, 그 대신 keySet()이나 entrySet()과 같은 메소드를 통해서 키와 값을 각각 따로 Set의 형태로 얻어 온 후에 다시 iterator()를 호출해야 Iterator를 얻을 수 있다.
  + ListIterator는 Iterator를 상속받아서 기능을 추가한 것으로, 컬렉션의 요소에 접근할 때 Iterator는 단방향으로만 이동할 수 있는 데 반해 ListIterator는 양방향으로의 이동이 가능하다. 단, List인터페이스를 구현한 컬렉션에서만 사용할 수 있다.

+ 1.6 Arrays
  + Arrays클래스에는 배열을 다루는데 유용한 메소드가 정의되어 있다.
  + 배열의 복사 - copyOf(), copyOfRange(): copyOf()는 배열 전체를, copyOfRange()는 배열의 일부를 복사해서 새로운 배열을 만들어 반환한다.
  + 배열 채우기  - fill(), setAll(): fill()은 배열의 모든 요소를 지정된 값으로 채운다. setAll()은 배열을 채우는데 사용할 함수형 인터페이스를 매개변수로 받는다.
  + 배열의 정렬과 검색 - sort(), binarySearch(): sort()는 배열을 정렬할 때, 그래고 배열에 저장된 요소를 검색할 때는 binarySearch()를 사용한다.
  + 배열을 List로 변환 - asList(Object... a): asList()는 배열을 List에 담아서 반환한다. asList()가 반환한 List의 크기를 변경할 수 없다.
 
+ 1.7 Comparator와 Comparable
  + Comparator와 Comparable은 모두 인터페이스로 컬렉션을 정렬하는데 필요한 메소드를 정의하고 있다.
  + Comparable: 기본 정렬기준을 구현하는데 사옹.
  + Comparator: 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용

+ 1.8 HashSet
  + HashSet은 Set인터페이스를 구현한 가장 대표적인 컬렉션이며, Set인터페이스의 특징대로 HashSet은 중복된 요소를 저장하지 않는다.
  + HashSet에 새로윤 요소를 추가할 때는 add메소드나 addAll메소드를 사용하는데, 만일 HashSet에 이미 저장되어 있는 요소와 중복된 요소를 추가하고자 한다면 이 메소드들은 false를 반환함으로써 중복된 요소이기 때문에 추가에 실패했다는 것을 알린다.
  + Set을 구현한 컬렉션 클래스는 List를 구현한 컬렉션 클래스와 달리 순서를 유지하지 않기 때문에 저장한 순서와 다를 수 있다.
  + 만일 중복을 제거하는 동시에 저장한 순서를 유지하고자 한다면 HashSet 대신 LinkedHashSet을 사용해야 한다.
  + HashSet의 add메소드는 새로윤 요소를 추가하기 전에 기존에 저장된 요소와 같은 것인지 판별하기 위해 추가하려는 요소의 equals()와 hashCode()를 호출하기 때문에 equals()와 hashCode()를 목적에 맞게 오버라이딩해야 한다.
  + 오버라이딩을 통해 작성된 HashCode()는 다음의 세 가지 조건을 만족 시켜야 한다.
    1. 실행 중인 애플리케이션 내의 동일한 객체에 대해서 여러번 hashCode()를 호출해도 동일한 int값을 반환해야 한다. 하지만, 실행시마다 동일한 int값을 반환할 필요는 없다.
    2. equals메소드를 이용한 비교에 의해서 true를 얻은 두 객체에 대해 각각 hashCode()를 호출해서 얻은 결과는 반드시 같아야 한다.
    3. equals메소드를 호출했을 때 false를 반환하는 두 객체는 hashCode() 호출에 대해 같은 int값을 반환하는 경우가 있어도 괜찮지만, 해싱(hashing)을 사용하는 컬렉션의 성능을 향상시키기 위해서는 다른 int값을 반환하는 것이 좋다.
   
+ 1.9 TreeSet
  + TreeSet은 이진 검색 트리라는 자료구조의 형태로 데이터를 저장하는 컬렉션 클래스이다.
  + Set인터페이스를 구현했으므로 중복된 데이터의 저장을 허용하지 않으며, 정렬된 위치에 저장하므로 저장순서를 유지하지도 않는다.
  + TreeSet에 저장되는 객체가 Comparable을 구현하던가 아니면, TreeSet에게 Comparator를 제공해서 두 객체를 비교할 방법을 알려줘야 한다.
  + 이진 검색 트리(Binary Search Tree)
    1. 모든 노드는 최대 두개의 자식노드를 가질 수 있다.
    2. 왼쪽 자식노드의 값은 부모노드의 값보다 작고 오른쪽 자식노드의 값은 부모노드의 값보다 커야한다.
    3. 노드의 추가 삭제에 시간이 걸린다.(순차적으로 저장하지 않으므로)
    4. 검색(범위검색)과 정렬에 유리하다.
    5. 중복된 값을 저장하지 못한다.

+ 1.10 HashMap과 Hashtable
  + HashMap은 Hashtable의 새로운 버전이다.
  + HashMap은 Map을 구현했으므로 Map의 특징, 키와 값을 묶어서 하나의 데이터로 저장한다는 특징을 갖는다. 그리고 해싱을 사용하기 때문에 많은 양의 데이터를 검색하는데 있어서 뒤어난 성능을 보인다.
  + hashMap은 키와 값을 각각 Object타입으로 저장한다. 그렇지만 키는 주로 String을 대문자 또는 소문자로 통일해서 사용하곤 한다.
  + 키는 저장된 값을 찾는데 사용되는 것이기 때문에 컬랙션 내에서 유일해야 한다.
  + 해싱과 해시함수
    + 해싱이란 해시함수(hash function)를 이용해서 데이터를 해시테이블에 저장하고 검색하는 기법을 말한다.
    + 해시함수는 데이터가 저장되어 있는 곳을 알려 주기 때문에 다량의 데이터 중에서도 원하는 데이터를 빠르게 찾을 수 있다.
    + 해싱을 구현하는 과정에서 제일 중요한 것은 해시함수의 알고리즘이다.
    + 실제로는 HashMap과 같이 해싱을 구현한 컬렉션 클래스에서는 Object클래스에 정의된 hashCode()를 해시함수로 사용한다.
    + Object클래스에 정의된 hashCode()는 객체의 주소를 이용하는 알고리즘으로 해시코드를 만들어 내기 때문에 모든 객체에 대해 hashCode()를 호출한 결과가 서로 유일한 훌륭한 방법이다.

+ 1.11 TreeMap
  + TreeMap은 이진검색트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장한다. 그래서 검색과 정렬에 적합한 컬렉션 클래스이다.
  + 검색에 관한 대부분의 경우에서 HashMap이 TreeMap보다 더 뛰어나므로 HashMap을 사용하는 것이 좋다. 다만 범위검색이나 정렬이 필요한 경우에는 TreeMap이 더 좋다.

+ 1.12 Properties
  + Properties는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것으로, Hashtable은 키와 값을 (Object,Object)의 형태로 저장하는데 비해 Properties는 (String, String)의 형태로 저장하는 보다 단순화된 컬렉션클래스이다.
  + 주로 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다.

+ 1.13 Collections
  + Arrays가 배열과 관련된 메소드를 제공하는 것처럼, Collections는 컬렉션과 관련된 메소드를 제공한다.
  + 멀티 쓰레드는 프로그래밍에서는 하나의 객체를 여러 쓰레드가 동시에 접근할 수 있기 때문에 데이터의 일관성을 유지하기 위해서는 공유되는 객체에 동기화가 필요하다.
  + ArrayList와 HashMap과 같은 컬렉션은 동기화를 자체적으로 처리하지 않고 필요한 경우에만 java.util.Collections클래스의 동기화 메소드를 이용해서 동기화처리가 가능하도록 변경하였다.
  + 컬렉션에 저장된 데이터를 보호하기 위해서 컬렉션을 변경할 수 없게, 즉 읽기전용으로 만들수 있는 기능을 제공한다.
  + 단 하나의 객체만을 저장하는 컬렉션을 만들고 싶을 때 singleton메소드를 이용하여 만들 수 있다.
  + 한 종류의 객체만 저장하는 컬렉션을 만들 수 있다.
    
