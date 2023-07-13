class Outer {
    class Inner {
        int iv=100;
    }
}
class Exercise7_25 {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner ic = o.new Inner();
        System.out.println(ic.iv);
    }
}