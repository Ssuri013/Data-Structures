import java.util.*;

public class CycleDetection{
    boolean[]  marked;
    LinkedList<Integer>[] adj;
    boolean cycle = false;

    CycleDetection(Graph gr){
      marked = new boolean[gr.ver];
      adj = gr.adj;
    }

    CycleDetection(){
      Graph gr = new Graph();
      adj = gr.adj;
      marked   = new boolean[gr.ver];
    }



    void cycleDetection(int ch, int par){
      marked[ch] =true;
      for(int x : adj[ch]){
        if(!marked[x]){
          cycleDetection(x,ch);
        }
        else if(x != par){
          cycle = true;
          return;
        }
      }

    }

    boolean hasCycle(){
      cycleDetection(0,-1);
      return cycle;
    }



  public static void main(String[] args) {
    CycleDetection cd = new CycleDetection();//pass graph if already present
    //Pre-defined graph is loaded in this example

    if(cd.hasCycle()){
      System.out.println("Cycle Detected");
    }
    else{
      System.out.println("Cycle Detection Failed");
    }
  }

}
