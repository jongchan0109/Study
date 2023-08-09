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
