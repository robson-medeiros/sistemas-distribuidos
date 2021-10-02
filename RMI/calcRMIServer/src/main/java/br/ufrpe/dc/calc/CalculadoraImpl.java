package br.ufrpe.dc.calc;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * Implementação da interface CalculadoraInterface
 */
public class CalculadoraImpl extends UnicastRemoteObject implements br.ufrpe.dc.calc.CalculadoraInterface {

	protected CalculadoraImpl() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public double somar(double x, double y) throws RemoteException {

		return x + y;
	}

	@Override
	public double subtrari(double x, double y) throws RemoteException {

		return x - y;
	}

	@Override
	public double multiplicar(double x, double y) throws RemoteException {

		return x * y;
	}

	@Override
	public double dividir(double x, double y) throws RemoteException {

		return x / y;
	}

    
    
}
