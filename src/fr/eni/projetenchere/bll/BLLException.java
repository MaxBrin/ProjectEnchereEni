package fr.eni.projetenchere.bll;

public class BLLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BLLException() {
		super();
	}

	public BLLException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BLLException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BLLException(String arg0) {
		super(arg0);
	}

	public BLLException(Throwable arg0) {
		super(arg0);
	}

}
