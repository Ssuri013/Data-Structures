//returns arraylist of connected vertices
import java.util.*;
class ConnectedComp{

  boolean[]  visited;
  LinkedList<Integer>[] adj;
  Graph gr ;
  ConnectedComp(Graph gra){
    gr = gra;
    visited = new boolean[gr.ver];
    adj = gr.adj;
  }

  ConnectedComp(){
    gr = new Graph();
    adj = gr.adj;
    visited = new boolean[gr.ver];
  }

  ArrayList connected(int x){
    DFS dfs = new DFS(gr);
    return dfs.dfsAL(1, new ArrayList());

  }

  public static void main(String[] args) {
    ConnectedComp co = new ConnectedComp();
    ArrayList arr = co.connected(1) ;
    for(int i=0; i<arr.size(); i++){
      System.out.println(arr.get(i));
    }
  }

}
