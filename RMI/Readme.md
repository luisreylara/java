# RMI-Java

## Código completo netbeans 
* [SD.ZIP](https://github.com/luisreylara/java/blob/main/RMI/SD.zip)
* [Otro Ejemplo RMI](https://github.com/luisreylara/java/blob/main/RMI/ServidorRMI.zip)

## Videos RMI Tutoriales 
* [Video 1 - RM1](https://drive.google.com/file/d/1s9KESved63ON8n1zkMkLhHJkpph3yoH9/view)
* [Video 2 - RM1](https://drive.google.com/file/d/1psVjcncOPMfh0ch8T88mdFpwNqD2-AXE/view)

## Presentación RMI
* [Presentación RMI ](https://docs.google.com/presentation/d/1L7ug-Y6KKmQp_JtNpyiaWh2mVNrdYk01MxHSlzuLE9c/edit#slide=id.g13d22570d93_0_304)

## Servidor.java
```
package sistema_distribuido;

import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
 
public class Servidor {
    public static void main(String[] args) {
        try {
            //1099
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1100);
            System.setProperty("java.rmi.server.hostname","localhost");

            r.rebind("Calculadora", new rmi());
            System.out.println("Servidor conectado");
        } catch (Exception e) {
            System.out.println("Servidor no conectado :"+ e);
        }
    }
}
```

## Cliente_1.java
```
package sistema_distribuido;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Registry miRegistro = LocateRegistry.getRegistry("localhost",1100);
            System.setProperty("java.rmi.server.hostname","localhost");
            Calculadora c = (Calculadora) miRegistro.lookup("Calculadora");
            System.out.println("Si se conecto y encontró el método Calculadora");
                    
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "servidor no conectado "+e);
        }
    }
}

```
## Cliente_2.java
```

package sistema_distribuido;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Registry miRegistro = LocateRegistry.getRegistry("localhost",1100);
            System.setProperty("java.rmi.server.hostname","localhost");
            Calculadora c = (Calculadora) miRegistro.lookup("Calculadora");
             
            int x= Integer.parseInt(JOptionPane.showInputDialog("num1 :"));
            int y= Integer.parseInt(JOptionPane.showInputDialog("num2 :"));
            JOptionPane.showMessageDialog(null,"Suma :"+c.add(x,y));
             
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "servidor no conectado "+e);
        }
    }
}
```


## Cliente.java
```
package sistema_distribuido;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Registry miRegistro = LocateRegistry.getRegistry("localhost",1100);
            System.setProperty("java.rmi.server.hostname","localhost");
            Calculadora c = (Calculadora) miRegistro.lookup("Calculadora");
            String menu="";
            while (!menu.equals("5") ) {
                menu = JOptionPane.showInputDialog("ingrese: \n"+
                        "1.- Suma\n"+
                        "5.- Salir"
                        );
                switch (menu) {
                    case "1" :{
                        int x= Integer.parseInt(JOptionPane.showInputDialog("num1 :"));
                        int y= Integer.parseInt(JOptionPane.showInputDialog("num2 :"));
                        JOptionPane.showMessageDialog(null,"Suma :"+c.add(x,y));
                        break;
                    }
                    default:
                      //  throw new AssertionError();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "servidor no conectado "+e);
        }
    }
}
```
 ## Rmi.java
 ```
 package sistema_distribuido;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class rmi extends UnicastRemoteObject implements Calculadora{

    public rmi() throws RemoteException {
        int a,b;
    }

    @Override
    public int add(int a, int b) throws RemoteException {
            return a+b;
    }
}
 ```
 ##  Calculadora.java
 ```
 package sistema_distribuido;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote{
     public int add(int a, int b)throws RemoteException;
}
 ```

# Fuentes:
```
Sistema Distribuido en java RMI con modelo Cliente - Servidor
https://www.youtube.com/watch?v=CSzTDvhioEA
```
 
