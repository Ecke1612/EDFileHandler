package com.ed.filehandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectSerializer {

    public void writeObject(Object object, String path){
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try{
            fout = new FileOutputStream(path);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(object);
            fout.close();
            oos.close();
            System.out.println("Objekt geschrieben");

        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            System.out.println("Error Writing AccountObjects");
        }
    }

    public Object loadObjects(String path){
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        Object object;
        try{
            fin = new FileInputStream(path);
            ois = new ObjectInputStream(fin);
            object = ois.readObject();
            fin.close();
            ois.close();
            System.out.println("Object geladen: ");
            return object;
        }catch(Exception e){
            System.out.println("Error Loading AccountObjects");
            System.out.println(e);
            return null;
        }
    }

}
