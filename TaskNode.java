import java.util.concurrent.Callable;


/**
 * @author fgMai
 * TaskNodes for internal saving as well as execution thread tasks
 */
public class TaskNode extends AbstractNode implements Callable{

	boolean executionStarted = false;
	boolean taskFinished = false;
	long startTime = System.currentTimeMillis();
	long endTime = System.currentTimeMillis();

	public TaskNode(String name, int id, Type type) {
		this.setID(id);
		this.setTypeNode(type);
		this.setName(name);
		this.setX(0);
		this.setY(0);
	}

	public TaskNode(String name, int id, Type type, int x, int y) {
		this(name, id, type);
		this.setX(x);
		this.setY(y);
	}

	private Result doTaskCalc() {
		Result r = new Result();
		return r;
	}

	private Result  doTaskWriting() {
		Result r = new Result();
		return r;
		}

	private Result doTaskReading() {
		Result r = new Result();
		return r;
		}

	private Result  doOtherTask() {
		Result r = new Result();
		return r;
		}
	@Override
	public Result call() throws Exception {
		executionStarted = true;
		Result r = new Result();
		switch (this.getTypeNode()) {

		case TASK_CALC:
			r = this.doTaskCalc();
			break;
		case TASK_WRITE:
			r = this.doTaskWriting();
			break;
		case TASK_READ:
			r =  this.doTaskReading();
			break;
		case TASK_OTHER:
			r =  this.doOtherTask();
			break;
		default:
			break;

		}
		taskFinished = false;
		endTime = System.currentTimeMillis();

		return r;
	}

}