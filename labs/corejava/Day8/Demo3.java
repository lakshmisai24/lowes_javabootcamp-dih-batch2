package Day8;

class InsufficientAmtException extends Exception {
    public InsufficientAmtException() {
        System.out.println("Amount is Insufficient");
    }

    public InsufficientAmtException(String message) {
        System.out.println("Amount is Insufficient");
    }

}

class Bank {

    public int amount;
    public int balance;

    public Bank() {
        this.amount = amount;
        this.balance = balance;
    }

    public int deposit(int amount) {
        return amount;

    }

    public int withdraw(int balance) throws InsufficientAmtException {
        if (balance < amount) {
            throw new InsufficientAmtException();
        }
        else
            System.out.println(balance);
        return balance;
    }
}

public class Demo3 {
    public static void main(String[] args) {
        Bank bk = new Bank();
        bk.amount = 5000;
        bk.balance = 10000;

        bk.deposit(2000);
        try {
            bk.withdraw(15000);
        } catch (InsufficientAmtException e) {

        }
    }
}
