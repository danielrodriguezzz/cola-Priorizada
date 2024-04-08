/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author felipe
 */
public class Colapirizada {

    public static void main(String[] args) {
    
          PriorityQueue<Integer> p1 = new PriorityQueue<>();
          
          p1.insert(2);         
          p1.insert(5);
          p1.insert(7);
          p1.insert(8);
          p1.insert(10);
          p1.insert(9);
          p1.insert(42);
          p1.insert(34);
          p1.insert(12);
          p1.insert(45);
          
          
          
          System.out.println(" Elimina  el dato maximo : "+p1.deleteMax());
          System.out.println(" Elimina el dato minimo"+p1.deleteMin());
          System.out.println("el arreglo "+p1.isEmpty());
          

          
          

    }
}
