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
    //Busca em profundidade
    public Number depthSearch(int value){
        return depthSearch(value, this.root);
    }
    private Number depthSearch(int value,Number root){
        if(root.getValue() == value){
            return root;
        }
        if(root.getFirstSon() != null){
            Number aux = depthSearch(value,root.getFirstSon());
            if(aux != null){
                return aux;
            }
            
        }
        if(root.getBrother() != null){
            return depthSearch(value,root.getBrother());
        }
        return null;
    }
        //Busca em largura
    public Number breadthSearch(int value){
        if(value == this.root.getValue()){
            return root;
        }
        return breadthSearch(value,this.root);
        }
        
    private Number breadthSearch(int value,Number root){
        Number sonAux = recursiveSearchSon(root.getFirstSon(), value);
        
        if(sonAux != null){
            return sonAux;
        }
        if(root.getBrother() != null){
            Number brotherAux = breadthSearch(value, root.getBrother());
            
            if(brotherAux != null){
                return brotherAux;
            }
        }
        if(root.getFirstSon() != null){
            return breadthSearch(value, root.getFirstSon());
        }
        
        return null;
    }
    
    public Number recursiveSearchSon(Number son,int value){
        if(son == null){
            return null;
        }
        if(son.getValue() == value){
            return son;
        }
        return recursiveSearchSon(son.getBrother(), value);
        
    }
   
    public boolean delete(int value){
        return this.delete(value, this.root);
    }
    private boolean delete(int value,Number root){
        if(root.getFirstSon()!=null){
            if(root.getFirstSon().getValue() == value){
                root.setFirstSon(root.getFirstSon().getBrother());
                return true;
        }
        }
        boolean sucessDelete = recursiveRemoveSon(root.getFirstSon(),value);
        if(sucessDelete){
            return true;
        }
        if(root.getBrother() != null){
           boolean sucessDelete2 = this.delete(value, root.getBrother());
           if(sucessDelete2){
               return true;
           }
        }
        if(root.getFirstSon() != null){
            return this.delete(value, root.getFirstSon());
        }
        return false;
    }
    
    public boolean recursiveRemoveSon(Number son,int sonToDelete){
        if(son == null){
            return false;
        }
        if(son.getBrother() == null){
            return false;
        }
        if(son.getBrother().getValue() == sonToDelete){
            son.setBrother(son.getBrother().getBrother());
            return true;
        }
        return recursiveRemoveSon(son.getBrother(), sonToDelete);
    }
    
    public void recursiveAddSon(Number son,Number newestSon){
        if(son.getBrother() == null){
            son.setBrother(newestSon);
        }
        else{
            recursiveAddSon(son.getBrother(), newestSon);
        }
        }
    public boolean insert(Number son,int father){
        Number daddy = this.breadthSearch(father);
        if(daddy == null){
            return false;
        }
        if(daddy.getFirstSon() == null){
            daddy.setFirstSon(son);
            return true;
        }
        recursiveAddSon(daddy.getFirstSon(), son);
        return true;
    }
    
}
