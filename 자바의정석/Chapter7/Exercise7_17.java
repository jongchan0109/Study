class Unit{
    void move(int x,int y){}
    void stop(){}
}

class Marine extends Unit{ // 보병
    int x, y; // 현재 위치
    void stimPack() { /* 스팀팩을 사용한다.*/}
}
class Tank extends Unit{ // 탱크
    int x, y; // 현재 위치
    void changeMode() { /* 공격모드를 변환한다. */}
}
class Dropship extends Unit{ // 수송선
    int x, y; // 현재 위치
    void load() { /* 선택된 대상을 태운다.*/ }
    void unload() { /* 선택된 대상을 내린다.*/ }
}
public class Exercise7_17 {
}
