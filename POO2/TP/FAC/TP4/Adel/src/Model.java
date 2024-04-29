public class Model {
  private int total;
  private int secondNumber;

  public void setOperation(int operation, int number) {
    this.secondNumber = number;
    this.doOperation(operation);
  }

  public void doOperation(int operation) {
    switch (operation) {
      case 1:
        add(secondNumber);
        break;
      case 2:
        sub(secondNumber);
        break;
      case 3:
        mul(secondNumber);
        break;
      case 4:
        div(secondNumber);
        break;
      default:
        break;
    }
  }

  public void resetTotal() {
    this.total = 0;
  }

  public void add(int number) {
    this.total += number;
  }

  public void sub(int number) {
    this.total -= number;
  }

  public void mul(int number) {
    this.total *= number;
  }

  public void div(int number) {
    this.total /= number;
  }

  public int getTotal() {
    return this.total;
  }
}
