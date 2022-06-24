package ru.vsu.cs.course1.graph.demo;

import ru.vsu.cs.course1.graph.Graph;

public class GraphUtils {
    public static int minCycle(Graph graph, int from, int min, int[] count, int[] prev, boolean[] visited) {
        if (visited[from]){
            return min;
        }
        visited[from] = true;
        for(Integer v: graph.adjacencies(from)){
            if (count[v] == 0){
                prev[v] = from;
                count[v] = count[prev[v]] + 1;
                min = minCycle(graph, v, min, count, prev, visited);
            }else{
                if (count[from] - count[v] > 1){
                    int cycleLength = count[from] + 1 - count[v];
                    min = cycleLength < min ? cycleLength : min;
                }
            }
        }

        return min;
    }
}
