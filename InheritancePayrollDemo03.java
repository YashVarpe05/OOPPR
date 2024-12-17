// Base Employee Class
class Employee {
    protected String emp_name;
    protected String emp_id;
    protected String address;
    protected String mail_id;
    protected String mobile_no;

    public Employee(String emp_name, String emp_id, String address,
            String mail_id, String mobile_no) {
        this.emp_name = emp_name;
        this.emp_id = emp_id;
        this.address = address;
        this.mail_id = mail_id;
        this.mobile_no = mobile_no;
    }
}

class Programmer extends Employee {
    protected double basicPay;

    public Programmer(String emp_name, String emp_id, String address,
            String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double clubFund = 0.001 * basicPay;

        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - pf - clubFund;

        System.out.println("Pay Slip for Programmer: " + emp_name);
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("DA (97%): $" + da);
        System.out.println("HRA (10%): $" + hra);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("PF (12%): $" + pf);
        System.out.println("Staff Club Fund (0.1%): $" + clubFund);
        System.out.println("Net Salary: $" + netSalary);
        System.out.println();
    }
}

class TeamLead extends Employee {
    protected double basicPay;

    public TeamLead(String emp_name, String emp_id, String address,
            String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double clubFund = 0.001 * basicPay;

        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - pf - clubFund;

        System.out.println("Pay Slip for Team Lead: " + emp_name);
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("DA (97%): $" + da);
        System.out.println("HRA (10%): $" + hra);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("PF (12%): $" + pf);
        System.out.println("Staff Club Fund (0.1%): $" + clubFund);
        System.out.println("Net Salary: $" + netSalary);
        System.out.println();
    }
}

class AssistantProjectManager extends Employee {
    protected double basicPay;

    public AssistantProjectManager(String emp_name, String emp_id, String address,
            String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double clubFund = 0.001 * basicPay;

        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - pf - clubFund;

        System.out.println("Pay Slip for Assistant Project Manager: " + emp_name);
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("DA (97%): $" + da);
        System.out.println("HRA (10%): $" + hra);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("PF (12%): $" + pf);
        System.out.println("Staff Club Fund (0.1%): $" + clubFund);
        System.out.println("Net Salary: $" + netSalary);
        System.out.println();
    }
}

class ProjectManager extends Employee {
    protected double basicPay;

    public ProjectManager(String emp_name, String emp_id, String address,
            String mail_id, String mobile_no, double basicPay) {
        super(emp_name, emp_id, address, mail_id, mobile_no);
        this.basicPay = basicPay;
    }

    public void generatePaySlip() {
        double da = 0.97 * basicPay;
        double hra = 0.10 * basicPay;
        double pf = 0.12 * basicPay;
        double clubFund = 0.001 * basicPay;

        double grossSalary = basicPay + da + hra;
        double netSalary = grossSalary - pf - clubFund;

        System.out.println("Pay Slip for Project Manager: " + emp_name);
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Basic Pay: $" + basicPay);
        System.out.println("DA (97%): $" + da);
        System.out.println("HRA (10%): $" + hra);
        System.out.println("Gross Salary: $" + grossSalary);
        System.out.println("PF (12%): $" + pf);
        System.out.println("Staff Club Fund (0.1%): $" + clubFund);
        System.out.println("Net Salary: $" + netSalary);
        System.out.println();
    }
}

public class InheritancePayrollDemo03 {
    public static void main(String[] args) {
        Programmer programmer = new Programmer(
                "John Doe", "EMP001", "123 Tech Lane",
                "john@company.com", "555-1234", 5000.0);
        programmer.generatePaySlip();

        TeamLead teamLead = new TeamLead(
                "Jane Smith", "EMP002", "456 Code Street",
                "jane@company.com", "555-5678", 7500.0);
        teamLead.generatePaySlip();

        AssistantProjectManager assistantPM = new AssistantProjectManager(
                "Mike Johnson", "EMP003", "789 Management Road",
                "mike@company.com", "555-9012", 9000.0);
        assistantPM.generatePaySlip();

        ProjectManager projectManager = new ProjectManager(
                "Sarah Williams", "EMP004", "321 Leadership Avenue",
                "sarah@company.com", "555-3456", 12000.0);
        projectManager.generatePaySlip();
    }
}