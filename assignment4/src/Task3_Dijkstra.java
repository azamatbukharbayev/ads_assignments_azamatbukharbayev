import java.util.*;

public class Task3_Dijkstra {
    private Map<String, List<String[]>> adjacencyList;

    public Task3_Dijkstra() {
        adjacencyList = new LinkedHashMap<>();
    }

    public void add_vertex(String v) {
        if (!adjacencyList.containsKey(v)) {
            adjacencyList.put(v, new ArrayList<>());
        }
    }

    public void add_edge(String u, String v, int weight) {
        if (!adjacencyList.containsKey(u)) adjacencyList.put(u, new ArrayList<>());
        if (!adjacencyList.containsKey(v)) adjacencyList.put(v, new ArrayList<>());
        adjacencyList.get(u).add(new String[]{v, String.valueOf(weight)});
        adjacencyList.get(v).add(new String[]{u, String.valueOf(weight)});
    }


    public void dijkstra(String source) {
        System.out.println("========================================");
        System.out.println("  Dijkstra's Algorithm from source: " + source);
        System.out.println("========================================\n");


        Map<String, Integer> dist = new HashMap<>();


        Map<String, String> prev = new HashMap<>();


        Set<String> visited = new HashSet<>();


        PriorityQueue<String[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1])
        );


        for (String vertex : adjacencyList.keySet()) {
            dist.put(vertex, Integer.MAX_VALUE);
            prev.put(vertex, null);
        }

        dist.put(source, 0);

        pq.add(new String[]{source, "0"});

        System.out.println("INITIALIZATION:");
        System.out.print("  dist = {");
        printDistMap(dist, source);
        System.out.println("}");
        System.out.println("  pq   = [(" + source + ", 0)]");
        System.out.println();

        int iteration = 1;

        while (!pq.isEmpty()) {
            String[] current = pq.poll();
            String currentNode = current[0];
            int currentDist = Integer.parseInt(current[1]);

            if (visited.contains(currentNode)) {
                continue;
            }

            System.out.println("ITERATION " + iteration + ": Extract " + currentNode
                    + " (distance = " + currentDist + ")");

            visited.add(currentNode);

            List<String[]> neighbors = adjacencyList.get(currentNode);

            for (String[] neighbor : neighbors) {
                String neighborName = neighbor[0];
                int edgeWeight = Integer.parseInt(neighbor[1]);

                if (visited.contains(neighborName)) {
                    System.out.println("  Check " + neighborName
                            + ": already finalized, skip");
                    continue;
                }

                int newDist = currentDist + edgeWeight;

                System.out.print("  Check " + neighborName
                        + ": dist[" + currentNode + "]+" + edgeWeight
                        + " = " + newDist);

                if (newDist < dist.get(neighborName)) {
                    int oldDist = dist.get(neighborName);
                    String oldDistStr = (oldDist == Integer.MAX_VALUE) ? "∞"
                            : String.valueOf(oldDist);

                    System.out.println(" < " + oldDistStr
                            + " → UPDATE dist[" + neighborName + "] = " + newDist
                            + ", prev[" + neighborName + "] = " + currentNode);

                    dist.put(neighborName, newDist);
                    prev.put(neighborName, currentNode);

                    pq.add(new String[]{neighborName, String.valueOf(newDist)});
                } else {
                    System.out.println(" >= " + dist.get(neighborName)
                            + " → no update");
                }
            }

            System.out.print("  dist = {");
            printDistMap(dist, source);
            System.out.println("}");
            System.out.println();

            iteration++;
        }

        System.out.println("========================================");
        System.out.println("  FINAL RESULTS");
        System.out.println("========================================");
        System.out.printf("  %-12s %-10s %-20s%n", "Destination", "Distance", "Path");
        System.out.println("  " + "-".repeat(42));

        List<String> vertices = new ArrayList<>(adjacencyList.keySet());
        Collections.sort(vertices);

        for (String vertex : vertices) {
            int distance = dist.get(vertex);
            String path = reconstructPath(prev, source, vertex);
            System.out.printf("  %-12s %-10d %-20s%n", vertex, distance, path);
        }

        System.out.println("========================================\n");
    }

    private String reconstructPath(Map<String, String> prev, String source, String dest) {
        List<String> path = new ArrayList<>();
        String current = dest;

        while (current != null) {
            path.add(current);
            current = prev.get(current);
        }

        Collections.reverse(path);

        return String.join(" → ", path);
    }


    private void printDistMap(Map<String, Integer> dist, String source) {
        List<String> keys = new ArrayList<>(dist.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            int val = dist.get(key);
            String valStr = (val == Integer.MAX_VALUE) ? "∞" : String.valueOf(val);
            System.out.print(key + ":" + valStr);
            if (i < keys.size() - 1) System.out.print(", ");
        }
    }


    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("  Task 3: Shortest Path (Dijkstra's Algorithm)");
        System.out.println("==============================================\n");

        Task3_Dijkstra graph = new Task3_Dijkstra();
        graph.add_vertex("A");
        graph.add_vertex("B");
        graph.add_vertex("C");
        graph.add_vertex("D");
        graph.add_vertex("E");

        graph.add_edge("B", "A", 2);
        graph.add_edge("C", "B", 11);
        graph.add_edge("D", "C", 6);
        graph.add_edge("E", "B", 14);
        graph.add_edge("B", "D", 12);
        graph.add_edge("E", "A", 8);
        graph.add_edge("C", "E", 7);

        graph.dijkstra("C");
    }
}
