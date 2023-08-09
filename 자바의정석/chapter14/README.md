# 14 람다와 스트림

## 1. 람다식(Lambda expression)

+ 1.1 람다식이란?
  + 람다식은 메소드를 하나의 '식(expression)'으로 표현한 것이다.
  + 람다식은 함수를 간략하면서도 명확한 식으로 표현할 수 있게 한다.
  + 메소드를 람다식으로 표현하면 메소드의 이름과 반환값이 없어지므로, 람다식을 '익명 함수(anonymous function)'이라고도 한다.

+ 1.2 람다식 작성하기
  + 람다식은 '익명 함수'답게 메소드에서 이름과 반환타입을 제거하고 매개변수 선언부와 몸통{} 사이에 '->'를 추가한다.
  ```
  반환타입 메소드이름(매개변수 선언) {
    문장들
  }

  (매개변수 선언) -> {
    문장들
  }
  ```
  + 반환값이 있는 메소드의 경우, return문 대신 식으로 대신 할 수 있다. 식의 연산결과가 자동적으로 반환값이 된다. 문장이 아닌 식이므로 끝에 ';'를 붙이지 않는다.
  ```
  int max(int a,int b){
    return a>b? a:b;
  }

  (int a,int b) -> a>b? a:b
  ```
  + 람다식에 선언된 매개변수의 타입은 추론이 가능한 경우는 생략할 수 있는데, 대부분의 경우에 생략가능하다.
  ```
  (a,b) -> a > b ? a : b
  ```
  + 선언된 매개변수가 하나뿐인 경우에는 괄호()를 생략할 수 있다. 단, 매개변수의 타입이 있으면 괄호()를 생략할 수 없다.
  ```
  a -> a * a
  ```
  + 마찬가지로 괄호{} 안의 문장이 하나일 때는 괄호{}를 생략할 수 있다.
  ```
  (String name, int i) ->
    System.out.println(name+"="+i)
  ```
  + 그러나 괄호{} 안의 문장이 return문일 경우 괄호{}를 생략할 수 없다.
 

+ 1.3 함수형 인터페이스(Functional Interface)
  + 자바에서 모든 메소드는 클래스 내에 포함되어야 하는데, 람다식은 익명 클래스의 객체와 동등하다.
  ```
  타입 f = (int a,int b) -> a > b ? a : b // 참조변수 f의 타입은??
  ```
  + 참조변수 f의 타입은 클래스 또는 인터페이스가 가능하다. 그리고 람다식과 동등한 메소드가 정의되어 있는 것이어야 한다.
  + 예를 들어 max()라는 메소드가 정의된 MyFunction인터페이스가 정의되어 있다고 가정하자.
  ```
  interface MyFunction{
    public abstract int max(int a,int b);
  }

  Myfunction f = (int a,int b) -> a > b ? a : b;
  int big = f.max(5,3) // 익명 객체의 메소드를 호출
  ```
  + 이처럼 인터페이스를 구현한 익명 객체를 람다식으로 대체가 가능한 이유는, 람다식도 익명 객체이고, 인터페이스를 구현한 익명 객체의 메소드와 람다식의 매개변수의 타입과 개수 그리고 반환값이 일치하기 때문이다.
  + 람다식을 다루기 위한 인터페이스를 함수형 인터페이스라고 한다. 함수형 인터페이스에는 오직 하나의 추상 메소드만 정의되어 있어야 한다.
  + 메소드의 매개변수가 MyFunction타입이면, 이 메소드를 호출할 때 람다식을 참조하는 참조변수를 매개변수로 지정해야한다는 뜻이다. 또는 참조변수 없이 람다식을 매개변수로 지정하는 것도 가능하다.
  + 함수형 인터페이스로 람다식을 참조할 수 있는 것일 뿐, 람다식의 타입이 함수형 인터페이스의 타입과 일치하는 것은 아니다. 람다식은 익명 객체이고 익명 객체는 타입이 없다.
  + 그래서 대입 연산자의 양변의 타입을 일치시키기 위해 형변환이 필요하다. (생략 가능)
  + 람다식은 이름이 없을 뿐, 객체인데도 Object타입으로 형변환 할 수 없고, 함수형 인터페이스로만 형변환 가능하다.
  + 굳이 Object타입으로 형변환하려면, 먼저 함수형 인터페이스로 변환해야 한다.

+ 1.4 java.util.function 패키지
  + 대부분의 메소드는 타입이 비슷하기 때문에, java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메소드를 함수형 인터페이스로 미리 정의해 놓았다.
  
  |함수형 인터페이스|메소드|설명|
  |---|--------|-----|
  |java.lang.Runnable|void run()|매개변수도 없고, 반환값도 없음.|
  |Supplier<T>|T get()|매개변수는 없고, 반환값만 있음|
  |Consumer<T>|void accept(T t)|매개변수만 있고, 반환값이 없음|
  |Function<T,R>|R apply(T t)|일반적인 함수, 하나의 매개변수를 받아서 결과를 반환|
  |Predicate<T>|boolean test(T t)|조건식을 표현하는데 사용됨.<br>매개변수는 하나, 반환 타입은 boolean|

  + 매개변수가 두 개인 함수형 인터페이스는 이름 앞에 접두사 'Bi'가 붙는다.

  |함수형 인터페이스|메소드|설명|
  |---|--------|-----|
  |BiConsumer<T,U>|void accept(T t,U u)|두개의 매개변수만 있고, 반환값이 없음|
  |BiFunction<T,U,R>|R apply(T t,U u)|두 개의 매개변수를 받아서 하나의 결과를 반환|
  |BiPredicate<T,U>|boolean test(T t,U u)|조건식을 표현하는데 사용됨.<br>매개변수는 둘, 반환 타입은 boolean|

  + 두 개 이상의 매개변수를 갖는 함수형 인터페이스가 필요하다면 직접 만들어서 써야한다.
  + Function의 또 다른 변형으로 UnaryOperator와 BinaryOperator가 있는데, 매개변수의 타입과 반환타입이 일치한다는 점만 제외하고는 Function과 같다.

  |함수형 인터페이스|메소드|설명|
  |---|--------|-----|
  |UnaryOperator<T>|T apply(T t)|Function의 자손, Function과 달리 매개변수와 결과의 타입이 같다.
  |BinaryOperator<T>|T apply(T t,T t)|BiFunction|의 자손, BiFunction과 달리 매개변수와 결과의 타입이 같다.|

  + 컬렉션 프레임웍의 인터페이스에 다수의 디폴트 메소드가 추가되었는데, 그 중의 일부는 함수형 인터페이스를 사용한다.
 
  |인터페이스|메소드|설명|
  |---|--------|-----|
  |Collection|boolean removeIf(Predicate<E> filter)|조건에 맞는 요소를 삭제|
  |List|void repalceAll(UnaryOperator<E> operator)|모든 요소를 변환하여 대체|
  |Iterable|void forEach(Consumer<T> action)|모든 요소에 작업 action을 수행|
  |Map|V compute(K key, BiFunction<K,V,V> f)|지정된 키의 값에 작업 f를 수행|
  |Map|V computeIfAbsent(K key, Function<K,V> f)|키가 없으면, 작업 f 수행 후 추가|
  |Map|V computeIfPresent(K key, BiFunction<K,V,V> f)|지정된 키가 있을 때, 작업 f수행|
  |Map|V merge(K key, V value, BiFunction<V,V,V> f)|모든 요소에 병합작업 f를 수행|
  |Map|void forEach(BiConsumer<K,V> action)|모든 요소에 작업 action을 수행|
  |Map|void repalceAll(BiFunction<K,V,V> f)|모든 요소에 치환작업 f를 수행|
  
  + 지금까지 소개한 함수형 인터페이스는 매개변수와 반환값의 타입이 모두 지네릭 타입이엇는데, 기본형 대신 래퍼클래스를 사용하는 것은 비효율적이다.
  + 그래서 보다 효율적으로 처리할 수 있도록 기본형을 사용하는 함수형 인터페이스들이 제공된다.
 
  |함수형 인터페이스|메소드|설명|
  |---|--------|-----|
  |DoubleToIntFunction|int applyAsInt(double d)|AToBFunction은 입력이 A타입 출력이 B타입|
  |ToIntFunction<T>|int applyAsInt(T t)|ToBFunction은 출력이 B타입이고 입력은 지네릭 타입|
  |IntFunction<R>|R apply(T t,U u)|AFunction은 입력이 A타입이고, 출력은 지네릭 타입|
  |ObjIntConsumer<T>|void accept(T t,U u)|ObjAFunction은 입력이 T,A타입이고, 출력은 없다.|

+ 1.5 Function의 합성과 Predicate의 결합
  + 두 람다식을 합성해서 새로운 람다식을 만들 수 있다.
  + 함수 f,g가 있을 때 f.andThen(g)는 함수 f를 먼저 적용하고, 그다음에 함수 g를 적용한다.
  + f.compose(g)는 반대로 g를 먼저 적용하고 f를 적용한다.
  ```
  Function<String,Integer> f = (s) -> Integer.toBinaryString(i);
  Function<Integer,String> g = (i) -> Integer.toBinaryString(i);
  Function<String,String> h = f.andThen(g);
  ```
  + 문자열을 숫자로 변환하는 함수 f와 숫자를 2진 문자열로 변환하는 함수 g를 합성하여 새로운 함수 h를 만들어낼 수 있다.
  + idntity()는 함수를 적용하기 이전과 이후가 동일한 '항등 함수'가 필요할 때 사용한다.
  + 여러 조건식을 논리 연산지로 연결해서 하나의 식을 구성할 수 있는 것처럼, 여러 Predicate를 and(), or(), negate()로 연결해서 하나의 새로운 Predicate로 결합할 수 있다.
  ```
  Predicate<Integer> p = i -> i < 100;
  Predicate<Integer> q = i -> i < 200;
  Predicate<Integer> r = i -> i % 2 == 0;
  Predicate<Integer> notP = p.negate(); // i >= 100
  Predicate<Integer> all = notP.and(q.or(r)); // 100 <= i && (i < 200 || i % 2 ==0)
  ```
  + static메소드인 isEqual()은 두 대상을 비교하는 Predicate를 만들 때 사용한다.

+ 1.6 메소드 참조
  + 람다식이 하나의 메소드만 호출하는 경우에는 '메소드 참조(method reference)'라는 방법으로 람다식을 간략히 할 수 있다.
  ```
  Function<String,String> f = (String s) -> Integer.parseInt(s);
  Function<String,String> f = Integer::parseInt;
  ```
  + 1개의 String을 받아서 String을 반환하는 parseInt라는 이름의 메소드는 다른 클래스에도 존재할 수 있기 때문에 parseInt 앞에 클래스 이름은 반드시 필요하다.
  + 이미 생성된 객체의 메소드를 람다식에서 사용한 경우에는 클래스 이름 대신 그 객체의 참조변수를 적어줘야 한다.
  + 생성자를 호출하는 람다식도 메소드 참조로 변환할 수 있다.
 

## 2.스트림(stream)

+ 2.1 스트림이란?
  + 스트림은 데이터 소스를 추상화하고, 데이터를 다루는데 자주 사용되는 메소드를 정의해 놓았다.
  + 데이터 소스를 추상화하였다는 것은, 데이터 소스가 무엇이던 간에 같은 밥ㅇ식으로 다룰 수 있게 되었다는 것과 코드의 재사용성이 높아진다는 것을 의미한다.
  + 스트림은 데이터 소스로 부터 데이터를 읽기만할 뿐, 데이터 소스를 변경하지 않는다는 차이가 있다.
  + 스트림은 Iterator처럼 일회용이다.
  + 스트림이 제공하는 연산은 중간 연산과 최종 연산으로 분류할 수 있는데, 중간 연산은 연산결과를 스트림으로 반환하기 때문에 중간 연산을 연속해서 연결할 수 있다.
  + 최종 연산은 스트림의 요소를 소모하면서 연산을 수행하므로 단 한번만 연산이 가능하다.
  + 스트림 연산에서 중요한 점은 최종 연산이 수행되기 전까지는 중간 연산이 수행되지 않는다.
  + 요소의 타입이 T인 스트림은 기본적으로 Stream<T>이지만, 오토박싱&언박싱으로 인한 비효율을 줄이기 위해 데이터 소스의 요소를 기본형으로 다루는 스트림, IntStraem, LongStream, DoubleStream이 제공된다.

+ 2.2 스트림 만들기
  + 스트림의 소스가 될 수 잇는 대상은 배열, 컬렉션, 임의의 수 등 다양하다.
  + 컬렉션의 최고 조상인 Collection에 stream()이 정의되어 있다. 그래서 Collection의 자손인 List와 Set을 구현한 컬렉션 클래스들은 모두 이 메소드로 스트림을 생성할 수 있다.
  + forEach()는 지정된 작업을 스트림의 모든 요소에 대해 수행한다.
  + forEach()가 스트림의 모든 요소를 소모하면서 작업을 수행하므로 같은 스트림에 forEach()를 두 번 호출할 수 없다.
  + 배열을 소스로 하는 스트림을 생성하는 메소드는 Stream과 Arrays에 static메소드로 정의되어 있다.
  ```
  Stream<T> Stream.of(T... values) // 가변 인자
  Stream<T> Strema.of(T[])
  Stream<T> Arrays.stream(T[])
  Stream<T> Arrays.stream(T[], int startInculsive, int endExclusive)
  ```
  + int, long, double과 같은 기본형 배열을 소스로 하는 스트림을 생성하는 메소드도 있다.
  + IntStream과 LongStraem은 다음과 같이 지정된 범위의 연속된 정수를 스트림으로 생성해서 반환하는 range()와 rangeClosed()를 가지고 있다.
  ```
  IntStream IntStream.range(int begin, int end) // end 미포함
  IntStream IntStream.rangeClosed(int begin, int end) // end도 포함
  ```
  + 난수를 생성하는데 사용하는 Random클래스에는 아래와 같은 인스턴스 메소드들이 포함되어 있고, 이 메소드들은 해당 타입의 난수들로 이루어진 스트림을 반환한다.
  ```
  IntStream ints()
  LongStreram longs()
  DoubleStream doubles()
  ```
  + 이 메소드들이 반환하는 스트림은 크기가 정해지지 않은 '무한 스트림'이므로 limit()도 같이 사용해서 스트림의 크기를 제한해 주어야 한다.
  + 매개변수로 스트림의 크기를 지정해서 '유한 스트림'을 생성할 수도 있다.
  + Stream클래스의 iterate()와 generate()는 람다식을 매개변수로 받아서, 이 람다식에 의해 계산되는 값들을 요소로 하는 무한 스트림을 생성한다.
  ```
  static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
  static <T> Stream<T> generate(Supplier<T> s)
  ```
  + iterate()는 씨앗값(seed)으로 지정된 값부터 시작해서, 람다식 f에 의해 계산된 결과를 다시 seed값으로 해서 계산을 반복한다.
  + generate()도 iterate()처럼, 람다식에 의해 계산되는 값을 요소로 하는 무한 스트림을 생성해서 반환하지만, iterate()와 달리, 이전 결과를 이용해서 다음 요소를 계산하지 않는다.
  + Stream의 static메소드인 concat()을 사용하면, 두 스트림을 하나로 연결할 수 있다.

+ 2.3 스트림의 중간연산
  + 스트림 자르기 - skip(), limit()
    + skip()과 limit()은 스트림의 일부를 잘라낼 때 사용한다.
    + skip(3)은 처음 3개의 요소를 건너뛰고, limit(5)는 스트림의 요소를 5개로 제잔한다.
    + 예를 들어 10개의 요소를 가진 스트림에 skip(3)과 limit(5)을 순서대로 적용하면 4번째 요소부터 5개의 요소를 가진 스트림이 반환된다.
  + 스트림의 요소 걸러내기 - filter(), distinct()
    + distinct()는 스트림에서 중복된 요소들을 제거하고, filter()는 주어진 조건(Predicate)에 맞지 않는 요소를 걸러낸다.
    + filter()는 매개변수로 Predicate를 필요로 하는데, 연산결과가 boolean인 람다식을 사용해도 된다.
    + 필요하다면 filter()를 다른 조건으로 여러 번 사용할 수도 있다.
  + 정렬 - sorted()
    ```
    Stream<T> sotred()
    Stream<T? sorted(Comparator<? super T> comparator)
    ```
    + sorted()는 지정된 Comparator로 스트림을 정렬하는데, Comparator대신 int값을 반환하는 람다식을 사용하는 것도 가능하다.
    + Comparator를 지정하지 않으면 스트림 요소의 기본 정렬 기준(Comparable)으로 정렬한다.
  + 변환 - map()
    + 스트림의 요소에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정 형태로 변환해야 할때 map()을 사용한다.
    + 메소드의 선언부는 아래와 같으며, 매개변수로 T타입을 R타입으로 변환해서 반환하는 함수를 지정해야 한다.
    ```
    Stream<R> map(Function<? super T, ? extends R> mapper)
    ```
  + 조회 - peek()
    + 연산과 연산 사이에 올바르게 처리되었는지 확인하고 싶을 때, peek()를 사용한다.
    + forEach()와 달리 스트림의 요소를 소모하지 않는다.
  + mapToInt(), mapToLong(), mapToDouble()
    + map()은 연산의 결과로 Stream<T>타입의 스트림을 반환하는데, 스트림의 요소를 숫자로 변환하는 경우 기본형 스트림으로 변환하는 것이 더 유리하다.
    + count()만 지원하는 Stream<T>와 달리 IntStream과 같은 기본형 스트림은 아래와 같이 숫자를 다루는데 편리한 메소드들을 제공한다.
    ```
    int sum() // 스트림의 모든 요소의 총합
    OptionalDouble average() // sum() / (double)count()
    OptionalInt max() // 스트림의 요소 중 제일 큰 값
    OptionalInt min() // 스트름의 요소 중 제일 작은 값
    ```
    + 이 메소드들은 최종연산이기 때문에 호출 후에 스트림이 닫힌다.
    + 이 메소드들을 연속해서 호출할 때 새로 스트림을 생성해야 하는 불편함때문에 summaryStatistics()라는 메소드가 따로 제공된다.
    ```
    Stream<String> -> IntStream 변환할 때, mapToInt(Integer::parseInt)
    Stream<Integer> -> IntStream 변환할 때, mapToInt(Integer::intValue)
    ```
  + flatMap() - Stream<T[]>를 Stream<T>로 변환
    + 스트림의 요소가 배열이거나 map()의 연산결과가 배열인 경우, 즉 스트림의 타입이 Stream<T[]>인 경우, Stream<T>로 다루는 것이 더 편리할 때가 있다.
    + 그럴 때는 map()대신 flatMap()을 사용하면 된다.
    ```
    Stream<String[]> strArrStrm = Stream.of(
      new String[] {"abc", "def", "ghi"},
      new String[] {"ABC", "DEF", "GHI"}
    );
    Stream<String> strStrm = strArrStrm.flatMap(Arrays::stream);
    ```

+ 2.4 Optional<T>와 OptinalInt
  + Optional<T>은 지네릭 클래스로 'T타입의 객체'를 감싸는 래퍼 클래스이다. 그래서 Optional타입의 객체에는 모든 타입의 참조변수를 담을 수 있다.
  + 최종 연산의 결과를 그냥 반환하는게 아니라 Optional객체에 담아서 반환을 하면, 반환된 결과가 null인지 매번 if문으로 체크하는 대신 Optional에 정의된 메소드를 통해서 간단히 처리할 수 있다.
  + Optional객체를 생성할 때는 of()또는 ofNullable()을 사용한다.
  + 만일 참조변수의 값이 null일 가능성이 있으면, of()대신 ofNullable()을 사용해야 한다.
  + Optional<T>타입의 참조변수를 기본값으로 초기화할 때는 empty()를 사용한다.
  + Optional객체에 저장된 값을 가져올 때는 get()을 사용한다. 값이 null일 때를 대비하여 orElse()로 대체할 값을 지정할 수 있다.
  + orElse()의 변형으로는 null을 대체할 값을 반환하는 람다식을 지정할 수 있는 orElseGet()과 null일 때 지정된 예외를 발생시키는 orElseThrow()가 있다.
  + Stream처럼 Optional객체에도 filter(), map(), flatMap()을 사용할 수 있다.
  + IntStream과 같은 기본형 스트림에는 Optional도 기본형을 값으로 하는 OptionalInt, OptionalLong, OptionalDouble을 반환한다.
  + 기본형 Optional에 저장된 값을 꺼낼 때 사용하는 메소드는 이름이 조금씩 다르다.

+ 2.5 스트림의 최종 연산
  + 최종 연산은 스트림의 요소를 소모해서 결과를 만들어내기 때문에 최종 연산후에는 스트림이 닫히게 되고, 더 이상 사용할 수 없다.
  + 최종 연산의 결과는 스트림 요소의 합과 같은 단일 값이거나, 스트림의 요소가 담긴 배열 또는 컬렉션일 수 있다.
  + forEach()
    + forEach()는 peek()와 달리 스트림의 요소를 소모하는 최종연산이다.
    + 반환 타입이 void이므로 스트림의 요소를 출력하는 용도로 많이 사용된다.
    ```
    void forEach(Consumer<? super T> action)
    ```
  + 조건 검사 - allMatch(), anyMatch(), noneMatch(), findFirst(), findAny()
    + 스트림의 요소에 대해 지정된 조건에 모든 요소가 일치하는지, 일부가 일치하는지 아니면 어떤 요소도 일치하지 않는지 확인하는데 사용할 수 있는 메소드들이다.
    + 이 메소드들은 모두 매개변수로 Predicate를 요구하며, 연산결과로 boolean을 반환한다.
    ```
    boolean allMatch(Predicate<? super T> predicate)
    boolean anyMatch(Predicate<? super T> predicate)
    boolean noneMatch(Predicate<? super T> predicate)
    ```
    + 이외에도 스트림의 요소 중에서 조건에 일치하는 것을 반환하는 findFirst(), findAny()가 있다.
  + 통계 - count(), sum(), average(), max(), min()
    + 기본형 스트림이 아닌 경우에는 통계와 관련된 메소드들이 아래의 3개뿐이다.
    ```
    long count()
    Optional<T> max(Comparator<? super T> comparator)
    Optional<T> min(Comparator<? super T> comparator)
    ```
  + 리듀싱 -reduce()
    + 스트림의 요소를 줄여나가면서 연산을 수행하고 최종결과를 반환한다.
    + 그래서 매개변수의 타입이 BinaryOperator<T>인 것이다.
    + 처음 두 요소를 가지고 연산한 결과를 가지고 그 다음 요소와 연산한다.
    ```
    Optional<T> reduce(BinaryOperator<T> accumulator)
    ```
    + 이 외에도 초기값을 갖는 reduce()도 있는데, 이 메소드들은 초기값과 스트림의 첫 번째 요소로 연산을 시작한다.
    ```
    T reduce(T identity, BinaryOperator<T> accumulator)
    ```
    + 최종 연산 count()와 sum() 등은 내부적으로 모두 reduce()를 이용해서 작성된 것이다.
   
+ 2.6 collect()
  + collect()는 스트림의 요소를 수집하는 최종 연산으로 리듀싱(reducing)과 유사하다.
  + collect()가 스트림의 요소를 수집하려면, 어떻게 수집할 것인가에 대한 방법이 정의되어 있어야 하는데, 이 방법을 정의한 것이 바로 컬렉터(collector)이다.
  + 컬렉터는 Collector인터페이스를 구현한 것으로, 직접 구현할 수도 있고 미리 작성된 것을 사용할 수도 있다.
  + Collectors클래스는 미리 작성된 다양한 종류의 컬렉터를 반환하는 static메소드를 가지고 있으며, 이 클래스를 통해 제공되는 컬렉터만으로도 많은 일들을 할 수 있다.
  + 스트림을 컬렉션과 배열로 변환 - toList(), toSet(), toMap(), toCollection(), toArray()
    + 
