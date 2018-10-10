package modelo;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable
{
    private String cuit;
    private String razon_social;
    private GrupoDeClientes grupos_de_clientes;
    
    public Cliente()
    {
        super();
    }


    @Override
    public String toString()
    {
        // TODO Implement this method
        return "NyA: "+this.getNombre_apellido()+" CUIT: "+this.cuit+" GrupoCliente: "+this.grupos_de_clientes;
    }

    public void setCuit (String cuit)
    {
        this.cuit = cuit;
    }

    public String getCuit()
    {
        return cuit;
    }

    public void setRazon_social(String razon_social)
    {
        this.razon_social = razon_social;
    }

    public String getRazon_social()
    {
        return razon_social;
    }

    public void setGrupos_de_clientes(GrupoDeClientes grupos_de_clientes)
    {
        this.grupos_de_clientes = grupos_de_clientes;
    }

    public GrupoDeClientes getGrupos_de_clientes()
    {
        return grupos_de_clientes;
    }
}
