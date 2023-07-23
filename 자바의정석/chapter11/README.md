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
    |int indexOf(Object o)|지정된 객체의 위치(index)를 반환한다.|
    
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

    |기호|의미|보기|
    |------|---|---|
    |G|연대(BC,AD)|AD|
    |y|년도|2006|
    |M|얼(1\~12 또는 1월~12월)|10 또는 10월, OCT|
    |w|년의 몇 번째 주(1\~53)|50|
    |W|월의 몇 번째 주(1\~5)|4|
    |D|년의 몇 번째 일(1\~366)|100|
    |d|월의 몇 번째 일(1\~31) |15|
    |F|월의 몇 번째 요일(1\~5) |1|
    |E|요일|월|
    |a|오전/오후(AM,PM)|PM|
    |H|시간(0\~23)|20|
    |k|시간(1\~24)|13|
    |K|시간(0\~11)|10|
    |h|시간(1\~12)|11|
    |m|분(0\~59)|35|
    |s|초(0\~59)|55|
    |S|천분의 일초(0\~999)|253|
    |z|Time zone(General time zone)|GMT+9:00|
    |Z|Time zone(RFC 822 time zone)|+0900|
    |'|escape문자(특수문자를 표현하는데 사용)|없음|
    
  + 보다 자세한 내용은 java API문서에서 SimpleDateFormat을 찾으면 된다.

+ 2.3 ChoiceFormat
  + ChioceFormat은 특정 범위에 속하는 값을 문자열로 변환해준다. 연속적 또는 불연속적인 범위의 값들을 처리하는데 있어서 if문이나 switch문은 적절하지 못한 경우가 많다.
  + 예시)
  ```
  public static void main(String[] args){
    double[] limits = {60,70,80,90};
    String[] grades = {"D","C","B","A"};
    int[] scores = {100,95,88,70,52,60,70};
    ChoiceFormat form = new ChoiceFormat(limits,grades);
    for(int i=0;i<scores.length;i++){
      System.out.println(scores[i]+":"+form.format(scores[i]));
    }
  }

  실행 결과:
  100:A
  95:A
  88:B
  70:C
  52:D
  60:D
  70:C
  ```
  
+ 2.4 MessageFormat
  + MessageFormat은 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와준다.
  + 데이터가 들어갈 자리를 마련해 놓은 양식을 미리 작성하고 프로그램을 이용해서 다수의 데이터를 같은 양식으로 출력할 때 사용하면 좋다.
  + 예시
  ```
  public static void main(String[] args){
    String msg = "Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}";

    Object[] arguments = {"이자비","02-123-1234","27","07-09"};

    String result = MessageFormat.format(msg,arguments);
    System.out.println(result);
  }
    실행 결과
    Name: 이자바
    Tel: 02-123-1234
    Age: 27
    BirthDay: 07-09
  ```

## 3. java.time패키지
+ Java의 탄생부터 지금까지 날짜와 시간을 다루는데 사용해왔던, Date와 Calendar가 가지고 있떤 단점들을 해소하기 위해 JDK1.8부터 'java.time'패키지가 추가되었다.
+ java.time : 날짜와 시간을 다루는데 필요한 핵심 클래스들을 제공 (4개의 하위 패키지를 가지고 있음)
+ java.time.chrono : 표준(ISO)이 아닌 달력 시스템을 위한 클래스들을 제공
+ java.time.format : 날짜와 시간을 파싱하고, 형식화하기 위한 클래스들을 제공
+ java.time.temporal : 날짜와 시간의 필드(field)와 단위(unit)를 위한 클래스들을 제공
+ java.time.zone : 시간대(time-zone)와 관련된 클래스들을 제공
+ 위의 패키지들에 속한 클래스들의 가장 큰 특징은 변경이 불가능하다는 것이다.

+ 3.1 java.time패키지의 핵심 클래스
  + 날짜와 시간을 하나로 표현하는 Calendar클래스와 달리, java.time 패키지에서는 날짜와 시간을 별도의 클래스로 분리해 놓았다.
  + 시간을 표현할 대는 LocatTime 클래스를, 날짜를 표현할 때는 LocalDate클래스를, 날짜와 시간을 표현할 때는 LocatDateTime클래스를 사용하면 된다.
  + 시간대까지 다뤄야 한다면, ZonedDateTIme 클래스를 사용한다.
  + java.time 패키지에 속한 클래스의 객체를 생성하는 가장 기본적인 방법은 now()와 of()를 사용하는 것이다.
  + now()는 현재 날짜와 시간을 저장하는 객체를 생성하고, of()는 단순히 해당 필드의 값을 순서대로 지정해 주기만 하면 된다.
  + 날짜와 시간을 표현하는 클래스들은 모두 Temporal,TemporalAccessor,TemporalAdjuster 인터페이스를 구현했고, Duration,period는 TemporalAmount 인터페이스를 구현하였다.
  + 날짜와 시간의 단위를 정의해 놓은 것이 TemporalUnit 인터페이스이고, 이 인터페이스를 구현한 것이 열거형 ChronoUnit이다.

+ 3.2 LocalDate와 LocalTime
  + LocalDate와 LocalTime는 java.time 패키지의 가장 기본이 되는 클래스이다.
  + 객체를 생성하는 방법은 now()와 of()가 있으며 둘 다 static 메소드이다.
  ```
  LocalDate today = LocalDate.now();
  LocalTime now = LocalTime.now();

  LocalDate birthDate = LocalDate.of(1999,12,31);
  LocalTime bitrhTime = LocalTime.of(23,59,59);
  ```
  + LocalDate에서 month의 범위는 Calendar과 달리 1~12이고, 요일은 월요일이 1, 화요일이 2, ... 일요일이 7이다.
  + 날짜와 시간에서 특정 필드 값을 변경하려면, wtih로 시작하는 메소드를 사용하면 된다. java.time 패키지는 불변이므로, 새로운 객체를 생성해서 반환하여 변환한다.
  + 날짜와 시간을 비교하기 위해 isAfter(), isBefore(), isEqual()을 사용할 수 있다.

+ 3.3 Instant
  + Instant는 에포크 타임(EPOCH TIME, 1970-01-01 00:00:00 UTC)부터 경과된 시간을 나노초 단위로 표현한다.
  + Instant를 생성할 때는 now()와 ofEpochSecond()를 사용한다.
  + Instant는 시간을 초 단위와 나노초 단위로 나누어 저장한다.
  + Instant는 항상 UTC(+00:00)를 기준으로 하기 때문에 LocalTime와 차이가 있을 수 있다 (ex: 한국 +09:00)

+ 3.4 LocalDateTime과 ZonedDateTime
  + LocalDate와 LocalTime으로 LocalDateTime을 만들 수 있다.
  ```
  LocalDate date = LocalDate.of(2015,12,31);
  LocalTime time = LocalTime.of(12,34,56);

  LocalDateTime dt = LocalDateTime.of(date,time);
  LocalDateTime dt2 = date.atTime(time);
  LocalDateTime dt3 = time.atDate(date);
  etc...
  ```
  + 반대로 LocalDateTime을 LocalDate 또는 LocalTIme으로 변경할 수 있다.
  ```
  LocalDateTime dt = LocalDateTime.of(2015,12,31,12,34,56);
  LocalDate date = dt.toLocalDate();
  LocalTime time = dt.toLocalTime();
  ```
  + LocalDateTime에 시간대(time-zone)를 추가하면, ZonedDateTime이 된다.
 
+ 3.5 TemporalAdjusters
  + plus(), minus()와 같이 메소드로 날짜와 시간을 계산할 수 있지만, 자주 쓰일만한 날짜 계산들을 대신 해주는 메소드를 정의해 놓은 것이 TemporalAdjusters클래스이다.
  + 유용한 메소드들
  
  |메소드|설명|
  |------|---|
  |firstDayOfNextYear()|다음 해의 첫 날|
  |firstDayOfNextMonth()|다음 달의 첫 날|
  |firstDayOfYear()|올 해의 첫 날|
  |firstDayOfMonth()|이번 달의 첫 날|
  |lastDayOfYear()|올 해의 마지막 날|
  |lastDayOfMonth()|이번 달의 마지막 날|
  |firstInMonth(DayOfWeek dayOfWeek)|이번 달의 첫번째 ?요일|
  |lastInMonth(DayOfWeek dayOfWeek)|이번 달의 마지막 ?요일|
  |previous(DayOfWeek dayOfWeek)|지난 ?요일(당일 미포함)|
  |previousOrSame(DayOfWeek dayOfWeek)|지난 ?요일(당일 포함)|
  |next(DayOfWeek dayOfWeek)|다음 ?요일(당일 미포함)|
  |nextOrSame(DayOfWeek dayOfWeek)|다음 ?요일(당일 포함)|
  |dayOfWeekInMonth(DayOfWeek dayOfWeek)|이번 달의 n번째 ?요일|
  
  + 필요하면 자주 사용되는 날짜 계산을 해주는 메소드를 직접 만들 수도 있다.
  + LocalDate, LocalTime 등 날짜와 시간에 관련된 클래스에 포함되어 있는 with으로 할 수 있는데, with(TemporalAdjuster adjuster)에서 adjuster은 TemporalAdjuster 인터페이스를 구현한 클래스의 객체를 매개변수로 제공해야 한다.
 
+ 3.6 Period와 Duration
  + Period는 날짜의 차이를, Duration은 시간의 차이를 계산하기 위한 것이다.
  + between()으로 두 시간, 날짜 사이의 차이를 계산할 수 있다.
  + between()과 until()은 거의 같은 일은 하지만, between은 static메소드이고, until()은 인스턴스 메소드이다. Period는 년월일을 분리해서 저장하기 때문에, D-day를 구하려는 경우에는 두 개의 매개변수를 받는 until()을 사용하는 것이 낫다.
  + Period, Duration에서 특정 필드의 값을 얻을 때는 get()을 사용한다.
  + plus(), minus()외에 곱셈과 나눗셈을 위한 메소드도 있다.
  + Peroid에는 나눗셈을 위한 메소드가 없는데, Peroid는 날짜의 기간을 표현한 것이기 때문에 나눗셈을 위한 메소드가 별로 유용하지 않기 때문이다.
  + 다른 단위로 변환하는 메소드들도 있다.

+ 3.7 파싱과 포맷
  + 형식화와 관련된 클래스들은 java.time.format 패키지에 들어있는데, 이 중에서 DateTimeFormatter가 핵심이다.
  + 예시)
  + DateTimeFormatter의 static메소드 ofLocalizedDate(), ofLocalizedTime(), ofLocalizedDateTime()은 로케일(locale)에 종속적인 포맷터를 생성한다.
  + 예시)
  + 문자열을 날짜 또는 시간으로 변환하려면 static메소드 parse()를 사용하면 된다.
  ```
  stiatc LocalDateTime parse(CharSequence text)
  stiatc LocalDateTime parse(CharSequence text, DateTimeFormatter formmater)
  ```
  + 위의 2개가 자주 쓰인다.
