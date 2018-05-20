package chat;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Mensagem implements Serializable {
	private String texto;
	private String remetente;
	private String destinatario;
	private DateFormat dataDeEnvio;
	private boolean visto;
	
	public String getTexto() {
		return this.texto;
	}
	public String getRemetente()
	{
		return this.remetente;
	}
	public String getDestinatario()
	{
		return this.destinatario;
	}
	public DateFormat getDataDeEnvio() {
		return this.dataDeEnvio;
	}
	public boolean isVisto()
	{
		return this.visto;
	}
	public void setVisto()
	{
		this.visto=true;
	}
	public Mensagem (String texto, String remetente, String destinatario)
	{
		this.texto=texto;
		this.remetente=remetente;
		this.destinatario=destinatario;
		this.dataDeEnvio=new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		this.visto=false;
	}
	public Mensagem (String texto, String remetente, String destinatario, DateFormat dataDeEnvio, boolean visto)
	{
		this.texto=texto;
		this.remetente=remetente;
		this.destinatario=destinatario;
		this.dataDeEnvio=dataDeEnvio;
		this.visto=visto;
	}
	public String toString()
	{
		return this.getDataDeEnvio().toString()+" "+this.getRemetente()+" disse para "+this.getDestinatario()+": "+this.getTexto()+" visto: "+this.isVisto();
	}
}
