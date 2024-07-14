package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims_Algo {
    static  class  edge{
        int src,dest,wt;
        public edge(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
    }

    public static void createGraph(ArrayList<edge>[] graph){
        for (int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        graph[0].add(new edge(0,1,10));
        graph[0].add(new edge(0,2,15));
        graph[0].add(new edge(0,3,30));

        graph[1].add(new edge(1,0,10));
        graph[1].add(new edge(1,3,40));

        graph[2].add(new edge(2,0,15));
        graph[2].add(new edge(2,3,50));

        graph[3].add( new edge(3,1,40));
        graph[3].add( new edge(3,2,50));
    }

    static class  pair implements  Comparable<pair>{
        int v;
        int cost;
        public  pair(int v,int c){
            this.v=v;
            this.cost=c;
        }
        @Override
        public int compareTo(pair p){
            return  this.cost-p.cost;
        }

    }

    public static void prims(ArrayList<edge>[] graph){
        boolean[] visit= new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(0,0));
        int finalcost=0;
        while(!pq.isEmpty()){
            pair curr= pq.remove();
            if(!visit[curr.v]){
                visit[curr.v]=true;
                finalcost +=curr.cost;

                for (int i=0;i<graph[curr.v].size();i++){
                    edge e = graph[curr.v].get(i);
                    pq.add(new pair(e.dest,e.wt));
                }
            }
        }
        System.out.println(finalcost);
    }


    public static void main(String[] args) {
        int v=4;
        ArrayList<edge>[] graph= new ArrayList[v];
        createGraph(graph);
        prims(graph);
    }

}
