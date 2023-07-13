class SutdaDeck {
    final int CARD_NUM = 20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];
    SutdaDeck() {
        for(int i=0;i<cards.length;i++){
            int num = i%10+1;
            boolean isKwang = (i<10)&&(num==1 || num ==3||num==8);
            cards[i] = new SutdaCard(num,isKwang);
        }
    }
    void shuffle(){
        SutdaCard temp = null;
        for(int i=0;i<cards.length;i++){
            int num = (int)(Math.random()*cards.length);
            temp = cards[num];
            cards[num]=cards[i];
            cards[i]=temp;
        }
    }

    SutdaCard pick(int index){
        if(index<0 || index>=cards.length)
            return null;
        return cards[index];
    }
    SutdaCard pick(){
        int index = (int)(Math.random()*cards.length);
        return pick(index);
    }
}
class SutdaCard {
    int num;
    boolean isKwang;
    SutdaCard() {
        this(1, true);
    }
    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }
    // info()대신 Object 클래스이  toString()을 오버라이딩했다.
    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}

class Exercise7_2 {
    public static void main(String args[]) {
        SutdaDeck deck = new SutdaDeck();
        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();
        for(int i=0; i < deck.cards.length;i++)
            System.out.print(deck.cards[i]+",");
        System.out.println();
        System.out.println(deck.pick(0));
    }
}