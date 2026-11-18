import java.util.Scanner;

public class PartTime extends  Employee   {
    private  int hours;
    private  double cost;


    Scanner sc = new Scanner(System.in);
    public PartTime(int id, String name, double salary, int age, int hours, double cost) {
        super(id, name, salary, age);
        this.hours = hours;
        this.cost = cost;
    }

    public PartTime(int hours, double cost) {
        this.hours = hours;
        this.cost = cost;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public void display() {


    }

    @Override
    public void save() {



    }
}
