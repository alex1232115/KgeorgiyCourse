package introduction.exceptions;

public class Test {
    public static void main(String[] args) {
        Complex complex = new Complex(2.0, 0.3);
        try {
            complex.divide(null);
        } catch (Throwable e3) {

        }
    }

}
class Complex {
    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    Complex divide(Complex c) {
        try {
            c.divide(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }

        return null;
        //throw new AssertionError("assertion error");
    }
}