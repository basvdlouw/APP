package han.ica.asd.app.data_structures.non_linear_data_structures.graph.directed;

import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Edge;
import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Graph;
import han.ica.asd.app.data_structures.non_linear_data_structures.graph.Vertex;

import java.util.Arrays;

public class UnweightedDirectedGraph extends Graph {

    public UnweightedDirectedGraph(String[][] schema) {
        super(Weight.UNWEIGHTED);
        createGraph(schema);
    }

    public UnweightedDirectedGraph() {
        super(Weight.UNWEIGHTED);
    }

    @Override
    public void createGraph(String[][] schema) {
        Arrays.stream(schema).forEach(strings -> {
            addVerticesToList(strings);
            vertices.get(strings[0]).addEdge(new Edge(vertices.get(strings[1])));
        });
    }

    @Override
    public void print() {
        vertices.values().forEach(Vertex::printUnweighted);
    }

    public static void main(String[] args) {
        final UnweightedDirectedGraph directedGraph = new UnweightedDirectedGraph(DEFAULT_UNWEIGHTED_SCHEMA);
        directedGraph.print();
        directedGraph.getShortestPath(directedGraph.vertices, "V2", "V4", directedGraph.weighted).print();
        System.out.println("Connected : " + directedGraph.isConnected());
    }
}