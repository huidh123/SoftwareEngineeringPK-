package controler;

import java.util.ArrayList;

import javax.ejb.FinderException;

import Utils.Utils;

import model.ConnectModel;
import model.Connector;
import model.Message;
import model.MessageControler;

public class EXMessageControler {
	private ConnectModel connectModel;
	private MessageControler messageControler;
	
	public EXMessageControler(ConnectModel connectModel) {
		this.connectModel = connectModel;
		messageControler = new MessageControler();
	}
	
	public void sendMsgToOneConnector(String uuid,String msgText){
		Connector connector = connectModel.findConnectByUuid(uuid);
		if(connector.getIoSession() != null){
			connector.getIoSession().write("MESSAGE"+msgText);
		}
		Message msg = new Message(uuid,msgText,Utils.getCurrentTimestamp());
		messageControler.addMessage(msg);
		
	}
	
	public void sendMsagToAllConnector(String msgText){
		ArrayList<Connector> connList = connectModel.getAllConnector();
		for(Connector conn : connList){
			if(conn.getIoSession() != null){
				conn.getIoSession().write("MESSAGE"+msgText);
			}
		}
		Message msg = new Message("ALL",msgText,Utils.getCurrentTimestamp());
		messageControler.addMessage(msg);
	}
	
	public void sendUnRecieveMsg(Connector connector){
		ArrayList<Message> unRevieMsg = messageControler.getMessageAfterTime(connector.getLastConnTime().toString(), connector.getUuid());
		System.out.println("推送未发送信息");
		for(Message msg : unRevieMsg){
			System.out.println("推送成功一条");
			connector.getIoSession().write("MESSAGE"+msg.getMessage());
		}
	}
}
