package ViewModel;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ListDataListener;

import model.ConnectModel;
import model.Connector;
import model.User;

public class AllConnectorCombleBoxModel extends AbstractListModel implements
		ComboBoxModel {

	ArrayList<Connector> userList;
	Connector seleConn = null;

	public AllConnectorCombleBoxModel(ArrayList<Connector> userList) {
		this.userList = userList;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		if (userList != null) {

			return userList.size();
		}
		return 0;
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		Connector user = userList.get(index);
		return user.getUuid();
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		if (seleConn != null && !seleConn.equals(anItem) || seleConn == null
				&& anItem != null) {
			seleConn = (Connector) anItem;
			fireContentsChanged(this, -1, -1);
		}
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub

		return seleConn;
	}

}
