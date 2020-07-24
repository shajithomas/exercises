import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Node {

  public String name;
  public List<Node> children;
 
  /* create a method to return a list of all of a node's 
      descendants */
/*
public List<Node> listNodes() {
    List <Node> childList = getChildren(this);
    Iterator iterator = children.listIterator();
    while ( iterator.hasnext()) {
        Node child = iterator.get();
        Iterator it = child.iterator();
        while ( it.hasNext() ){
            childList.add()
        }
        childList.add(getChildren(child);
    }
    return childList;
}
*/
private List<Node> getChildren(Node node){
    List<Node> childList = new ArrayList<>();
    ListIterator iterator = node.children.listIterator();
    while ( iterator.hasNext()) {
        childList.addAll(getChildren(((Node)iterator.next())));
    }
    return childList;
        
    }
}