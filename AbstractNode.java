
import java.util.ArrayList;


/**
 * @author cMorgan
 * Abstract node to ensure all nodes provide methods and contain variables
 */
public abstract class AbstractNode {
	private String name;
	private int id;
	private Type typeNode;
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * this enum is for all types of nodes
	 *
	 */
	public static enum Type {
		SEQ, START_NODE, AND, OR, XOR, Dis, X_OUTOF_Y, TASK_WRITE, TASK_READ, TASK_CALC, TASK_DISPALAY, TASK_OTHER
	}

	protected ArrayList<AbstractNode> follower = new ArrayList<AbstractNode>();
	protected ArrayList<AbstractNode> precedent = new ArrayList<AbstractNode>();

	public void addFollower(AbstractNode n) {
		follower.add(n);
	}

	public void addPrecedent(AbstractNode n) {
		precedent.add(n);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public Type getTypeNode() {
		return typeNode;
	}

	public void setTypeNode(Type typeNode) {
		this.typeNode = typeNode;
	}

	public ArrayList<AbstractNode> getFollower() {
		return follower;
	}

	public void setFollower(ArrayList<AbstractNode> follower) {
		this.follower = follower;
	}

	public ArrayList<AbstractNode> getPrecedent() {
		return precedent;
	}

	public void setPrecedent(ArrayList<AbstractNode> precedent) {
		this.precedent = precedent;
	}

	public void printPredecent() {

		for (AbstractNode n : precedent) {
			System.out.println(
					"Pre Node of\t" + this.getID() + "\t" + this.getName() + " :\t" + n.getID() + "\t" + n.getName());
			n.getName();

		}

	}

	public void printFollower() {

		for (AbstractNode n : precedent) {
			System.out.println(
					"Pre Node of\t" + this.getID() + "\t" + this.getName() + " :\t" + n.getID() + "\t" + n.getName());
			n.getName();

		}

	}

	@Override
	public String toString() {
		return "AbstractNode [name=" + name + ", id=" + id + ", typeNode=" + typeNode + ", x=" + x + ", y=" + y + "]";
	}

}