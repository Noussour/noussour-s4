package EXO3;

public class Bit {
    char bit;

    public Bit(char bit){
        this.bit = bit;
    }


    public void invert() {
        this.bit = (this.bit == '0') ? '1' : '0';
    }

    @Override
    public String toString() {
        return String.valueOf(this.bit);
    }
}
