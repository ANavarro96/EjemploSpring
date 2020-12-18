package liceosorollab.accesoadatos.excepcion;

import java.util.Date;

public class MiError {

	String mensaje;
	Date error;
	
	public MiError(String mensaje, Date error) {
		super();
		this.mensaje = mensaje;
		this.error = error;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Date getError() {
		return error;
	}
	public void setError(Date error) {
		this.error = error;
	}
	
	
}
