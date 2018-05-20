package chat;
import java.net.URL;
import java.util.Scanner;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;


public class ChatCliente {
	
	public static void main(String args[]) throws Exception {
	    URL url = new URL("http://127.0.0.1:9876/chat?wsdl");
	    QName qname = new QName("http://chat/","ChatServerImplService");
	    Service ws = Service.create(url, qname);
	    ChatServer chat = ws.getPort(ChatServer.class);
	    Scanner keyboard = new Scanner(System.in);
	    System.out.println("Digite seu nome de usuario");
	    String usuario=keyboard.nextLine();
	    while (true) {
	    	System.out.println("Digite 1 para enviar uma mensagem, digite 2 para checar pro mensagens recebidas, digite 0 para encerrar: ");
	    	String input=keyboard.nextLine();
	    	if (input.equals("1"))
	    	{
	    		System.out.println("Digite o nome do usuario destinatario: ");
		    	String destinatario=keyboard.nextLine();
		    	System.out.println("Digite a mensagem: ");
		    	String texto=keyboard.nextLine();
		    	chat.sendMsg(texto, usuario, destinatario);
	    	}
	    	else if (input.equals("2"))
	    	{
	    		String msg=chat.getMsg(usuario);
	    		if (msg==null || msg.equals(""))
	    			System.out.println("nao ha nenhuma mensagem pra voce");
	    		else
	    			System.out.println(msg);
	    	}
	    	else if (input.equals("0"))
	    		break;
	    	else
	    		System.out.println("entrada invalida, tente novamente");
	    }
	    
	 
	  }
}
