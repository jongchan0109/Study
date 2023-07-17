# 9. java.lang패키지와 유용한 클래스

## 1. java.lang패키지
+ java.lang 패키지는 자바 프로그래밍에 가장 기본이 되는 클래스들을 포함하고 있기 때문에 import문 없이도 사용할 수 있게 되어 있다.

+ 1.1 Object클래스
  + Object클래스는 모든 클래스의 최고 조상이기 때문에 Object클래스의 멤버들은 모든 클래스에서 바로 사용 가능하다.
    ```
    protected Object clone(): 객체 자신의 복사본을 반환한다.
    public boolean equals(Object obj): 객체 자신과 객체 obj가 같은 객체인지 알려준다(같으면 true)
    protected void finalize(): 객체가 소멸될 때 가비지 컬렉터에 의해 자동적으로 호출된다. 이 때 수행되어야 하는 코드가 있을 때 오버라이딩한다.(거의 사용안함)
    public Class getClass(): 객체 자신의 클래스 정보를 담고 잇는 Class인스턴스를 반환한다.
    public int hashCode(): 객체 자신의 해시코드를 반환한다.
    public String toString(): 객체 자신의 정보를 문자열로 반환한다.
    public void notify(): 객체 자신을 사용하려고 기다리는 쓰레드를 하나만 깨운다.
    public void notifyAll(): 객체 자신을 사용하려고 기다리는 모든 쓰레드를 깨운다.
    public void wait()
    public void wait(long timeout)
    public void wait(long timeout, int nanos): 다른 쓰레드가 notify()나 notifyAll()을 호출할 때까지 현재 쓰레드를 무한히 또는 지정된 시간동안 기다리게 한다.
    ```
    + equals(Object obj): 두 객체의 같고 다름을 참조변수의 값으로 판단한다. 오버라이딩하여 주소가 아닌 객체에 저장된 내용을 비교하도록 할 수 있다.
    + hashCode(): Object클래스에 정의된 hashCode 메소드는 객체의 주소값으로 해시코드를 만들어 반환하기 때문에 32bit JVM에서는 서로 다른 두 객체는 같은 해시코드를 가질 수 없지만, 64bit JVM에서는 8byte 주소값으로 해시코드(4byte)를 만들기 때문에 값이 중복될 수 있다.
    + toString(): 인스턴스에 대한 정보를 문자열로 제공할 목적으로 정의된 메소드로, 오버라이딩하지 않는다면, 클래스이름 + @ + 해시코드를 반환한다.
    + clone(): clone()메소드는 단순히 인스턴스변수의 값만 복사하기 때문에 참조타입의 인스턴스 변수가 있는 클래스는 완전한 복제가 이루어지지 않는다. clone()을 사용하려면, 먼저 복제할 클래스가 Cloneable 인터페이스를 구현해야 하고, clone()을 오버라이딩하면서 접근 제어자를 protected에서 public로 변경해야 한다. JDK1.5부터 '공변 반환타입'이라는 것이 추가되었는데, 이 기능은 오버라이딩할 때 조상 메소드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것이다.
    + getClass(): 자신이 속한 클래스의 Class객체를 반환하는 메소드인데, Class객체는 이름이 'Class'인 클래스의 객체이다. Class객체는 클래스의 모든 정보를 담고 있으며, 클래스 당 1개만 존재한다. 그리고 클래스 파일이 '클래스 로더'에 의해서 메모리에 올라갈 때, 자동으로 생성된다.
    ```
    Class cObj = new Card().getClass();
    Class cObj = Card.class;
    Class cObj = Class.forName("Card");
    ```

+ 1.2 String클래스
  + 기존의 다른 언어에서는 문자열을 char형의 배열로 다루었으나 자바에서는 문자열을 위한 클래스인 String클래스를 제공한다.
  + 한번 생성된 String인스턴스가 갖고 있는 문자열은 읽어 올 수만 있고, 변경할 수는 없다.
  + 문자열을 만들 때는 두 가지 방법, 문자열 리터럴을 저장하는 방법과 String클래스의 생성자를 사용해서 만드는 방법이 있다.
  ```
  String str1 = "abc"; 
  String str2 = "abc"; // str1과 str2는 같은 인스턴스의 주소값을 저장
  String str3 = new String("abc");
  String str4 = new String("abc"); // str3와 str4는 각자 다른 인스턴스의 주소값을 저장
  // equals()를 사용하면 두 문자열의 내용을 비교하기 때문에 모두 true를 결과로 얻음 '=='로 비교하였을 때는 str1과 str2는 true, str4와 str4는 false
  ```
  + 자바 소스파일에 포함된 모든 문자열 리터럴은 컴파일 시에 클래스 파일에 저장되는데, 같은 내용의 문자열 리터럴은 한번만 저장된다.
  + String s = ""; 과 같은 빈 문자열도 생성 가능하다.
  + 기본형 값을 String으로 변환하려면 기본형 값에 '기본형 변수 + ""' 를 해주면 된다. 또는 String.valueOf(기본형) 을 하면 된다.
  + String을 기본형 값으로 변환하기 위해서는 wrapper클래스.parse(), wrapper클래스.valueof()를 해주면 된다.
 
+ 1.3 StringBuffer클래스와 StringBuilder클래스
  + String클래스는 인스턴스를 생성할 때 지정된 문자열을 변경할 수 없지만, StringBuffer클래스는 변경이 가능하다.
  + 내부적으로 문자열 편집을 위한 버퍼(buffer)를 가지고 있으며, StringBuffer 인스턴스를 생성할 때 그 크기를 지정할 수 있다.
  + append()는 반환타입이 StringBuffer인데 자신의 주소를 반환한다.
  + StringBuffer은 equals()메소드를 오버라이딩하지 않아서 equlas 메소드를 사용하여 비교해도 '=='연산조로 비교한 것과 같은 결과를 얻는다.
  + StringBuffer도 문자열을 다루기 위한 클래스이므로, String클래스와 유사한 메소드를 많이 가지고 있다.
  + StringBuilder는 멀티쓰레드에 안전하도록 동기화되어 있다.
  
+ 1.4 Math클래스
  + Math클래스는 기본적인 수학계산에 유용한 메소드로 구성되어 있다.
  + Math클래스의 생성자는 private이기 때문에 다른 클래스에서 Math인스턴스를 생성할 수 없다.
  + Math클래스의 메소드는 모두 static이며, E,PI의 2개의 상수만 정의해 놓았다.
  + 소수 n번째 자리에서 반올림한 값을 얻기 위해서는 round()를 사용해야 하는데, 이 메소드는 항상 소수점 첫째자리에서 반올림을 해서 정수값(long)을 결과로 반환한다. 그러므로 10의 제곱을 곱하고 나누어서 원하는 소수점 위치의 반올림 값을 구할 수 있다.
  + 메소드 이름에 Exact가 포함된 메소드들은 정수형간의 연산에서 발생할 수 있는 오버플로우를 감지하기 위한 것이고, 오버플로우가 발생하면 예외(ArithmeticException)를 발생시킨다.
  + Math클래스는 최대한의 성능을 얻기 위해 JVM이 설치된 OS의 메소드를 호출해서 사용한다. 그러므로 반올림의 처리방법 설정이 OS마다 다를 수 있기 때문에 자바로 작성된 프로그램임에도 불구하고 컴퓨터마다 결과가 다를 수 있다. 이러한 차이를 없애기 위해 StrictMath클래스가 새로 작성되었다.
  
+ 1.5 래퍼(wrapper)클래스
  + 객체지향 개념에서 모든 것은 객체로 다루어져야 하기 때문에, 자바에서는 기본형 변수도 객체로 사용하기 위해 래퍼(wrapper)클래스를 지원한다.
  + 래퍼 클래스들은 객체 생성 시에 생성자의 인자로 주어전 각 자료형에 알맞은 값을 내부적으로 저장하고 있으며, 이에 관련된 여러 메소드가 정의되어있다.
  + Number클래스는 추상클래스로 내부적으로 숫자를 멤버변수로 갖는 래퍼 클래스들의 조상이다. 기본형 중에서 boolean과 char을 제외한 모든 기본형의 래퍼 클래스는 Number클래스의 자손이다.
  + JDK1.5 이전에는 기본형과 참조형 간의 연산이 불가능했기 때문에, 래퍼 클래스로 기본형을 객체로 만들어서 연산해야 했다. 그러나 이제는 기본형과 참조형 간의 덧셈이 가능하다.
  + 기본형 값을 래퍼 클래스의 객체로 자동 변환해주는 것을 '오토박싱(autoboxing)'이라고 하고, 반대로 변환하는 것을 '언박싱(unboxing)'이라고 한다.

## 2. 유용한 클래스

+ 2.1 java.util.Object클래스

+ 2.2 java.util.Random클래스

+ 2.3 정규식(Regular Expression) - java.util.regex패키지

+ 2.4 java.util.Scanner클래스

+ 2.5 java.util.StringTokenizer클래스

+ 2.6 java.math.BigInteger클래스

+ 2.7 java.math.BigDecimal클래스
