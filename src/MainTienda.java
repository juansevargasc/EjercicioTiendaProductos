/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Vargas
 */

import java.util.*;


public class MainTienda 
{
    public static void main(String[] args)
    {
        //Menu
        System.out.println("TIENDA");
        System.out.println("\n" + "Menú");
        System.out.println("1. Crear tienda");
        
        //Objetos de entrada
        Scanner input = new Scanner(System.in);
        int opcion = input.nextInt();
        
        if(opcion == 1)
        {
            //Creación de tienda
            System.out.println("Nombre de tienda: ");
            String nombreTienda = input.next();
            System.out.println("Cantidad de productos:");
            int cantidadProductos = input.nextInt();
            Tienda tienda1 = new Tienda(nombreTienda, cantidadProductos);
            System.out.println(" \n Confirmación de información");
            System.out.println("Nombre: " + tienda1.getNombre());
            System.out.println("Cantidad de productos: " + tienda1.getCantTotalProductos());

            //Creación de producto
            Producto [] productos = new Producto[ tienda1.getCantTotalProductos() ];
            System.out.println("\n Cree los productos ");
            System.out.println("El número de productos debe ser: " + tienda1.getCantTotalProductos());
            //Creación del objeto que servirá como varible para llenar arreglo
            Producto producto1 = new Producto();
            for(int i = 0; i < ( tienda1.getCantTotalProductos() ) ; i++)
            {
                System.out.print("Nombre de producto: ");
                String nombreProducto = input.next();
                producto1.setNombre(nombreProducto);

                System.out.println("Tipo (Puede ser unicamente Papelería, Droguería o Supermercado) ");
                String tipo = input.next();
                producto1.setTipo(tipo);

                System.out.println("Unidades mínimas que debe haber en tienda");
                int unidadesMin = input.nextInt();
                producto1.setUndMinimas(unidadesMin);

                System.out.println("Precio base");
                double precioBase = input.nextDouble();
                producto1.setPrecioBase(precioBase);

                System.out.println("Unidades que va a asignar (Recuerde que las unidades no pueden ser menores al mínimo deisgnado)");
                int cantidadActual = input.nextInt();
                //Garantía de que unidades de producto sean como mínimo el número mínimo designado
                if(cantidadActual < unidadesMin)
                {
                    do
                    {
                        System.out.println("La cantidad de producto no puede ser menor a las unidades mínimas designadas para este");
                        System.out.print("Ingrese cantidad de producto de nuevo: ");
                        cantidadActual = input.nextInt();
                    }while( cantidadActual < unidadesMin );
                }
                producto1.setCantidadActual(cantidadActual);
                //Asignación del producto al arreglo
                productos[i] = producto1; 

            }
            //Asignación a la tienda de productos creados
            tienda1.setProductos(productos);



            //Vender producto
            System.out.println("\n Venta de producto \n Ingrese nombre de producto: ");
            String nombreProducto = input.next();
            System.out.println("Unidades: ");
            int unidades = input.nextInt();
            boolean resultado = tienda1.venderProducto(nombreProducto, unidades);
            System.out.println("Producto vendido: " + resultado);

            //Hacer pedido
            System.out.println("\n \n Si un producto se agota se debe hacer un pedido \n Ingrese nombre de producto agotado: ");
            nombreProducto = input.next();
            Producto producto = tienda1.getProductoPorNombre(nombreProducto);
            System.out.println("Unidades: ");
            unidades = input.nextInt();
            resultado = tienda1.pedirProducto(producto, unidades);
            System.out.println("Resultado: " + resultado);
            if(resultado == true)
            {
                System.out.println("Producto: " + producto.getNombre());
                System.out.println("Unidades mínimas designadas: " + producto.getUndMinimas());
                System.out.println("Unidades actuales: " + producto.getCantidadActual());
            }else
            {
                System.out.println("No fue posible hacer la venta");
            }
            
            
            //Otras opciones
            System.out.println(" \n \n");
            System.out.println("2. Mostrar estadísticas de ventas \n 3. Mostrar ingresos totales por ventas \n 4. Mostrar promedio de ventas");
            opcion = input.nextInt();
            switch(opcion)
            {
                case 2: tienda1.generarEstadísticas();
                        break;
                case 3: System.out.println("Ingresos totales: " + tienda1.getVentasTotales() );
                        break;
                case 4: System.out.println("Promedio de ventas: " + tienda1.promedioDeVentas());
                        break;
                default: System.out.println("Opción no válida");
            }
            
        }
        System.out.println(" FIN DE PROGRAMA  ");
        
        
       
    }
            
    
}
