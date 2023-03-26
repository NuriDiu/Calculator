
import java.util.Scanner;
import java.util.function.*;

public class Calculator {

    Scanner scanner = new Scanner(System.in);

    static Supplier<Calculator> instance = Calculator::new;

    Supplier<Integer> getNumber = () -> {
        System.out.println(" ");
        return scanner.nextInt();
    };

    public BinaryOperator<Integer> add = (a, b) -> a + b;
    public BinaryOperator<Integer> subtract = (a, b) -> a - b;
    public BinaryOperator<Integer> multiply = (a, b) -> a * b;
    public BinaryOperator<Integer> divide = (a, b) -> a / b;
    public UnaryOperator<Integer> power = a -> a * a;
    public UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    public Predicate<Integer> isPositive = a -> a > 0;

    public Consumer<Integer> printResult = result -> System.out.println("Result: " + result);


    // perform calculations
    public void calculate(int num1, int num2) {

        System.out.print("Enter number 1: ");
        num1 = getNumber.get();

        System.out.print("Enter number 2: ");
        num2 = getNumber.get();

        int result1 = add.apply(num1, num2);
        int result2 = subtract.apply(num1, num2);
        int result3 = multiply.apply(num1, num2);
        int result4 = divide.apply(num1, num2);
        int result5 = power.apply(num1);
        int result6 = abs.apply(num1);

        boolean isPositiveResult = isPositive.test(num1);


        // Print out the results
        System.out.println("addition");
        printResult.accept(result1);

        System.out.println("subtraction");
        printResult.accept(result2);

        System.out.println("multiplication");
        printResult.accept(result3);

        System.out.println("division");
        printResult.accept(result4);

        System.out.println("power");
        printResult.accept(result5);

        System.out.println("absolute value");
        printResult.accept(result6);

        System.out.println("Is " + num1 + " positive? " + isPositiveResult);
    }

}