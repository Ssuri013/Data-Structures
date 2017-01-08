  import java.util.*;

//works only one time if same object needs to be used twice then marked array need to re-initialised

  class DFS{

     LinkedList<Integer>[] adj;
     boolean marked[];
     Graph gr;
     int ver;

     //Graph is passed to perform DFS on
     DFS(Graph g){
       ver = g.ver;
       marked = new boolean[ver];
       adj = g.adj;
     }

     //Default Graph is LOaded, for just the sake of testing
     DFS(){
       gr = new Graph();
       ver = gr.ver;
        marked = new boolean[ver];
       adj = gr.adj;
     }

       void dfs(int x){
         marked[x] = true;
         System.out.println(x);
         for(int i : adj[x]){
           if(!marked[i]){
             dfs(i);
           }
         }
       }

       ArrayList dfsAL(int x, ArrayList arr){
         marked[x] = true;
         arr.add(x);
         for(int i : adj[x]){
           if(!marked[i]){
             arr = dfsAL(i,arr);
           }
         }
         return arr;
       }

   public static void main(String[] args) {
       DFS bf = new DFS();
        bf.dfs(1);
     }

  }
