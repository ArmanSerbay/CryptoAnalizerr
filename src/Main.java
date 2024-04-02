import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws Exception {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Криптоанализ");
            System.out.println("Input operation");
            System.out.println("1-cipher");
            System.out.println("2-decipher");
            String operation = scanner.nextLine();
            if (operation.equals("1")) {
                Encryption.encryption();
            } else if (operation.equals("2")) {

            } else {
                System.out.println("Wrong number");
            }
//        char s = '!';
//        char s2 = Character.toUpperCase('!');
//        System.out.println(s == s2);
        }
    }


