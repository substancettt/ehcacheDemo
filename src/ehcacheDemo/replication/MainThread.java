package ehcacheDemo.replication;

import ehcacheDemo.replication.rep1.Rep1;
import ehcacheDemo.replication.rep2.Rep2;
import ehcacheDemo.replication.rep3.Rep3;

public class MainThread {
	
	/**
	 * 缓存1打印缓存2放进去的数据
	 * 缓存2打印缓存3放进去的数据
	 * 缓存3打印缓存1放进去的数据
	 * 只要3个线程打印出来的数据不为空就说名集群同步成功
	 */
	public static void main(String[] args) throws InterruptedException {
		Rep1 rep1 = new Rep1();
		new Thread(rep1).start();
		
		Rep2 rep2 = new Rep2();
		new Thread(rep2).start();
		
		Rep3 rep3 = new Rep3();
		new Thread(rep3).start();
		
		
		
	}
	
}
