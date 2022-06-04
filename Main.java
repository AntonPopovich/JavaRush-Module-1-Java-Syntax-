
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String encryption = "шифрование";
    public static String decryption = "расшифровка";
    public static String bruteForce = "bruteForce";

    public static void main(String[] args) {
        System.out.println("Выберите режим работы. Введите слово \"шифрование\", \"расшифровка\" или bruteForce." +
                "Для выхода нажмите 0.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (true) {
            if (input.equalsIgnoreCase(encryption)) {
                System.out.println("запуск метода encryption");
                try {
                    String text = NIO.readFile();
                    int key = Encryption.keyValidation();
                    NIO.createFile(Encryption.encryption(text, key));

                } catch (ArrayIndexOutOfBoundsException array) {
                    array.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else if (input.equalsIgnoreCase(decryption)) {
                System.out.println("запуск метода decryption");
                try {
                    String text = NIO.readFile();
                    int key = Encryption.keyValidation();
                    NIO.createFile(Encryption.decryption(text, key));

                } catch (ArrayIndexOutOfBoundsException array) {
                    array.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            } else if (input.equalsIgnoreCase(bruteForce)) {
                System.out.println("запуск метода bruteForce");
                try {
                    String text = NIO.readFile();
                    NIO.createFile(Encryption.bruteForce(text));

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

