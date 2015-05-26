package Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javassist.expr.Instanceof;

import javax.enterprise.inject.Instance;

import model.ConnectModel;
import model.Connector;
import model.LoginControler;
import model.Message;
import model.MessageControler;
import model.User;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import Utils.Utils;

import DBHelper.DBManaer;

import controler.ConnectControler;
import controler.EXMessageControler;
/**
 * sessionhandler�࣬��Ҫ�����Ǵ�����ܵ��ĵ���session���͵���Ϣ�������û����ӽ���ʱ�洢�����ݿ�
 * @author ����
 *
 */
public class MyTestHandler extends IoHandlerAdapter {

	private LoginControler loginControler;
	private ConnectModel connectModel;
	private ConnectControler connectControler;
	private EXMessageControler msgControler;
	public MyTestHandler() {
		loginControler = LoginControler.getInstance();
		connectModel = ConnectModel.getInstance();
		connectControler = new ConnectControler();
		msgControler = new EXMessageControler(connectModel);
	}

	//һ��session�Ͽ�����
	@Override
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(session, cause);
		System.out.println("�׳��쳣");
		if (session != null) {
			session.close(true);
			System.out.println("socket�Ͽ�");
		}
	}


	
	@Override
	public void inputClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.inputClosed(session);
		// System.out.println("session closed");
	}

	//session���յ�����
	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception {
		// TODO Auto-generated method stub
		super.messageReceived(session, message);
		if (message instanceof String) {
			String recieveStr = (String) message;
			String reciMessageUuid = "";
			// socket�ս���ʱ����֤����
			if (recieveStr.startsWith("CLIENTLOGIN")) {
				reciMessageUuid = recieveStr.replaceFirst("CLIENTLOGIN", "");
				User user = null;
				if (connectModel.findConnectByUuid(reciMessageUuid)!=null) {
					//��������������
					connectControler.reconnectOneConnector(reciMessageUuid, session);
					System.out.println("a old user "+reciMessageUuid+ " is connect");
				} else {
					connectControler.createNewConnector(reciMessageUuid, session);
					//�����Ӽ���
					System.out.println("a new user  " + " is connect");
				}
			}
			// �Ͽ�����
			else if (recieveStr.startsWith("CLIENT_DISCONNECT")) {
				session.write("SERVER_DISCONNECT");
				connectControler.disconnectOneConnector(reciMessageUuid);
			}
		}

	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
		
		String closeSessionUUID = (String) session.getAttribute("UUID");
		System.out.println(closeSessionUUID+ " : session is closes");
		connectControler.disconnectOneConnector(closeSessionUUID);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
		System.out.println("connnect");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status)
			throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
		
		String closeSessionUUID = (String) session.getAttribute("UUID");
		System.out.println(closeSessionUUID+":session idle");
		connectControler.disconnectOneConnector(closeSessionUUID);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionOpened(session);
		session.write("CONNECT");
	}
}
