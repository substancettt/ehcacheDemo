package ehcacheDemo.replication.rep3;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Rep3 implements Runnable {
    static int id = 3;

    public static void main(String[] args) {
        new Rep3().run();
    }

    @Override
    public void run() {
        CacheManager manager = CacheManager.newInstance("src/ehcacheDemo/replication/rep3/ehcache.xml");
        Cache cache = manager.getCache("rep");
        cache.put(new Element("key3", "value3"));
        while (true) {
            id += 3;
            System.out.println("Rep3 ------ " + cache.getKeys());
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
