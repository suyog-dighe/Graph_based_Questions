package Graph;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Kruskals_Algo {
    public static  class  edge implements Comparable <edge>{
        int src,dest,wt;
        public edge(int s,int d,int wt){
            this.src=s;
            this.dest=d;
            this.wt=wt;
        }
        public int compareTo(edge e2){
            return this.wt-e2.wt;
        }
    }
    public static void createGraph(ArrayList<edge> edges){
        edges.add(new edge(0,1,10));
        edges.add(new edge(0,2,15));
        edges.add(new edge(0,3,30));
        edges.add(new edge(1,3,40));
        edges.add(new edge(2,3,50));
    }
    static int n=4;
    static int[] par= new int[n];
    static int[] rank= new int[n];

    public static void  init(){
        for (int i=0;i<n;i++){
            par[i]=i;
        }
    }

    public static int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }

    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);

        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        } else if (rank[parA]<rank[parB]) {
            par[parA]=parB;
        }else{
            par[parB]=parA;
        }
    }

    public static void kruskals(ArrayList<edge> edges,int v){
        init();
        Collections.sort(edges);
        int mstcost=0;
        int count=0;
        for (int i=0;count<v-1;i++){
            edge e= edges.get(i);
            int parA=find(e.src);
            int parB=find(e.dest);

            if (parA != parB){
                union(e.src,e.dest);
                mstcost += e.wt;
                count++;
            }
        }
        System.out.println(mstcost);
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<edge> edges= new ArrayList<>();
        createGraph(edges);
        kruskals(edges,v);
    }
}
