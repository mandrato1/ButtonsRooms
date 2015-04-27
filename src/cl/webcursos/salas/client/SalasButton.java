/**
 * 
 */
package cl.webcursos.salas.client;


import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ToggleButton;

/**
 * @author Francisco García
 *
 */
public class SalasButton extends ToggleButton {

	private String nombreSala;
	private int idModulo;
	private String nombreModulo;
	private String inicioModulo;
	private String terminoModulo;
	private boolean sobreescribir = false;
	private boolean ocupado = false;
	private PopupPanel popup = null;
	private int idSala;
	/**
	 * @param upText
	 * @param downText
	 * @param handler
	 */
	public SalasButton(String sala,int idSala,String horaInicio,String horaFin,String modulo,int idModulo, boolean ocupa, boolean sobree, String upText, String downText, ClickHandler handler) {
		super(upText, downText, handler);
		this.nombreSala = sala;
		this.idSala = idSala;
		this.nombreModulo = modulo;
		this.sobreescribir = sobree;
		this.ocupado = ocupa;
		this.idModulo = idModulo;
		this.inicioModulo = horaInicio;
		this.terminoModulo = horaFin;
		
		
		this.popup = new PopupPanel(true);
		
		this.popup.setWidget(new HTML("<div>Modulo: "+modulo+"<br>("+horaInicio+"-"+horaFin+")<br><br> Sala:"+sala+"</div>"));
		
		this.addMouseOverHandler(new MouseOverHandler() {			
			@Override
			public void onMouseOver(MouseOverEvent event) {
				popup.setPopupPosition(getAbsoluteLeft(), getAbsoluteTop() + getOffsetHeight());
				popup.show();
			}
		});
		
		this.addMouseOutHandler(new MouseOutHandler() {			
			@Override
			public void onMouseOut(MouseOutEvent event) {
				popup.hide();
			}
		});
	
		if(!this.ocupado){
			this.setStylePrimaryName("Boton-disponible");
		} else {
			this.setStylePrimaryName("Boton-ocupado-nulo");
			if(!this.sobreescribir) {
				this.setEnabled(false);
			}
		}
	
	}

	public String getSala() {
		return this.nombreSala;
	}
	public String getModulo() {
		return this.nombreModulo;
	}
	public String getModuloInicio() {
		return this.inicioModulo;
	}
	public String getModuloTermino() {
		return this.terminoModulo;
	}
	public int getModuloid() {
		return this.idModulo;
	}
	public int getSalaid() {
		return this.idSala;
	}

	@Override
	protected void onLoad() {
		super.onLoad();
		
		this.popup.setPopupPosition(this.getAbsoluteLeft(), this.getAbsoluteTop());
	}

}