package com.ipartek.formacion.webservice.interfaz;

import com.ipartek.formacion.pojo.Candidato;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace="http://com.ipartek.formacion/types", 
name="candidatows")
@XmlSeeAlso(Candidato.class)
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public interface CandidatoWS {

	@WebMethod
	@RequestWrapper(targetNamespace="http://com.ipartek.formacion/types", 
     className="java.lang.String")
	@ResponseWrapper(targetNamespace="http://com.ipartek.formacion/types", 
      className="java.lang.String")
    @XmlElementRef(name="name", required=false)
	public String getSaludo(@WebParam(targetNamespace="http://com.ipartek.formacion/types", 
            name="nombre",
            mode=Mode.IN) @XmlElement(name="nombre", required=true,nillable=true)String name);

	@WebMethod
	@RequestWrapper(targetNamespace="http://com.ipartek.formacion/types", 
    className="java.lang.Integer")
	@ResponseWrapper(targetNamespace="http://com.ipartek.formacion/types", 
     className="com.ipartek.formacion.pojo.Candidato")
	@WebResult(targetNamespace="http://com.ipartek.formacion/types", 
    name="candidato")
	public Candidato getById(@WebParam(targetNamespace="http://com.ipartek.formacion/types", 
            name="id",
            mode=Mode.IN)Integer id);
}
