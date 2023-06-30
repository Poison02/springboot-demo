package cdu.zch.demo21mybatisgeneratorpage.pojo;

public class Account {
    private String actno;

    private Double balance;

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno == null ? null : actno.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
}