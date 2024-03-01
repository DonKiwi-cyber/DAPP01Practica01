/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.dapp01practica01;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    public static void main(String[] args) throws ParseException {
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
                  
           System.out.println("Inserte la fecha (en formato AAAA-MM-DD): ");
        String fechaStr = scanner.next();
        
    
            Date sqlDate = Date.valueOf(fechaStr);
            
            System.out.println("Inserte nombre del cliente: ");
            String nombre = scanner.next();
            
            System.out.println("Inserte el total: ");
            double total = scanner.nextDouble();
            
            Venta venta = new Venta();
            DaoVenta daoventa = new DaoVenta();
            
            venta.setFecha(sqlDate);
            venta.setCliente(nombre);
            venta.setTotal(total);
            
            
                      //venta.setDetalleVenta(detalleVenta);
            
            daoventa.Save(venta);
DaoDetalleVenta detalleventa = new DaoDetalleVenta();
              for (int i =0; i < 5; i++){
              Detalleventa det = new Detalleventa();
              det.setPrecio(800);
              det.setCantidad(3);
              det.setProducto("pizza");
              det.setVenta(venta);
              detalleventa.Save(det);
              }

    break;
                }
                
                case 2: {
                    System.out.println("Inserte el id ");
                    long id = scanner.nextLong();
                    System.out.println("Inserte la fecha ");
                    String fecha = scanner.next();
                    Date sqlDate = Date.valueOf(fecha);
                    System.out.println("Inserte nombre del cliente ");
                    String nombre = scanner.next();
                    System.out.println("Inserte inserte el total");
                    double total = scanner.nextDouble();
                 
                    Venta venta = new Venta();
                    DaoVenta daoventa = new DaoVenta();
                    
                    
                    venta.setId(id);
                    venta.setFecha(sqlDate);
                    venta.setCliente(nombre);
                    venta.setTotal(total);
                    daoventa.Edit(venta);

                    if (daoventa.Edit(venta)!=true){
                        System.out.println("error");
                    }
                        
                        ;
                    break;

                }
                case 3: {
               
                    System.out.println("Inserte clave de empleado");
                    int clave = scanner.nextInt();
                      DaoVenta daoventa = new DaoVenta();
                    daoventa.Delete(clave);
                    break;
                }
                case 4: {
                System.out.println("Inserte clave de empleado");
                int clave = scanner.nextInt();
                 DaoVenta daoventa = new DaoVenta();

                List<Venta> stventa = daoventa.Findbyid(clave);
                for (Venta venta : stventa) {
                    Logger.getLogger(DAPP01Practica01.class.getName()).log(Level.INFO, "clave..." + venta.getId() +"...nombre..." + venta.getFecha() + "...direccion..." + venta.getCliente()+ "...Telefono..." +venta.getTotal());
                }
            }
        }


}
    }



