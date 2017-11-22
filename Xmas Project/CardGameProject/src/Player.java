public class Player {

    private String name;
    private int age;
    private double balance;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public Player() {
        this("Unknown", 0, 00.00);
    }


    public Player(String name, int age, double balance) {
        setName(name);
        setAge(age);
        setBalance(balance);
    }


    public String toString() {
        return String.format("%-20s%-20s%-20s%-20d%-20s%f", "Name: ", getName(),
                "\nAge: ", getAge(), "\nBalance: ", getBalance());


    }
}