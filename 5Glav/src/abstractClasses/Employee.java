package abstractClasses;

import java.time.*;

public class Employee extends Person {

    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year, month, day);
    }

    public boolean equals(Object otherObject){

        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (this.getClass() != otherObject.getClass()) return false;

        Employee other = (Employee) otherObject;

        return name.equals(otherObject) && salary == other.salary && Object.equals(hireDay, other.hireDay);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

}
