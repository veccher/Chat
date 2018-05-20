package chat;

import javax.jws.WebService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ChatServer {
	  @WebMethod void sendMsg(Mensagem msg) throws IOException;
	  @WebMethod ArrayList<Mensagem> getMsgs(String usuario) throws FileNotFoundException, IOException, ClassNotFoundException;
}
