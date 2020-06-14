package com.wollcorp.gacela.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Integer idPersona;

	@ManyToOne
	@JoinColumn(name = "id_tidoc", referencedColumnName = "id_tidoc")
	private TipoDocumento tipoDocumento;

	@Column(name = "nu_doc")
	private String nuDoc;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "ap_paterno")
	private String apPaterno;

	@Column(name = "ap_materno")
	private String apMaterno;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "fe_nac")
	private Date feNac;

	@Column(name = "email")
	private String email;

	@Column(name = "imagen")
	private String imagen;

	@Column(name = "us_crea")
	private String usCrea;

	@Column(name = "us_modi")
	private String usModi;

	@Column(name = "fe_crea")
	private LocalDateTime feCrea;

	@Column(name = "fe_modi")
	private LocalDateTime feModi;

	/**
	 * @return the idPersona
	 */
	public Integer getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * @return the tipoDocumento
	 */
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the nuDoc
	 */
	public String getNuDoc() {
		return nuDoc;
	}

	/**
	 * @param nuDoc the nuDoc to set
	 */
	public void setNuDoc(String nuDoc) {
		this.nuDoc = nuDoc;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apPaterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}

	/**
	 * @param apPaterno the apPaterno to set
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	/**
	 * @return the apMaterno
	 */
	public String getApMaterno() {
		return apMaterno;
	}

	/**
	 * @param apMaterno the apMaterno to set
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the feNac
	 */
	public Date getFeNac() {
		return feNac;
	}

	/**
	 * @param feNac the feNac to set
	 */
	public void setFeNac(Date feNac) {
		this.feNac = feNac;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * @return the usCrea
	 */
	public String getUsCrea() {
		return usCrea;
	}

	/**
	 * @param usCrea the usCrea to set
	 */
	public void setUsCrea(String usCrea) {
		this.usCrea = usCrea;
	}

	/**
	 * @return the usModi
	 */
	public String getUsModi() {
		return usModi;
	}

	/**
	 * @param usModi the usModi to set
	 */
	public void setUsModi(String usModi) {
		this.usModi = usModi;
	}

	/**
	 * @return the feCrea
	 */
	public LocalDateTime getFeCrea() {
		return feCrea;
	}

	/**
	 * @param feCrea the feCrea to set
	 */
	public void setFeCrea(LocalDateTime feCrea) {
		this.feCrea = feCrea;
	}

	/**
	 * @return the feModi
	 */
	public LocalDateTime getFeModi() {
		return feModi;
	}

	/**
	 * @param feModi the feModi to set
	 */
	public void setFeModi(LocalDateTime feModi) {
		this.feModi = feModi;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", tipoDocumento=" + tipoDocumento + ", nuDoc=" + nuDoc
				+ ", nombres=" + nombres + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", sexo=" + sexo
				+ ", feNac=" + feNac + ", email=" + email + ", imagen=" + imagen + ", usCrea=" + usCrea + ", usModi="
				+ usModi + ", feCrea=" + feCrea + ", feModi=" + feModi + "]";
	}

}
