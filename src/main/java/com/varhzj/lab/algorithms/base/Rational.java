package com.varhzj.lab.algorithms.base;

import static com.varhzj.lab.algorithms.base.GCD.gcd;

public class Rational {

    private final int numerator;
    private final int denominator;

    public Rational(int numerator, int denominator) {
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public Rational plus(Rational b) {
        int numeratorN = this.numerator * b.denominator + this.denominator * b.numerator;
        int denominatorN = this.denominator * b.denominator;
        return new Rational(numeratorN, denominatorN);
    }

    public Rational minus(Rational b) {
        int numeratorN = this.numerator * b.denominator - this.denominator * b.numerator;
        int denominatorN = this.denominator * b.denominator;
        return new Rational(numeratorN, denominatorN);
    }

    public Rational times(Rational b) {
        int numeratorN = this.numerator * b.numerator;
        int denominatorN = this.denominator * b.denominator;
        return new Rational(numeratorN, denominatorN);
    }

    public Rational divides(Rational b) {
        int numeratorN = this.numerator * b.denominator;
        int denominatorN = this.denominator * b.numerator;
        return new Rational(numeratorN, denominatorN);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Rational) {
            Rational b = (Rational) obj;
            return (this.numerator == b.numerator) && (this.denominator == b.denominator);
        }
        return false;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
