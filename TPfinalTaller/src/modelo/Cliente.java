package modelo;

public class Cliente extends Persona
{
    private String cuit;
    private String razon_social;
    private String grupos_de_clientes;
    
    public Cliente()
    {
        super();
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

    public void setGrupos_de_clientes(String grupos_de_clientes)
    {
        this.grupos_de_clientes = grupos_de_clientes;
    }

    public String getGrupos_de_clientes()
    {
        return grupos_de_clientes;
    }
}
