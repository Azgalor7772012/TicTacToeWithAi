import java.util.InputMismatchException;
import java.util.Scanner;

public class Checker {
    int i;
    int j;

    // Смотрим, чтобы были введены цифры от 0 до 3 и не заняты клетки
    public int[] checkForDigits() {
        Scanner scanner;
//        TableInfo table = new TableInfo();
        while (true) {
            try {
                System.out.println("Enter the coordinates: ");
                scanner = new Scanner(System.in); // Сканнер суем внутрь цила, чтобы избежать зацикливания.
                this.i = scanner.nextInt();
                this.j = scanner.nextInt();
                if (TableInfo.getArea()[i - 1][j - 1] == 'X' || TableInfo.getArea()[i - 1][j - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    break;
                }
                // Проверяем чтобы были только цифры
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                // Проверяем на рендж от 0 до 3
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
        return new int[]{this.i - 1, this.j - 1};
    }
}