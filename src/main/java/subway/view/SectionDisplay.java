package subway.view;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class SectionDisplay extends Display {

    private static final String DISPLAY_NAME = "구간 관리 화면";
    private static final String INSERT_SUCCESS_MESSAGE = "구간이 등록되었습니다.";
    private static final String DELETE_SUCCESS_MESSAGE = "구간이 삭제되었습니다.";

    public static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(SectionMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    public static void loadMenu() {
        SectionMenu selectedMenu = null;
        while (selectedMenu != SectionMenu.BACK) {
            printMenu();
            selectedMenu = selectMenu();
            try {
                selectedMenu.executeMenu();
                break;
            } catch (IllegalArgumentException e) {
                printError(e.getMessage());
            }
        }
    }

    private static SectionMenu selectMenu() {
        while (true) {
            try {
                return SectionMenu.getMenuByInput(UserInput.getSelectMenu());
            } catch (NoSuchElementException e) {
                printSelectError();
            }
        }
    }

    public static void printInsertSuccess() {
        printInformation(INSERT_SUCCESS_MESSAGE);
    }

    public static void printDeleteSuccess() {
        printInformation(DELETE_SUCCESS_MESSAGE);
    }
}
