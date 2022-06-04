import java.io.IOException;
import java.util.Scanner;

public class Encryption {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ', '-'};
    private static final int ALPHABET_length = ALPHABET.length;

    public static String encryption(String text, int key) {         // шифровка

        String encryptedText = "";

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < ALPHABET.length; j++) {
                if (Character.toLowerCase(text.charAt(i)) == ALPHABET[j]) {
                    int shiftedKey = j + key;

                    while (shiftedKey > ALPHABET.length - 1) {
                        shiftedKey = shiftedKey - ALPHABET.length;
                    }
                    char encryptedLetter = ALPHABET[shiftedKey];

                    if (Character.isUpperCase(text.charAt(i)))
                        encryptedLetter = Character.toUpperCase(ALPHABET[shiftedKey]);

                    encryptedText = encryptedText + encryptedLetter;
                    break;
                }
            }
        }
        return encryptedText;
    }

    public static String decryption(String text, int key) throws ArrayIndexOutOfBoundsException {    // расшифровка

        String decryptedText = "";

        try {
            for (int i = 0; i < text.length(); i++) {

                for (int j = 0; j < ALPHABET.length + 1; j++) {
                    if (Character.toLowerCase(text.charAt(i)) == ALPHABET[j]) {
                        int shiftedKey = j - key;

                        while (shiftedKey < 0) {
                            shiftedKey = shiftedKey + ALPHABET.length;
                        }
                        char decryptedLetter = ALPHABET[shiftedKey];

                        if (Character.isUpperCase(text.charAt(i)))
                            decryptedLetter = Character.toUpperCase(ALPHABET[shiftedKey]);

                        decryptedText = decryptedText + decryptedLetter;
                        break;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("Предложенный текст не соответствует алфавиту!");
            throw a;
        }
        return decryptedText;
    }


    public static int keyValidation() {
        System.out.println("Введите ключ: ");
        Scanner sc = new Scanner(System.in);
        int key = sc.nextInt();

        while (true) {
            if (key >= 0 && key <= 39)
                break;
            else {
                System.out.println("Неверное значение. Повторите ввод. Убедитесь, что значение соответствует " +
                        "диапазону от 0 до 39.");
                key = sc.nextInt();
            }
        }

        return key;
    }

    public static String bruteForce(String text) throws ArrayIndexOutOfBoundsException {

        String decryptedText = "";
        int shift = 0;
        int maxCount = 0;

        for (int j = 0; j < ALPHABET.length; j++) {

            String iteration = decryption(text, j);
            int count = 0;

            for (int i = 0; i < iteration.length() - 1; i++) {
                char index = iteration.charAt(i);
                char nextIndex = iteration.charAt(i + 1); // '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
                if (index == ' ' && nextIndex != '.' && nextIndex != '-' &&
                        nextIndex != ',' && nextIndex != '«' &&
                        nextIndex != '»' && nextIndex != '"' &&
                        nextIndex != '\'' && nextIndex != ':' &&
                        nextIndex != '!' && nextIndex != '?')
                    count = count + 1;
            }
            if (count > maxCount) {
                maxCount = count;
                shift = j;
            }
        }

        return decryption(text, shift);
    }
}
