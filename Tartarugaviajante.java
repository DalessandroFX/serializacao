import java.io.Serializable;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class tartaruga implements Serializable{
    public String nome;
    public int idade; 
    public double alt;
    private static final long serialversonUID = 2l;
    
    public tartaruga(String nome, int idade, Double alt){
        this.nome = nome;
        this.idade = idade;
        this.alt = alt;

    }
}
public class Tartarugaviajante {
    public static void main(String[] args) {
        tartaruga tar = new tartaruga( "leon",100,2.50);

        try
        { 
            FileOutputStream infos = new FileOutputStream("infos.ser");
        ObjectOutputStream out = new ObjectOutputStream(infos);
        out.writeObject(tar);
        out.close();
        infos.close();
        System.out.println("foi serializado");
        }
        catch(IOException erro)
        {
            System.out.println("erro");
        }

        tartaruga tar1;
        try
        {
            FileInputStream infos = new FileInputStream("infos.ser");
            ObjectInputStream in = new ObjectInputStream(infos);

            tar1 = (tartaruga)in.readObject();
            in.close();
            infos.close();

            System.out.println("O objeto foi desserializado");
            System.out.println(tar1.nome);
            System.out.println(tar1.idade);
            System.out.println(tar1.alt);


        }

        catch(IOException erro)
        {
            System.out.println("Erro 1");
        }
        
        catch (ClassNotFoundException erro) 
        {
            System.out.println("Erro");
        }
        
    }
}
