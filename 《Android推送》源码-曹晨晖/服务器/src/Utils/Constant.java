package Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Constant {
		public static int CLIENT_CONN_TIMEOUT = 10;
		public void mian() {
			// TODO Auto-generated method stub
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (int i = 0; i < 100000; i++) {
				map.put(i, "string" + i);
			}

			long startTime = System.currentTimeMillis();
			for (int i : map.keySet()) {
				map.get(i);
			}
			long endTime = System.currentTimeMillis();
			System.out.println("time = " + (endTime - startTime));

			startTime = System.currentTimeMillis();
			Iterator<Entry<Integer, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<Integer, String> entry= iterator.next();
			}
			endTime = System.currentTimeMillis();
			System.out.println("time = " + (endTime - startTime));
		}
}
