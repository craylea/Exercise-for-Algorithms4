package exercise.algorithms4.e1_3;

import java.io.File;

import edu.princeton.cs.algs4.StdOut;
/**
 * 打印文件列表
 * @author lsp
 *
 */
public class E1_3_43_PrintFileList {

	public static void main(String[] args) {
		String org = args[0];
		File orgFile = new File(org);
//		printFileList(0, orgFile);
		QueueByCircularLinkedList queue = new QueueByCircularLinkedList();
		putFileListEnqueue(0, orgFile, queue);
		while(!queue.isEmpty()){
			StdOut.println(queue.dequeue());
		}
	}
	/**
	 * 直接打印文件列表
	 * @param layer
	 * @param file
	 */
	public static void printFileList(int layer, File file){
		if(!file.exists()){
			StdOut.println("文件目录不存在!");
			return;
		}
		for(int i = 0; i < layer; i++){
			// 本来打算使用空格的，可是汉字与其它字符前的缩进不一样，不知道为什么？没找到处理方法。
			// 网上看到|---，感觉效果还不错，嘿嘿。。。
			StdOut.print("|---"); 
		}
		StdOut.println(file.getName());
		if(file.isDirectory()){
			layer++;
			File[] files = file.listFiles();
			for(File item : files){
				printFileList(layer, item);
			}
		}
	}
	/**
	 * 把文件列表保存到队列中
	 * @param layer
	 * @param file
	 * @param queue
	 */
	public static void putFileListEnqueue(int layer, File file, QueueByCircularLinkedList queue){
		if(!file.exists()){
			StdOut.println("文件目录不存在!");
			return;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < layer; i++){
			sb.append("|---"); 
		}
		sb.append(file.getName());
		queue.enqueue(sb.toString());
		if(file.isDirectory()){
			layer++;
			File[] files = file.listFiles();
			for(File item : files){
				putFileListEnqueue(layer, item, queue);
			}
		}
	}
}
