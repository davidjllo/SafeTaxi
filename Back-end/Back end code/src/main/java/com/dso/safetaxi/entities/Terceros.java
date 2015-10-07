package com.dso.safetaxi.entities;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Terceros {
	// campos de la tabla usuarios
	
	private String idTercero;
    private String tipoId;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String dirPpal;
    private String razonSocial;
    private Integer idCiudadPpal;
    private String dirMail;
    private Integer idCiudadMail;
    private Integer idZona;
    private String telPpal;
    private String telOficina;
    private String telFax;
    private String telOtro;
    private String telCel1;
    private String telCel2;
    private String email1;
    private String email2;
    private String grupoId;
    private String genero;
    private String pathFoto;
    private Date fechaIngreso;	
    private Date fechaUltcambio;
    private String estado;
    private String idUserModifico;
    private String ctrlEdicion;
    
    public String getIdTercero() {
        return this.idTercero;
    }
    
    public void setIdTercero(String idTercero) {
        this.idTercero = idTercero;
    }
    
    public String getTipoId() {
        return this.tipoId;
    }
    
    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }
    public String getNombre1() {
        return this.nombre1;
    }
    
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }
    
    public String getNombre2() {
        return this.nombre2;
    }
    
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }
    
    public String getApellido1() {
        return this.apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
    public String getApellido2() {
        return this.apellido2;
    }
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    
    public String getDirPpal() {
        return this.dirPpal;
    }
    
    public void setDirPpal(String dirPpal) {
        this.dirPpal = dirPpal;
    }
    
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    public Integer getIdCiudadPpal() {
        return this.idCiudadPpal;
    }
    
    public void setIdCiudadPpal(Integer idCiudadPpal) {
        this.idCiudadPpal = idCiudadPpal;
    }
    
    public String getDirMail() {
        return this.dirMail;
    }
    
    public void setDirMail(String dirMail) {
        this.dirMail = dirMail;
    }
    
    public Integer getIdCiudadMail() {
        return this.idCiudadMail;
    }
    
    public void setIdCiudadMail(Integer idCiudadMail) {
        this.idCiudadMail = idCiudadMail;
    }
    
    public Integer getIdZona() {
        return this.idZona;
    }
    
    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }
    
    public String getTelPpal() {
        return this.telPpal;
    }
    
    public void setTelPpal(String telPpal) {
        this.telPpal = telPpal;
    }
    
    public String getTelOficina() {
        return this.telOficina;
    }
    
    public void setTelOficina(String telOficina) {
        this.telOficina = telOficina;
    }
    
    public String getTelFax() {
        return this.telFax;
    }
    
    public void setTelFax(String telFax) {
        this.telFax = telFax;
    }
    
    public String getTelOtro() {
        return this.telOtro;
    }
    
    public void setTelOtro(String telOtro) {
        this.telOtro = telOtro;
    }
    
    public String getTelCel1() {
        return this.telCel1;
    }
    
    public void setTelCel1(String telCel1) {
        this.telCel1 = telCel1;
    }
    
    public String getTelCel2() {
        return this.telCel2;
    }
    
    public void setTelCel2(String telCel2) {
        this.telCel2 = telCel2;
    }
    
    public String getEmail1() {
        return this.email1;
    }
    
    public void setEmail1(String email1) {
        this.email1 = email1;
    }
    
    public String getEmail2() {
        return this.email2;
    }
    
    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    
    public String getGrupoId() {
        return this.grupoId;
    }
    
    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }
    
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public String getPathFoto() {
        return this.pathFoto;
    }
    
    public void setPathFoto(String pathFoto) {
        this.pathFoto = pathFoto;
    }
    
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public Date getFechaUltcambio() {
        return this.fechaUltcambio;
    }
    
    public void setFechaUltcambio(Date fechaUltcambio) {
        this.fechaUltcambio = fechaUltcambio;
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getIdUserModifico() {
        return this.idUserModifico;
    }
    
    public void setIdUserModifico(String idUserModifico) {
        this.idUserModifico = idUserModifico;
    }
    
    public String getCtrlEdicion() {
        return this.ctrlEdicion;
    }
    
    public void setCtrlEdicion(String ctrlEdicion) {
        this.ctrlEdicion = ctrlEdicion;
    }
    
    
    public Terceros() {
    }
    
    public Terceros(String idTercero, String tipoId, String nombre1, String nombre2, String apellido1, String apellido2, String dirPpal, String razonSocial, Integer idCiudadPpal, String dirMail, Integer idCiudadMail, Integer idZona, String telPpal, String telOficina, String telFax, String telOtro, String telCel1, String telCel2, String email1, String email2, String grupoId, String genero, String pathFoto, Date fechaIngreso, Date fechaUltcambio, String estado, String idUserModifico) { 
        this.idTercero = idTercero;
        this.tipoId = tipoId;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dirPpal = dirPpal;
        this.razonSocial = razonSocial;
        this.idCiudadPpal = idCiudadPpal;
        this.dirMail = dirMail;
        this.idCiudadMail = idCiudadMail;
        this.idZona = idZona;
        this.telPpal = telPpal;
        this.telOficina = telOficina;
        this.telFax = telFax;
        this.telOtro = telOtro;
        this.telCel1 = telCel1;
        this.telCel2 = telCel2;
        this.email1 = email1;
        this.email2 = email2;
        this.grupoId = grupoId;
        this.genero = genero;
        this.pathFoto = pathFoto;
        this.fechaIngreso = fechaIngreso;
        this.fechaUltcambio = fechaUltcambio;
        this.estado = estado;
        this.idUserModifico = idUserModifico;
        this.ctrlEdicion = ctrlEdicion;
    }
    
}
