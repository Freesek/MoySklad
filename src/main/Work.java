package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Work {
	private final String sourceFileName;
	private FileReader fileReader = null;
	private final List<Integer> listId = new ArrayList<>();
	private final HashMap<Integer, String> map = new HashMap<>();
	
	public Work(String sourceFileName) {
		this.sourceFileName = sourceFileName;
	}
	
	public static void main(String[] args) {
		Work obj = new Work(args[0]);
		obj.readFile();
		obj.findCycles();
	}
	
	public void readFile() {
		String line = null;
		String[] twoNumbers = new String[2];
		try {
			fileReader = new FileReader(sourceFileName);
			BufferedReader reader = new BufferedReader(fileReader);
			while((line = reader.readLine()) != null) {
				twoNumbers = line.split(" ");
				int id = Integer.parseInt(twoNumbers[0]);
				listId.add(id);
				map.put(id, twoNumbers[1]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void findCycles() {
		for(int i = 0; i < listId.size(); i++) {
			boolean isCycle = false;
			if(map.get(listId.get(i)) != null){
					isCycle = addToMap(listId.get(i));
			} else {
				listId.remove(i);
				i--;
			}
			if(isCycle) {
				System.out.println(listId.get(i) + " " + map.get(listId.get(i)));
				String[] delete = map.get(listId.get(i)).split(" ");
				for(int k = 0; k < delete.length; k++) {
					map.remove(Integer.parseInt(delete[k]));
				}
			} else {
				map.remove(listId.get(i));
			}
		}
	}
	
	private boolean addToMap(int mapKey) {
		boolean isCycle = false;
		int key = mapKey;
		while(true) {
			if(map.get(Integer.parseInt(map.get(key))) != null) {
				String[] numbers = map.get(mapKey).split(" ");
				if(mapKey == (int) Integer.parseInt(numbers[numbers.length - 1])) { 
					isCycle = true;
					break;
				} else {
					key = Integer.parseInt(map.get(key));
					if(map.get(mapKey).contains(map.get(key))) {
						break;
					}
					map.put(mapKey, map.get(mapKey) + " " + map.get(key));
				}
			} else {
				break;
			}
		}
		return isCycle;
	}
}
