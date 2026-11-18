import java.util.Scanner;

public class FullTime  extends Employee {
private  double bonus =100000;

   Scanner sc = new Scanner(System.in);

    public FullTime(int id, String name, double salary, int age, double bonus) {
        super(id, name, salary, age);
        this.bonus = bonus;
    }

    public FullTime() {

    }

    public FullTime(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void display() {
        super.display();
    }

    @Override
    public void save() {


        System.out.println("Enter Your Names");
        String  names = sc.nextLine();



        System.out.println("Enter Your id");
        int id = sc.nextInt();
        System.out.println("Enter Your age");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Your Salary");
        double salary = sc.nextInt() + bonus;
         sc.nextLine();

        FullTime ft = new FullTime(id,names,salary,age,bonus);
        ls.add(ft);


    }
}
