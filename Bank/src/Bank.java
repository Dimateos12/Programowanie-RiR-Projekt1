import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private final double[] accounts;
    private final Lock bankLock = new ReentrantLock();

    public Bank(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }


    public void transfer(int from, int to, double amount)
    {
        bankLock.lock();
        try{
            if(accounts[from] < amount) return;
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f z %d na %d",amount,from,to);
            accounts[to] +=amount;
            System.out.printf("Saldo ogólne: 10%.2f%n",getTotalBalance());
        }
        finally {
            bankLock.unlock();
        }


    }

    private double getTotalBalance() {
        double sum = 0;
        for (double a: accounts) {
            sum +=a;
        }
        return sum;
    }
    public int size(){
        return accounts.length;
    }
}
