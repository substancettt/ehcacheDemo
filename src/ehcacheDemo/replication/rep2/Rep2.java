package ehcacheDemo.replication.rep2;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Rep2 implements Runnable {
    static int id = 2;

    public static void main(String[] args) {
        new Rep2().run();
    }

    @Override
    public void run() {
        CacheManager manager = CacheManager.newInstance("src/ehcacheDemo/replication/rep2/ehcache.xml");
        Cache cache = manager.getCache("rep");
        cache.put(new Element("key2", "value2"));
        while (true) {
            id += 3;
            System.out.println("Rep2 ------ " + cache.getKeys());
            Element element = new Element("key" + id, "value" + id);
            cache.put(element);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
