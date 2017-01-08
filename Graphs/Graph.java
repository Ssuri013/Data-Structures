import java.util.*;

class Graph{
  int ver;
  int edge=0;
  LinkedList<Integer>[] adj;

   Graph(int x){
     ver=x;
     adj = new LinkedList[ver];
     for(int i = 0; i < ver; i++){
       adj[i] = new LinkedList<Integer>();
     }
  }


// created to produce a random graph so we dont have to enter edges
  Graph(){
    ver=7;
    adj = new LinkedList[ver];
    for(int i=0; i < ver; i++){
      adj[i] = new LinkedList<Integer>();
    }
    createEdge(1,2);
    createEdge(2,5);
    createEdge(1,5);
    createEdge(1,3);
    createEdge(2,4);
    createEdge(6,1);
    createEdge(3,4);
    createEdge(4,6);
    //0 = null
    // 1 = 2 -> 5 -> 3 -> 6
    // 2 = 1 -> 5 -> 4
    // 3 = 1 -> 4
    // 4 = 2 -> 3 -> 6
    // 5 = 2 -> 1
    // 6 = 1 -> 4
    // 7 = null
 }

  void createEdge(int x,int y){
     adj[x].add(y);
     adj[y].add(x);
    edge++;
  }

  void display(int x){
    //for( int i : adj[x] ){
      System.out.println(adj[x]);
      //}
  }
  public static void main(String args[]){

    Graph gr = new Graph(7);
    gr.createEdge(1,2);
    gr.createEdge(2,5);
    gr.createEdge(1,5);
    gr.createEdge(1,3);
    gr.createEdge(2,4);
    gr.display(1);
    }

}
