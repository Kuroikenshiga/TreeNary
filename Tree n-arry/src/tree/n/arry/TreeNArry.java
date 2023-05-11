package tree.n.arry;

public class TreeNArry {
public static void main(String[] args) {

    Tree t = new Tree(new Number(10));
    
    t.insert(new Number(12), 10);
    t.insert(new Number(4), 10);
    t.insert(new Number(3), 10);
    t.insert(new Number(1), 10);
    t.insert(new Number(24), 3);
    t.insert(new Number(18), 3);
    t.insert(new Number(5), 3);
    t.insert(new Number(6), 3);
    
    System.out.println(t.breadthSearch(3).getFirstSon().getValue());
    System.out.println( t.delete(5));
    System.out.println(t.breadthSearch(3).getFirstSon().getBrother().getBrother().getValue());
    
}
    
}
