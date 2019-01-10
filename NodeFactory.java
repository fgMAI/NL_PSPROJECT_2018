
/**
 * @author fgMai
 *concrete node factory as part of factoryDesign pattern
 */


public class NodeFactory extends AbstractNodeFactory {
	private static int id = 0;

	/**
	 * @return fresh unique id
	 */
	public static synchronized int getId() {
		id++;
		return id;
	}

	/**
	 * @return reset id to 0
	 */
	
	public static synchronized void resetId() {
		NodeFactory.id = 0;
	}

	/**
	 * @return TaskNode with unique id
	 */
	
	public TaskNode getTaskNode(String name, AbstractNode.Type nodetype) {

		return new TaskNode(name, getId(), nodetype);
	}
	
	/**
	 * @return TaskNode with unique id
	 * @param x used in task pattern x_of_y
	 * @param y used in task pattern x_of_y
	 */
	public TaskNode getTaskNode(String name, AbstractNode.Type nodetype, int x, int y) {

		return new TaskNode(name, getId(), nodetype, x, y);
	}

	/**
	 * @return GateNode with unique id
	 */
	
	public GateNode getLogicNode(String name, AbstractNode.Type nodetype) {

		return new GateNode(name, getId(), nodetype);
	}

}
