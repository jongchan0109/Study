# 변수(variable)

## 1. 변수(variable)

+ 1.1 변수란?
  변수란 값을 저장할 수 있는 메모리상의 공간을 의미한다.

+ 1.3 변수의 명명규칙
  변수의 이름처럼 프로그래밍에서 사용되는 모든 이름을 식별자(identifier)라고 하며, 식별자는 같은 영영 내에서 서로 구분될 수 있어야 한다.
  규칙
  1. 대소문자가 구분되며 길이에 제한이 없다. - True와 true는 서로 다른 것으로 간주된다.
  2. 예약어를 사용해서는 안된다. - true는 예약어라서 사용할 수 없지만, True는 가능하다.
  3. 숫자로 시작해서는 안된다. - top10은 허용하지만, 7up은 허용되지 않는다.
  4. 특수문자는 '_' 와 '$'만을 허용한다. - $harp은 허용되지만, S#arp은 허용되지 않는다.
 
## 2. 변수의 타입
  자료형에는 크게 기본형과 참조형 두 가지로 나눌 수 있는데, 기본형 변수는 실제 값을 저장하는 반면, 참조형 변수는 어떤 값이 저장되어 있는 주소를 값으로 갖는다.

+ 2.1 기본형(primitive type)
  기본형에는 모두 8개의 타입이 있으며, 크게 논리형, 문자형, 정수형, 실수형으로 구분된다.

  + 논리형 boolean: true와 false 두 가지 값만 표현할 수 있고, 1byte 차지
 
  + 문자형 char: 자바에서 유니코드를 사용하므로 2byte 차지
 
  + 정수형 byte, short, int, long
    
    byte 1byte 차지
    
    short 2byte 차지

    int 4byte 차지, 주로 사용됨

    long 8byte 차지

  + 실수형 float, double
    
    float 4byte 차지

    double 8byte 차지, 주로 사용됨

+ 2.2 상수와 리터럴(constant &literal)
  + 변수(variable): 하나의 값을 저장하기 위한 공간
  + 상수(constant): 값을 한번만 저장할 수 있는 공간
  + 리터럴(literal): 그 자체로 값을 의미하는 것
 
  + 리터럴 타입의 접미사
    long 형: L 사용

    float 형: f 사용

    double 형: d 사용 (주로 생략)
    
## 4. 기본형(primitive type)
+ 4.1 논리형 - boolean

  boolean형 변수에는 true와 false 중 하나를 저장할 수 있으며 default는 false이다.
+ 4.2 문자형 - char

  char형 변수에 문자가 저장되는 것이 아닌 문자의 유니코드 값이 저장된다. (0~65536)
+ 4.3 정수형 - byte, short, int, long

  4개의 자료형이 표현할 수 있는 값의 범위가 다르고, byte는 1byte, short는 2byte, int는 4byte, long는 8byte가 된다. 각 자료가 표현할 수 있는 최대 범위를 벗어나면 오버플로우가 발생한다.
  
  overflow: 각 자료형의 표현할 수 있는 최대값에 1을 더할 경우 최솟값이 되고, 최솟값에 1을 뺄 경우 최댓값이 된다.
