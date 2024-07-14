package Graph;

import java.util.ArrayList;

public class PrintAllPath {
    static class  edge{
        int src;
        int dest;

        public  edge(int src,int dest){
            this.src=src;
            this.dest=dest;

        }
    }

    public static  void createGraph(ArrayList<edge>[] graph){
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new edge(0,3));

        graph[2].add(new edge(2,3));

        graph[3].add(new edge(3,1));

        graph[4].add(new edge(4,0));
        graph[4].add(new edge(4,1));

        graph[5].add(new edge(5,0));
        graph[5].add(new edge(5,2));
    }

    public  static void findAllPath(ArrayList<edge>[] graph,int src,int dest,String  path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        for(int i=0;i<graph[src].size();i++){
            edge e= graph[src].get(i);
            findAllPath(graph,e.dest,dest,path+src);
        }

    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<edge>[] graph= new ArrayList[v];
        createGraph(graph);
        int src=5,dest=1;
        findAllPath(graph,src,dest,"");

    }
}
