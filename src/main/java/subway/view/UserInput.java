package subway.view;

import java.util.Scanner;

public class UserInput extends Display {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getSelectMenu() {
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

    public static String getStationNameForStartStation() {
        printNotice("등록할 노선의 상행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getStationNameForEndStation() {
        printNotice("등록할 노선의 하행 종점역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getLineNameForInsertSection() {
        printNotice("노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getStationNameForInsertSection() {
        printNotice("역이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getOrderForInsert() {
        printNotice("순서를 입력하세요.");
        return scanner.nextLine();
    }

    public static String getLineNameForDeleteSection() {
        printNotice("삭제할 구간의 노선을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getStationNameForDeleteSection() {
        printNotice("삭제할 구간의 역을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getStationNameForDelete() {
        printNotice("삭제할 역 이름을 입력하세요.");
        return scanner.nextLine();
    }

    public static String getLineNameForDelete() {
        printNotice("삭제할 노선 이름을 입력하세요.");
        return scanner.nextLine();
    }
}
