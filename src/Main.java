import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        printMainMenu();

        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();

        if (operation.equals("1")) {
            Encryption.encryption();
        } else if (operation.equals("2")) {
            Decipher.decryption();
        } else if (operation.equals("3")) {
            BruteForce.bruteforce();
        } else {
            System.out.println("Wrong number");
        }
    }

    private static void printMainMenu() {
        System.out.println("""
                Криптоанализ
                Input operation
                1-cipher
                2-decipher
                3-bruteforce
                4-wrong number
                """);
    }

}


