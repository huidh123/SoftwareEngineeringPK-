package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Map;

import javax.jms.Session;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import sun.java2d.pipe.BufferedBufImgOps;

import Utils.Constant;

import com.sun.corba.se.impl.protocol.giopmsgheaders.IORAddressingInfo;


/**
 * 推送核心服务，运行在单独的一个线程中，主要负责任务是初始化配置和SessionHandler
 * 
 * @author 晨晖
 * 
 */
public class MinaTestServer {
	private static MinaTestServer minaTestServer;

	public static MinaTestServer getInstance() {
		if (minaTestServer == null) {
			minaTestServer = new MinaTestServer();
		}
		return minaTestServer;
	}

	private MinaTestServer() {

	}

	public void start() {
		System.out.println("服务器已开启");
		// 初始化Acceptor进行接受连接，接收数据
		IoAcceptor acceptor = null;
		try {
			acceptor = new NioSocketAcceptor();
			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 5);
			acceptor.getSessionConfig().setUseReadOperation(true);
			acceptor.setHandler(new MyTestHandler());
			acceptor.getFilterChain().addLast(
					"codex",
					new ProtocolCodecFilter(new TextLineCodecFactory(Charset
							.forName("UTF-8"),
							LineDelimiter.WINDOWS.getValue(),
							LineDelimiter.WINDOWS.getValue())));
			acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE,
					Constant.CLIENT_CONN_TIMEOUT);
			acceptor.bind(new InetSocketAddress(9900));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		ConnectManager connectManager = new ConnectManager(acceptor);
//		InputStreamReader inr = null;
//		BufferedReader reader = null;
//		try {
//			inr = new InputStreamReader(System.in);
//			reader = new BufferedReader(inr);
//			String controlInputStr = null;
//			// 控制台命令
//			while (!(controlInputStr = reader.readLine()).equals(null)) {
//				System.out.println("to all session : " + controlInputStr);
//				// connectManager.sendMessageToAllSession(controlInputStr);
//				connectManager.sendMessageToOneUser(controlInputStr,
//						"9cf7f108-e3b3-4228-afe1-c95c649787e5");
//			}
//		} catch (Exception e) {
//
//		} finally {
//
//			try {
//				inr.close();
//				reader.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}
