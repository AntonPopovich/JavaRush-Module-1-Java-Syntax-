
/*
Online Java - IDE, Code Editor, Compiler

Online Java is a quick and easy tool that helps you to build, compile, test your programs online.
*/
import java.util.Scanner;

public class Main
{
    public static String encryption = "шифрование";
    public static String decryption = "расшифровка";
    
    public static void main(String[] args) {
        System.out.println("Выберите режим работы. Введите слово шифрование или расшифровка.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        while (true) {
            if (input.equalsIgnoreCase(encryption)) {
                System.out.println("запуск метода encryption");
                break;
            }
            else if (input.equalsIgnoreCase(decryption)) {
                System.out.println("запуск метода decryption");
                break;
            }
            else if (input.equals("0"))
                break;
            else
                System.out.println("Неверно указан режим работы. Пожалуйста, повторите ввод.");
                input = sc.nextLine();
                continue;
        }
        sc.close();
    }
}
