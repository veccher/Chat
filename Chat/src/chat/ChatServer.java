package chat;

import javax.jws.WebService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ChatServer {
	  @WebMethod void sendMsg(String texto, String remetente, String destinatario) throws IOException;
	  @WebMethod String getMsg(String usuario) throws FileNotFoundException, IOException, ClassNotFoundException;
}
