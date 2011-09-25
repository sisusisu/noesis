package test.ikor.model.mock;

// Title:       Document
// Version:     1.0
// Copyright:   2006
// Author:      Fernando Berzal
// E-mail:      berzal@acm.org


import ikor.model.*;
import ikor.model.description.*;

// Document
// --------------------------------

// v1.0 - 16/08/2006

@Persistent(id="DOCUMENT")
@Label("Documento")
@Description("Ejemplo de uso de asociaciones entre clases: Representaci�n de documentos")
public class Document 
{

    @Key
    @Persistent(type=DataType.Integer)
    @Label("ID")
    @Description("Identificador del documento")
    protected int    id;

    @Persistent(type=DataType.String, size=256, nullable=false)
    @Label("T�tulo")
    @Description("T�tulo del documento")   
    protected String title;

    @Persistent(type=DataType.String, size=256)
    @Label("Autor")
    @Description("Autor(es) del documento")
    protected String author;

    @Persistent(type=DataType.String, size=256)
    @Label("Fuente")
    @Description("Origen del documento")
    protected String source;

    // Derived attribute
    @Label("Cita")
    @Description("Cita bibliogr�fica")
    @Derived("author+\": \"+title+\". \"+source")
    protected String citation;

    @Persistent
    @Label("Formato")
    @Description("Formato del documento")
    protected Format format;

    @Persistent
    @Label("Propietario")
    @Description("Usuario responsable del documento")
    protected User owner;
}
