package generic3;

	public class Util {
	    public static <K, V> boolean compareLegume(Legume<K, V> p1, Legume<K, V> p2) {
	        return p1.getLegume().equals(p2.getLegume());
	    }
	    
	    public static <K, V> boolean compareLieu(Legume<K, V> p1, Legume<K, V> p2) {
	        return p1.getJardin().equals(p2.getJardin());
	    }
	    public static <K, V> boolean compareLegumeJardin(Legume<K, V> p1, Legume<K, V> p2) {
	        return p1.getLegume().equals(p2.getLegume()) &&
	               p1.getJardin().equals(p2.getJardin());
	    }
	}