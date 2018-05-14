package chat;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ChatServer {
	  @WebMethod float sendMsg(float num1, float num2);
	  @WebMethod float getMsgs(float num1, float num2);
	  @WebMethod float acao(float num1, float num2);
	  @WebMethod float divisao(float num1, float num2);
}
