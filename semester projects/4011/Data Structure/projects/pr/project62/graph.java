import java.util.*;


class Graph {
    int V;
    LinkedList<Integer>[] adj;

    Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<Integer>();

    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFS(int n) {
        boolean nodes[] = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(n);
        int a = 0;

        while (!stack.empty()) {
            n = stack.peek();
            stack.pop();

            if (nodes[n] == false) {
                System.out.print(n + " ");
                nodes[n] = true;
            }

            for (int i = 0; i < adj[n].size(); i++)
            {
                a = adj[n].get(i);
                if (!nodes[a])
                {
                    stack.push(a);
                }
            }

        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 5);
        g.addEdge(1, 6);
        g.addEdge(1, 2);
        g.addEdge(2, 3);


        System.out.println("Following is the Depth First Traversal");
        System.out.println("derakhte pushaye aval");
        g.DFS(0);
        System.out.println();
        System.out.println("derakhte pushaye dovom");

        g.DFS(1);
        System.out.println();
        System.out.println("derakhte pushaye sevom");

        g.DFS(4);
    }
}