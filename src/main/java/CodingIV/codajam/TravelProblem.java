package CodingIV.codajam;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TravelProblem {

    private Map<Integer, City> graphVertices;
    private List<Road> graphEdges;

    public Map<Integer, City> getGraphVertices() {
        return graphVertices;
    }

    public List<Road> getGraphEdges() {
        return graphEdges;
    }

    private void constructGraphVertices(int numberOfVertices) {
        HashMap<Integer, City> vertices = new HashMap<Integer, City>();

        int i = numberOfVertices;
        while (i > 0) {
            City dummyCity = new City(i);
            vertices.put(i, dummyCity);
        }

        this.graphVertices = vertices;

    }

    private void constructEdge(String[] vertices, String cost) {

        City start = graphVertices.get(Integer.parseInt(vertices[0]));
        City end = graphVertices.get(Integer.parseInt(vertices[1]));

        ArrayList<Integer> roadCost = new ArrayList<Integer>(24);

        String[] costs = cost.split("\\s");
        for (String s : costs) {
            roadCost.add(Integer.parseInt(s));
        }

        Road dummyRoad = new Road(start, end, roadCost);
        start.getRoads().add(dummyRoad);
        end.getRoads().add(dummyRoad);

    }

    public void constructGraphFromFile(String fileName) {

        BufferedReader graphReader = null;
        String line = null;

        try {
            graphReader = new BufferedReader(new FileReader(fileName));
            // handling test cases
            line = graphReader.readLine();
            int numberOfTestCases = -1;
            if (line != null) {
                numberOfTestCases = Integer.parseInt(line);
            }
            if (numberOfTestCases < 0)
                throw new IllegalArgumentException("Please Insert Number of Test Cases as the first Line of the input");

            // building the vertices && edges
            for (int i = 0; i < numberOfTestCases; i++) {

                // reading the N && M && K
                line = graphReader.readLine();
                int numberOfEdges = -1, numberOfQuestion = -1;

                if (line != null) {

                    String[] splits = line.split("\\s");
                    constructGraphVertices(Integer.parseInt(splits[0]));
                    numberOfEdges = Integer.parseInt(splits[1]);
                    numberOfQuestion = Integer.parseInt(splits[2]);

                }

                for (int j = 0; j < numberOfEdges; j++) {

                    String[] vertices = graphReader.readLine().split("\\s");
                    String edgeCost = graphReader.readLine();
                    constructEdge(vertices, edgeCost);
                }

            }
        } catch (IOException ex) {


        } finally {
            try {
                graphReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
