package Graph;

import java.util.ArrayList;

public class isCycle_DFS {
   static class  edge{
        int src;
        int dest;
        public edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,1));
        //graph[0].add(new edge(0,2));

        graph[1].add(new edge(1,3));

        graph[2].add(new edge(2,0));

        graph[3].add(new edge(3,2));
    }

    public static boolean isCycle(ArrayList<edge>[] graph){
       boolean[] vis= new boolean[graph.length];
       boolean[] stack= new boolean[graph.length];
       for(int i=0;i<graph.length;i++){
           if(!vis[i]){
               if(isCycleUtil(graph,i,vis,stack)){
                   return  true;
               }
           }
       }
       return false;
    }

    public static boolean isCycleUtil(ArrayList<edge>[] graph,int curr, boolean[] visit, boolean[] stack){
       visit[curr]=true;
       stack[curr]=true;

       for (int i=0;i<graph[curr].size();i++){
           edge e= graph[curr].get(i);
           if(stack[e.dest]){
               return true;
           }
           if(!visit[e.dest] && isCycleUtil(graph,e.dest,visit,stack)){
               return true;
           }
       }
       stack[curr]=false;
       return false;
    }

    public static void main(String[] args) {
       int v=4;
       ArrayList<edge> graph[]= new ArrayList[v];
       createGraph(graph);
        System.out.println(isCycle(graph));


    }
}
