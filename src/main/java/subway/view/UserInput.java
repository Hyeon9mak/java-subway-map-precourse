package subway.view;

import java.util.Scanner;

public class UserInput extends Display {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getSelectMenu(){
        printNotice("원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }
}
