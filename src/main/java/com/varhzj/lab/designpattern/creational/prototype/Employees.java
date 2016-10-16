package com.varhzj.lab.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by varhzj on 16-10-16.
 * Prototype pattern is used when the Object creation is a costly affair and requires a lot of time and resources and you have a similar object already exists.
 * This pattern provides a mechanism to copy the original object to a new object and then modify it according our needs.
 * This pattern uses java cloning to copy the object.
 */
public class Employees implements Cloneable{

    private List<String> empList;

    public Employees() {
        empList = new ArrayList<>();
    }

    public Employees(List<String> list) {
        this.empList = list;
    }

    public void loadData() {
        // get all data from database or somewhere else, which costs a lot of time
        empList.add("John");
        empList.add("Mary");
        empList.add("Lucy");
        empList.add("Tom");
    }

    public List<String> getEmpList() {
        return empList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
//        super.clone();
        List<String> list = new ArrayList<>();
//        for (String s : empList) {
//            list.add(s);
//        }
        // use addAll to add a list to another list, except using foreach
        list.addAll(empList);
        return new Employees(list);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Employees employees = new Employees();
        employees.loadData();

        Employees employees1 = (Employees) employees.clone();
        List<String> list1 = employees1.getEmpList();
        list1.add("Fake");

        Employees employees2 = (Employees) employees.clone();
        List<String> list2 = employees2.getEmpList();
        list2.remove("Tom");

        System.out.println("employees: " + employees.getEmpList());
        System.out.println("employees1: " + employees1.getEmpList());
        System.out.println("employees2: " + employees2.getEmpList());
    }
}
