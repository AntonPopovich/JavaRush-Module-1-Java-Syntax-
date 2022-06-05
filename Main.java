import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String encryption = "1";
    public static String decryption = "2";
    public static String bruteForce = "3";

    public static void main(String[] args) {
        System.out.println("Выберите режим работы. \nДля шифрования нажмите - 1, для расшифровки - 2, для bruteForce - 3." +
                "Для выхода нажмите 0.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (true) {
            if (input.equalsIgnoreCase(encryption)) {                       // Шифрование
                System.out.println("запуск метода encryption");
                try {
                    String text = NIO.readFile();
                    int key = Encryption.keyValidation();
                    System.out.println("Шифрование началось. Ожидайте окончания процесса." + "\n" +
                            "Для больших файлов операция может занимать пару минут.");
                    String encryptedText = Encryption.encryption(text, key);
                    System.out.println("Шифрование успешно завершено!");
                    NIO.createFile(encryptedText);

                } catch (ArrayIndexOutOfBoundsException array) {
                    array.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else if (input.equalsIgnoreCase(decryption)) {                // Расшифровка
                System.out.println("запуск метода decryption");
                try {
                    String text = NIO.readFile();
                    int key = Encryption.keyValidation();
                    System.out.println("Расшифровка запущена. Ожидайте окончания процесса." + "\n" +
                            "Для больших файлов операция может занимать пару минут.");
                    String decryptedText = Encryption.decryption(text, key);
                    System.out.println("Расшифровка успешно завершена!");
                    NIO.createFile(decryptedText);

                } catch (ArrayIndexOutOfBoundsException array) {
                    array.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else if (input.equalsIgnoreCase(bruteForce)) {                // BruteForce
                System.out.println("запуск метода bruteForce");
                try {
                    String text = NIO.readFile();
                    System.out.println("Подбор ключа методом \"bruteForce\" запущен. Ожидайте окончания процесса." + "\n" +
                            "Для больших файлов операция может занимать пару минут.");
                    String bruteForcedText = Encryption.bruteForce(text);
                    System.out.println("Подбор ключа методом \"bruteForce\" успешно завершен!");
                    NIO.createFile(bruteForcedText);

                } catch (ArrayIndexOutOfBoundsException array) {
                    array.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else if (input.equals("0"))
                break;
            else {
                System.out.println("Неверно указан режим работы. Пожалуйста, повторите ввод.");
                input = sc.nextLine();
            }
        }
        sc.close();
    }
}

