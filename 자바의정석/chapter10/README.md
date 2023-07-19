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

+ 2.1 DecimalFormat
  + Object클래스의 보조 클래스로 Math클래스처럼 모든 메소드가 static이다. 객체의 비교나 널 체크에 유용하다.
  + isNull()은 해당 객체가 null인지 확인해서 null이면 true를 반환하고, 아니면 false를 반환한다.
  + nonNull()은 해당 객체가 null인지 확인해서 null이면 false를 반환하고, 아니면 true를 반환한다.
  + requireNonNull()은 해당 객체가 널이 아니어야 하는 경우에 사용한다.
  + Object클래스에는 두 객체의 등가비교를 위한 equlas()만 있고, 대소비교를 위한 compare()는 없는데, Objects에는 compare()가 추가되었다.

+ 2.2 java.util.Random클래스
  + 난수를 얻으려면 Math.random()이 있는데, Math.random()은 Random클래스의 인스턴스를 생성해서 사용하는 것이므로 둘 중에서 편한 것을 사용하면 된다.
  + 생성자 Random()은 seed를 추가하여, 정해진 난수를 발생시킬 수 있다.

+ 2.3 정규식(Regular Expression) - java.util.regex패키지
  + 정규식이란 텍스트 데이터 중에서 원하는 조건(패턴,pattern)과 일치하는 문자열을 찾아 내기 위해 사용하는 것으로 미리 정의된 기호와 문자를 이용해서 작성한 문자열을 말한다.
  + 정규식을 이용하면 많은 양의 텍스트 파일 중에서 원하는 데이터를 손쉽게 뽑아낼 수도 있고 입력된 데이터가 형식에 맞는지 체크할 수도 있다.
  ```
  c[a-z]* : c로 시작하는 영단어
  c[a-z] : c로 시작하는 두 자리 영단어
  c[a-zA-Z] : c로 시작하는 두 자리 영단어(a~z, A-Z 대소문자 구분안함)
  c[a-zA-Z0-9], c\w : c로 시작하고 숫자와 영어로 조합된 두 글자
  .* : 모든 문자열
  c. : c로 시작하는 두 자리 문자열
  c.* : c로 시작하는 모든 문자열(기호 포함)
  c\. : c.와 일치하는 문자열 '.'은 패턴작성에 사용되는 문자이므로 escape문자인 '\'를 사용해야 한다.
  c\d, c[0-9] : c와 숫자로 구성된 두 자리 문자열
  c.*t : c로 시작하고 t로 끝나는 모든 문자열
  [b|c].*, [bc].*, [b-c].*: b또는 c로 시작하는 문자열
  [^b|c].*, [^bc].*, [^b-c].* : b또는 c로 시작하지 않는 문자열
  .*a.* : a를 포함하는 모든 문자열 (*: 0 또는 그 이상의 문자)
  .*a.+ : a를 포함하는 문자열 (+: 1또는 그 이상의 문자)
  [b|c].{2} : b또는 c로 시작하는 세 자리 문자열
  ```
  + 정규식의 일부를 괄호로 나누어 묶어서 그룹화 할 수 있다.

+ 2.4 java.util.Scanner클래스
  + Scanner는 화면, 파일, 문자열과 같은 입력소스로부터 문자데이터를 읽오으는데 도움을 줄 목적으로 JDK1.5부터 추가되었다.
  + 입력받을 값이 숫자라면 nextLine()대신 nextInt(), nextLong()과 같은 메소드를 사용할 수 있다.
  + Scanner는 정규식 표현을 이용한 라인단위의 검색을 지원하며 구분자에도 정규식 표현을 사용할 수 있다.

+ 2.5 java.util.StringTokenizer클래스
  + StringTokenizer는 긴 문자열을 지정된 구분자를 기준으로 토큰이라는 여러 개의 문자열을 잘라내는 데 사용된다.
  ```
  StringTokenizer(String str, String delim) : 문자열(str)을 지정된 구분자(delim)으로 나누는 StringTokenizer를 생성한다.(구분자는 토큰으로 간주되지 않음)
  StringTokenizer(String str, String delim, boolean returnDelims) : retrunDelims의 값을 true로 하면 구분자도 토큰으로 간주된다.
  int countTokens() : 전체 토큰의 수를 반환한다.
  boolean hasMoreTokens() : 토큰이 남아있는지 알려준다.
  String nextToken() : 다음 토큰을 반환한다.
  ```
  + StringTokenizer는 단 한 문자의 구분자만 사용할 수 있기 때문에, "+-*/=()" 전체가 하나의 구분자가 아니라 각각이 하나의 구분자가 된다.

+ 2.6 java.math.BigInteger클래스
  + 정수형으로 표현할 수 있는 값의 한계가 있으므로, 더 큰수를 표현하기 위해 BigInteger을 사용한다.
  + BigInteger는 내부적으로 int배열을 사용해서 값을 다루므로, 성능이 long타입보다 떨어진다.

+ 2.7 java.math.BigDecimal클래스
  + double타입으로 표현할 수 있는 값은 상당히 넓지만, 정밀도가 최대 13자리 밖에 되지 않고, 오차를 피할 수 없기 때문에 BigDecimal을 사용할 수가 있다.
  + BigDecimal은 실수형과 달리 정수를 이용해서 실수를 표현한다.
  + 정수 x 10^(-scale)
  + 정수를 표현할 때는 BigInteger 인스턴스를 사용하므로, 정밀도가 매우 높다.
  + 무한소수인 경우, 반올림 모드를 지정해주지 않으면 ArithmeticException이 발생한다.
