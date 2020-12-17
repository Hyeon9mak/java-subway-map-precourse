package subway.view;

import java.util.Arrays;

public class LineDisplay extends Display {
    private static final String DISPLAY_NAME = "노선 관리 화면";

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
}
