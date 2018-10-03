package modelo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;

public class Serializador implements Serializable
{
    public Serializador()
    {
        super();
    }
    
    public void guardarBaseDeDatos(BaseDatos bd) throws IOException
    {
        String path = System.getProperty("user.dir") + "/Datos/";
        File folder = new File(path);
        if (!folder.isDirectory())
            folder.mkdir();
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path+"BaseDatos.xml"))); // guarda en subdirectorio Datos
        encoder.writeObject(bd);
        encoder.close();
    }
    
    public BaseDatos recuperarBaseDeDatos() throws IOException, ClassNotFoundException
    {
        BaseDatos almacenAux = null;
        String path = System.getProperty("user.dir") + "/Datos/";
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path+"BaseDatos.xml"))); // // recupera de subdirectorio Datos
        if (decoder != null)
        {
            almacenAux = (BaseDatos) decoder.readObject();
            decoder.close();
        }
        return almacenAux;
    }

}
