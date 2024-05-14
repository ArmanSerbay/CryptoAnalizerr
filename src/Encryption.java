import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Encryption {

    private static final List<Character> ALPHABET = List.of('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я',
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Я',
            '.', ',', '«', '»', ':', '!', '?', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static void encryption() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key");
        int key = scanner.nextInt();
        String inn = "src\\Resources\\astana.txt";
        String out = "src\\Resources\\arman.txt";

        Path inputPath = Paths.get(inn);
        Path outputPath = Paths.get(out);

        List<String> lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
        List<String> encryptedLines = lines.stream()
                .map(line -> encryptedLine(line, key))
                .collect(Collectors.toList());

        Files.write(outputPath, encryptedLines, StandardCharsets.UTF_8);
    }

    private static String encryptedLine(String line, int key) {
        StringBuilder encryptedLine = new StringBuilder();

        for (char symbolForEncryption : line.toCharArray()) {
            if (ALPHABET.contains(symbolForEncryption)) {
                char encryptedChar = encryptChar(symbolForEncryption, key);
                encryptedLine.append(encryptedChar);
            } else {
                encryptedLine.append(symbolForEncryption);
            }
        }
        return encryptedLine.toString();
    }

    private static char encryptChar(char symbolForEncryption, int key) {
        int index;
        int encryptedSymbolIndex = ALPHABET.indexOf(symbolForEncryption) + key;
        if (encryptedSymbolIndex >= ALPHABET.size()) {
            encryptedSymbolIndex = encryptedSymbolIndex - ALPHABET.size();
            Character encryptedSymbol = ALPHABET.get(encryptedSymbolIndex);
            return encryptedSymbol;
        } else {
            Character symbol = ALPHABET.get(encryptedSymbolIndex);
            return symbol;
        }
    }

}




