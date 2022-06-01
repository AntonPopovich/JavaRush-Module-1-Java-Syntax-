import java.util.Scanner;

public class Encryption {
        private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
                'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

        public static String isPartOfAlphabet(String text, int key) {

            String encryptedText = "";

            for (int i = 0; i < text.length(); i++) {
                for (int j = 0; j < ALPHABET.length; j++) {
                    if (Character.toLowerCase(text.charAt(i)) == ALPHABET[j]) {
                        int shiftedKey = j + key;

                        while (shiftedKey > ALPHABET.length - 1) {
                            shiftedKey = shiftedKey - 40;
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
        sc.close();
        return key;
    }

            //TEST MAIN
            public static void main (String[]args){
                String encryptedText = "МеДвЕдЬ укусил вОрчуна!?:.,«»\'\"";
                String df = "абв";
                int key = keyValidation();

                System.out.println(isPartOfAlphabet(encryptedText, key));
            }

}