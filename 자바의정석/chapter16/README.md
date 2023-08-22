# 16 네트워킹(Networking)

## 1. 네트워킹(Networking)
+ 네트워킹이란 두 대 이상의 컴퓨터를 케이블로 연결하여 네트워크를 구성하는 것을 말한다.
+ 자바에서는 java.net패키지를 사용하면 네트워크 어플리케이션의 데이터 통신 부분을 쉽게 작성할 수 있다.

+ 1.1 클라이언트/서버(client/server)
  + '클라이언트/서버'는 컴퓨터간의 관계를 역할로 구분하는 개념이다. 서버는 서비스를 제공하는 컴퓨터이고, 클라이언트는 서비스를 사용하는 컴퓨터가 된다.
  + 서버가 서비스를 제공하기 위해서는 서버프로그램이 있어야 하고, 클라이언트가 서비스를 제공받기 위해서는 서버프로그램과 연결할 수 있는 클라이언트 프로그램이 있어야 한다.

+ 1.2 IP주소(IP address)
  + IP주소는 컴퓨터(호스트)를 구별하는데 사용되는 고유한 값으로 인터넷에 연결된 모든 컴퓨터는 IP주소를 갖는다.
  + IP주소는 4 byte(32 bit)의 정수로 구성되어 있으며, 4개의 정수가 마침표를 구분자로 'a.b.c.d'와 같은 형식으로 표현된다.

+ 1.3 InetAddress
  + 자바에서는 IP주소를 다루기 위한 클래스로 InetAddress를 제공한며 다음과 같은 메소드가 정의되어 있다.

  |메소드|설명|
  |------|--------|
  |byte[] getAddress()|IP주소를 byte배열로 반환한다.|
  |static InetAddress[] getAllByName(String host)|도메인명(host)에 지정된 모든 호스트의 IP주소를 배열에 담아 반환한다.|
  |static InetAddress getByAddress(byte[] addr)|byte배열을 통해 IP주소를 얻는다.|
  |String getCanonicalHostName()|FQDN(Fully Qualified Domain Name)을 반환한다.|
  |String getHostAddress()|호스트의 IP주소를 반환한다.|
  |String getHostName()|호스트의 이름을 반환한다.|
  |static InetAddress getLocalHost()|지역호스트의 IP주소를 반환한다.|
  |boolean isMulticastAddress()|IP주소가 멀티캐스트 주소인지 알려준다.|
  |boolean isLoopbackAddress()|IP주소가 loopback 주소(127.0.0.1)인지 알려준다.|
  
+ 1.4 URL(Uniform Resource Locator)
  + URL은 인터넷에 존재하는 여러 서버들이 제공하는 자원에 접근할 수 있는 주소를 표현하기 위한 것으로 '프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조'의 형태로 이루어져 있다.
  + 자바에서는 URL을 다루기 위한 클래스로 URL클래스를 제공한다.

+ 1.5 URLConnection
  + URLConnection은 어플리케이션과 URL간의 통신연결을 나타내는 클래스의 최상위 클래스로 추상클래스이다.
  + URLConnection을 상속받아 구현한 클래스로는 HttpURLConnection과 JarURLConnection이 있으며 URL의 프로토콜이 http프로토콜이라면 openConnection()은 HttpURLConnection을 반환한다.
   

## 2. 소켓 프로그래밍
+ 소켓 프로그래밍은 소켓을 이용한 통신 프로그래밍을 뜻하는데, 소켓(socket)이란 프로세스간의 통신에 사용되는 양쪽 끝단(endpoint)을 의미한다.


+ 2.1 TCP와 UDP
  + TCP/IP 프로토콜은 이기종 시스템간의 통신을 위한 표준 프로토콜로 프로토콜의 집합이다.
  + TCP는 데이터를 전송하기 전에 먼저 상대편과 연결을 한 후에 데이터를 전송하며 잘 전송되었는지 확인하고 전송에 실패했다면 해당 데이터를 재전송하기 때문에 신뢰 있는 데이터의 전송이 요구되는 통신에 적합하다.
  + UDP는 상대편과 연결하지 않고 데이터를 전송하며, 데이터를 전송하지만 데이터가 바르게 수신되었는지 확인하지 않기 때문에 데이터가 전송되었는지 확인할 방법이 없다.



