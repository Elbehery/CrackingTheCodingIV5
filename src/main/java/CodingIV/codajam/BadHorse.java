package CodingIV.codajam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class BadHorse {


    public static List<Pair<String, String>> loadInputIntoListOfPairs(List<String> inputList) {

        if (inputList == null)
            throw new NullPointerException();

        if (inputList.size() <= 0)
            throw new IllegalArgumentException();


        ArrayList<Pair<String, String>> parsedInput = new ArrayList<Pair<String, String>>(120);

        for (String input : inputList) {

            String[] splits = input.split("\\s");
            Pair dummyPair = new Pair(splits[0], splits[1]);
            parsedInput.add(dummyPair);
            dummyPair = null;
        }

        return parsedInput;

    }

    public static Map<String, HashSet<String>> createBadHorseLookUp(List<Pair<String, String>> input) {

        if (input == null)
            throw new NullPointerException();


        if (input.size() <= 0)
            throw new IllegalArgumentException();


        Map<String, HashSet<String>> lookup = new HashMap<String, HashSet<String>>();

        for (Pair pair : input) {

            // handling the first name
            if (lookup.containsKey(pair.getL())) {
                lookup.get(pair.getL()).add((String) pair.getR());
            } else {
                HashSet<String> dummySet = new HashSet<String>();
                dummySet.add((String) pair.getR());
                lookup.put((String) pair.getL(), dummySet);
            }

            // handling the second name
            if (lookup.containsKey(pair.getR())) {
                lookup.get(pair.getR()).add((String) pair.getL());
            } else {
                HashSet<String> dummySet = new HashSet<String>();
                dummySet.add((String) pair.getL());
                lookup.put((String) pair.getR(), dummySet);
            }
        }

        return lookup;

    }


    public static boolean validateLeagueSplitting(Map<String, HashSet<String>> lookup, List<Pair<String, String>> input) {

        if (lookup == null || input == null)
            throw new NullPointerException();

        if (lookup.size() <= 0 || input.size() <= 0)
            throw new IllegalArgumentException();


        LinkedList<String> leftLeague = new LinkedList<String>();
        LinkedList<String> rightLeague = new LinkedList<String>();

        for (Pair pair : input) {

            leftLeague.add((String) pair.getL());
            rightLeague.add((String) pair.getR());

        }

        // validation left League
        for (String evil : leftLeague) {
            for (String otherEvil : leftLeague) {
                if (!evil.equals(otherEvil) && lookup.get(evil).contains(otherEvil)) {
                    return false;
                }
            }
        }


        // validation right League
        for (String evil : rightLeague) {
            for (String otherEvil : rightLeague) {
                if (!evil.equals(otherEvil) && lookup.get(evil).contains(otherEvil)) {
                    return false;
                }
            }
        }


        return true;
    }

    public static void readInputFromAFileIntoList(String fileName) {


        LinkedList<String> output = new LinkedList<String>();
        BufferedReader inputBufferedReader = null;
        String inputLine = null;
        int numberOfTestCases = -1;
        int caseCounter = 0;

        try {
            inputBufferedReader = new BufferedReader(new FileReader(fileName));

            inputLine = inputBufferedReader.readLine();
            // validation purpose
            if (inputLine != null) {
                numberOfTestCases = Integer.parseInt(inputLine);
            }

            while ((inputLine = inputBufferedReader.readLine()) != null && caseCounter <= numberOfTestCases) {

                caseCounter++;
                int numberOfPairs = Integer.parseInt(inputLine);

                for (int i = numberOfPairs; i > 0; i--) {
                    inputLine = inputBufferedReader.readLine();
                    if (inputLine != null) {
                        output.add(inputLine);
                    }
                }

                // Testing
                if (output.size() == numberOfPairs) {
                    List<Pair<String, String>> input = loadInputIntoListOfPairs(output);
                    Map<String, HashSet<String>> lookup = createBadHorseLookUp(input);
                    String answer;
                    if(validateLeagueSplitting(lookup, input)){
                        answer = "Yes";
                    }else
                        answer = "No";
                    System.out.println("Case #" + caseCounter + ": " + answer);
                    output.clear();
                }
            }
        } catch (IOException e) {

        } finally {
            try {
                inputBufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {


        String fileName = "/home/mustafa/Downloads/CodeJam/A-small-practice-1.in";
        BadHorse.readInputFromAFileIntoList(fileName);
    }


}
