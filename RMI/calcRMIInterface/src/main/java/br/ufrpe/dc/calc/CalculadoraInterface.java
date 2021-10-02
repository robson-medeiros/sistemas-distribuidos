package br.ufrpe.dc.calc;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Imterface de uma Calculadora
 * 
 */
public interface CalculadoraInterface extends Remote {
    
    
    public double somar(double x, double y) throws RemoteException;
    public double subtrari(double x, double y) throws RemoteException;
    public double multiplicar(double x, double y) throws RemoteException;
    public double dividir(double x, double y) throws RemoteException;
}
