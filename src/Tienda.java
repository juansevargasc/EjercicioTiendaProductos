/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Tienda 
{
    private String nombre;
    private Producto[] productos;
    private int cantTotalProductos;
    private double ventasTotales;

    public Tienda() 
    {
        
    }

    public Tienda(String nombre, Producto[] productos, int cantTotalProductos, double ventasTotales) 
    {
        this.nombre = nombre;
        this.productos = productos;
        this.cantTotalProductos = cantTotalProductos;
        this.ventasTotales = ventasTotales;
    }

    public String getNombre()
    {
        return nombre;
    }

    public Producto[] getProductos() 
    {
        return productos;
    }

    public int getCantTotalProductos() 
    {
        return cantTotalProductos;
    }

    public double getVentasTotales() 
    {
        return ventasTotales;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public void setProductos(Producto[] productos)
    {
        this.productos = productos;
    }

    public void setCantTotalProductos(int cantTotalProductos) 
    {
        this.cantTotalProductos = cantTotalProductos;
    }

    public void setVentasTotales(double ventasTotales)
    {
        this.ventasTotales = ventasTotales;
    }
    
    /**
     * Vende una cierta cantidad de unidades de un producto
     * @param a
     * @param unidades
     * @return pedido
     */
    public double precioDeProducto(Producto a)
    {
        double impPapeleria = 0.16, impSupermercado = 0.4, impDrogueria = 0.12, precioTotal = 1;
        if(a.getTipo().equals("Papeleria"))
        {
            precioTotal = ( a.getPrecioBase() * impPapeleria);
        }else if(a.getTipo().equals("Supermrcado"))
         {
             precioTotal = ( a.getPrecioBase() * impSupermercado);
         }else if(a.getTipo().equals("Drogueria"))
         {
            precioTotal = ( a.getPrecioBase() * impDrogueria );
         }
        return precioTotal;
    }
    
    /**
     * Retorna la cantidad de productos que hay con un nombre en específico
     * en la tienda
     * @param a
     * @return cantidadTipoProducto
     */
    public int cantProductoTipo(Producto a)
    {
        int cantidadProductoTipo = 0;
        for(int i = 0; i > this.cantTotalProductos; i++)
        {
            // Condición: Si el nombre del producto coincide con el nombre de algun producto en el inventario
            if( a.getNombre().equals(this.productos[i].getNombre()) )
            {
                cantidadProductoTipo++;
            }
        }
        return cantidadProductoTipo;
    }
    
    /**
     * 
     * @param nombreProducto
     * @param unidades
     * @return 
     */
    public boolean venderProducto(String nombreProducto, int unidades)
    {
  
        //Busca si hay ese producto en inventario
        for(int i = 0; i < this.cantTotalProductos; i++)
        {
            //Condición: Si el nombre del producto coincide con alguno del inventario: this.productos[i].getNombre()
            if( nombreProducto.equals( this.productos[i].getNombre() ) )
            {
                
                //Minimo: Hace la diferencia entre
                //la cantidad de productos de la tienda (de ese producto en específico)
                //con las unidades mínimas que se deben mantener de ese producto
                int minimo = ( cantProductoTipo(this.productos[i]) - this.productos[i].getUndMinimas() );
                if(minimo >= 0)
                {
                    // Actualiza el valor de unidades disponibles
                    this.productos[i].setCantidadActual( this.productos[i].getCantidadActual() - unidades );
                    break;
                }
             
            }else
            {
                return false;
            }

        }
        return true;
        
    }
    
    /**
     * 
     * @param nombre
     * @return 
     */
    public Producto getProductoPorNombre(String nombre)
    {
        Producto producto = new Producto();
        for(int i = 0; i < this.cantTotalProductos; i++)
        {
            if( this.productos[i].getNombre().equals(nombre) )
            {
                producto = this.productos[i];
            }else
            {
                producto = null;
            }
        }
        return producto;
        
    }
    
    /**
     * 
     * @param a
     * @param unidades
     * @return 
     */
    public boolean pedirProducto(Producto a, int unidades)
    {
        
        if( a.getCantidadActual() <= a.getUndMinimas() )
        {
            for(int i = 0; i < unidades; i++)
            {
               if( a.getNombre().equals( this.productos[i].getNombre() ) )
               {
                   //this.productos[this.cantTotalProductos] = a;
                   this.productos[i].setCantidadActual( this.productos[i].getCantidadActual() + unidades );
                   this.cantTotalProductos += unidades;
                   break;
               }else
               {
                   return false;
               }
               
                
            }
            return true;
        }else
        {
            return false;
        }
    }
    
    public void generarEstadísticas()
    {
        double ventaMayor = 0;
        double ventaMenor = this.productos[0].getVentas();
        String nomProductoMayor = null, nomProductoMenor = null;
        for(int i = 0; i < this.cantTotalProductos; i++)
        {
            if( this.productos[i].getVentas() > ventaMayor )
            {
                ventaMayor = this.productos[i].getVentas();
                nomProductoMayor = this.productos[i].getNombre();
            }else if(this.productos[i].getVentas() < ventaMenor)
            {
                ventaMenor = this.productos[i].getVentas();
                nomProductoMenor = this.productos[i].getNombre();
            } 
        }
        System.out.println("Venta Mayor: " + "\n" + "Producto: " + nomProductoMayor + " Precio: " + ventaMayor);
        System.out.println("Venta Menor: " + ventaMenor + "\n" + "Producto: " + nomProductoMenor + " Precio: " + ventaMenor);
    }
    
}
