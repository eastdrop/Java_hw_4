package Model;

import java.util.LinkedList;

public class Calc {
    private Integer number1 = null;
    private Integer number2 = null;
    private Character Mark = null;

    public void SetItem(char mark) {
        Mark = mark;
    }

    public void SetItem(int numb) throws Exception {
        if (number1 == null)
            number1 = numb;
        else if (number2 == null)
            number2 = numb;
        else {
            throw new Exception("Все знач введены!");
        }
    }

    public int GetValue() throws Exception {
        if (number2 == null || number1 == null || Mark == null) {
            throw new Exception("Нет данных!");
        }
        int numb1 = number1;
        int numb2 = number2;
        Character m = Mark;
        number1 = number2 = null;
        Mark = null;
        switch (m) {
            case '+':
                return numb1 + numb2;
            case '-':
                return numb1 - numb2;
            case '*':
                return numb1 * numb2;
            case '/':
                return numb1 / numb2;
            default:
                System.out.println("Wrong operation!");
                throw  new Exception("Такого знака нет!");
        }
    }
}
