package com.evaluacion.dto.response;

public abstract class Response {
    public String mensaje ="";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
