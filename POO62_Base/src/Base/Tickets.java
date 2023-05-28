/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author lambda
 */
public class Tickets {

    private RandomAccessFile raf;
    private int id;
    private int importe;
    private String fecha;
    private String modelo;
    private String talla;
    private String depen;

    public void setId(int id) {
        this.id = id;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public void setDepen(String depen) {
        this.depen = depen;
    }
    
    
    
    
    
    
    private void writePerson(long num, Person person) throws IOException {
        this.raf.seek(num * Person.SIZE);
        byte[] record = person.toBytes();
        this.raf.write(record);
    }

    private Person readPerson(long num) throws IOException {
        this.raf.seek(num * Person.SIZE);
        byte[] record = new byte[Person.SIZE];
        this.raf.read(record);
        return Person.fromBytes(record);
    }  
    
     
    
      Person p;

     static Scanner lee = new Scanner(System.in);
     String per;
    static String res="s";
   
    public static void main(String args[]) throws IOException {
       new Tickets().leer(); 
        
    }

    public void Datos() throws IOException{

      String mod="",tal="",dep="";
      int imp = importe;
      int i = id;
      mod = modelo; tal=talla; dep=depen;
         System.out.println(mod);
         System.out.println(i);
         System.out.println(dep);
         System.out.println(imp);
        ejecutar(id,imp,modelo,fecha,talla,dep);
       
       
    }
    

        
       
   
    public void ejecutar(long id,long importe,String modelo,String fecha,String talla,String ven) {             
         Person p;
       
//        id,name,importe, modelo,fecha,talla
        try {
            this.raf = new RandomAccessFile("ticket.dat", "rw");        
            Person perr = new Person(id,ven,importe,modelo,fecha,talla); 
            
           this.writePerson(id, perr);             
//          
//           for(int i=0; i<=id; i++){
//             p = this.readPerson(i);
//               System.out.println("p" +p);
//           }               
          
                                       
        }catch(IOException e){
            System.out.println("Something has gone wrong!!!");
        }
    }
    public void leer() throws IOException{
        
          this.raf = new RandomAccessFile("ticket.dat", "rw");
        for(int i=1; i<=raf.length(); i++){
         
        
            p = this.readPerson(i);
            if(p.getName().equals("")){
                
            }else{
               System.out.println("p= " + p); 
            }
                
            
            
        
    }
   } 
     public void buscar(String nombre) throws IOException{
         int enc = 0;
          this.raf = new RandomAccessFile("people.dat", "rw");
           for(int i=1; i<=raf.length(); i++){         
             p = this.readPerson(i);
            if(nombre.equals(p.getName())){
               enc=1;
                
                
            }          
    }   if(enc==1){
         System.out.println("Registro existe");
     }
                  
                  
         
     }
 
}
