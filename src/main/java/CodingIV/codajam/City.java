package CodingIV.codajam;

import java.util.List;

/**
 * Created by mustafa on 10.03.16.
 */
public class City {

    private int cityName;
    private List<Road> roads;

    public City(int cityName) {
        this.cityName = cityName;
    }

    public City(int cityName, List<Road> roads) {

        this.cityName = cityName;
        this.roads = roads;
    }

    public int getCityName() {
        return cityName;
    }

    public void setCityName(int cityName) {
        this.cityName = cityName;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }
}
