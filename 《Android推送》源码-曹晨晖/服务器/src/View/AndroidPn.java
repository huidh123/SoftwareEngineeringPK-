/*
 * AndroidPn.java
 *
 * Created on __DATE__, __TIME__
 */

package View;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import model.ConnectModel;
import model.Connector;
import model.LoginControler;
import model.User;
import Interface.Observer;
import Server.MinaTestServer;
import ViewModel.AllConnectorCombleBoxModel;
import controler.ConnectControler;
import controler.EXMessageControler;

/**
 * 
 * @author __USER__
 */
public class AndroidPn extends javax.swing.JFrame implements Observer {

	private LoginControler loginControler;
	private ConnectModel connectModel;
	private ConnectControler connectControler;
	private EXMessageControler messageControler;

	/** Creates new form AndroidPn */
	public AndroidPn() {
		initComponents();
		initView();
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		popupMenu1 = new java.awt.PopupMenu();
		popupMenu2 = new java.awt.PopupMenu();
		popupMenu3 = new java.awt.PopupMenu();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		jLabel1 = new javax.swing.JLabel();
		cb_all_user = new javax.swing.JComboBox();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tp_message_content = new javax.swing.JTextPane();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTable2 = new javax.swing.JTable();
		jButton3 = new javax.swing.JButton();
		lb_is_online = new javax.swing.JLabel();

		popupMenu1.setLabel("PopupMenu");

		popupMenu2.setLabel("PopupMenu");

		popupMenu3.setLabel("PopupMenu");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null },
						{ null, null, null, null } }, new String[] { "Title 1",
						"Title 2", "Title 3", "Title 4" }));
		jScrollPane2.setViewportView(jTable1);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("\u662f\u5426\u5728\u7ebf\uff1a");

		cb_all_user.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "推送给全部用户" }));
		cb_all_user.setName("cb_all_user");
		cb_all_user.addItemListener(new CbItemListener());
		cb_all_user.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				cb_all_userMouseClicked(evt);
			}
		});
		

		jLabel2.setText("\u9009\u62e9\u63a8\u9001\u7528\u6237\uff1a");

		jLabel3.setText("\u8f93\u5165\u63a8\u9001\u5185\u5bb9:");

		tp_message_content.setName("et_message");
		jScrollPane1.setViewportView(tp_message_content);

		jButton1.setText("\u63a8\u9001\u4fe1\u606f");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u6e05\u9664\u5168\u90e8");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jTable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null },
						{ null, null, null } }, new String[] { "时间", "用户",
						"状态信息" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jScrollPane3.setViewportView(jTable2);

		jButton3.setText("\u5f3a\u5236\u4e0b\u7ebf");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		lb_is_online.setText("\u5426");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jScrollPane1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						382,
																						Short.MAX_VALUE)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jLabel2)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										cb_all_user,
																										0,
																										293,
																										Short.MAX_VALUE))
																				.addGroup(
																						javax.swing.GroupLayout.Alignment.TRAILING,
																						layout.createSequentialGroup()
																								.addComponent(
																										jScrollPane3,
																										javax.swing.GroupLayout.DEFAULT_SIZE,
																										283,
																										Short.MAX_VALUE)
																								.addGap(18,
																										18,
																										18)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jButton3)
																												.addComponent(
																														jButton1)))
																				.addGroup(
																						layout.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																								.addComponent(
																										lb_is_online)
																								.addComponent(
																										jLabel3)))
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		89,
																		Short.MAX_VALUE)
																.addGap(305,
																		305,
																		305))
												.addGroup(
														javax.swing.GroupLayout.Alignment.TRAILING,
														layout.createSequentialGroup()
																.addComponent(
																		jButton2)
																.addContainerGap()))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														cb_all_user,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(lb_is_online))
								.addGap(9, 9, 9)
								.addComponent(jLabel3)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										90,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jButton2)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		110,
																		Short.MAX_VALUE)
																.addComponent(
																		jButton3)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton1))
												.addComponent(
														jScrollPane3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														141,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		tp_message_content.setText("");
	}

	private void cb_all_userMouseClicked(java.awt.event.MouseEvent evt) {

	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		connectControler.disconnectOneConnector(cb_all_user.getSelectedItem().toString());
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		messageControler.sendMsgToOneConnector(cb_all_user.getSelectedItem()
				.toString(), tp_message_content.getText());
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AndroidPn().setVisible(true);
			}
		});
	}

	private void initView() {
		ServerThread serverThread = new ServerThread();
		serverThread.start();
		connectModel = ConnectModel.getInstance();
		connectModel.addObserver(this);
		connectControler = new ConnectControler();
		messageControler = new EXMessageControler(connectModel);
		update();

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JComboBox cb_all_user;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JTable jTable1;
	private javax.swing.JTable jTable2;
	private javax.swing.JLabel lb_is_online;
	private java.awt.PopupMenu popupMenu1;
	private java.awt.PopupMenu popupMenu2;
	private java.awt.PopupMenu popupMenu3;
	private javax.swing.JTextPane tp_message_content;

	// End of variables declaration//GEN-END:variables
	@Override
	public void update() {
		// TODO Auto-generated method stub
		// cb_all_user.setModel(aModel);
		System.out.println("fresh");
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel(
				connectModel.getAllConnectorUuidArr());
		cb_all_user.setModel(boxModel);
	}

	// 推送核心服务线程
	class ServerThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			MinaTestServer minaTestServer = MinaTestServer.getInstance();
			minaTestServer.start();
		}
	}

	class CbItemListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			
			String selectUuid = (String) cb_all_user.getSelectedItem();
			Connector connector = connectModel.findConnectByUuid(selectUuid);
			if (connector.isOnline()) {
				lb_is_online.setText("是");
			} else {
				lb_is_online.setText("否");
			}

		}
	}

}