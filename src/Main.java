public class Main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        addEmployee(employees, new Employee("Ivanov Ivan Ivanovich", 1, 60_000));
        addEmployee(employees, new Employee("Petrov Petor Petrovich", 1, 45_000));
        addEmployee(employees, new Employee("Sidorov Ivan Sidorovich", 2, 35_000));
        addEmployee(employees, new Employee("Ivanov Petor Ivanovich", 3, 49_000));
        addEmployee(employees, new Employee("Sidorov Ivan Ivanovich", 5, 75_000));

        employeesInfo(employees);

        System.out.println("Общие затраты на зарплату составляют " + sumSalary(employees) + " рублей");
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeWithMinSalary(employees));
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeWithMaxSalary(employees));
        System.out.println("Средняя зарплата по сотрудникам: " + averageSalary(employees));

        printEmployeeNames(employees);
    }

    public static void addEmployee(Employee[] employees, Employee employee) {
        boolean employeeAdded = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employeeAdded = true;
                employees[i] = employee;
                break;
            }
        }
        if (!employeeAdded) {
            System.out.println("Нет места для новых сотрудников");
        }
    }

    public static void employeesInfo(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static double sumSalary(Employee[] employees) {
        double sumSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
               sumSalary += employee.getSalary();
            }
        }
        return sumSalary;
    }

    public static String employeeWithMinSalary(Employee[] employees) {
        int minSalary = employees[0].getSalary();
        String employeeName = employees[0].getFullName();
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                employeeName = employee.getFullName();
            }
        }
        return employeeName + " " + minSalary;
    }

    public static String employeeWithMaxSalary(Employee[] employees) {
        int maxSalary = employees[0].getSalary();
        String employeeName = employees[0].getFullName();
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                employeeName = employee.getFullName();
            }
        }
        return employeeName + " " + maxSalary;
    }

    public static double averageSalary(Employee[] employees) {
        return sumSalary(employees) / Employee.count;
    }

    public static void printEmployeeNames(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getFullName());
            }
        }
    }
}