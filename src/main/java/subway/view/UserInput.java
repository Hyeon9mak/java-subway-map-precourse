package subway.view;

import java.util.Scanner;

public class UserInput extends Display {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getSelectMenu(){
        printNotice("원하는 기능을 선택하세요.");
        return scanner.nextLine();
    }

    public static String getStationNameForSave() {
        printNotice("등록할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getLineNameForSave() {
        printNotice("등록할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }
}
