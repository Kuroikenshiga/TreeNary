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
            return breadthSearch(value,this.root);
        }
        
        private Number breadthSearch(int value,Number root){
            if(root.getValue() == value){
                return root;
            }
            if(root.getBrother()!= null){
                Number aux = breadthSearch(value,root.getBrother());
                if(aux != null){
                    return aux;
                }

            }
            if(root.getFirstSon()!= null){
                return breadthSearch(value,root.getFirstSon());
            }
            return null;
    }
        
    public boolean delete(int value){
        return this.delete(value, this.root);
    }
    private boolean delete(int value,Number root){
        boolean sucessDelete = root.removeSon(value);
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
    
    public boolean insert(Number son,int father){
        Number daddy = this.breadthSearch(father);
        if(daddy == null){
            return false;
        }
        daddy.addSon(son);
        return true;
    }
    
}
