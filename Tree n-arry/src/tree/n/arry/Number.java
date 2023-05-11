package tree.n.arry;

public class Number {
    
    Number(int n){
        this.value = n;
    }
    
    private int value;
    private Number firstSon;
    private Number brother;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Number getFirstSon() {
        return firstSon;
    }

    public void setFirstSon(Number firstSon) {
        this.firstSon = firstSon;
    }

    public Number getBrother() {
        return brother;
    }

    public void setBrother(Number brother) {
        this.brother = brother;
    }
    
    public void addSon(Number son){
        if(this.firstSon == null){
            this.firstSon = son;
        }
        else{
            addSon(son, this.firstSon);
    }
    }
    
    private void addSon(Number son,Number brother){
       
            if(brother.brother == null){
                brother.brother = son;
            }
            else{
                addSon(son, brother.brother);
            }
        }
    public boolean removeSon(int value){
        if(this.firstSon == null){
            return false;
        }
        if(this.firstSon.value == value){
            this.firstSon = this.firstSon.brother;
            return true;
        }
        return removeSon(value, this.firstSon);
    }
    private boolean removeSon(int value,Number first){
        if(first.brother == null){
            return false;
        }
        if(first.brother.value == value){
            first.brother = first.brother.brother;
            return true;
        }
        return removeSon(value, first.brother);
       
    }
    
            
}
