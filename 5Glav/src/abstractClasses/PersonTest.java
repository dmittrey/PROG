package abstractClasses;


public class PersonTest {

    public static void main(String[] args) {
        Person[] people = new Person[2];

        //Заполнить массив people объектами
        //типа Student и Employee

//        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
//
//        people[1] = new Student("Maria Morris", "computer science");
//
        Object obj = new Employee("Harry Hacker", 50000, 1989, 10, 1);

        Employee e = (Employee) obj;

        Employee[] staff = new Employee[10];

        obj = staff;

        obj = new int[10];






        //Вывести имена и описания всех лиц,
        //представленных объектами типа Person

        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDescription());
    }
}
