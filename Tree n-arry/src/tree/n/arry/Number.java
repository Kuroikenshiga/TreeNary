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
    
    
    
   
    
    
            
}
