package br.com.fiap;

import java.net.Socket;
import java.util.Scanner;

public class Client {
	
    Socket socket;

    public void comunicarComServidor() throws Exception {
    	
        String textoRequisicao = "Conexão estabelecida";
        String textoRecebido = "";
        socket = new Socket("localhost", 9600);

        Scanner input = new Scanner(System.in);
        
        System.out.print("\n Digite o ID do produto: ");
        textoRequisicao = input.nextLine();
        
        ConexaoTCP.enviar(socket, textoRequisicao);

        textoRecebido = ConexaoTCP.receber(socket);

        System.out.println("Servidor enviou: " + textoRecebido);
    }

    public static void main(String[] args) {
        try {
            Client cliente = new Client();
            cliente.comunicarComServidor();
        } catch(Exception e){
            e.printStackTrace();
        }
    } 
}
