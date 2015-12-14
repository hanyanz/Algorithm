//1.8写一个Fraction类，定义分数的加减乘除，然后编写一个分数的化简方法以及分数的输入输出方法
package com.yanzi.swordOffer;

import java.io.IOException;


public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
      this.numerator = numerator;
      this.denominator = denominator;
    }

    public Fraction(int numerator) {
      this(numerator, 1);
    }

    public static Fraction add(Fraction f1, Fraction f2) {
      Fraction[] fs = RCD(f1, f2);
      Fraction add = new Fraction(fs[0].numerator + fs[1].numerator,
        fs[0].denominator);
      return simpler(add);
    }

    public static Fraction minus(Fraction f1, Fraction f2) {
      Fraction[] fs = RCD(f1, f2);
      Fraction minus = new Fraction(fs[0].numerator - fs[1].numerator,
        fs[0].denominator);
      return simpler(minus);
    }

    public static Fraction multi(Fraction f1, Fraction f2) {
      Fraction multi = new Fraction(f1.numerator * f2.numerator,
      f1.denominator * f2.denominator);
      return simpler(multi);
    }

    public static Fraction div(Fraction f1, Fraction f2) {
      return multi(f1, new Fraction(f2.denominator, f2.numerator));
    }

    public static void input(String s) {
      String[] ss = s.split(" ");
      if (ss.length == 1) {
        Fraction f = StringToFraction(ss[0]);
        if (f == null)
          output("Usage: Should input a numeric");
        else
          output(f);
      } else if (ss.length == 3) {
        Fraction f1 = StringToFraction(ss[0]);
        Fraction f2 = StringToFraction(ss[2]);
        if (f1 == null) {
          output("Usage: The first input should be numeric/numeric");
          return;
        }
        if (f2 == null) {
          output("Usage: The third input should be numeric/numeric");
          return;
        }
        switch (ss[1].charAt(0)) {
        case '+':
          output(add(f1, f2));
          break;
        case '-':
          output(minus(f1, f2));
          break;
        case '*':
          output(multi(f1, f2));
          break;
        case '/':
          output(div(f1, f2));
          break;
        default:
          output("Usage: The second input should be one of +-*/");
          break;
        }
      } else
      output("Usage: Should input one fraction or two fractions and a operator with the style 'f1 + f2'");
    }

    public static void output(Fraction f) {
      if (f.denominator == 1) {
        System.out.println(f.numerator);
        return;
      }
      StringBuilder sb = new StringBuilder();
      sb.append(f.numerator);
      sb.append('/');
      sb.append(f.denominator);
      System.out.println(sb.toString());
    }

    public static void output(String s) {
      System.out.println(s);
    }

    private static Fraction StringToFraction(String s) {
      String[] ss = s.split("/");
      try {
        if (ss.length == 2)
          return simpler(new Fraction(Integer.valueOf(ss[0]), Integer
            .valueOf(ss[1])));
        else if (ss.length == 1)
          return new Fraction(Integer.valueOf(ss[0]));
        else
          return null;
      } catch (NumberFormatException e) {
          output("Usage: Should input one fraction or two fractions and a operator with the style 'f1 + f2'");
      }
      return null;
    }

 /**
  * both the numerator and denominator are divided by GCD
  */
    private static Fraction simpler(Fraction f) {
      int gcd = GCD(f.numerator, f.denominator);
      if (gcd > 1)
        return new Fraction(f.numerator / gcd, f.denominator / gcd);
      else
        return f;
    }

 /**
  * reduction to common denominator
  */
    private static Fraction[] RCD(Fraction f1, Fraction f2) {
      int lcm = LCM(f1.denominator, f2.denominator);
      int m = lcm / f1.denominator;
      if (m > 1)
        f1 = new Fraction(f1.numerator * m, f1.denominator * m);
      m = lcm / f2.denominator;
      if (m > 1)
        f2 = new Fraction(f2.numerator * m, f2.denominator * m);
      return new Fraction[] { f1, f2 };
    }

 /**
  * greatest common divisor最大公约数
  */
    private static int GCD(int s, int b) {
      // s-small,b-big
      if (s > b) {
        int temp = s;
        s = b;
        b = temp;
      }
      while (b != 0) {
        int temp = s % b;
        s = b;
        b = temp;
      }
      return s;
    }

 /**
  * a lowest common multiple最小公倍数
  */
    private static int LCM(int a, int b) {
      return a * b / GCD(a, b);
    }

    public static void main(String[] args) throws IOException {
      int c;
      StringBuilder sb = new StringBuilder();
      while ((c = System.in.read()) != '\n')
        sb.append((char) c);
      input(sb.toString());
      }
}
