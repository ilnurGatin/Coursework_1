import org.apache.commons.lang3.StringUtils;

public class Employee {
    private final int id;
    private final String fullName;
    private int departmentId;
    private int salary;
    public static int count = 0;

    public Employee(String fullName, int departmentId, int salary) {
        this.id = count++;
        if (StringUtils.isBlank(fullName) || !StringUtils.isAlpha(fullName.replace(" ", ""))) {
            throw new IllegalArgumentException("400 Bad Request");
        }
        this.fullName = fullName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", departmentId=" + departmentId +
                ", salary=" + salary +
                '}';
    }
}
