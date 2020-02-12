package br.com.ss.exception;

public class VeiculoExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3421037767849044495L;

	public VeiculoExistenteException(String mensagem) {
		super(mensagem);
	}

	public VeiculoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
