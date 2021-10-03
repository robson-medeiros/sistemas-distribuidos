package br.ufrpe.dc.sd;

import java.net.*;
import java.io.*;

public class ClienteUDP {
	public static void main(String args[]) {
// args fornece o conteúdo da mensagem e o nome de host do servidor 
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			String mensagem = "Olá";
			String endereco = "localhost";
			byte[] m = mensagem.getBytes();
			InetAddress aHost = InetAddress.getByName(endereco);
			int serverPort = 6789;
			DatagramPacket request = new DatagramPacket(m, m.length, aHost, serverPort);
			aSocket.send(request);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Reply: " + new String(reply.getData()));
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
	}
}