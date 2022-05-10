/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainNew;

import domain.CircularDoublyLinkedList;
import domain.CircularLinkedList;
import domain.Courses;
import domain.DoublyLinkedList;
import domain.Employee;
import domain.JobPosition;
import domain.ListException;
import domain.Node;
import domain.SinglyLinkedList;
import domain.Student;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Quiz3 {
    
    private Node reference = new Node("Referencia");

    public Node getReference() {
        return reference;
    }
    
    
    
    public void Quiz3(){
        
        try {
            SinglyLinkedList a = new SinglyLinkedList();
            Student S1 = new Student("1", "Mariano", 20, "Cartago");
            Student S2 = new Student ("2","Wilson", 25,"San Jose");
            Student S3 = new Student ("3", "Kevin", 30, "Paraiso");
            Student S4 = new Student ("4","Yuliana",28,"Limon");
            Student S5 = new Student("5", "Luciana", 27, "San Rafael");
            a.add(S1);  a.add(S2); a.add(S3); a.add(S4); a.add(S5);
            
            DoublyLinkedList b = new DoublyLinkedList();
            Courses C1 = new Courses("1", "Algoritmos y Estructuras de Datos", 4);
            Courses C2 = new Courses("2", "Sistemas de informacion", 2);
            Courses C3 = new Courses("3", "Programacion l", 4);
            Courses C4 = new Courses("4", "Programacion ll", 4);
            Courses C5 = new Courses("5", "Calculo", 3);
            b.add(C1); b.add(C2); b.add(C3); b.add(C4); b.add(C5);
            
            CircularLinkedList c = new CircularLinkedList();
            Calendar calendar = Calendar.getInstance();
            calendar.set(2002, 2, 6);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(1998, 5, 9);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.set(1997, 10, 11);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.set(1994, 5, 10);
            Calendar calendar4 = Calendar.getInstance();
            calendar4.set(1992, 3, 1);

            c.add(new Employee(1, "Duran","Mariano","Informatica", calendar.getTime()));
            c.add(new Employee(28, "Torres","Juan", "administración", calendar1.getTime()));
            c.add(new Employee(4532, "Fuentes", "Lucia", "inglés", calendar2.getTime()));
            c.add(new Employee(5423, "Jimenez", "Shirley", "turismo", calendar3.getTime()));
            c.add(new Employee(22314, "Gonzalez", "Gabriel", "agronomía", calendar4.getTime()));
            
            CircularDoublyLinkedList d = new CircularDoublyLinkedList();
            d.add(new JobPosition("Contador",100));
            d.add(new JobPosition("Turismo",75));
            d.add(new JobPosition("Administrador",200));
            d.add(new JobPosition("Gerente",1000));
            d.add(new JobPosition("Operario",25));
            
            
            reference = a.getNode(1);
            a.getNode(a.size()).next = b.getNode(1);
            b.getNode(b.size()).next = c.getNode(1);
            c.getNode(c.size()).next = d.getNode(1);            
            
            
        } catch (ListException ex) {
            Logger.getLogger(Quiz3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public String display(Node reference){
        
        String result = "Display Content\n";
        while(reference!=null){
           result+=reference.data+" ";
           reference = reference.next;
        }
        return result;
        
    }
}
