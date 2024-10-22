package Hw2_23001908_VuQuangNam.Ex1;


public class Fraction {
    private float numerator;
    private float denominator;

    public Fraction(float numerator, float denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction c) {
        float num, de;

        if (this.denominator == c.denominator) {
            num = this.numerator + c.numerator;
            de = this.denominator;
            return new Fraction(num, de);
        }

        if (isInt(this.denominator) && isInt(c.denominator) && isInt(this.numerator) && isInt(c.numerator)) {
            de = LCM((int) this.denominator, (int) c.denominator);
            num = (de / this.denominator) * this.numerator + (de / c.denominator) * c.numerator;
            Fraction fraction = new Fraction(num, de);
            return normalize(fraction);
        }

        de = this.denominator * c.denominator;
        num = (this.numerator * c.denominator) + (this.denominator * c.numerator);

        Fraction fraction = new Fraction(num, de);
        return normalize(fraction);
    }


    public Fraction multi(Fraction c) {
        float num = this.numerator * c.numerator;
        float de = this.denominator * c.denominator;
        if (isInt(num) && isInt(de)) {
            Fraction fraction = new Fraction(num, de);
            return normalize(fraction);
        }
        return new Fraction(num, de);
    }


    public Fraction minus(Fraction c) {
        float num, de;

        if (this.denominator == c.denominator) {
            num = this.numerator - c.numerator;
            de = this.denominator;
            return new Fraction(num, de);
        }

        if (isInt(this.numerator) && isInt(this.denominator) && isInt(c.numerator) && isInt(c.denominator)) {
            de = LCM((int) this.denominator, (int) c.denominator);
            num = (de / this.denominator) * this.numerator - (de / c.denominator) * c.numerator;
            return normalize(new Fraction(num, de));
        }

        de = this.denominator * c.denominator;
        num = this.numerator * c.denominator - c.numerator * this.denominator;
        Fraction fraction = new Fraction(num, de);
        return normalize(fraction);
    }


    public Fraction divisor(Fraction c) {
        return multi(new Fraction(c.denominator, c.numerator));
    }

    public Fraction normalize(Fraction c) {
        int sign = (c.denominator > 0) ? 1 : -1;
        float num = c.numerator * sign;
        float de = Math.abs(c.denominator);
        if (isInt(num) && isInt(de)) {
            int gcd = GCD((int) Math.abs(num), (int) de);
            return new Fraction(num / gcd, de / gcd);
        }
        return new Fraction(num, de);
    }

    public float getNumerator() {
        return numerator;
    }

    public float getDenominator() {
        return denominator;
    }

    public int GCD(int x, int y) { // x > y
        if (y == 0) {
            return x;
        }
        return GCD(y, x % y);
    }

    public int LCM(int x, int y) { // x > y
        return x * y / GCD(x, y);
    }

    public boolean isInt(float num) {
        return Math.floor(num) == Math.ceil(num);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
