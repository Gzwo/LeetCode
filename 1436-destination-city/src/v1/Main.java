package v1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> paths;

        paths = new ArrayList<>();
        paths.add(Arrays.asList("London", "New York"));
        paths.add(Arrays.asList("New York", "Lima"));
        paths.add(Arrays.asList("Lima", "Sao Paulo"));
        System.out.println(solution.destCity(paths));

    }
}

class Solution {
    public String destCity(List<List<String>> paths) {
        int N = paths.size();
        Set<String> departures = new HashSet<>(N);
        Set<String> destinations = new HashSet<>(N);
        for (List<String> path : paths) {
            departures.add(path.get(0));
            destinations.add(path.get(1));
        }

        for (String destination : destinations) {
            if (!departures.contains(destination)) {
                return destination;
            }
        }
        return "ERROR";
    }
}