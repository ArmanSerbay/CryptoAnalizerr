import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BruteForce {
    private static final List<String> frequentWordsRepository = Arrays.asList("им", "их", "из", "он", "она", "они", "оно", "мы", "вы", "тот", "этот",
            "но", "на", "или", "быть", "делать", "идти", "себя", "свой", "этот", "мой", "ваш", "как", "так", "чтобы", "потому что", "поскольку", "также", "том", "там",
            "ними", "через", "над", "под", "за", "не", "нет", "да", "уже", "как", "когда", "где", "что", "ей", "по");
    private static final List<Character> ALPHABET = List.of('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я',
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Я',
            '.', ',', '«', '»', ':', '!', '?', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');


    public static void bruteforce() throws IOException {
        for (int key = 0; key < 11; key++) {

            String inn = "src\\Resources\\arman.txt";
            String out = "src\\Resources\\bruteforce.txt";


            Path inputPath = Paths.get(inn);
            Path outputPath = Paths.get(out);

            List<String> lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
            int finalKey = key;
            List<String> decryptedLines = lines.stream()
                    .map(line -> Decipher.decryptedLine(line, finalKey))
                    .collect(Collectors.toList());

            Files.write(outputPath, decryptedLines, StandardCharsets.UTF_8);

            List<String> outlines = Files.readAllLines(outputPath, StandardCharsets.UTF_8);
            for (String line : outlines) {
                String[] words = line.split(" "); // Разделить строку на слова по пробелам
                for (String word : words) {
                    for (int i = 0; i < frequentWordsRepository.size(); i++) {
                        if (word.equals(frequentWordsRepository.get(i))) {
                            System.out.println(finalKey);
                        }
                    }
                }
            }
        }
    }

    private static String decryptedLine(String line, int key) {
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




