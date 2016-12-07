package exercise.algorithms4.e1_3;


/**
 * 删除链表指定节点之后的节点.
 * @author lsp
 *
 */
public class E1_3_39_RingBuffer {

	public static void main(String[] args) {
		RingBuffer<String> buffer = new RingBuffer<>(3);
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i < 10; i++){
					try {
						buffer.add(i + "");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i < 10; i++){
					try {
						buffer.remove();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
