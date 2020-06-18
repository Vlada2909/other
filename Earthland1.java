package projects;
import java.util.*;
public class Earthland1 {
    static List<Integer> graph[], revGraph[];
    static boolean visited[];
    static int parent[];
    public static void main(String args[])throws Exception
    {
        int n = 0,m,t,u,v;    // n - number of rooms, m - number of connections between rooms
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while(t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            graph = new List[n];
            revGraph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Integer>();
                revGraph[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < m; i++) {
                //way from room u to room v
                u = scanner.nextInt() - 1;
                v = scanner.nextInt() - 1;
                graph[u].add(v);
                revGraph[v].add(u);
            }
            visited = new boolean[n];
            parent = new int[n];
            Arrays.fill(parent, -1);
            int friends = 0;
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited, false);
                if (!path(i)) {
                    friends ++;
                }
            }
            System.out.println(friends - 1);
        }
    }
    public static boolean path(int index) {
        for(int i=revGraph[index].size()-1;i>=0;i--) {
            int p = revGraph[index].get(i);
            if(!visited[p]) {
                visited[p] = true;
                if(parent[p] < 0 || path(parent[p])) {
                    parent[p] = index;
                    return true;
                }
            }
        }
        return false;
    }
}
