package br.ufrpe.dc.sd;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class TCPCliente {
	public static void main(String args[]) {
// os argumentos fornecem a mensagem e o nome de host de destino
		Socket s = null;
		String nome = "-";

		while (!nome.isBlank()) {
			try {

				System.out.print("\n\nInforme um nome: ");
				Scanner ler = new Scanner(System.in);
				nome = ler.nextLine();

				if (!nome.isBlank()) {
					int serverPort = 7896;

					String endereco = "localhost";
					s = new Socket(endereco, serverPort);

					DataInputStream in = new DataInputStream(s.getInputStream());
					DataOutputStream out = new DataOutputStream(s.getOutputStream());
					out.writeUTF(nome); // UTF é uma codificação de string; veja a Seção 4.3
					String data = in.readUTF();
					System.out.println("Resposta: " + data);
				}
			} catch (UnknownHostException e) {
				System.out.println("Sock:" + e.getMessage());
			} catch (EOFException e) {
				System.out.println("EOF:" + e.getMessage());
			} catch (IOException e) {
				System.out.println("IO:" + e.getMessage());
			} finally {
				if (s != null)
					try {
						s.close();
					} catch (IOException e) {
						/* close falhou */}
			}
		}

	}
}