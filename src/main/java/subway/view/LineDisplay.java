package subway.view;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;

public class LineDisplay extends Display {
    private static final String DISPLAY_NAME = "노선 관리 화면";
    private static final String SAVE_SUCCESS_MESSAGE = "지하철 노선이 등록되었습니다.";
    private static final String PRINT_STATIONS_MESSAGE = "노선 목록";

    public static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(LineMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    public static void loadMenu() {
        LineMenu selectedMenu = null;
        while (selectedMenu != LineMenu.BACK) {
            printMenu();
            selectedMenu = LineMenu.getMenuByInput(UserInput.getSelectMenu());
            selectedMenu.executeMenu();
        }
    }

    public static void printSaveSuccess() {
        printInformation(SAVE_SUCCESS_MESSAGE);
    }

    public static void printLines(List<Line> lines) {
        printNotice(PRINT_STATIONS_MESSAGE);
        lines.stream().forEach(line -> System.out.println("[INFO] " + line.getName()));
    }
}
