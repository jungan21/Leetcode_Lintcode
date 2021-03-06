package sort;

/**
 * For fun. Inspiration: http://dis.4chan.org/read/prog/1295544154
 * 
 * @author zengr
 *
 */

public class Sleepsort {

	private static int[] inputArray = { 3, 1, 2, 1, 181, 10 };

	public static void main(String[] args) throws InterruptedException {
		Sleepsort ss = new Sleepsort();
		ss.sleepsort(inputArray);
	}

	// method 1:
	public void sleepsort(int[] array) throws InterruptedException {
		for (int val : array) {
			Thread thread = new Thread(new SleepsortThread(val));
			thread.start();
		}
	}

}

class SleepsortThread implements Runnable {
	private int val;

	public SleepsortThread(int val) {
		this.val = val;
	}

	@Override
	public void run() {
		try {
			// the key point is larger value, sleep for longer time
			Thread.sleep(val);
			System.out.println(val);
		} catch (InterruptedException e) {
			// Oops...
		}
	}
}
