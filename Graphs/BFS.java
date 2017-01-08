import java.util.*;

class BFS{

   LinkedList<Integer>[] adj;
   boolean marked[];
   Graph gr;
   int ver;

   //Graph is passed to perform BFS on
   BFS(Graph g){
     ver = g.ver;
     marked = new boolean[ver];
     adj = g.adj;
   }

   //Default Graph is LOaded, for just the sake of testing
   BFS(){
     gr = new Graph();
     ver = gr.ver;
      marked = new boolean[ver];
     adj = gr.adj;
   }


  //  void bfs(int x){   // different kind of a bfs
  //    Queue<Integer> q = new LinkedList<>();
  //     q.add(x);
   //
  //    for( int i : adj[x]){
  //      if(!marked[i]){
  //      q.add(i);
  //      System.out.println(i + " ");
  //     }
  //   }
   //
  //    while(!q.isEmpty()){
  //      int i = q.poll();
  //      if(!marked[i]){
  //        bfs(i);
  //      }
  //    }
  //  }

  void bfs(int x){//x is not displayed   as bfs of x is needed
    Queue<Integer> q = new LinkedList<>();
     q.add(x);
    while(!q.isEmpty()){
      int temp = q.poll();
      for( int i : adj[temp]){
           if(!marked[i]){
           q.add(i);
           marked[i] = true;
           System.out.println(i);
          }
        }

    }
  }




   void display(int x){
     for( int i : adj[x] ){
       System.out.print(i + " ");
      }
   }

   public static void main(String[] args) {
     BFS bf = new BFS();
     bf.bfs(1);
   }

}
