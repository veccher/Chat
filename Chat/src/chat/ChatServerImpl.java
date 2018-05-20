package chat;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.jws.WebService;

@WebService(endpointInterface = "chat.ChatServer")
public class ChatServerImpl implements ChatServer {
	
	private synchronized ArrayList<Mensagem> getMensagens ()
	{
		ArrayList<Mensagem> l=null;
		try {
			FileInputStream file = new FileInputStream("msgFile.ser");
			ObjectInputStream in=new ObjectInputStream(file);
			l=(ArrayList<Mensagem>) in.readObject();
			if (in!=null)
				in.close();
			if (file!=null)
				file.close();
		} catch (FileNotFoundException e) {
			return new ArrayList<Mensagem>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	private synchronized void saveMensagens(ArrayList<Mensagem> mensagens) throws IOException
	{
		FileOutputStream file=new FileOutputStream("msgFile.ser",false);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(mensagens);
		out.close();
		file.close();
	}
	@Override
	public synchronized void sendMsg(String texto, String remetente, String destinatario) throws IOException {
		ArrayList<Mensagem> mensagens=getMensagens();
		Mensagem m=new Mensagem(texto,remetente,destinatario);
		if (mensagens==null)
			mensagens=new ArrayList<Mensagem>();
		mensagens.add(m);
		saveMensagens(mensagens);
		
	}

	@Override
	public synchronized String getMsg(String usuario) throws IOException, ClassNotFoundException {
		ArrayList<Mensagem> mensagens = getMensagens();
		String mensagem="";
		for (Mensagem msg:mensagens)
		{
			if (msg.getDestinatario().equals(usuario) && !msg.isVisto() && mensagem.equals(""))
			{
				mensagem=msg.getRemetente()+": "+msg.getTexto();
				msg.setVisto();
			}
		}
		//recria o arquivo, atualizando o campo "visto" da mensagem que vai ser lida agora..
		saveMensagens(mensagens);
		return mensagem;
	}
}