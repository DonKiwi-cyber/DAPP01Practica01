/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.dapp01practica01;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class detalleventa {

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
                  
                    System.out.println("Inserte la cantidad ");
                    int cantidad = scanner.nextInt();
                    System.out.println("Inserte el precio ");
                    double precio = scanner.nextDouble();
                    System.out.println("Inserte inserte el nombre del producto");
                    String producto = scanner.next();
                    System.out.println("Inserte inserte el id de venta");
                    long idventa= scanner.nextLong(); 
                 
                    Detalleventa detalleventa = new Detalleventa();
                    DaoDetalleVenta daodetalleventa = new DaoDetalleVenta();
          
                    detalleventa.setCantidad(cantidad);
                    detalleventa.setPrecio(precio);
                    detalleventa.setProducto(producto);
                    daodetalleventa.Save(detalleventa);
                      daodetalleventa.Edit(detalleventa);

                    if (daodetalleventa.Save(detalleventa)!=true){
                        System.out.println("error");
                    }
                        
                        ;
                    break;
                }
                case 2: {
                       System.out.println("Inserte inserte el id");
                    long idLinea = scanner.nextLong();             
                    System.out.println("Inserte la cantidad ");
                    int cantidad = scanner.nextInt();
                    System.out.println("Inserte el precio ");
                    double precio = scanner.nextDouble();
                    System.out.println("Inserte inserte el nombre del producto");
                    String producto = scanner.next();
                       System.out.println("Inserte inserte el id de venta");
                    long idventa= scanner.nextLong(); 
                 
                    Detalleventa detalleventa = new Detalleventa();
                    DaoDetalleVenta daodetalleventa = new DaoDetalleVenta();
          
                    detalleventa.setIdLinea(idLinea);
                    detalleventa.setCantidad(cantidad);
                    detalleventa.setPrecio(precio);
                    detalleventa.setProducto(producto);
                    detalleventa.setIdventa(idventa);
                    daodetalleventa.Edit(detalleventa);

                    if (daodetalleventa.Edit(detalleventa)!=true){
                        System.out.println("error");
                    }
                        
                        ;
                    break;

                }
                case 3: {
               
                    System.out.println("Inserte clave del producto");
                    int idLineal = scanner.nextInt();
                      DaoDetalleVenta daodetalleventa = new DaoDetalleVenta();
                    daodetalleventa.Delete(idLineal);
                    break;
                }
                case 4: {
                System.out.println("Inserte clave de producto");
                int idLineal = scanner.nextInt();
                DaoDetalleVenta daodetalleventa = new DaoDetalleVenta();

                List<Detalleventa> stdetalle = daodetalleventa.Findbyid(idLineal);
                for (Detalleventa detalle : stdetalle) {
                    Logger.getLogger(detalleventa.class.getName()).log(Level.INFO, "clave..." + detalle.getIdLinea()+"...nombre..." + detalle.getProducto() + "...direccion..." + detalle.getCantidad()+ "...Telefono..." +detalle.getCantidad());
                }
            }
        }


}
    }



