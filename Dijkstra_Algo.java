package Graph;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public   class Dijkstra_Algo {
    static   class  edge{
        int src;
        int dest;
        int wt;
        public edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void CreateGarph(ArrayList<edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new  edge(0,1,2));
        graph[0].add(new  edge(0,2,4));

        graph[1].add(new  edge(1,3,7));
        graph[1].add(new  edge(1,2,1));

        graph[2].add(new  edge(2,4,3));

        graph[3].add(new  edge(3,5,1));

        graph[4].add(new  edge(4,3,2));
        graph[4].add(new  edge(4,5,5));
    }
    static class pair implements Comparable<pair> {
        int n;
        int path;
        public  pair(int n,int path){
            this.n=n;
            this.path=path;
        }
        @Override
        public int compareTo(pair p2){
            return this.path-p2.path; // path based sorting for my pair
        }
    }
    public static  void dijkstra(ArrayList<edge>[] graph,int src){  // TC = V + E log V
        int[] dist= new int[graph.length]; // dist[i] ->src to i
        boolean[] visit=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!= src){
                dist[i]=Integer.MAX_VALUE;  // + infinity;
            }
        }
        PriorityQueue<pair> pq= new PriorityQueue<>();
        pq.add(new pair(src,0));
        while (!pq.isEmpty()){
            pair curr= pq.remove();
            if(!visit[curr.n]){
                visit[curr.n]=true;
                //neighbour
                for(int i=0;i<graph[curr.n].size();i++){
                    edge e= graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int w=e.wt;
                    if(dist[u]+w< dist[v]){// update distance from src to v
                        dist[v]=dist[u]+w;
                        pq.add(new pair(v,dist[v]));
                    }
                }
            }
        }
        // print all source to vertices  shortest distance
        for(int i=0;i<graph.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
  public static void main(String[] args) {
    int v=6;
    ArrayList<edge>[] graph=new ArrayList[v];
    CreateGarph(graph);
    dijkstra(graph,0);
    }
}
