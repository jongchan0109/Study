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
