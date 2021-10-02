package br.ufrpe.dc.clienterpc;

  import java.net.URL;

  import org.apache.xmlrpc.client.XmlRpcClient;
  import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
  import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

  public class ClienteRPC {
      public static void main(String[] args) throws Exception {
          // Configurações
          
    	  XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
    	  
          config.setServerURL(new URL("http://localhost:8080/xmlrpc"));
          
          config.setEnabledForExtensions(true); // Habilita  valores float
          

          XmlRpcClient client = new XmlRpcClient();
        
          // Usa Commons HttpClient como transporte
          client.setTransportFactory(
              new XmlRpcCommonsTransportFactory(client));
          // set configuration
          client.setConfig(config);

          // Faz uma chamada remota
          Object[] params = new Object[]
              { 2.0, 3.0 };
          double result = (double)client.execute("Calculadora.somar", params);
          System.out.println("40 + 9 = " + result);
        
          
      }
  }