
public class TableInfo {

    private static char[][] area = new char[3][3];

    public static char[][] getArea() {
        return area;
    }

    // Заполняем массив начальными данными
    public void generateArea() {
        for (char[] item : area) {
            for (int i = 0; i < area[0].length; i++) {
                item[i] = ' ';
            }
        }
    }

    public void printArea() {
        System.out.println("---------");
        System.out.println("|" + " " + area[0][0] + " " + area[0][1] + " " + area[0][2] + " " + "|");
        System.out.println("|" + " " + area[1][0] + " " + area[1][1] + " " + area[1][2] + " " + "|");
        System.out.println("|" + " " + area[2][0] + " " + area[2][1] + " " + area[2][2] + " " + "|");
        System.out.println("---------");
    }


    public void nextTurn(int[] nextStep, char symbol) {
        if (symbol == 'X') {
            area[nextStep[0]][nextStep[1]] = 'X';
        } else {
            area[nextStep[0]][nextStep[1]] = 'O';
        }
    }

    public void nextTurn(int i, int j, char symbol) {
        area[i][j] = symbol;
    }

    public boolean xWins(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            // Победа по горизонтале
            if (table[i][0] == table[i][1] && table[i][0] == table[i][2] && table[i][0] == 'X') {
                return true;
                // Победа по вертикале
            } else if (table[0][i] == table[1][i] && table[0][i] == table[2][i] && table[0][i] == 'X') {
                return true;
                // Победа по диагонале
            } else if (table[0][0] == table[1][1] && table[0][0] == table[2][2] && table[0][0] == 'X') {
                return true;
            } else if (table[2][0] == table[1][1] && table[2][0] == table[0][2] && table[2][0] == 'X') {
                return true;
            }
        }
        return false;
    }

    public boolean oWins(char[][] table) {
        for (int i = 0; i < table.length; i++) {
            // Победа по горизонтале
            if (table[i][0] == table[i][1] && table[i][0] == table[i][2] && table[i][0] == 'O') {
                return true;
                // Победа по вертикале
            } else if (table[0][i] == table[1][i] && table[0][i] == table[2][i] && table[0][i] == 'O') {
                return true;
                // Победа по диагонале
            } else if (table[0][0] == table[1][1] && table[0][0] == table[2][2] && table[0][0] == 'O') {
                return true;
            } else if (table[2][0] == table[1][1] && table[2][0] == table[0][2] && table[2][0] == 'O') {
                return true;
            }
        }
        return false;
    }

    public boolean draw(char[][] table) {
        int cntSymbols = 0;
        for (char[] item : table) {
            for (int i = 0; i < table[0].length; i++) {
                if (item[i] == 'X' || item[i] == 'O') {
                    cntSymbols++;
                }
            }
        }
        if (cntSymbols == 9) {
            return true;
        }
        return false;
    }
}
//        public boolean findCondition() {
//            int cntSymbols = 0;
//            for (int i = 0; i < area.length; i++) {
//                // Победа по горизонтале
//                if (area[i][0] == area[i][1] && area[i][0] == area[i][2] && area[i][0] == 'X') {
//                    System.out.println("X wins");
//                    return true;
//                } else if (area[i][0] == area[i][1] && area[i][0] == area[i][2] && area[i][0] == 'O') {
//                    System.out.println("O wins");
//                    return true;
//                    // Победа по вертикале
//                } else if (area[0][i] == area[1][i] && area[0][i] == area[2][i] && area[0][i] == 'X') {
//                    System.out.println("X wins");
//                    return true;
//                } else if (area[0][i] == area[1][i] && area[0][i] == area[2][i] && area[0][i] == 'O') {
//                    System.out.println("O wins");
//                    return true;
//                    // Победа по диагонале
//                } else if (area[0][0] == area[1][1] && area[0][0] == area[2][2] && area[0][0] == 'X') {
//                    System.out.println("X wins");
//                    return true;
//                } else if (area[0][0] == area[1][1] && area[0][0] == area[2][2] && area[0][0] == 'O') {
//                    System.out.println("O wins");
//                    return true;
//                } else if (area[2][0] == area[1][1] && area[2][0] == area[0][2] && area[2][0] == 'X') {
//                    System.out.println("X wins");
//                    return true;
//                } else if (area[2][0] == area[1][1] && area[2][0] == area[0][2] && area[2][0] == 'O') {
//                    System.out.println("O wins");
//                    return true;
//                }
//            }
//            for (char[] item : area) {
//                for (int i = 0; i < area[0].length; i++) {
//                    if (item[i] == 'X' || item[i] == 'O') {
//                        cntSymbols++;
//                    }
//                }
//            }
//            if (cntSymbols == 9) {
//                System.out.println("Draw");
//                return true;
//            }
//            return false;
//
//        }


