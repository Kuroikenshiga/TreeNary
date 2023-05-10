package tree.n.arry;

public class Tree {
    
    private Number root;
    Tree(Number n){
        this.root = n;
    }
    public boolean isEmpty(){
        if(this.root == null){
            return true;
        }
        return false;
    }
    
    public Number search(int value){
        return search(value, this.root);
    }
    private Number search(int value,Number root){
        if(root.getValue() == value){
            return root;
        }
        if(root.getFirstSon() != null){
            Number aux = search(value,root.getFirstSon());
            if(aux != null){
                return aux;
            }
            
        }
        if(root.getBrother() != null){
            return search(value,root.getBrother());
        }
        return null;
    }
    
    public boolean insert(Number son,int father){
        Number daddy = this.search(father);
        if(daddy == null){
            return false;
        }
        daddy.addSon(son);
        return true;
    }
    
}
