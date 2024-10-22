package Hw2_23001908_VuQuangNam.Ex1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of fractions: ");
        int n = sc.nextInt();

        ListNodeFraction listNodeFraction = new ListNodeFraction();
        System.out.println("\nEnter a pair consisting of a numerator and a denominator:");
        for (int i = 0; i < n; i++) {
            float num = sc.nextFloat();
            float de = sc.nextFloat();
            if (de == 0) {
                System.out.println("denominator is greater than 0!!!");
                System.out.println("Enter denominator again");
                de = sc.nextFloat();
            }
            listNodeFraction.add(new Node(new Fraction(num, de)));
        }
        printList(listNodeFraction);

        System.out.print("\nEnter the index of Fraction ");
        int v = sc.nextInt();
        while (listNodeFraction.checkOutOfRange(v - 1)) {
            System.out.print("\nPosition outside the set, enter again: ");
            v = sc.nextInt();
        }
        System.out.println("\nFraction " + v + " : " + listNodeFraction.getFractionAtIndex(v - 1));

        sumAll(listNodeFraction);
        multiplyAll(listNodeFraction);
        subtractAll(listNodeFraction);
        divideAll(listNodeFraction);
    }

    public static void printList(ListNodeFraction listNodeFraction) {
        MyIterator it = listNodeFraction.iterator();
        while (it.hasNext()) {
            System.out.print(it.next().toString() + " ");
        }
    }

    public static void sumAll(ListNodeFraction listNodeFraction) {
        MyIterator it = listNodeFraction.iterator();
        Fraction fraction = it.next();
        while (it.hasNext()) {
            fraction = fraction.add(it.next());
        }
        System.out.println("Sum of all fractions: " + fraction);
    }

    public static void multiplyAll(ListNodeFraction listNodeFraction) {
        MyIterator it = listNodeFraction.iterator();
        Fraction fraction = it.next();
        while (it.hasNext()) {
            fraction = fraction.multi(it.next());
        }
        System.out.println("Product of all fractions: " + fraction);
    }

    public static void subtractAll(ListNodeFraction listNodeFraction) {
        MyIterator it = listNodeFraction.iterator();
        Fraction fraction = it.next();
        while (it.hasNext()) {
            fraction = fraction.minus(it.next());
        }
        System.out.println("Difference of all fractions: " + fraction);
    }

    public static void divideAll(ListNodeFraction listNodeFraction) {
        MyIterator it = listNodeFraction.iterator();
        Fraction fraction = it.next();
        while (it.hasNext()) {
            fraction = fraction.divisor(it.next());
        }
        System.out.println("Quotient of all fractions: " + fraction);
    }
}
