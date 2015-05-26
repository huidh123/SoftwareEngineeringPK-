package model;

import java.util.ArrayList;
import java.util.Vector;

import javax.security.auth.login.LoginException;

import org.apache.mina.core.session.IoSession;

import Interface.Observer;
import Interface.Pulisher;
import Utils.Utils;

public class ConnectModel implements Pulisher {
	private ArrayList<Connector> connectorList;
	private static ConnectModel connectModel = null;
	private ArrayList<Observer> observerList;
	private LoginControler loginControler;

	private ConnectModel() {
		connectorList = new ArrayList<Connector>();
		observerList = new ArrayList<Observer>();
		loginControler = LoginControler.getInstance();
		connectorList = loginControler.getAllConnector();
		notifyAllObserver();
	}

	public static ConnectModel getInstance() {
		if (connectModel == null) {
			connectModel = new ConnectModel();
		}
		return connectModel;
	}

	public void addConnector(Connector connector) {
		connectorList.add(connector);
		loginControler.addNewConnector(connector);
		notifyAllObserver();
	}

	public void getAllConnectorFromDB() {
		connectorList = loginControler.getAllConnector();
		notifyAllObserver();
	}

	public void updateConnectTime(Connector conn) {

		conn.setLastConnTime(Utils.getCurrentTimestamp());
		loginControler.updateSessionConnTime(conn);
		notifyAllObserver();
	}

	public void removeConnector(String uuid) {
		for (int i = 0; i < connectorList.size(); i++) {
			if (connectorList.get(i).getUuid().equals(uuid)) {
				connectorList.remove(i);
				break;
			}
		}
	}

	public void testPushMsg() {
		for (Connector connector : connectorList) {
			connector.getIoSession().write("MESSAGEÄãºÃ£¡£¡£¡");
		}
	}

	public Connector findConnectByUuid(String uuid) {
		for (int i = 0; i < connectorList.size(); i++) {
			if (connectorList.get(i).getUuid().equals(uuid)) {
				return connectorList.get(i);
			}
		}
		return null;
	}

	public ArrayList<Connector> getAllConnector() {
		return this.connectorList;
	}

	public String[] getAllConnectorUuidArr() {
		String[] uuidArr = new String[connectorList.size()];
		for (int i = 0; i < connectorList.size(); i++) {
			uuidArr[i] = connectorList.get(i).getUuid();
		}
		return uuidArr;
	}

	@Override
	public void addObserver(Observer observer) {
		// TODO Auto-generated method stub
		observerList.add(observer);
	}

	@Override
	public void deleteObserver(Observer observer) {
		// TODO Auto-generated method stub
		observerList.remove(observer);
	}

	@Override
	public void notifyAllObserver() {
		// TODO Auto-generated method stub
		for (Observer observer : observerList) {
			System.out.println("Ë¢ÐÂÒ³Ãæ");
			observer.update();
		}
	}
}
