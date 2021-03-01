
public class Employee {

    public String name;
    public String position;
    public String email;
    public String number;
    public int salary;
    public int age;

    public Employee(){

        this.name = "Smirnov Alex";
        this.position = "courier";
        this.email = "Alex@mail.ru";
        this.number = "+7 900-000-00 00";
        this.salary = 20500;
        this.age = 24;

    }

    public Employee(String name, String position, String email,
                    String number, int salary, int age){

        this.name = name;
        this.position = position;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;

    }

    public static void main(String[] args){

        employeeDemo();
        employeeArrayDemo();

    }

    static void employeeDemo(){

        Employee employee = new Employee();

        System.out.println("| Name: " + employee.name + " | Position: " + employee.position
                + " | Email: " + employee.email + " | Number: " + employee.number
                + " | Salary: " + employee.salary + " | Age: " + employee.age + " |");

        System.out.println();
    }

    static void employeeArrayDemo(){

        System.out.println("Employees over 40 years old");

        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Ivanov Ivan", "driver", "Ivan@mail.ru",
                "+7 000-000-00 01", 30000, 30);
        employeeArray[1] = new Employee("Ivanov Roman", "driver", "Roman@mail.ru",
                "+7 000-000-00 02", 34000, 50);
        employeeArray[2] = new Employee("Ivanov Alex", "driver", "Alex@mail.ru",
                "+7 000-000-00 03", 31000, 32);
        employeeArray[3] = new Employee("Ivanov Serg", "driver", "Serg@mail.ru",
                "+7 000-000-00 04", 32000, 41);
        employeeArray[4] = new Employee("Ivanova Mariya", "driver", "Mariya@mail.ru",
                "+7 000-000-00 05", 33000, 25);

        for (int i = 0; i < employeeArray.length; i++){

            if (employeeArray[i].age > 40){

                System.out.println("| Name: " + employeeArray[i].name + " | Position: " + employeeArray[i].position
                        + " | Email: " + employeeArray[i].email + " | Number: " + employeeArray[i].number
                        + " | Salary: " + employeeArray[i].salary + " | Age: " + employeeArray[i].age + " |");

            }
        }
    }
}