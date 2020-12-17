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

    public static String getStationNameForStart() {
        printNotice("등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getStationNameForEnd(){
        printNotice("등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getLineNameForInsert() {
        printNotice("노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getStationNameForInsert() {
        printNotice("역이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getOrderForInsert() {
        printNotice("순서를 입력하세요.");
        return scanner.nextLine();
    }
}
