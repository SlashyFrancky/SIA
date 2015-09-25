import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TextFileLineParser {

	private FileInputStream fstream;
	private BufferedReader br;
	private ArrayList<String> lines;

	
	public TextFileLineParser(String filename) throws FileNotFoundException{
		this.fstream = new FileInputStream (filename);
		this.br = new BufferedReader(new InputStreamReader(fstream));
		this.lines = new ArrayList<String>();
	}
	
	public ArrayList<String> getLines() throws IOException{
		String line; 
		
		while((line = br.readLine()) != null ){
			lines.add(line);
		}
		return lines;
	}
}
