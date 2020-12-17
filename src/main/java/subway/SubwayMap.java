package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Order;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.MainDisplay;

public class SubwayMap {

    private SubwayMap() {
        init();
    }

    public static SubwayMap newSubwayMap() {
        return new SubwayMap();
    }

    public void start() {
        MainDisplay.loadMenu();
    }

    private void init() {
        Station 교대역 = Station.newStationWithName("교대역");
        Station 강남역 = Station.newStationWithName("강남역");
        Station 역삼역 = Station.newStationWithName("역삼역");
        Station 남부터미널역 = Station.newStationWithName("남부터미널역");
        Station 양재역 = Station.newStationWithName("양재역");
        Station 양재시민의숲역 = Station.newStationWithName("양재시민의숲역");
        Station 매봉역 = Station.newStationWithName("매봉역");
        StationRepository.addStation(교대역);
        StationRepository.addStation(강남역);
        StationRepository.addStation(역삼역);
        StationRepository.addStation(남부터미널역);
        StationRepository.addStation(양재역);
        StationRepository.addStation(양재시민의숲역);
        StationRepository.addStation(매봉역);

        Line 선2호선 = Line.newLineWithName("2호선");
        Line 선3호선 = Line.newLineWithName("3호선");
        Line 선신분당선 = Line.newLineWithName("신분당선");
        LineRepository.addLine(선2호선);
        LineRepository.addLine(선3호선);
        LineRepository.addLine(선신분당선);

        Section 구간2호선 = Section.newSectionWithLineStations(선2호선, 교대역, 강남역);
        구간2호선.insertStation(역삼역, Order.newOrder("3"));
        Section 구간3호선 = Section.newSectionWithLineStations(선3호선, 교대역, 남부터미널역);
        구간3호선.insertStation(양재역, Order.newOrder("3"));
        구간3호선.insertStation(매봉역, Order.newOrder("4"));
        Section 구간신분당선 = Section.newSectionWithLineStations(선신분당선, 강남역, 양재역);
        구간신분당선.insertStation(양재시민의숲역, Order.newOrder("3"));
        SectionRepository.addSection(구간2호선);
        SectionRepository.addSection(구간3호선);
        SectionRepository.addSection(구간신분당선);
    }
}
