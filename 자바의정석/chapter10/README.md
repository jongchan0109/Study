# 10 날짜와 시간 & 형식화

## 1. 날짜와 시간

+ 1.1 Calendar와 Date
  + Date는 날짜와 시간을 다룰 목적으로 JDK1.0부터 제공되어온 클래스이다. Date클래스의 기능이 부족했기 때문에 Calendar라는 새로운 클래스를 JDK1.1부터 제공하기 시작했다.
  + Calendar는 추상클래스이기 때문에 직접 객체를 생성할 수 없고, 메소드를 통해서 완전히 구현된 클래스의 인스턴스를 얻어야 한다.
  + Calendar를 상속받아 완전히 구현한 클래스로는 GregorianCalendar와 BuddhistCalendar가 있는데, getInstance()는 시스템의 국가와 지역설정을 확인해서 태국인 경우에는 BuddhistCalendar의 인스턴스를 반환하고, 그 외에는 GregorianCalendar의 인스턴스를 반환한다.
  + Calendar가 새로 추가되면서 Date는 대부분의 메소드가 'deprecated'되어 잘 사용되지 않는다. 그럼에도 불구하고 여전히 Date를 필요로 하는 메소드들이 있기 때문에 Calendar를 Date로 또는 그 반대로 변환할 일이 생긴다.
  ```
  Calendar cal = Calendar.getInstance();
  Date d = new Date(cal.getTimeInMillis());

  Date d = new Date();
  Calendar cal = Calendar.getInstance();
  cal.setTime(d)
  ```
  + getInstance()를 통해서 얻은 인스턴스는 기본적으로 현재 시스템의 날짜와 시간에 대한 정보를 담고 있다. 원하는 날짜나 시간으로 설정하려면 set메소드를 사용하면 된다.
  + get메소드의 매개변수로 사용되는 int값들은 Calendar에 정의된 static상수이다.
  + get(Calendar.MONTH)로 얻어오는 값은 1~12의 범위가 아닌 0~11의 범위이므로 사용에 주의해야 한다. set(MONTH)도 마찬가지로 0~11의 범위이다.
  + add(int field, int amount)를 사용하면 지정한 필드이 값을 원하는 만큼 증가 또는 감소시킬 수 있다.


## 2. 형식화클래스
+ 형식화 클래스는 java.text 패키지에 포함되어 있으며 숫자 날짜, 텍스트 데이터를 일정한 형식에 맞게 표현할 수 있는 방법을 객체지향적으로 설계하여 표준화하였다.

+ 2.1 DecimalFormat
  + 형식화 클래스 중에서 숫자를 형식화 하는데 사용되는 것이 DecimalFormat이다.
  + DecimalFormat을 이용하면 숫자 데이터를 정수, 부동소수점, 금액 등의 다양한 형식으로 표현할 수 있으며, 반대로 일정한 형식의 텍스트 데이터를 숫자로 쉽게 변환하는 것도 가능하다.
  + DecimalFormat에 대한 자세한 내용은 java API문서에서 DecimalFormat를 찾아보면 된다.

+ 2.2 SimpleDateFormat
  + Date와 Calendar만으로 날짜 데이터를 원하는 형태로 다양하게 출력하는 것은 불편하고 복잡하다. SimpleDateFormat을 사용하면 이러한 문제들이 간단히 해결된다.
  + 보다 자세한 내용은 java API문서에서 SimpleDateFormat을 찾으면 된다.

+ 2.3 ChoiceFormat
  + ChioceFormat은 특정 범위에 속하는 값을 문자열로 변환해준다. 연속적 또는 불연속적인 범위의 값들을 처리하는데 있어서 if문이나 switch문은 적절하지 못한 경우가 많다.
  + 예시

+ 2.4 MessageFormat
  + MessageFormat은 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와준다.
  + 데이터가 들어갈 자리를 마련해 놓은 양식을 미리 작성하고 프로그램을 이용해서 다수의 데이터를 같은 양식으로 출력할 때 사용하면 좋다.
  + 예시

## 3. java.time패키지
+ Java의 탄생부터 지금까지 날짜와 시간을 다루는데 사용해왔던, Date와 Calendar가 가지고 있떤 단점들을 해소하기 위해 JDK1.8부터 'java.time'패키지가 추가되었다.
+ java.time : 날짜와 시간을 다루는데 필요한 핵심 클래스들을 제공 (4개의 하위 패키지를 가지고 있음)
+ java.time.chrono : 표준(ISO)이 아닌 달력 시스템을 위한 클래스들을 제공
+ java.time.format : 날짜와 시간을 파싱하고, 형식화하기 위한 클래스들을 제공
+ java.time.temporal : 날짜와 시간의 필드(field)와 단위(unit)를 위한 클래스들을 제공
+ java.time.zone : 시간대(time-zone)와 관련된 클래스들을 제공
+ 위의 패키지들에 속한 클래스들의 가장 큰 특징은 변경이 불가능하다는 것이다.

+ 3.1 java.time패키지의 핵심 클래스
  + 
