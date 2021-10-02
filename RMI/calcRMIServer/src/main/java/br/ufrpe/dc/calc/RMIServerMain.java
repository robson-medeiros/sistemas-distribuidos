package br.ufrpe.dc.calc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServerMain {

	public static void main(String[] args) {
		try {

			Registry registry = LocateRegistry.createRegistry(5509);
			registry.rebind("RMI-Calculadora", new CalculadoraImpl());
		} catch (RemoteException ex) {
			ex.printStackTrace();
			return;
		}

		System.out.println("Servidor aguardando requisições.");
	}
}
