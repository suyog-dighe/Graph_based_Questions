package Graph;

import java.util.ArrayList;

public class DFS {
    static class  edge{
        int src;
        int dest;
        int wt;
        public  edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static void  CreateGraph(ArrayList<edge> graph[]){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1,1));
        graph[0].add(new edge(0,2,1));

        graph[1].add(new edge(1,0,1));
        graph[1].add(new edge(1,3,1));

        graph[2].add(new edge(2,0,1));
        graph[2].add(new edge(2,4,1));

        graph[3].add(new edge(3,1,1));
        graph[3].add(new edge(3,4,1));
        graph[3].add(new edge(3,5,1));

        graph[4].add(new edge(4,2,1));
        graph[4].add(new edge(4,3,1));
//        graph[4].add(new edge(4,5,1));

        graph[5].add(new edge(5,3,1));
//        graph[5].add(new edge(5,4,1));
        graph[5].add(new edge(5,6,1));

        graph[6].add(new edge(6,5,1));
    }

    static void dfs(ArrayList<edge> [] graph){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i< graph.length;i++){
            if (!vis[i]){
                dfsUtil(graph,i,vis);
            }
        }


    }
    public  static void dfsUtil(ArrayList<edge>[] graph, int curr, boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;
        for (int i=0;i<graph[curr].size();i++){
            edge e= graph[curr].get(i);
            if (!vis[e.dest]){
                dfsUtil(graph,e.dest,vis);
            }
        }
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<edge> graph[] = new ArrayList[v];
        CreateGraph(graph);

        dfsUtil(graph,0,new boolean[v]);
    }
}
