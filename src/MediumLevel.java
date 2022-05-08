
import java.util.Random;

public class MediumLevel {

    public void userMedium() {
        TableInfo table = new TableInfo();
        Checker checker = new Checker();
        //Перед началом печатаем доску
        table.printArea();
        //Играем до логического конца
        while (true) {
            // Просим координаты хода пользователя и проверяем их сразу же
            int[] personInput = checker.checkForDigits();
            // Вносим ход человека в массив
            table.nextTurn(personInput, 'X');
            // Печатаем поле перед проверкой и возможным окончанием игры
            table.printArea();
            // Проверяем есть ли победитель/ничья, если так - заканчиваем
            if (table.xWins(TableInfo.getArea()) ) {
                System.out.println("X wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }
            // Если есть возможность победить / предотвратить победу оппонента - так и делаем, иначе - рандомное число.
            if (mediumTurn()) {
                // Генерируем рандомное число, если победить или не дать победить не выходит
                table.nextTurn(randomTurn(), 'O');
            }
            // Печатаем поле перед проверкой и возможным окончанием игры
            table.printArea();
            // Проверяем есть ли победитель/ничья, если так - заканчиваем
            if (table.oWins(TableInfo.getArea()) ) {
                System.out.println("O wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }
        }
        // Генерируем новое поле
        table.generateArea();
    }

    public void mediumUser() {
        TableInfo table = new TableInfo();
        Checker checker = new Checker();
        //Перед началом печатаем доску
        table.printArea();
        //Играем до логического конца
        while (true) {
            // Если есть возможность победить / предотвратить победу оппонента - так и делаем, иначе - рандомное число.
            if (mediumTurn()) {
                // Генерируем рандомное число, если победить или не дать победить не выходит
                table.nextTurn(randomTurn(), 'O');
            }
            // Печатаем поле перед проверкой и возможным окончанием игры
            table.printArea();
            // Проверяем есть ли победитель/ничья, если так - заканчиваем
            if (table.oWins(TableInfo.getArea()) ) {
                System.out.println("O wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }
            // Просим координаты хода пользователя и проверяем их сразу же
            int[] personInput = checker.checkForDigits();
            // Вносим ход человека в массив
            table.nextTurn(personInput, 'X');
            // Печатаем поле перед проверкой и возможным окончанием игры
            table.printArea();
            // Проверяем есть ли победитель/ничья, если так - заканчиваем
            if (table.xWins(TableInfo.getArea()) ) {
                System.out.println("X wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }

        }
        // Генерируем новое поле
        table.generateArea();
    }

    private boolean mediumTurn() {
        TableInfo table = new TableInfo();
        System.out.println("Making move level \"medium\"");
        // Смотрим на свою победу
        for (int i = 0; i < TableInfo.getArea().length; i++) {
            for (int j = 0; j < TableInfo.getArea()[0].length; j++) {
                if (TableInfo.getArea()[i][j] == ' ') {
                    TableInfo.getArea()[i][j] = 'O';
                    if (table.oWins(TableInfo.getArea())) {
                        table.nextTurn(i, j, 'O');
                        return false;
                    }
                    TableInfo.getArea()[i][j] = ' ';
                }
            }
        }
        // Смотрим на победу игрока
        for (int i = 0; i < TableInfo.getArea().length; i++) {
            for (int j = 0; j < TableInfo.getArea()[0].length; j++) {
                if (TableInfo.getArea()[i][j] == ' ') {
                    TableInfo.getArea()[i][j] = 'X';
                    if (table.xWins(TableInfo.getArea())) {
                        table.nextTurn(i, j, 'O');
                        return false;
                    }
                    TableInfo.getArea()[i][j] = ' ';
                }
            }
        }
        return true;
    }


    public int[] randomTurn() {
        Random random = new Random();
        int i;
        int j;

        do {
            i = random.nextInt(3);
            j = random.nextInt(3);
        } while (TableInfo.getArea()[i][j] == 'X' || TableInfo.getArea()[i][j] == 'O');
        return new int[]{i, j};
    }
}
