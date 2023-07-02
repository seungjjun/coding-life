import java.util.Objects;

public class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(Complex complex) {
        return new Complex(re + complex.re, im  + complex.im);
    }

    public Complex minus(Complex complex) {
        return new Complex(re - complex.re, im - complex.im);
    }

    public Complex times(Complex complex) {
        return new Complex(
            re * complex.re - im * complex.im,
            re * complex.re + im * complex.im);
    }

    public Complex dividedBy(Complex complex) {
        double temp = complex.re * complex.re + complex.im * complex.im;
        return new Complex(
            (re * complex.re + im * complex.im) / temp,
            (im * complex.re - re * complex.im) / temp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.re, re) == 0 && Double.compare(complex.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }

    @Override
    public String toString() {
        return "Complex{" +
            "re=" + re +
            ", im=" + im +
            '}';
    }
}
