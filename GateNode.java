
/**
 * @author morganC
 *
 */
public class GateNode extends AbstractNode {

	public GateNode(String name, int id, Type nodetype) {
		this.setID(id);
		this.setTypeNode(nodetype);
		this.setName(name);
		this.setX(0);
		this.setY(0);
	}

	public GateNode(String name, int id, Type nodetype, int x, int y) {
		this(name, id, nodetype);
		this.setX(x);
		this.setY(y);

	}

}