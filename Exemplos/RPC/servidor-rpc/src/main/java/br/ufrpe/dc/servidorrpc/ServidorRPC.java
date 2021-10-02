package br.ufrpe.dc.servidorrpc;

import java.io.IOException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class ServidorRPC {

	public static void main(String[] args) {

		System.out.println("Iniciando o servidor........");

		
		try {
			// Instanciando o objetivo WebServer com a definição da porta
			WebServer server = new WebServer(8080);

			XmlRpcServer xmlRpcServer = server.getXmlRpcServer();

			PropertyHandlerMapping phm = new PropertyHandlerMapping();

			phm.addHandler("Calculadora", Calculadora.class);
			xmlRpcServer.setHandlerMapping(phm);

			XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
			serverConfig.setEnabledForExtensions(true); // Habilita valores float

			server.start();

			System.out.println("Servidor inicializado.");
			System.out.println("Aguardando requisições.");

		} catch (IOException | XmlRpcException e) {
			e.printStackTrace();
		}

	}

}
