package lab1;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<String> test = new CompareTwo();
        String a = "12345";
        String b = "1234";
        System.out.println(test.compare(a, b));
        b = "12345";
        System.out.println(test.compare(a, b));
        b = "123451";
        System.out.println(test.compare(a, b));

    }
}