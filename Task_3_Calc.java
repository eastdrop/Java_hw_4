/*
3. В калькулятор (урок 1 и 2) добавьте возможность отменить последнюю операцию.
*/
import Model.Calc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class Task_3_Calc {
    public static void main(String[] args) throws IOException {
        Deque s = new ArrayDeque();
        File file = new File("log.txt");
        FileWriter fileWriter = new FileWriter(file, true);
        Scanner scanner = new Scanner(System.in);
        Calc calc = new Calc();
        try {
            while (true) {
                fileWriter = new FileWriter(file, true);
                System.out.println("Че хочешь?");
                String command = scanner.nextLine();
                if (command.equals("calc")){
                    System.out.print("Введите первое число: ");
                    int a = Integer.parseInt(scanner.nextLine());
                    calc.SetItem(a);
                    System.out.print("Введите операцию (+ - * /): ");
                    char op = scanner.nextLine().charAt(0);
                    calc.SetItem(op);
                    System.out.print("Введите второе число: ");
                    int b = Integer.parseInt(scanner.nextLine());
                    calc.SetItem(b);
                    var result = calc.GetValue();
                    System.out.println(a + " " + String.valueOf(op) + " " + b + " = " + result);
                    fileWriter.append(a + " " + String.valueOf(op) + " " + b + " = " + result + '\n');
                    s.add(a + " + " + b + " = " + result);
                    fileWriter.flush();
                    fileWriter.close();
                }
                else if (command.equals("log")){
                    System.out.println(s);
                }
                else if (command.equals("remove")){
                    s.pollLast();
                    System.out.println(s);
                }
                else if (command.equals("exit")) {
                    break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Исключение при работе с файлом." + e.getStackTrace());
            if (fileWriter != null)
            {
                fileWriter.flush();
                fileWriter.close();

            }
        }
    }
}
