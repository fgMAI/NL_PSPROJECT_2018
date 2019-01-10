
public class Result <T> {
	private boolean hasResult =false;
	private long publishTime = System.currentTimeMillis();
	private T result;
	long threadID;
	/**
	 * @return the publishTime
	 */
	public synchronized long getPublishTime() {
		return publishTime;
	}
	/**
	 * @param publishTime 
	 * 
	 * 
	 */
	public void setPublishTime() {
		this.publishTime = System.currentTimeMillis();
	}
	/**
	 * @return the result
	 */
	public T getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(T result) {
		this.result = result;
		threadID = Thread.currentThread().getId();
		this.setResultFlag();
	}
	/**
	 * @return the hasResult
	 */
	public synchronized boolean hasResult() {
		return hasResult;
	}
	/**
	 * @param hasResult the hasResult to set
	 */
	public synchronized void setResultFlag() {
		this.hasResult = true;
	}

	
	

}
