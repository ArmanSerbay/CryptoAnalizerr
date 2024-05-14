import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Decipher {
    private static final List<Character> ALPHABET = List.of('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я',
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Я',
            '.', ',', '«', '»', ':', '!', '?', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static void decryption() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key");
        int key = scanner.nextInt();

        String inn = "src\\Resources\\arman.txt";
        String out = "src\\Resources\\shymkent.txt";

        Path inputPath = Paths.get(inn);
        Path outputPath = Paths.get(out);

        List<String> lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
        List<String> decryptedLines = lines.stream()
                .map(line -> decryptedLine(line, key))
                .collect(Collectors.toList());

        Files.write(outputPath, decryptedLines, StandardCharsets.UTF_8);
    }

    static String decryptedLine(String line, int key) {
        StringBuilder decryptedLine = new StringBuilder();

        for (char symbolForEncryption : line.toCharArray()) {
            if (ALPHABET.contains(symbolForEncryption)) {
                char decryptedChar = decryptChar(symbolForEncryption, key);
                decryptedLine.append(decryptedChar);
            } else {
                decryptedLine.append(symbolForEncryption);
            }
        }
        return decryptedLine.toString();
    }

    private static char decryptChar(char symbolForEncryption, int key) {
        int index;
        int encryptedSymbolIndex = ALPHABET.indexOf(symbolForEncryption) - key;
        if (encryptedSymbolIndex < 0) {
            encryptedSymbolIndex = encryptedSymbolIndex + ALPHABET.size();
            Character decryptedSymbol = ALPHABET.get(encryptedSymbolIndex);
            return decryptedSymbol;
        } else {
            Character symbol = ALPHABET.get(encryptedSymbolIndex);
            return symbol;
        }
    }

}
