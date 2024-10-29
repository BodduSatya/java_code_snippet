package com.javamonk.stream_api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataBase.getAllEmployees();

//        StreamsDemo.forEach(employees);         // forEach(Consumer)
//        StreamsDemo.filterCollect(employees);   // filter(Predicate), collect(Collector)
        StreamsDemo.mapDistinct(employees);     // map(Function), distinct()
//        StreamsDemo.mapFlatMap(employees);      // flatMap(Function)
//        StreamsDemo.sortedASC(employees);       // sorted(Comparator both ASC and DESC)
//        StreamsDemo.sortedDESC(employees);
//        StreamsDemo.minMax(employees);          // min() & max()
//        StreamsDemo.groupBy(employees);         // GroupBy
//        StreamsDemo.findFirst(employees);       // findFirst()
//        StreamsDemo.findAny(employees);         // findAny()
//        StreamsDemo.match(employees);           // anyMatch(Predicate), allMatch(Predicate), noneMatch(Predicate)
//        StreamsDemo.limit(employees);           // limit(long maxSize)
//        StreamsDemo.skip(employees);            // skip(long n)


    }

    private static void skip(List<Employee> employees) {
        //skip(long)
        List<Employee> skipEmployees = employees.stream().skip(10)
                .collect(Collectors.toList());

        System.out.println("skipEmployees = " + skipEmployees);
    }

    private static void limit(List<Employee> employees) {
        //limit(long)

        List<Employee> topPaidEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(4)
                .collect(Collectors.toList());

        topPaidEmployees.forEach(e-> System.out.println(e.getName()));

    }

    private static void match(List<Employee> employees) {
        //anyMatch(Predicate) , allMatch(Predicate) , noneMatch(Predicate)

        boolean developmentEmpAnyMatch = employees.stream()
                .anyMatch(e -> e.getDept().equals("Development"));
        System.out.println("is there any employee match from development dept "+developmentEmpAnyMatch);


        boolean developmentEmpAllMatch = employees.stream()
                .allMatch(e -> e.getSalary()>50000);//55000
        System.out.println(developmentEmpAllMatch); //false


        boolean isNoneMatch = employees.stream()
                .noneMatch(e -> e.getDept().equals("abc"));
        System.out.println(isNoneMatch);

    }

    private static void findAny(List<Employee> employees) {
        //findAny

        Employee findAnyElement = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("Employee not found "));

        System.out.println(findAnyElement);
    }

    private static void findFirst(List<Employee> employees) {

        Employee findFirstElement = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("Employee not found "));

        System.out.println(findFirstElement);


        Optional<Employee> findFirstElement2 = employees.stream()
                .filter(e -> e.getDept().equals("Development"))
                .findFirst();

        findFirstElement2.ifPresent(e-> System.out.println(e.getName()));

    }

    private static void groupBy(List<Employee> employees) {
        Map<String, List<Employee>> employeeGroup = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender));

        System.out.println(employeeGroup);

        //Gender -> [names]
        Map<String, List<String>> employeeGroupNames = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));

        System.out.println(employeeGroupNames);

        //Gender -> [count]
        Map<String, Long> employeeGroupCountMap = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(employeeGroupCountMap);
    }

    private static void minMax(List<Employee> employees) {
        //min & max
        Optional<Employee> highestPaidEmployees = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("Highest paid employee : "+highestPaidEmployees);

        Optional<Employee> lowestPaidEmployees = employees.stream()
                .min(Comparator.comparingDouble(Employee::getSalary));

        System.out.println("Lowest paid employee : "+lowestPaidEmployees);
    }

    private static void sortedDESC(List<Employee> employees) {
        List<Employee> descSortedEmployees = employees.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Employee::getSalary)))
                .collect(Collectors.toList());

        descSortedEmployees.get(0);

        descSortedEmployees.forEach(System.out::println);
    }

    private static void sortedASC(List<Employee> employees) {
        List<Employee> ascSortedEmployees = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        ascSortedEmployees.get(0);

        ascSortedEmployees.forEach(System.out::println);
    }

    private static void mapFlatMap(List<Employee> employees) {
        List<Stream<String>> projectNames = employees.stream()
                .map(e -> e.getProjects()
                        .stream().map(Project::getName))
                .collect(Collectors.toList());

        System.out.println("projectNames = " + projectNames);

        //flatMap
        List<String> projects = employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .map(Project::getName).distinct()
                .collect(Collectors.toList());

        System.out.println(projects);
    }

    private static void mapDistinct(List<Employee> employees) {
        List<String> depts = employees.stream()
                .map(Employee::getDept)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(depts);
    }

    private static void filterCollect(List<Employee> employees) {
        Map<Integer, String> developmentEmployees = employees.stream()
                .filter(e -> e.getDept().equals("Development") && e.getSalary() > 80000)
                .collect(Collectors.toMap(Employee::getId, Employee::getName));

        System.out.println(developmentEmployees);
    }

    private static void forEach(List<Employee> employees){
        employees.forEach(e-> System.out.println(e.getName()+" : "+e.getSalary()));
        employees.stream().forEach(System.out::println);
    }
}


class EmployeeDataBase {

    public static List<Employee> getAllEmployees() {
        Project p1 = new Project("P001", "Alpha", "ABC Corp", "Alice");
        Project p2 = new Project("P002", "Beta", "XYZ Ltd", "Bob");
        Project p3 = new Project("P003", "Gamma", "ABC Corp", "Alice");
        Project p4 = new Project("P004", "Delta", "TechWorld", "Charlie");
        Project p5 = new Project("P005", "Epsilon", "MoneyMatters", "Daniel");
        Project p6 = new Project("P006", "Zeta", "SmartTech", "Eva");
        Project p7 = new Project("P007", "Eta", "BrandBoost", "George");
        Project p8 = new Project("P008", "Theta", "InnoSoft", "Hannah");
        Project p9 = new Project("P009", "Iota", "FastTrack", "Ian");
        Project p10 = new Project("P010", "Kappa", "DigitalWave", "Jessica");

        // Employee instances
        Employee e1 = new Employee(1, "John Doe", "Development", Arrays.asList(p1, p2), 80000, "Male");
        Employee e2 = new Employee(2, "Jane Smith", "Development", Arrays.asList(p3), 80000, "Female");
        Employee e3 = new Employee(3, "Robert Brown", "Sales", Arrays.asList(p4), 60000, "Male");
        Employee e4 = new Employee(4, "Lisa White", "HR", Arrays.asList(p1), 55000, "Female");
        Employee e5 = new Employee(5, "Michael Green", "Finance", Arrays.asList(p5), 90000, "Male");
        Employee e6 = new Employee(6, "Sophia Brown", "Development", Arrays.asList(p6), 85000, "Female");
        Employee e7 = new Employee(7, "James Wilson", "Marketing", Arrays.asList(p7), 72000, "Male");
        Employee e8 = new Employee(8, "Olivia Harris", "Development", Arrays.asList(p8), 88000, "Female");
        Employee e9 = new Employee(9, "William Lee", "Sales", Arrays.asList(p9), 78000, "Male");
        Employee e10 = new Employee(10, "Emily Clark", "Development", Arrays.asList(p10), 95000, "Female");

        // Print employee details (just for testing)
        return Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }
}


class Employee{

    private int id;
    private String name;
    private String dept;
    private List<Project> projects;
    private double salary;
    private String gender;

    public Employee(int id, String name, String dept, List<Project> projects, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.projects = projects;
        this.salary = salary;
        this.gender = gender;
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", projects=" + projects +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                '}';
    }
}


class Project{

    private String projectCode;
    private String name ;
    private String client;
    private String buLeadName;

    public Project(String projectCode, String name, String client, String buLeadName) {
        this.projectCode = projectCode;
        this.name = name;
        this.client = client;
        this.buLeadName = buLeadName;
    }

    public Project() {
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBuLeadName() {
        return buLeadName;
    }

    public void setBuLeadName(String buLeadName) {
        this.buLeadName = buLeadName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectCode='" + projectCode + '\'' +
                ", name='" + name + '\'' +
                ", client='" + client + '\'' +
                ", buLeadName='" + buLeadName + '\'' +
                '}';
    }
}