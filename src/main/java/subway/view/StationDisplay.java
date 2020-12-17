package subway.view;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import subway.domain.Station;

public class StationDisplay extends Display {

    private static final String DISPLAY_NAME = "역 관리 화면";
    private static final String SAVE_SUCCESS_MESSAGE = "지하철 역이 등록되었습니다.";
    private static final String DELETE_SUCCESS_MESSAGE = "지하철 역이 삭제되었습니다.";
    private static final String PRINT_STATIONS_MESSAGE = "역 목록";

    public static void printMenu() {
        printNotice(DISPLAY_NAME);
        Arrays.stream(StationMenu.values()).forEach(menu ->
            System.out.println(menu.getKey() + ". " + menu.getName()));
    }

    public static void loadMenu() {
        StationMenu selectedMenu = null;
        while (selectedMenu != StationMenu.BACK) {
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

    private static StationMenu selectMenu() {
        while (true) {
            try {
                return StationMenu.getMenuByInput(UserInput.getSelectMenu());
            } catch (NoSuchElementException e) {
                printSelectError();
            }
        }
    }

    public static void printSaveSuccess() {
        printInformation(SAVE_SUCCESS_MESSAGE);
    }

    public static void printDeleteSuccess() {
        printInformation(DELETE_SUCCESS_MESSAGE);
    }

    public static void printStations(List<Station> stations) {
        printNotice(PRINT_STATIONS_MESSAGE);
        stations.stream().forEach(station -> System.out.println("[INFO] " + station.getName()));
    }
}
