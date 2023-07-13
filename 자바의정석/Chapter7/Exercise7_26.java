class Outer {
    static class Inner {
        int iv=200;
    }
}
class Exercise7_26 {
    public static void main(String[] args) {
        Outer.Inner ic = new Outer.Inner();
        System.out.println(ic.iv);
    }
}