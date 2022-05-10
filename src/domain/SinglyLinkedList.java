/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class SinglyLinkedList implements List {
    private Node first; //apunta al inicio de la lista

    //Constructor
    public SinglyLinkedList(){
        this.first = null;
    }

    @Override
    public int size() throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        Node aux = first;
        int counter = 0;
        while(aux!=null){
           counter++;
           aux = aux.next;
        }
        return counter;
    }

    @Override
    public void clear() {
        this.first = null;
    }

    @Override
    public boolean isEmpty() {
        return first==null;
    }

    @Override
    public boolean contains(Object element) throws ListException {
         if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        Node aux = first;
        while(aux!=null){
            if(util.Utility.equals(aux.data, element))
                return true;
           aux = aux.next;
        }
        return false;
    }

    @Override
    public void add(Object element) {
        Node newNode = new Node(element);
        if(isEmpty()){
            this.first = newNode;
        }else{
            Node aux = first;
            while(aux.next!=null)
                aux = aux.next; //muevo el aux al sgte nodo
            //se sale del while cuando aux.next == null
            aux.next = newNode;
        }
    }

    @Override
    public void addFirst(Object element) {
        Node newNode = new Node(element);
        if(isEmpty())
            first = newNode;
        else{
           newNode.next = first; 
           first = newNode;
        }
    }

    @Override
    public void addLast(Object element) {
        add(element);
    }

    @Override
    public void addInSortedList(Object element) {
        Node newNode = new Node(element);
        if(isEmpty())
            first = newNode;
        else{
            if(util.Utility.lessT(newNode.data,first.data))
                addFirst(element);
            
            Node prev = first;
            Node aux = first.next;
            while(aux != null && util.Utility.greaterT(newNode.data, aux.data)){
                prev = aux;
                aux = aux.next;
            }
            prev.next = newNode;
            newNode.next = aux;
        }
        
    }

    @Override
    public void remove(Object element) throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        //caso 1. El elemento a suprimir es el primero
        if(util.Utility.equals(first.data, element)){
            first = first.next;
        }  
        //case 2. El elemento a suprimir puede estar donde sea
        else{
            Node prev = first; //elemento anterior
            Node aux = first.next; //elemento sgte
            while(aux!=null&&!util.Utility.equals(aux.data, element)){
                prev = aux; //actualizo anterior
                aux = aux.next;
            }
            //se sale del while cuando alcanza nulo
            //o cuando encuentra el elemento a suprimir
            if(aux!=null&&util.Utility.equals(aux.data, element)){
                //ya lo encontro, lo puede suprimir
                //tengo que desenlazar el nodo
                prev.next = aux.next; //se lo salta
            }
        }
    }

    @Override
    public Object removeFirst() throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        Object element = first.data;
        first = first.next;
        return element;
    }

    @Override
    public Object removeLast() throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        Object element = getLast();
        remove(element);
        return element;
        
    }

    @Override
    public void sort() throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        
        for (int i = 1; i <= size(); i++) {
            Node prev = first;
            Node aux = first.next;
            while(aux != null){
                if(util.Utility.greaterT(prev.data, aux.data)){
                    Object temp = prev.data;
                    prev.data = aux.data;
                    aux.data = temp;
                }
                prev = aux;
                aux = aux.next;
            }     
            
        }
        
    }
    
    @Override
    public int indexOf(Object element) throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        int i = 1; //posicion del 1er elemento
        Node aux = first;
        while(aux!=null&&!util.Utility.equals(aux.data, element)){
            aux = aux.next;
            i++;
        }
        //sale cuando aux==null o encontro el elemento
        if(aux!=null&&util.Utility.equals(aux.data, element)){
            return i;
        }
        return -1; //el elemento no existe
    }

    @Override
    public Object getFirst() throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        return first.data;
    }

    @Override
    public Object getLast() throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        Node aux = first;
        while(aux.next!=null){
           aux = aux.next;
        }
        //cuando sale del while es porque esta en el ult nodo
        return aux.data;
    }

    @Override
    public Object getPrev(Object element) throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        Node prev = first; //elemento anterior
        Node aux = first.next; //elemento sgte
        while(aux!=null&&!util.Utility.equals(aux.data, element)){
            prev = aux; //actualizo anterior
            aux = aux.next;
            }
        if(aux!=null && util.Utility.equals(aux.data, element)){
                return prev.data; 
        }
        return null;
    }

    @Override
    public Object getNext(Object element) throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        Node prev = first; //elemento anterior
        Node aux = first.next; //elemento sgte
        while(aux!=null&&!util.Utility.equals(prev.data, element)){
            prev = aux; //actualizo anterior
            aux = aux.next;
            }
        if(aux != null && util.Utility.equals(prev.data, element)){
                return aux.data; 
        }
        return null;
    }

    @Override
    public Node getNode(int index) throws ListException {
        if(isEmpty())
            throw new ListException("Singly Linked List is empty");
        int i = 1; //posicion del 1er elemento
        Node aux = first;
        while(aux!=null&&!util.Utility.equals(index, i)){
            aux = aux.next;
            i++;
        }
        //sale cuando aux==null o encontro el elemento
        if(aux!=null&&util.Utility.equals(index, i)){
            return aux;
        }
        return null; //el elemento no existe
    }

    @Override
    public String toString() {
        String result = "Singly Linked List Content\n";
        Node aux = first;
        while(aux!=null){
           result+=aux.data+" ";
           aux = aux.next;
        }
        return result;
    }
    
    public int countNames(SinglyLinkedList list, String name) throws ListException{
        int count = 0;
        for(int i = 1; i<= list.size(); i++){
            Student s = (Student)list.getNode(i).data;
            if(s.getName().equalsIgnoreCase(name)){
                count++;
            }
        }
        return count;
    }
    
    public boolean findNames(SinglyLinkedList list, String name) throws ListException{
        for(int i = 1; i<= list.size(); i++){
            Student s = (Student)list.getNode(i).data;
            if(s.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
    
    
}
