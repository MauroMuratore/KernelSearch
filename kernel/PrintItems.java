package kernel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import gurobi.GRB;
import gurobi.GRBException;
import gurobi.GRBVar;

public class PrintItems {
	
	private static BufferedWriter bw;
	
	public PrintItems() {
	}
	
	
	public static void print(Kernel kernel, List<Bucket> buckets, String path) {
		path = path + "list_k_b.txt";
		try
		{
			bw = new BufferedWriter(new FileWriter(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		write("KERNEL");
		writeItems(kernel.getItems());
		
		for(int i=0; i<buckets.size(); i++) {
			write("BUCKET " + i);
			writeItems(buckets.get(i).getItems());
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void writeItems(List<Item> list) {
		for(Item i: list) {
			write(i.getName() + " " + i.getXr() + " " + i.getRc() + " " +
					i.getValue() + " " + i.getWeight() + " "  + (double) i.getValue()/ (double) i.getWeight() );
		}
	}
	
	private static void write(String line) {
		try {
			bw.append(line);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
