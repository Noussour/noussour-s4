public class Bit {
    //* Question 1 :
    private int value;
    
    public Bit(int value) {
        this.value = value;
    }
    
    // Methods
    public int getValue() {
        return value;
    }
    
    public void Inverse() {
        if (this.value == 0) {
            this.value = 1;
        } else {
            this.value = 0;
        }
    }
    
}