package exercise.algorithms4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author lsp
 *
 */
public class E1_1_21_inAndPrint {

	public static void main(String[] args) {
		
//		inAndPrint();
		
		inAndPrint2();
		
	}
	
	public static void inAndPrint(){
		StdOut.print("请输入记录数量: ");
		int number = StdIn.readInt();
		String[] names = new String[number];
		int[] firstDatas = new int[number];
		int[] secondDatas = new int[number];
		
		StdOut.println("请输入记录: ");
		String line = "";
		int count = 0; 
		// 循环获取记录
		while(StdIn.hasNextLine()){
			line = StdIn.readLine();
			if(!line.isEmpty()){
				if(line.trim().equals("exit")) break;
				String[] datas = line.split(" ");
				names[count] = datas[0];
				firstDatas[count] = Integer.parseInt(datas[1]);
				secondDatas[count] = Integer.parseInt(datas[2]);
				count++;
				if(count >= number){
					break;
				}
			}
		}
		// 输出
		for(int i = 0; i < number; i++){
			if(names[i] == null) continue;
			StdOut.printf("%-6s %d  %d  %.3f\n", names[i], firstDatas[i], secondDatas[i], 
					secondDatas[i] == 0 ? 0 : firstDatas[i] * 1.0 / secondDatas[i]);
		}
	}
	
	public static void inAndPrint2(){
		String[] data = StdIn.readAllStrings();
		for(int i = 0; i < data.length; i = i + 3){
			double first = Double.parseDouble(data[i + 1]);
			double second = Double.parseDouble(data[i + 2]);
			StdOut.printf("%-6s %-4s %-4s %.3f\n", data[i], data[i + 1], data[i + 2], 
					second == 0 ? 0 : first / second);
		}
	}

}
