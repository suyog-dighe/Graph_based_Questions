package Graph;

public class LargestSumCycle {
    /*

        public static long largesSumCycle(int N, int Edge[]){
            int[] state = new int[N]; // 0 = unvisited, 1 = visiting, 2 = visited
            int[] entryTime = new int[N]; // to track entry time for each node in the DFS path
            int maxCycleSum = -1;

            for (int i = 0; i < N; i++) {
                if (state[i] == 0) {
                    maxCycleSum = Math.max(maxCycleSum, dfs(i, state, entryTime, Edge, 0));
                }
            }
            return maxCycleSum;
        }

        private  static  int dfs(int node, int[] state, int[] entryTime, int[] Edge, int currentTime) {
            state[node] = 1; // Mark as visiting
            entryTime[node] = currentTime; // Record the entry time
            int nextNode = Edge[node];
            int maxCycleSum = -1;

            if (nextNode != -1) {
                if (state[nextNode] == 0) { // If the next node is unvisited
                    maxCycleSum = Math.max(maxCycleSum, dfs(nextNode, state, entryTime, Edge, currentTime + 1));
                } else if (state[nextNode] == 1) { // If a cycle is detected
                    maxCycleSum = 0;
                    for (int i = nextNode; i != node; i = Edge[i]) {
                        maxCycleSum += i;
                    }
                    maxCycleSum += node;
                }
            }

            state[node] = 2; // Mark as visited
            return maxCycleSum;
        }
        */

    //#########   Approach Second    ##########
   public static long res=-1;

    public static long largesSumCycle2(int N, int Edge[]){

        boolean[] vis=new boolean[N];
        boolean[] pvis=new boolean[N];
        for(int i=0;i<N;i++)
        {
            if(!vis[i])
            {
                dfs2(i,Edge,vis,pvis);
            }
        }
        return res;
    }
    public  static void dfs2(int i,int[] Edge,boolean[] vis,boolean[] pvis )
    {
        vis[i]=true;
        pvis[i]=true;
        if(Edge[i]!=-1)
        {
            int adj=Edge[i];
            if(!vis[adj])
            {
                dfs2(adj,Edge,vis,pvis);
            }
            else if(pvis[adj])
            {
                int curr=adj;
                long s=0;
                do{
                    s+=curr;
                    curr=Edge[curr];
                }while(curr!=adj);
                res=Math.max(res,s);
            }
        }
        pvis[i]=false;

    }



    public static void main(String[] args) {
        int N = 4;
         int Edge[] = {1, 2, 0, -1};
        System.out.println( largesSumCycle2(N,Edge));


    }
   }

