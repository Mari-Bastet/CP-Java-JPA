/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fiap;

/**
 *
 * @author MSWagner
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Server {
    Socket socketClient;
    ServerSocket serversocket;
    String mensagemProduto;
    SimpleDateFormat formatacao = new SimpleDateFormat("dd/MM/yyyy");

    public boolean connect() {
        try {
            socketClient = serversocket.accept();  //**fase de conexao**
            return true;
        } catch (IOException e) {
            System.err.println("Nao fez conexão " + e.getMessage());
            return false;
        }
    }
    
    public String chamaDao(int id) {
    	
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLIENT_ORACLE");

        ProdutoDAOImpl dao = new ProdutoDAOImpl(emf.createEntityManager());
               
        Produto produto = dao.buscarProdutoPorId(id);
      //  System.out.println(formatacao.format(produto.getDataValidade()));
        
        mensagemProduto = "\nNome: " + produto.getNomeProduto() +
        				  "\nDescrição: " + produto.getDescricaoProduto() +
        				  "\nTamanho: " + produto.getPrecoProduto();
       
        return mensagemProduto;
    }

    public static void main(String[] args) {
        try {
            Server servidor = new Server();
            servidor.rodarServidor();
        } catch(Exception e){
            e.printStackTrace();
        }
    } 

    public void rodarServidor() throws Exception {
        String textoRecebido = "";
        String textoEnviado = "Olá, Cliente";

        serversocket = new ServerSocket(9600);
        System.out.println("Servidor iniciado!");

        while(true) {

            if (connect()) {
            	
                textoRecebido = ConexaoTCP.receber(socketClient);
                
                System.out.println("Cliente enviou: " + textoRecebido.replaceAll("[^0-9]", ""));      
                
               textoEnviado = chamaDao(Integer.parseInt(textoRecebido.replaceAll("[^0-9]", "")));       
                
                ConexaoTCP.enviar(socketClient, textoEnviado);
                socketClient.close(); 
            }
        }
    }
}
