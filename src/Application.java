import java.util.Scanner;

public class Application {
    private int a;
    private int b;
    private Scanner scanner = new Scanner(System.in);

    public Application() {
    }

    public Application(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void start() {
        System.out.println("Привет.");
        run();
        System.out.println("Пока.");
    }

    private void run() {
        while (true) {
            Operation operation = selectOperation();
            if (operation == null) {
                break;
            }
            System.out.println("Введите первое число.(целое)");
            a = scanner.nextInt();
            System.out.println("Введите второе число.(целое)");
            b = scanner.nextInt();
            operation.calculate(a, b);
        }
    }

    private Operation selectOperation() {

        showMenu();
        System.out.println("Выберите операцию.");
        int value = scanner.nextInt();
        switch (value) {
            case 1:
                return new Addition();
            case 2:
                return new Subtraction();
            case 3:
                return new Multiplication();
            case 4:
                return new Division();
            case 0:
                return null;
            default:
                System.out.println("Нет такой операции! Повторите ввод.");
                return selectOperation();
        }
    }

    private void showMenu() {
        System.out.println("1 - Сложение.");
        System.out.println("2 - Вычитание.");
        System.out.println("3 - Умножение.");
        System.out.println("4 - Деление.");
        System.out.println("0 - Выход.");
    }
}
