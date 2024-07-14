package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public  class IsBiPartite {

    public  static class  edge{
        int src;
        int dest;

        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void CreateGraph(ArrayList<edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1));
        graph[0].add(new edge(0,2));

        graph[1].add(new edge(1,0));
        graph[1].add(new edge(1,3));

        graph[2].add(new edge(2,0));
        graph[2].add(new edge(2,4));

        graph[3].add(new edge(3,1));
        graph[3].add(new edge(3,4));

        graph[4].add(new edge(4,2));
        graph[4].add(new edge(4,3));

    }

    public static boolean isbipartite(ArrayList<edge>[] graph){
        int color[] = new int[graph.length];
        for(int i=0;i<color.length;i++){
            color[i]=-1;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                q.add(i);
                color[i]=0;
                while (!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<graph[curr].size();j++){
                        edge e= graph[curr].get(j);
                        if(color[e.dest]==-1){
                            int nextcolor=(color[curr]==0)?1:0;
                            color[e.dest]=nextcolor;
                            q.add(e.dest);
                        }
                        else if(color[e.dest]==color[curr]){
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }

    public static boolean ispartite(ArrayList<DFS.edge>[] graph){
        if(DetectCycle.detectCycle(graph)){
            if(graph.length-1%2==0){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int v=5;
        ArrayList<edge> graph[]= new ArrayList[v];
        ArrayList<DFS.edge> graph1[]= new ArrayList[v];
        CreateGraph(graph);
        System.out.println(isbipartite(graph));
        System.out.println(ispartite(graph1));

    }
}
