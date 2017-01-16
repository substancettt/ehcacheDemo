package ehcacheDemo.replication.rep1;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class Rep1 implements Runnable {
    static int id = 1;

    public static void main(String[] args) {
        new Rep1().run();
    }

    @Override
    public void run() {
        CacheManager manager = CacheManager.newInstance("src/ehcacheDemo/replication/rep1/ehcache.xml");
        Cache cache = manager.getCache("rep");
        cache.put(new Element("key1", "value1"));
        while (true) {
            id += 3;
            System.out.println("Rep1 ------ " + cache.getKeys());
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
