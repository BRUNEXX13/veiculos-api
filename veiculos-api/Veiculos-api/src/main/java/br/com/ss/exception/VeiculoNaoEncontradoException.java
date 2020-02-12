package br.com.ss.exception;

public class VeiculoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4707561371440657440L;

	public VeiculoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public VeiculoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}	
