package app.sinc.bean;
/**
 * @author mnieves
 *
 */
public class BeanConfiguracion {
	
	private String id_tabla_config;
	private String cod_config;
	private String dsc_valor;
	private String usr_ult_mod;
	private String fec_ult_mod;
	
	public String getId_tabla_config() {
		return id_tabla_config;
	}
	public void setId_tabla_config(String id_tabla_config) {
		this.id_tabla_config = id_tabla_config;
	}
	public String getCod_config() {
		return cod_config;
	}
	public void setCod_config(String cod_config) {
		this.cod_config = cod_config;
	}
	public String getDsc_valor() {
		return dsc_valor;
	}
	public void setDsc_valor(String dsc_valor) {
		this.dsc_valor = dsc_valor;
	}
	public String getUsr_ult_mod() {
		return usr_ult_mod;
	}
	public void setUsr_ult_mod(String usr_ult_mod) {
		this.usr_ult_mod = usr_ult_mod;
	}
	public String getFec_ult_mod() {
		return fec_ult_mod;
	}
	public void setFec_ult_mod(String fec_ult_mod) {
		this.fec_ult_mod = fec_ult_mod;
	}
	
}
