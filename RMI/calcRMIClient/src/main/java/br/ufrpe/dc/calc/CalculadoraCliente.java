package br.ufrpe.dc.calc;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculadoraCliente {
	public static void main(String[] args) {
        try {
           CalculadoraInterface calc = (CalculadoraInterface) Naming.lookup("rmi://localhost:5509/RMI-Calculadora");
           double resultado = calc.somar(8.0, 9.8);
            System.out.println("Resultado: " + resultado);
            
        } catch (NotBoundException ex) {
            System.out.println(ex.getMessage());
        } catch (MalformedURLException ex) {
        	System.out.println(ex.getMessage());
        } catch (RemoteException ex) {
        	System.out.println(ex.getMessage());
        }
      
   }

}
