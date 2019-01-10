
/**
 * 
 */

/**
 * @author fgMai
 * abstract factory as part of factoryDesign pattern
 */
public abstract class AbstractNodeFactory {

	public abstract TaskNode getTaskNode(String name, AbstractNode.Type nodetype);

	public abstract GateNode getLogicNode(String name, AbstractNode.Type nodetype);

}
