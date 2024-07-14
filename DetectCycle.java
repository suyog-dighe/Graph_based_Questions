package Graph;
import java.util.ArrayList;
//********     Detect Cycle Using DFS  in undirected graph  ********** //
public class DetectCycle {
    public static boolean detectCycle(ArrayList<DFS.edge> [] graph){
        boolean visit[]= new  boolean[graph.length];
        for(int i=0;i<graph.length;i++) {
            if (!visit[i]){
                if(detectCycleUtil(graph,visit,i,-1)){
                    return true;
                }
            }
        }
        return  false;
    }
    public static boolean detectCycleUtil(ArrayList<DFS.edge>[]  graph,boolean[] visit,int curr,int par){
        visit[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            DFS.edge e=graph[curr].get(i);
            //case: 1
            if (!visit[i]){
                if(detectCycleUtil(graph,visit,e.dest,curr)){
                    return  true;
                }
            }
            //case :2
            else if(visit[e.dest] && e.dest !=par){
                return true;
            }
            //case 3 : Do nothing only Continue
        }
        return false;
    }
    public static void main(String[] args) {
        int v=7;
        ArrayList<DFS.edge> graph[] = new ArrayList[v];
        DFS.CreateGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
