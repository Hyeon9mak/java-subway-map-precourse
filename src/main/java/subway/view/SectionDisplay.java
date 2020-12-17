package subway.view;

import java.util.Arrays;

public class SectionDisplay extends Display{
    private static final String DISPLAY_NAME = "구간 관리 화면";
    private static final String INSERT_SUCCESS_MESSAGE = "구간이 등록되었습니다.";

    public static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(SectionMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    public static void loadMenu() {
        SectionMenu selectedMenu = null;
        while (selectedMenu != SectionMenu.BACK) {
            printMenu();
            selectedMenu = SectionMenu.getMenuByInput(UserInput.getSelectMenu());
            selectedMenu.executeMenu();
        }
    }

    public static void printInsertSuccess() {
        printInformation(INSERT_SUCCESS_MESSAGE);
    }
}
