package Inherit;

public class Class2 extends ClassInherit implements IClassInterface {
    @Override
    public int add(int a, int b) {
        return super.add(a, b);
    }

    @Override
    public int mod(int a, int b) {
        return a%b;
    }
}
