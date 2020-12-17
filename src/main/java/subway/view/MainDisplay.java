package subway.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import subway.domain.Section;

public class MainDisplay extends Display {

    private static final String DISPLAY_NAME = "메인 화면";
    private static final String PRINT_SECTIONS_MESSAGE = "지하철 노선도";
    private static final String INFO_PREFIX = "[INFO] ";

    public static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(MainMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    public static void loadMenu() {
        MainMenu selectedMenu = null;
        while (selectedMenu != MainMenu.QUIT) {
            printMenu();
            selectedMenu = selectMenu();
            selectedMenu.executeMenu();
        }
    }

    private static MainMenu selectMenu() {
        while (true) {
            try {
                return MainMenu.getMenuByInput(UserInput.getSelectMenu());
            } catch (NoSuchElementException e) {
                printSelectError();
            }
        }
    }

    public static void printSections(List<Section> sections) {
        printNotice(PRINT_SECTIONS_MESSAGE);
        sections.stream().forEach(sc -> {
            System.out.println(INFO_PREFIX + sc.getLine().getName());
            System.out.println(INFO_PREFIX + "---");
            sc.getStations().stream().forEach(st ->
                System.out.println(INFO_PREFIX + st.getName()));
            System.out.println();
        });
    }
}
