/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import domain.DoublyLinkedList;
import domain.SinglyLinkedList;
import domain.CircularLinkedList;
import domain.CircularDoublyLinkedList;
import domain.Courses;
import domain.Employee;
import domain.JobPosition;
import domain.Student;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Profesor Lic. Gilberth Chaves Avila
 */
public class Utility {
    private static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
    private static DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    private static CircularLinkedList circularLinkedList = new CircularLinkedList();
    private static CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();
    
    private static String criterioOrdenamiento;
    
    public static String getCriterioOrdenamiento(){
        return criterioOrdenamiento;
    }
    
    public static void setCriterioOrdenamiento(String criterio){
        Utility.criterioOrdenamiento = criterio;
    }
    
    public static SinglyLinkedList getSinglyLinkedList() {
        return singlyLinkedList;
    }

    public static void setSinglyLinkedList(SinglyLinkedList singlyLinkedList) {
        Utility.singlyLinkedList = singlyLinkedList;
    }

    public static DoublyLinkedList getDoublyLinkedList() {
        return doublyLinkedList;
    }

    public static void setDoublyLinkedList(DoublyLinkedList doublyLinkedList) {
        Utility.doublyLinkedList = doublyLinkedList;
    }

    public static CircularLinkedList getCircularLinkedList() {
        return circularLinkedList;
    }

    public static void setCircularLinkedList(CircularLinkedList circularLinkedList) {
        Utility.circularLinkedList = circularLinkedList;
    }

    public static CircularDoublyLinkedList getCircularDoublyLinkedList() {
        return circularDoublyLinkedList;
    }

    public static void setCircularDoublyLinkedList(CircularDoublyLinkedList circularDoublyLinkedList) {
        Utility.circularDoublyLinkedList = circularDoublyLinkedList;
    }
    
    

    public static int random(){
        return 1+(int) Math.floor(Math.random()*99); 
    }
    
    public static int random(int bound){
        //return 1+random.nextInt(bound);
        return 1+(int) Math.floor(Math.random()*bound); 
    }
    
    public static int random(int lowBound, int highBound) {
        return lowBound+(int) Math.floor(Math.random()*highBound); 
    }
    
    public static String format(double value){
        return new DecimalFormat("###,###,###,###.##")
                .format(value);
    }
    
    public static String $format(double value){
        return new DecimalFormat("$###,###,###,###.##")
                .format(value);
    }
     public static String perFormat(double value){
         //#,##0.00 '%'
        return new DecimalFormat("#,##0.00'%'")
                .format(value);
    }
    
    public static void fill(int a[]) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++)
            a[i] = random.nextInt(99)+1;
    }
    
     public static void bubbleSort(int a[]){
    	for(int i=0;i<a.length;i++){
    	     for(int j=i+1;j<a.length;j++){
    		if(a[j]<a[i]){
    		   int aux=a[i];
                    a[i]=a[j];
    		    a[j]=aux;
    		}//if
            }//for j
        }//for i
    }
     public static String show(int[] a) {
        String result="";
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            if(counter++>=50){
                result+="\n";
                counter = 0;
            }
            result+=a[i]+" ";
        }
        return result;
    }
     
    private static String instanceOf(Object a, Object b) {
        if(a instanceof Integer && b instanceof Integer) return "Integer";
        if(a instanceof String && b instanceof String) return "String";
        if(a instanceof Character && b instanceof Character) return "Character";
        if(a instanceof Employee && b instanceof Employee) return "Employee";
        if(a instanceof JobPosition && b instanceof JobPosition) return "JobPosition";
        if(a instanceof Student && b instanceof Student) return "Student";
        if(a instanceof Courses && b instanceof Courses) return "Courses";
        return "unknown";
    }

    public static boolean equals(Object a, Object b) {
        switch(instanceOf(a, b)){
            case "Integer":
                Integer a1=(Integer)a; Integer b1=(Integer)b;
                //return x==y;
                return a1.equals(b1);
            case "String":
                String a2=(String)a; String b2=(String)b;
                return a2.equalsIgnoreCase(a2);
            case "Character":
                Character a3=(Character)a; Character b3=(Character)b;
                return a3.compareTo(a3)==0;
            case "Student":
                Student a4 = (Student)a; Student b4 = (Student)b;
                return a4.getId().equals(b4.getId());  
            case "Courses":
                Courses a5 = (Courses)a; Courses b5 = (Courses)b;
                return a5.getId().equals(b5.getId());
            case "JobPosition":
                JobPosition a6=(JobPosition)a; JobPosition b6=(JobPosition)b;
                return a6.getDescription().equalsIgnoreCase(b6.getDescription());
            case "Employee":
                Employee a7=(Employee)a; Employee b7=(Employee)b;
                return a7.getId() == b7.getId();
        }
        return false;
    }
    
    
   
    //less than (menorQ)
    public static boolean lessT(Object a, Object b){
        switch(instanceOf(a, b)){
            case "Integer":
                Integer a1=(Integer) a; Integer b1=(Integer) b;
                return a1<b1;
            case "String":
                String a2=(String) a; String b2=(String) b;
                return a2.compareToIgnoreCase(b2)<0;
            case "Character":
                Character a3=(Character)a; Character b3=(Character)b;
                return a3.compareTo(a3)<0;
//            case "Employee":
//                Employee a4=(Employee) a; Employee b4=(Employee) b;
//                switch(criterio){
//                    case "Id":
//                        return a4.getId()<b4.getId();
//                    case "Name":
//                        return a4.getFirstName().compareToIgnoreCase(b4.getFirstName()) < 0;
//                }
//            case "JobPosition":
//                JobPosition a5=(JobPosition) a; JobPosition b5=(JobPosition) b;
//                switch(criterio){
//                    case "Hourly":
//                        return a5.getHourlyWage()<b5.getHourlyWage();
//                    case "Description":
//                        return a5.getDescription().compareToIgnoreCase(b5.getDescription()) < 0;
//                }
            case "Student":
                Student a4 = (Student)a; Student b4 = (Student)b;
                return a4.getName().compareToIgnoreCase(b4.getName()) < 0;
            case "Courses":
                Courses a5 = (Courses)a; Courses b5 = (Courses)b;
                return a5.getName().compareToIgnoreCase(b5.getName()) < 0;
        }
        return false; 
    }
    
    
    //greater than (mayorQ)
    public static boolean greaterT(Object a, Object b){
        switch(instanceOf(a, b)){
            case "Integer":
                Integer a1=(Integer) a; Integer b1=(Integer) b;
                return a1>b1;
            case "String":
                String a2=(String) a; String b2=(String) b;
                return a2.compareToIgnoreCase(b2)>0;
            case "Character":
                Character a3=(Character)a; Character b3=(Character)b;
                return a3.compareTo(a3)>0;
//            case "Employee":
//                Employee a4=(Employee) a; Employee b4=(Employee) b;
//                switch(criterio){
//                    case "Id":
//                        return a4.getId()>b4.getId();
//                    case "Name":
//                        return a4.getFirstName().compareToIgnoreCase(b4.getFirstName()) > 0;
//                }
//            case "JobPosition":
//                JobPosition a5=(JobPosition) a; JobPosition b5=(JobPosition) b;
//                switch(criterio){
//                    case "Hourly":
//                        return a5.getHourlyWage()>b5.getHourlyWage();
//                    case "Description":
//                        return a5.getDescription().compareToIgnoreCase(b5.getDescription()) > 0;
//                }
             case "Student":
                Student a4 = (Student)a; Student b4 = (Student)b;
                return a4.getName().compareToIgnoreCase(b4.getName()) > 0;
            case "Courses":
                Courses a5 = (Courses)a; Courses b5 = (Courses)b;
                return a5.getName().compareToIgnoreCase(b5.getName()) > 0;
        }
        return false;
    }
    public static int getAge(Date birthday) {
        LocalDate fecha = LocalDate.now();
        LocalDate fechaNacimiento = birthday.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long edad = ChronoUnit.YEARS.between(fechaNacimiento, fecha);
        return (int) edad;
    }
     public static String dateFormat(Date value) {
        return new SimpleDateFormat("dd/MM/yyyy")
                .format(value);
    }
    
     
    
    
}
