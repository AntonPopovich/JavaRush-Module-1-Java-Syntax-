import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Files;

public class NIO {
    private static final Path systemMac = Path.of("/System");
    private static final Path systemLinux = Path.of("/bin");
    private static final Path systemWindows = Path.of("c:/windows");

    static Scanner sc = new Scanner(System.in);
    static String input = null;


        public static String readFile() throws IOException {
            // Путь для ввода и чтение
            System.out.println("Введите путь к файлу:");
//            Scanner sc = new Scanner(System.in);
                input = sc.nextLine();
            boolean isPathExist = Files.isRegularFile(Path.of(input));
            while (!isPathExist) {
                System.out.println("Вы ввели несуществующий путь к файлу. Пожалуйста, повторите ввод.");
                input = sc.nextLine();
                isPathExist = Files.isRegularFile(Path.of(input));
            }
//            sc.close();
            Path in = Path.of(input);

            // чтение
            List<String> list = Files.readAllLines(in);
            String a = "";
            for (String str : list) {
                a = a + str;
            }
            return a;
        }
        // Путь для вывода
        public static void createFile (String a) throws IOException {

        System.out.println("Укажите путь к папке для сохранения результата:");
        Scanner scanner = new Scanner(System.in);
        String output = scanner.nextLine();
        boolean isPathExist = Files.isDirectory(Path.of(output));
            while (!isPathExist) {
                System.out.println("Вы ввели несуществующий путь к папке. Пожалуйста, повторите ввод.");
                output = scanner.nextLine();
                isPathExist = Files.isDirectory(Path.of(output));
            }
            int startIndex = input.lastIndexOf('/');
            int endIndex = input.lastIndexOf('.');
            String outputPath = input.substring(startIndex, endIndex);
        System.out.println(outputPath);
        // Проверка сист директорий
        Path out = Path.of(output + outputPath + "-new.txt");
        boolean isOutValidMac = out.startsWith(systemMac);
        boolean isOutValidWin = out.startsWith(systemWindows);
        boolean isOutValidLin = out.startsWith(systemLinux);

            while (isOutValidMac || isOutValidWin || isOutValidLin) {
                System.out.println("Вы пытаетесь сохранить файл в системную директорию! Пожалуйста, измените путь.");
                output = scanner.nextLine();
                out = Path.of(output);
                isOutValidMac = out.startsWith(systemMac);
                isOutValidWin = out.startsWith(systemWindows);
                isOutValidLin = out.startsWith(systemLinux);
        }
        scanner.close();

        Files.writeString(out, a);
            System.out.println("Файл успешно создан!" + "\n" + out);
        }


}
