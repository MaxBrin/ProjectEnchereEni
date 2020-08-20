package fr.eni.projetenchere.dal;

public class DALException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DALException() {
		super();
	}

	public DALException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public DALException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DALException(String arg0) {
		super(arg0);
	}

	public DALException(Throwable arg0) {
		super(arg0);
	}

}
