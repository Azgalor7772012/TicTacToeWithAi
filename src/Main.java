
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TableInfo table = new TableInfo();
        EasyLevel easy = new EasyLevel();
        MediumLevel medium = new MediumLevel();
        HardLevel hard = new HardLevel();

        // Генерируем пустое поле
        table.generateArea();
        String menuChoice;
        do {
            System.out.println("Input command: ");
            menuChoice = scanner.nextLine();
            switch (menuChoice) {
                case "start user easy" :
                    easy.userEasy();
                    break;
                case "start easy user":
                    easy.easyUser();
                    break;
                case  "start easy easy":
                    easy.easyEasy();
                    break;
                case "start user user":
                    easy.userUser();
                    break;
                case "start user medium":
                    medium.userMedium();
                    break;
                case "start medium user":
                    medium.mediumUser();
                    break;
                case "start hard user":
                    hard.hardUser();
                    break;
                case "start user hard":
                    hard.userHard();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Bad parameters!");
            }

        } while (!(menuChoice.equals("exit")));

    }
}
