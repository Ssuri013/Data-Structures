import java.util.*;

class ReverseGraph{
  int ver;
  int edge=0;
  LinkedList<Integer>[] adj;

   ReverseGraph(int x){
     ver=x;
     adj = new LinkedList[ver];
     for(int i = 0; i < ver; i++){
       adj[i] = new LinkedList<Integer>();
     }
  }


// created to produce a random graph so we dont have to enter edges
  ReverseGraph(){
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
    // 1 = 2 -> 5 -> 3
    // 2 = 5 -> 4
    // 3 = 4
    // 4 = 6
    // 5 = 2 -> 1
    // 6 = 1
    // 7 = null
 }

  void createEdge(int x,int y){
     adj[x].add(y);
     edge++;
  }

  void display(int x){
  //  for( int i : adj[x] ){
      System.out.println(adj[x]);
  //  }
  }

  void reverse(){
      LinkedList<Integer>[] adj_new;
      adj_new = new LinkedList[ver];

      for(int i=0; i < ver; i++){
        for(int j : adj[i]){
          adj_new[j].add(i);
        }
      }
      adj = adj_new;
  }


  public static void main(String args[]){

    ReverseGraph gr = new ReverseGraph();
    gr.reverse();
    }

}
