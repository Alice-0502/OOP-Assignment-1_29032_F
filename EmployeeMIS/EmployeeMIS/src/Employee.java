import java.util.ArrayList;
import java.util.List;

public class Employee {
   List<Employee> ls = new ArrayList<>();
    private  int id;
private String name;
private double salary;
private  int age;

    public Employee(int id, String name, double salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void display()
    {
       for (Employee em: ls){
           System.out.println(em.getName());
           System.out.println(em.salary);
       }



    }

    public void save(){



    }

}
