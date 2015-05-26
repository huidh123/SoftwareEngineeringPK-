package controler;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import model.ConnectModel;
import model.Connector;
import model.Message;
import model.User;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.service.IoService;
import org.apache.mina.core.session.IoSession;

import Utils.Utils;

public class ConnectControler {
	private ConnectModel connectModel;

	private EXMessageControler messageControler;
	public ConnectControler() {
		// TODO Auto-generated constructor stub
		connectModel = ConnectModel.getInstance();
		messageControler = new EXMessageControler(connectModel);
	}

	
	public void disconnectOneConnector(String uuid){
		Connector conn = connectModel.findConnectByUuid(uuid);
		if(conn == null){
			System.out.println("找不到此链接");
			return;
		}
		conn.setOnline(false);
		conn.setLastConnTime(Utils.getCurrentTimestamp());
		conn.getIoSession().close(true);
		connectModel.updateConnectTime(conn);
	}
	
	public void reconnectOneConnector(String uuid,IoSession session){
		Connector conn = connectModel.findConnectByUuid(uuid);
		if(conn == null){
			System.out.println("找不到此链接");
			return;
		}
		conn.setOnline(true);
		conn.setIoSession(session);
		session.setAttribute("UUID", uuid);
		System.out.println("上次连接时间"+conn.getLastConnTime().toString());
		messageControler.sendUnRecieveMsg(conn);
		connectModel.updateConnectTime(conn);
	}
	
	public void createNewConnector(String uuid,IoSession session){
		Connector newConnector = new Connector(uuid, "connect", Utils.getCurrentTimestamp(), Utils.getCurrentTimestamp(), true, session);
		connectModel.addConnector(newConnector);
		session.setAttribute("UUID", uuid);
		connectModel.updateConnectTime(newConnector);
	}
	
}
