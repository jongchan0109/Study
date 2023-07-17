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
      
+ 1.2 String클래스
 
+ 1.3 StringBuffer클래스와 StringBuilder클래스
  
+ 1.4 Math클래스
  
+ 1.5 래퍼(wrapper)클래스

## 2. 유용한 클래스

+ 2.1 java.util.Object클래스

+ 2.2 java.util.Random클래스

+ 2.3 정규식(Regular Expression) - java.util.regex패키지

+ 2.4 java.util.Scanner클래스

+ 2.5 java.util.StringTokenizer클래스

+ 2.6 java.math.BigInteger클래스

+ 2.7 java.math.BigDecimal클래스
