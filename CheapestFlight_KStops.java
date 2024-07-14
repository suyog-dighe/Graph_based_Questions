package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight_KStops {
    public static  class  edge{
        int src, dest,wt;
        public  edge(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
    }

    public static  void  createGraph(ArrayList<edge>[] graph,int flight[][]){
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        for (int i=0;i<flight.length;i++){
            int src=flight[i][0];
            int dest=flight[i][1];
            int wt=flight[i][2];

            edge e= new edge(src,dest,wt);
            graph[src].add(e);
        }
    }

    public static  class info{
        int n ,cost,stops;
        public info(int n,int c,int s){
            this.n=n;
            this.cost=c;
            this.stops=s;
        }
    }

    public static int cheapestFlight(int n ,int[][] flight, int src ,int dest, int k){
        ArrayList<edge>[] graph= new ArrayList[n];
        createGraph(graph,flight);
        int dist[]=new int[n];
        for (int i=0;i<n;i++){
            if (i !=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        Queue<info> q= new LinkedList<>();
        q.add(new info(src,0,0));
        while (!q.isEmpty())
        {
            info curr= q.remove();
            if(curr.stops>k){
                break;
            }
            for(int i=0;i<graph[curr.n].size();i++){
                edge e= graph[curr.n].get(i);

                int u=e.src;
                int v=e.dest;
                int wt=e.wt;
                if(curr.cost+wt<dist[v] && curr.stops <=k){
                    dist[v]=curr.cost+wt;
                    q.add(new info(v,dist[v], curr.stops+1));
                }
            }
        }
        //display distance
        if(dist[dest]==Integer.MAX_VALUE){
            return -1;
        }else{
            return dist[dest];
        }
    }

    public static void main(String[] args) {
        int n=4;
        int src=0;
        int dest=3;
        int k=2;
        int[][] flight={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println( cheapestFlight(n,flight,src,dest,k));

        //if k=2 then ans =400
        //if k=1 then ans =700

    }
}
