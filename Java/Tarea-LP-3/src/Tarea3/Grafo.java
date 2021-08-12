package tarea3;
import java.util.ArrayList;

public interface Grafo{
    int nEdges();
    int nNodes();
    int edgeWeight(int a, int b);
    void addEdge(int a, int b, int c);
    ArrayList<Integer> shortestPath(int a, int b);

}
