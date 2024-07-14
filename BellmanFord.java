package Graph;

import java.util.ArrayList;

public class BellmanFord {
    public static class  edge{
        int src,dest,wt;
        public  edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void createGraph(ArrayList<edge>[] graph){
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();

        }
        graph[0].add(new edge(0,1,2));
        graph[0].add(new edge(0,2,4));

        graph[1].add(new edge(1,2,-4));

        graph[2].add(new edge(2,3,2));

        graph[3].add(new edge(3,4,4));

        graph[4].add(new edge(4,1,-1));
    }



    public static  void bellmanFord(ArrayList<edge>[] graph,int src){
        int[] dist= new int[graph.length];
        for (int i=0;i< dist.length;i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        int V=graph.length;
        for(int i=0;i<V-1;i++){
            //TC = O(E)
            for(int j=0;j<dist.length;j++){
                for (int k=0;k<graph[j].size();k++){
                    edge e= graph[j].get(k);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    // Relaxation
                    if(dist[u] != Integer.MAX_VALUE &&  dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }
        }
        int sum=0;
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
            sum=sum+dist[i];
        }
        System.out.println();
        System.out.println(sum);
    }


    // *************    Using only Edge Not the take Array ************ //

    public static void createGraph2(ArrayList<edge> graph){

        graph.add(new edge(0,1,2));
        graph.add(new edge(0,2,4));
        graph.add(new edge(1,2,-4));
        graph.add(new edge(2,3,2));
        graph.add(new edge(3,4,4));
        graph.add(new edge(4,1,-1));
    }
    public static  void bellmanFord2(ArrayList<edge> graph,int src,int V){
        int[] dist= new int[V];
        for (int i=0;i< dist.length;i++){
            if(i != src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<V-1;i++){
            //TC = O(E)
            for(int j=0;j<graph.size();j++){

                    edge e= graph.get(j);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;
                    // Relaxation
                    if(dist[u] != Integer.MAX_VALUE &&  dist[u]+wt<dist[v]){
                        dist[v]=dist[u]+wt;
                    }
                }
            }

        int sum=0;
        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" ");
            sum=sum+dist[i];
        }
        System.out.println();
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<edge>[] graph= new ArrayList[v];
//        ArrayList<edge> graph= new ArrayList<>();
        createGraph(graph);
        bellmanFord(graph,0);

    }
}
