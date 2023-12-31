# 4. 조건문과 반복문
+ 프로그램의 흐름을 바꾸는 역할을 하는 문장들을 제어문(control statememt)이라고 하고, 제어문에는 조건문과 반복문이 있다.
  
## 1. 조건문 - if, switch

+ 1.1 if문
  
  + if문은 가장 기본적인 조건문이며, 조건식과 괄호{}로 이루어져 있다.
  + 만일 조건식이 참이면 괄호{}안의 문장을 수행한다.
  + 조건식은 일반적으로 비교연산자와 논리연산자로 구성된다.

+ 1.2 if-else문
  + if문의 변형인 if-else문은 if문의 조건식의 결과가 참이 아닐 때 else 문의 괄호{}안의 문장들을 수행한다.

+ 1.3 if-else if문
  + if-else문은 두 가지 경우 중 하나가 수행되는 구조인데, 처리해야할 경우의 수가 셋 이상인 경우에는 if-else if문을 사용한다.
  + if문의 조건식이 거짓인 경우 else if문이 처리되고, else if문이 참인 경우 else if문의 괄호{}안의 문장들이 수행되고, else if들이 거짓인 경우 else문의 괄호{}안의 문장들이 수행된다.
 
+ 1.4 중첩 if문
  + if문의 블럭 내에 또 다른 if문을 포함시키는 것이 가능한데 이것을 중첩 if문이라고 부르며 중첩의 횟수에는 거의 제한이 없다.
  + 괄호의 생략에 따라 바깥쪽의 if문과 안쪽의 if문이 서로 엉켜서 if문과 else블럭의 관계가 의도한 바와 다르게 형성될 수 있기 때문에 주의해야 한다.
 
+ 1.5 switch문
  + if문은 조건식의 결과가 참과 거짓 두 가지 밖에 없기 때문에 경우의 수가 많아질수록 else-if를 계속 추가해야하므로 복잡해지고, 처리시간도 많이 걸릴 수 있다.
  + switch문은 단 하나의 조건식으로 많은 경우의 수를 처리할 수 있고, 표현도 간결하기 때문에 알아보기 쉽다.
  + switch문은 조건식을 먼저 계산한 다음, 그 결과와 일치하는 case문으로 이동한다. 한 case문 아래에 있는 문장들을 수행하며, break문을 만나면 전체 switch문을 빠져나가게 된다.
  + 만일 조건식의 결과와 일치하는 case문이 없는 경우에는 default문으로 이동한다.
  + switch문에서 break문은 각 case를 구분하는 역할을 하기 때문에, break문을 빼먹는 실수를 하지 않아야 한다. 의도적으로 break문을 빼는 경우도 있다.
  + switch문의 제약 조건
      1. switch문의 조건식 결과는 정수 또는 문자열이어야 한다.
      2. case문의 값은 정수 상수만 가능하며, 중복되지 않아야 한다,
  + switch문도 if문처럼 중첩이 가능하다. 

      
## 2. 반복문 - for, while, do-while

+ 2.1 for문
  + for문은 반복 횟수를 알고 있을 때 적합하다.
  + for문은 초기화, 조건식, 증감식, 볼럭{} 모두 4가지 부분으로 이루어져 있으며, 조건식이 참인 동안 블럭{} 내의 문장들을 반복하다 거짓이 되면 반복문을 벗어난다.
  + 초기화,조건식,증감식은 생략이 가능하다.
  + 제일 먼저 초기화가 진행되고, 그히우부터는 조건식이 참인 동안 조건식 -> 수행될 문장 -> 증감식의 순서로 계속 반복된다.
  + for문 안에 다른 for문을 포함시키는 중첩 for문이 가능하다.
  + for-each 문
    + 배열과 컬렉션에 저장된 여소에 접근할 때 기존보다 편리한 방법으로 처리할 수 있도록 for문의 새로운 문법이 추가되었다.
    + for(타입 변수명: 배열 또는 컬렉션){반복할 문장}
    + 타입은 배열 또는 컬렉션의 요소의 타입이어야 한다.

+ 2.2 while문
  + for문과 다르게 while문은 조건식과 블럭{}으로 이루어져 있다.
  + while문은 조건식읊 평가해서 조건식이 거짓이면 문장 전체를 벗어나고, 참이면 블럭{} 내의 문장을 수행한다.
  + for문과 다르게 조건식의 생략이 불가능하다.
 
+ 2.3 do-while문
  + do-while문은 while문의 변형으로 기본적인 구조는 while문과 같으나 조건식과 블럭{}의 순서를 바꿔놓은 것이다. 그래서 while문과 반대로 블럭{}을 먼저 수행한 후에 조건식을 평가한다.
  + while문은 조건식의 결과에 따라 블럭{}이 한번도 수행되지 않을 수 있지만, do-while문은 최소한 한번은 수행된다.
  + do{수행될 문장} while(조건식);

+ 2.4 break문
  + 주로 if문과 함께 사용되어 특정 조건을 만족하면 반복문을 벗어나도록 한다.

+ 2.5 continue문
  + continue문은 반복문 내에서만 사용될 수 있으며, 반복이 진행되는 도중에 continue문을 만나면 반복문의 끝으로 이동하여 다음 반복으로 넘어간다.
 
+ 2.6 이름 붙은 반복문
  + break문은 근접한 단 하나의 반복문만 벗어날 수 있기 때문에, 여러 개의 반복문이 중첩된 경우에는 break문으로 중첩 반복문을 완전히 벗어날 수 없다. 이 때 중첩 반복문 앞에 이름을 붙이고 break문과 continue문에 이름을 지정해 줌으로써 하나 이상의 반복문을 벗어나거나 반복을 건너뛸 수 있다.
  + Loop1 = for(;;)
