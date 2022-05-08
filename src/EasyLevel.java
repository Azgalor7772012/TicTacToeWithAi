
import java.util.Random;

public class EasyLevel {

    public void userEasy() {
        TableInfo table = new TableInfo();
        Checker checker = new Checker();
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
            if (table.xWins(TableInfo.getArea())) {
                System.out.println("X Wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }
            // Находим рандомные координаты
            int[] coordinatesBot1 = randomTurn();
            //Записываем в таблицу новое значение
            table.nextTurn(coordinatesBot1, 'O');
            //Печатаем таблицу перед оценкой и завершением цикла
            table.printArea();
            //Если есть ничья/выигрыш - выходим из цикла
            if (table.oWins(TableInfo.getArea())) {
                System.out.println("O wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }
        }
        // Генерируем новое поле
        table.generateArea();
        // Устанавливаем значение для конца игры по умолчанию
    }

    public void easyUser() {
        TableInfo table = new TableInfo();
        Checker checker = new Checker();
        table.printArea();
        // Играем до логического конца
        while (true) {
            // Находим рандомные координаты
            int[] coordinatesBot1 = randomTurn();
            //Записываем в таблицу новое значение
            table.nextTurn(coordinatesBot1, 'X');
            //Печатаем таблицу перед оценкой и завершением цикла
            table.printArea();
            //Оцениваем на результат
            //Если есть ничья/выигрыш - выходим из цикла
            if (table.xWins(TableInfo.getArea())) {
                System.out.println("X wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }
            // Просим координаты хода пользователя
            int[] personInput = checker.checkForDigits();
            // Вносим ход человека в массив
            table.nextTurn(personInput, 'O');
            table.printArea();
            // Вносим ход компьютера
            //Печатаем таблицу снова
            if (table.oWins(TableInfo.getArea())) {
                System.out.println("O wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }
        }
        // Генерируем новое поле
        table.generateArea();
        // Устанавливаем значение для конца игры по умолчанию
    }

    public void easyEasy() {
        TableInfo table = new TableInfo();
        //Печатаем пустое поле
        table.printArea();

        //Запускаем цикл до логичного конца игры
        while (true) {
            // Первый бот делает ход
            // Находим рандомные координаты
            int[] coordinatesBot1 = randomTurn();
            //Записываем в таблицу новое значение
            table.nextTurn(coordinatesBot1, 'X');
            //Печатаем таблицу перед оценкой и завершением цикла
            table.printArea();
            //Если есть ничья/выигрыш - выходим из цикла
            if (table.xWins(TableInfo.getArea())) {
                System.out.println("X wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }
            // Второй  бот делает ход
            // Находим рандомные координаты
            int[] coordinatesBot2 = randomTurn();
            //Записываем в таблицу новое значение
            table.nextTurn(coordinatesBot2, 'O');
            //Печатаем таблицу перед оценкой и завершением цикла
            table.printArea();
            //Если есть ничья/выигрыш - выходим из цикла
            if (table.oWins(TableInfo.getArea())) {
                System.out.println("O wins");
                break;
            } else if (table.draw(TableInfo.getArea())) {
                System.out.println("Draw");
                break;
            }
        }
        // Генерируем новое поле
        table.generateArea();
        // Устанавливаем значение для конца игры по умолчанию
    }

    public void userUser() {
        TableInfo table = new TableInfo();
        Checker checker = new Checker();
        table.printArea();
        //Играем до логического конца
        while (true) {
            // Просим координаты хода пользователя и проверяем их сразу же
            int[] firstPersonInput = checker.checkForDigits();
            // Вносим ход человека в массив
            table.nextTurn(firstPersonInput, 'X');
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
            // Просим координаты хода пользователя и проверяем их сразу же
            int[] secondPersonInput = checker.checkForDigits();
            // Вносим ход человека в массив
            table.nextTurn(secondPersonInput, 'O');
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
        // Устанавливаем значение для конца игры по умолчанию
    }

    public int[] randomTurn() {
        System.out.println("Making move level \"easy\"");
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

