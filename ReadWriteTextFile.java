
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * @author morganC
 * class providing methods to write and read execution pattern from respectively to files
 */

public class ReadWriteTextFile {

	
	public static enum Syntax {
		minors, vectors , runtimeDecisions , TASK_WRITE, TASK_READ ,TASK_OTHER , TASK_CALC
	}
	public static void read() {
		try {
			Scanner scanner = new Scanner(new File("Dag-Graph.txt"));
			String line = "tmp";
			int x = 0;
			ArrayList<AbstractNode> Nodes = new ArrayList<AbstractNode>();
			while (true) {
				line = scanner.nextLine();
				if (line.equals(Syntax.minors.toString()))
					break;
				String tmp[] = line.split("/");
				Nodes.add(new TaskNode(tmp[0], x, AbstractNode.Type.valueOf(tmp[1])));
				x++;
			}
			int firstSmall = x;

			Pattern pattern = Pattern.compile(".+/\\d+/\\d+");

			while (true) {
				line = scanner.nextLine();
				if (line.equals(line.equals(Syntax.vectors.toString())))
					break;
				Matcher matcher = pattern.matcher(line);
				if (matcher.matches()) {
					String nums[] = line.split("/");
					Nodes.add(new GateNode(nums[0], x, AbstractNode.Type.X_OUTOF_Y, Integer.parseInt(nums[1]),
							Integer.parseInt(nums[2])));
					continue;
				}
				String tmp[] = line.split("/");

				Nodes.add(new GateNode(tmp[0], x, AbstractNode.Type.valueOf(tmp[1])));
				x++;
			}
			while (true) {
				line = scanner.nextLine();
				if (line.equals(Syntax.vectors.toString()))
					break;
				String nums[] = line.split(">");
				AbstractNode node1 = Nodes.get(Integer.parseInt(nums[0]));
				AbstractNode node2 = Nodes.get(Integer.parseInt(nums[1]));
				node1.addFollower(node2);
				node2.addPrecedent(node1);
			}
			/*
			 * while(scanner.hasNextLine()) { line =scanner.nextLine(); String
			 * pairs[]=line.split(","); for(int i=0;i<pairs.length;i++) { String
			 * nums[]=line.split(",");
			 * 
			 * }
			 * 
			 * 
			 * }
			 */
			scanner.close();
			for (int y = 0; y < Nodes.size(); y++) {
				System.out.println("*");
				System.out.println(Nodes.get(y).toString());
				Nodes.get(y).printPredecent();
				Nodes.get(y).printFollower();
				System.out.println("*");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void write() throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter writer = new PrintWriter("Dag-Graph.txt", "UTF-8");
		writer.println("A/"+Syntax.TASK_WRITE.toString());
		writer.println("B/"+Syntax.TASK_CALC.toString());
		writer.println("C/"+Syntax.TASK_CALC.toString());
		writer.println(Syntax.minors.toString());
		writer.println("name/AND");
		writer.println("vectors");
		writer.println("0>3");
		writer.println("3>1");
		writer.println("3>2");
		writer.println(Syntax.runtimeDecisions.toString());
		writer.println("3>1,3>2");
		writer.close();
	}
}