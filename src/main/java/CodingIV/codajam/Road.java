package CodingIV.codajam;

import java.util.ArrayList;

/**
 * Created by mustafa on 10.03.16.
 */
public class Road {

    private City start;
    private City end;
    private ArrayList<Integer> cost;

    public Road(City start, City end, ArrayList<Integer> cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;

    }

    public City getStart() {
        return start;
    }

    public void setStart(City start) {
        this.start = start;
    }

    public City getEnd() {
        return end;
    }

    public void setEnd(City end) {
        this.end = end;
    }

    public ArrayList getCost() {
        return cost;
    }

    public void setCost(ArrayList cost) {
        this.cost = cost;
    }
}
