import java.util.ArrayList;
import java.util.ListIterator;

public class Graph {
    int V;
    ArrayList<ArrayList<Integer>> adjListArray;
    ArrayList<Integer>size=new ArrayList<>();
    Graph(int V)
    {
        //size graph mara moshakas mikonad ke haman tedade ras ast
        this.V = V;
        adjListArray = new ArrayList<>();

        // har ras mitune be bishomar ras bere pas yek array listi az array listhast

        for (int i = 0; i < V; i++) {
            adjListArray.add(i, new ArrayList<>());
        }
    }

    void addEdge(int src, int dest)
    {
        // pas dadan ras ha be onvane mabda va maghsad
        adjListArray.get(src).add(dest);
        // ezafe kardane ras ha
        //har ras mitune be chandtacha bere
        adjListArray.get(dest).add(src);
    }

    void DFSUtil(int v, boolean[] visited)
    {
        // vaghti roye khode node hastim engar matrix mojaverat true hast
        visited[v] = true;
        size.add(v);
        //System.out.print(v + " ");
        //tamam etesalat ra dor mizanim agar ghablan visit nashode bud dobare inkar ra mikonim
        for (int x : adjListArray.get(v)) {
            if (!visited[x])
                DFSUtil(x, visited);
        }
    }

    //namayeshe matrix mojaverat
    public void toString(int numVertices) {

        System.out.println("The adjacency matrix for the given connected  graph is: ");
        System.out.print("  ");
        for (int i = 0; i < numVertices; i++)
            System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < numVertices; i++)
        {
            System.out.print(i + " ");
            for (int j = 0; j < numVertices; j++)
                if(adjListArray.get(i).contains(j)){
                    System.out.print(1 + " ");

                }
            else{
                    System.out.print(0+ " ");
                }
            System.out.println();
        }
    }
    void connectedComponents()
    {
       //tamam vertex hayi ke visit nashodand ra chap mikonim
        boolean[] visited = new boolean[V];
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                DFSUtil(v, visited);
                toString(size.size());
                size.clear();
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        //tolid graph ba estefade az kelase graph va ezafe kardane methode addEdge
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(2, 1);

        g.addEdge(3, 4);
        g.connectedComponents();
    }

}
