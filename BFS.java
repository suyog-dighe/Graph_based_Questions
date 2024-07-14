package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    //Breadth First Search
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
        graph[4].add(new edge(4,5,1));

        graph[5].add(new edge(5,3,1));
        graph[5].add(new edge(5,4,1));
        graph[5].add(new edge(5,6,1));

        graph[6].add(new edge(6,5,1));
    }

    static  void bfs(ArrayList<edge> [] graph){
        boolean[]  vis= new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph,vis);
            }
        }
    }
    static  void  bfsUtil(ArrayList<edge>[] graph , boolean[] visit){  // O(n) Time Complexity
        Queue<Integer> q= new LinkedList<>();
//        boolean [] visit= new boolean[graph.length];
        q.add(0);
//        int count=0;

        while (!q.isEmpty()){
            int curr=q.remove();

            if (!visit[curr]){
                System.out.print(curr+" ");

                visit[curr]=true;
                for (int i=0;i<graph[curr].size();i++){
                    edge e= graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    public static void main(String[] args) {
        int v=7;
        ArrayList<edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        bfs(graph);


    }
}
