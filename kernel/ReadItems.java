package kernel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadItems {
	
	private BufferedReader br;
	private String line = "";
	
	public List<Item> read(String pathmps){
		try {
			br=new BufferedReader(new FileReader(pathmps));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		readUntilColumns();
		List<Item> ritorno = readItems();
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ritorno;
	}
	
	private List<Item> readItems() {
		ArrayList<Item> ritorno = new ArrayList<Item>();
		while(!line.equals("RHS")) {
			if(line.contains("OBJ")) {
				String[] split = line.trim().split("\\s+");
				ritorno.add(new Item(split[0], Integer.valueOf(split[2].trim()), 
						Integer.valueOf(split[4].trim())));
			}
			nextLine();
		}
		return ritorno;
	}
	
	private void readUntilColumns() {
		while(!line.equals("COLUMNS")) {
			nextLine();
		}
		nextLine();
	}
	
	private void nextLine() {
		try {
			line= br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
