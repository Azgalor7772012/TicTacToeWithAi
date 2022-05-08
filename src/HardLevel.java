
public class HardLevel {

    public void hardUser() {
        TableInfo table = new TableInfo();
        Checker checker = new Checker();
        //Перед началом печатаем доску
        table.printArea();
        //Играем до логического конца
        while (true) {
            // Генерируем число бота
            hardTurn(TableInfo.getArea());
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
            int[] personInput = checker.checkForDigits();
            // Вносим ход человека в массив
            table.nextTurn(personInput, 'O');
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

    public void userHard() {
        TableInfo table = new TableInfo();
        Checker checker = new Checker();
        //Перед началом печатаем доску
        table.printArea();
        //Играем до логического конца
        while (true) {
            // Просим координаты хода пользователя и проверяем их сразу же
            int[] personInput = checker.checkForDigits();
            // Вносим ход человека в массив
            table.nextTurn(personInput, 'O');
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

            // Генерируем число бота
            hardTurn(TableInfo.getArea());
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

    private int miniMax(boolean isBotTurn, char[][] ourTable) {
        TableInfo table = new TableInfo();
        if (table.oWins(ourTable)) {
            return -1;
        } else if (table.xWins(ourTable)) {
            return 1;
        } else if (table.draw(ourTable)) {
            return 0;
        }

        int bestScore = Integer.MIN_VALUE;
        int worstScore = Integer.MAX_VALUE;


        if (isBotTurn) {
            for (int i = 0; i < ourTable.length; i++) {
                for (int j = 0; j < ourTable[0].length; j++) {
                    if (ourTable[i][j] == ' ') {
                        ourTable[i][j] = 'X';
                        int score = miniMax(false, ourTable);
                        ourTable[i][j] = ' ';
                        bestScore = Math.max(bestScore, score);
                    }
                }
            }
            return bestScore;
        } else {
            for (int i = 0; i < ourTable.length; i++) {
                for (int j = 0; j < ourTable[0].length; j++) {
                    if (ourTable[i][j] == ' ') {
                        ourTable[i][j] = 'O';
                        int score = miniMax(true, ourTable);
                        ourTable[i][j] = ' ';
                        worstScore = Math.min(worstScore, score);
                    }
                }
            }
            return worstScore;
        }
    }

    private void hardTurn(char[][] table) {
        System.out.println("Making move level \"hard\"");
        // Смотрим на свою победу
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = new int[2];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                if (table[i][j] == ' ') {
                    table[i][j] = 'X';
                    int score = miniMax(false, table);
                    table[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }
        TableInfo.getArea()[bestMove[0]][bestMove[1]] = 'X';
    }
}

