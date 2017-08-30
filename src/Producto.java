/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Estudiante
 */
public class Producto 
{
    private String nombre;
    private String tipo;
    private int undMinimas;
    private double precioBase;
    private int cantidadActual;

    public Producto() 
    {
        
    }

    public Producto(String nombre, String tipo, int undMinimas, double precioBase, int cantidadActual) 
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.undMinimas = undMinimas;
        this.precioBase = precioBase;
        this.cantidadActual = cantidadActual;
    }

    

    public String getNombre() 
    {
        return nombre;
    }

    public String getTipo()
    {
        return tipo;
    }

    public int getUndMinimas() 
    {
        return undMinimas;
    }

    public double getPrecioBase()
    {
        return precioBase;
    }

    public int getCantidadActual()
    {
        return cantidadActual;
    }
    
    

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) 
    {
        this.tipo = tipo;
    }

    public void setUndMinimas(int undMinimas)
    {
        this.undMinimas = undMinimas;
    }

    public void setPrecioBase(double precioBase) 
    {
        this.precioBase = precioBase;
    }

    public void setCantidadActual(int cantidadActual)
    {
        this.cantidadActual = cantidadActual;
    }
    
    
    
    
    
    
}
