/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.dapp01practica01;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author francisco
 */
public class DAPP01Practica01 {

    public static void main(String[] args) {
        SessionFactory sf=   HibernateUtil.getSessionFactory();
       
         
        
        
        
    
       Scanner scanner = new Scanner(System.in);
            int opcion = 0;
            System.out.println("1. Agregar");
            System.out.println("2. Editar");
            System.out.println("3. eliminar");
            System.out.println("4. buscar");
            opcion = scanner.nextInt();
         

            switch (opcion) {
                case 1: {
                    System.out.println("Inserte nombre");
                    String nombre = scanner.next();
                    System.out.println("Inserte direccion");
                    String direccion = scanner.next();
                    System.out.println("Inserte telefono");
                    String telefono = scanner.next();
                 
                    PojoEmpleado empleado = new PojoEmpleado();
                    daoempleado daoemp= new daoempleado();
          
                    empleado.setId(0);
                    empleado.setNombre(nombre);
                    empleado.setDireccion(direccion);
                    empleado.setTelefono(telefono);
                    daoemp.Save(empleado);

                    if (daoemp.Save(empleado)!=true){
                        System.out.println("error");
                    }
                        
                        ;
                    break;
                }
                case 2: {
                    System.out.println("Inserte clave ");
                    int clave = scanner.nextInt();
                    System.out.println("Inserte nombre");
                    String nombre = scanner.next();
                    System.out.println("Inserte direccion");
                    String direccion = scanner.next();
                    System.out.println("Inserte telefono");
                    String telefono = scanner.next();
                
                    PojoEmpleado empleado = new PojoEmpleado();
                    DAOEmpleado daoemp = new DAOEmpleado();

                    empleado.setId(clave);
                    empleado.setNombre(nombre);
                    empleado.setDireccion(direccion);
                    empleado.setTelefono(telefono);
              

                    daoemp.Edit(empleado);

                    
                   
                    break;

                }
                case 3: {
               
                    System.out.println("Inserte clave de empleado");
                    int clave = scanner.nextInt();
                    DAOEmpleado daoemp = new DAOEmpleado();
                    daoemp.Delete(clave);
                    break;
                }
                case 4: {
                System.out.println("Inserte clave de empleado");
                int clave = scanner.nextInt();
                DAOEmpleado daoemp = new DAOEmpleado();

                List<PojoEmpleado> stEmpleado = daoemp.Findbyid(clave);
                for (PojoEmpleado emp : stEmpleado) {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "clave..." + emp.getId()+ "...nombre..." + emp.getNombre() + "...direccion..." + emp.getDireccion() + "...Telefono..." + emp.getTelefono());
                }
            }
        }


}
    }



