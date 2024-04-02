import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Decipher {
    private static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');



    public static void decipher() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the key");
        int key = scanner.nextInt();
        String inn = "D:\\IT\\Chifr\\astana.txt";
        String outt = "D:\\IT\\Chifr\\shymkent.txt";


        try (
                FileReader reader = new FileReader(inn);
                FileWriter writer = new FileWriter(outt)) {
            while (reader.ready()) {
                char ch = (char) reader.read();
                List<Character> list = Arrays.asList(Character.valueOf(ch));
                for (Character str : list) {
                    for (Character sym : ALPHABET) {
                        if (str == Character.toUpperCase(str)) {
                            if (Character.toLowerCase(str) == Character.toLowerCase(sym)) {
                                int index = ALPHABET.indexOf(sym) - key;
                                if (index < 0) {
                                    int indexx = index + ALPHABET.size();
                                    Character getSymbol = ALPHABET.get(indexx);
                                    Character gett = Character.toUpperCase(getSymbol);
                                    writer.write(gett);

                                } else  {
                                    Character aa = ALPHABET.get(index);
                                    Character bb = Character.toUpperCase(aa);
                                    writer.write(bb);

                                }
                            }else if(!ALPHABET.contains(Character.toLowerCase(str))) {
                                writer.write(str);
                                break;
                            }
                        }else if (Character.toLowerCase(str) == Character.toLowerCase(sym)) {
                            int indext = ALPHABET.indexOf(sym) - key;
                            if (indext < 0) {
                                int indexx = indext + ALPHABET.size();
                                Character getSymbol = ALPHABET.get(indexx);
                                writer.write(getSymbol);
                            } else {
                                Character aa = ALPHABET.get(indext);
                                writer.write(aa);
                            }


                        }else if(!ALPHABET.contains(str)){
                            writer.write(str);
                            break;
                        }

                    }

                }
            }

        }
    }
}
