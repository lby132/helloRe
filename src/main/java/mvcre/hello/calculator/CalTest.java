package mvcre.hello.calculator;

import java.util.Scanner;

public class CalTest {


    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);

        System.out.println("숫자를 입력하세요");
        final String sc1 = sc.next();

        System.out.println("사칙 연산을 입력하세요");
        final String op = sc.next();

        System.out.println("숫자를 입력하세요");
        final String sc2 = sc.next();

        int num1 = Integer.parseInt(sc1);
        int num2 = Integer.parseInt(sc2);
        int num3;

        if (op.equals("+")) {
            num3 = num1 + num2;
        } else if (op.equals("*")) {
            num3 = num1 * num2;
        } else if (op.equals("/")) {
            num3 = num1 / num2;
        } else if (op.equals("-")) {
            num3 = num1 - num2;
        } else {
            System.out.println("올바르지 않은 사칙연산 입니다.");
            return;
        }

        System.out.println(num1 + op + num2 + "=" + num3);
    }
}