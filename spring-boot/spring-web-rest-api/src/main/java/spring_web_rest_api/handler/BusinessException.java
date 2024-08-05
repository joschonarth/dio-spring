package spring_web_rest_api.handler;

public class BusinessException extends RuntimeException {
	public BusinessException(String mensagem) {
		super(mensagem);
	}
	public BusinessException(String mensagem, Object ... params) {
		super(String.format(mensagem, params));
	}
}