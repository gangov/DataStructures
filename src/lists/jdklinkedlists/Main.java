package lists.jdklinkedlists;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();

        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        for (Employee employee : list) {
            System.out.println(employee);
        }

        list.add(billEnd);

        list.removeFirst();
        list.removeLast();

        System.out.println(" **** ");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
