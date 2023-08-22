# 15 입출력 I/O

## 1. 자바에서의 입출력

+ 1.1 입출력이란?
  + I/O란 Input과 Output의 약자로 입력과 출력, 간단히 줄여서 입출력이라고 한다.
  + 입출력은 컴퓨터 내부 또는 외부의 장치와 프로그램간의 데이터를 주고받는 것을 말한다.

+ 1.2 스트림(Stream)
  + 자바에서 입출력을 수행하려면, 즉 어느 한쪽에서 다른 쪽으로 데이터를 전달하려면, 두 대상을 연결하고 데이터를 전송할 수 있는 무언가가 필요한데 이것을 스트림(stream)이라고 정의했다.
  + 스트림이란 데이터를 운반하는데 사용되는 연결통로이다.
  + 스트림은 단방향통신만 가능하기 때문에 하나의 스트림으로 입력과 출력을 동시에 처리할 수 없다.
  + 입력과 출력을 동시에 수행하려면 입력을 위한 입력스트림과 출력을 위한 출력스트림, 모두 2개의 스트림이 필요하다.
  + 스트림은 먼저 보낸 데이터를 먼저 받게 되어 있으며 중간에 건너뜀 없이 연속적으로 데이터를 주고받는다.

+ 1.3 바이트기반 스트림 - InputStream, OutputStream
  + 스트림은 바이트단위로 데이터를 전송하며 입출력 대상에 따라 다음과 같은 입출력스트림이 있다.

  |입력스트림|출력스트림|입출력 대상의 종류|
  |------|--------|-----------|
  |FileInputStream|FileOutputStream|파일|
  |ByteArrayInputStream|ByteArrayOutputStream|메모리(byte배열)|
  |PipedInputStream|PipedOutputStream|프로세스(프로세스간의 통신)|
  |AudioInputStream|AudioOutputStream|오디오장치|

  + 이들은 모두 InputStream 또는 OutputStream의 자손들이며, 각각 읽고 쓰는데 필요한 추상메소드를 자신에 맞게 구현해 놓았다.
  + 자바에서는 java.io 패키지를 통해서 많은 종류의 입출력관련 클래스들을 제공하고 있으며, 입출력을 처리할 수 있는 표준화된 방법을 제공함으로써 입출력의 대상이 달라져도 동일한 방법으로 입출력이 가능하기 때문에 프로그래밍을 하기에 편리하다.

  |InputStream|OutputStream|
  |-----------|------------|
  |abstract int read()|abstract void write(int b)|
  |int read(byte[] b)|void write(byte[] b)|
  |int read(byte[] b, int off, int len)|void write(byte[] b, int off, int len)|

  + InputStream의 read()와 OutputStream의 write(int b)는 입출력의 대상에 따라 읽고 쓰는 방법이 다를 것이기 때문에 각 상황에 알맞게 구현하라는 의미에서 추상메소드로 정의되어 있다.
  + read()와 write(int b)를 제외한 나머지 메소드들은 추상메소드가 아니니까 굳이 추상메소드를 구현하지 않고 이들을 사용하면 될 것이라고 생각할 수도 있겠지만, 나머지 메소드들은 read()와 write(int b)를 이용하여 구현되어 있기 때문에 추상메소드를 구현해야 한다.
  
+ 1.4 보조 스트림
  + 스트림의 기능을 보완하기 위해 보조스트림이 제공되는데, 보조스트림은 실제 데이터를 주고받는 스트림이 아니기 때문에 데이터를 입출력할 수 있는 기능은 없지만, 스트림의 기능을 향상시키거나 새로운 기능을 추가할 수 있다.
  + 보조스트림만으로는 입출력을 처리할 수 없고, 스트림을 먼저 생성한 다음에 이를 이용해서 보조스트림을 생성해야 한다.
  + 모든 보조스트림 역시 InputStream과 OutputStream의 자손들이므로 입출력방법이 같다.

+ 1.5 문자기반 스트림 - Reader, Writer
  + 바이트기반의 스트림은 입출력의 단위가 1byte이다.
  + Java에서는 한 문자를 의미하는 char형이 1byte가 아니라 2byte이기 때문에 바이트기반의 스트림으로 2byte인 문자를 처리하는 데는 어려움이 있다.
  + 이 점을 보완하기 위해서 문자기반의 스트림이 제공된다.
  + InputStream -> Reader, OutputStream -> Writer
  + 보조스트림 역시 문자기반 보조스트림이 존재하며 사용목적과 방식은 바이트기반 보조스트림과 다르지 않다.
 

## 2. 바이트기반 스트림

+ 2.1 InputStream과 OutputStream
  + InputStream과 OutputStream은 모든 바이트기반의 스트림의 조상이다.
  + 프로그램이 종료될 때, 사용하고 닫지 않은 스트림을 JVM이 자동적으로 닫아 주기는 하지만, 스트림을 사용해서 모든 작업을 마치고 난 후에는 close()를 호출해서 반드시 닫아 주어야 한다.
  + ByteArrayInputStream과 같이 메모리를 사용하는 스트림과 System.in, System.out과 같은 표준 입출력 스트림은 닫아 주지 않아도 된다.

+ 2.2 ByteArrayInputStream과 ByteArrayOutputStream
  + ByteArrayInputStream/ByteArrayOutputStream은 메모리, 즉 바이트배열에 데이터를 입출력 하는데 사용되는 스트림이다.
  + 주로 다른 곳에 입출력하기 전에 데이터를 임시로 바이트배열에 담아서 변환 등의 작업을 하는데 사용된다.

+ 2.3 FileInputStream과 FileOutputStream
  + FileInputStream/FileOutputStream은 파일에 입출력을 하기 위한 스트림이다.
  + 실제 프로그래밍에서 많이 사용되는 스트림 중의 하나이다.


## 3. 바이트기반의 보조스트림

+ 3.1 FilterInputStream과 FilterOutputStream
  + FilterInputStream/FilterOutputStream은 InputStream/OutputStream의 자손이면서 모든 보조스트림의 조상이다.
  + 보조스트림은 자체적으로 입출력을 수행할 수 없기 때문에 기반스트림을 필요로 한다.
  + FilterInputStream/FilterOutputStream의 모든 메소드는 단순히 기반스트림의 메소드를 그대로 호출할 뿐이다.
  + FiluterInputStream/FilterOutputStream 자체로는 아무런 일도 하지 않음을 의미한다. 상속을 통해 원하는 작업을 수행하도록 읽고 스는 메소드를 오버라이딩해야 한다.

+ 3.2 BufferedInputStream과 BufferedOutputStream
  + BufferedInputStream/BufferedOutputStream은 스트림의 입출력 효율을 높이기 위해 버퍼를 사용하는 보조스트림이다.
  + 한 바이트씩 입출력하는 것 보다는 버퍼를 이용해서 한 번에 여러 바이트를 입출력하는 것이 빠르기 때문에 대부분의 입출력 작업에 사용된다.
  + BufferedInputStream의 버퍼크기는 입력소스로부터 한 번에 가져올 수 있는 데이터의 크기로 지정하면 좋다.
  + 보통 입력소스가 파일인 경우 8192(8k) 정도의 크기로 하는 것이 보통이다.
  + BufferedOutputStream의 경우 버퍼가 가득 찼을 때만 출력소스에 출력을 하기 때문에, 마지막 출력부분이 출력소스에 쓰이지 못하고 BufferedOutputStream의 버퍼에 남아있는 채로 프로그램이 종료될 수 있다는 점을 주의해야 한다.
  + 그래서 프로그램에서 모든 출력작업을 마친 후 BufferedOutputStream에 close()나 flush()를 호출해서 마지막에 버퍼에 있는 모든 내용이 출력소스에 출력되도록 해야 한다.
  + 보조스트림을 사용한 경우에는 기반스트림의 close()나 flush()를 호출할 필요없이 단순히 보조스트림의 close()를 호출하기만 하면 된다.
 
+ 3.3 DataInputStream과 DataOutputStream
  + DataInputStream/DataOutputStream도 각각 FilterInputStream/FilterOutputStream의 자손이며 DataInputStream은 DataInput인터페이스를, DataOutputStream은 DataOut인터페이스를 각각 구현하였기 때문에, 데이터를 읽고 쓰는데 있어서 byte단위가 아닌, 8가지 기본 자료형의 단위로 읽고 쓸 수 있다는 장점이 있다.
  + 각 자료형의 크기가 다르므로, 출력한 데이터를 다시 읽어 올 때는 출력했을 때의 순서를 염두에 두어야 한다.
 
+ 3.4 SequenceInputStream
  + SequenceInputStream은 여러 개의 입력스트림을 연속적으로 연결해서 하나의 스트림으로부터 데이터를 읽는 것과 같이 처리할 수 있도록 도와준다.
  + SequenceInputStream의 생성자를 제외하고 나머지 작업은 다른 입력스트림과 다르지 않다.
  + SequenceInputStream은 다른 보조스트림들과는 달리 FilterInputStream의 자손이 아닌 InputStream을 바로 상속받아서 구현하였다.

+ 3.5 PrintStream
  + PrintStream은 데이터를 기반스트림에 다양한 형태로 출력할 수 있는 print, println, printf와 같은 메소드를 오버로딩하여 제공한다.


## 4. 문자기반 스트림

+ 4.1 Reader와 Writer
  + 바이트기반 스트림의 조상이 InputStream/OutputStream인 것과 같이 문자기반의 스트림에서는 Reader/Writer가 그와 같은 역할을 한다.
  + Reader/Writer의 메소드는 byte배열 대신 char배열을 사용한다는 것 외에는 InputStream/OutputStream의 메소드와 다르지 않다.

+ 4.2 FileReader와 FileWriter
  + FileReader/FileWriter는 파일로부터 텍스트데이터를 읽고, 파일에 쓰는데 사용된다.

+ 4.3 PipedReader와 PipedWriter
  + PipedReader/PipedWriter는 쓰레드 간에 데이터를 주고받을 때 사용된다.
  + 다른 스트림과는 달리 입력과 출력스트림을 하나의 스트림으로 연결해서 데이터를 주고받는다는 특징이 있다.
  + 스트림을 생성한 다음에 어느 한쪽 쓰레드에서 connect()를 호출해서 입력스트림과 출력스트림을 연결한다. 입출력을 마친 후에는 어느 한쪽 스트림만 닫아도 나머지 스트림은 자동으로 닫힌다.

+ 4.4 StringReader와 StringWriter
  + StringReader/StringWriter는 CharArrayReader/CharArrayWriter와 같이 입출력 대상이 메모리인 스트림이다.
  + StringWriter에 출력되는 데이터는 내부의 StringBuffer에 저장되며 StringWriter의 다음과 같은 메소드를 이용해서 저장된 데이터를 얻을 수 있다.


## 5. 문자기반의 보조스트림

+ 5.1 BufferedReader와 BufferWriter
  + BufferedReader/BufferedWriter는 버퍼를 이용해서 입출력의 효율을 높일 수 있도록 해주는 역할을 한다.
  + 버퍼를 이용하면 입출력의 효율이 비교할 수 없을 정도로 좋아지기 때문에 사용하는 것이 좋다.
  + BufferedReader의 readLine()을 사용하면 데이터를 라인단위로 읽을 수 있고, BufferedWriter는 newLine()이라는 줄바꿈 해주는 메소드를 가지고 있다.
 
+ 5.2 InputStreamReader와 OutputStreamWriter
  + InputStreamReader/OutputStreamWriter는 이름에서 알 수 있는 것과 같이 바이트기반 스트림을 문자기반 스트림으로 연결시켜주는 역할을 한다.


## 6. 표준입출력과 File

+ 6.1 표준입출력 - System.in, System.out, System.err
  + 표준입출력은 콘솔을 통한 데이터 입력과 콘솔로의 데이터 출력을 의미한다.
  + 자바에서는 표준 입출력(standard I/O)을 위한 3가지 입출력 스트림, System.in, System.out, System.err을 제공하는데, 이들은 자바 어플리케이션의 실행과 동시에 사용할 수 있게 자동적으로 생성되기 때문에 개발자가 별도로 스트림을 생성하는 코드를 작성하지 않고도 사용이 가능하다.
  + System.in : 콘솔로부터 데이터를 입력받는데 사용
  + System.out : 콘솔로 데이터를 출력하는데 사용
  + System.err : 콘솔로 데이터를 출력하는데 사용
  + out,err,in의 타입은 InputStream과 PrintStream이지만 실제로는 버퍼를 이용하는 BufferedInputStream과 BufferedOutputStream의 인스턴스를 사용한다.

+ 6.2 표준입출력의 대상변경 - setOut(), setErr(), setIn()
  + 초기에는 System.in, System.out, System.err의 입출력대상이 콘솔화면이지만, setIn(), setOut(), setErr()를 사용하면 입출력을 콘솔 이외에 다른 입출력 대상으로 변경하는 것이 가능하다.

+ 6.3 RandomAccessFile
  + 자바에서는 입력과 출력이 각각 분리되어 별도로 작업을 하도록 설계되어 있는데, RandomAccessFile만은 하나의 클래스로 파일에 대한 입력과 출력을 모두 할 수 있도록 되어 있다.
  + DataInput인터페이스와 DataOutput인터페이스를 모두 구현했기 때문에 읽기와 쓰기가 모두 가능하다.
  + RandomAccessFile클래스도 DataInputStream과 DataOutputStream처럼, 기본자료형 단위로 데이터를 읽고 쓸 수 있다.
  + 가장 큰 장점은 파일의 어느 위치에나 읽기/쓰기가 가능하다는 것이다. 이것을 가능하게 하기 위해서 내부적으로 파일 포인터를 사용하는데, 입출력 시에 작업이 수행되는 곳이 바로 파일 포인터가 위차한 곳이 된다.
