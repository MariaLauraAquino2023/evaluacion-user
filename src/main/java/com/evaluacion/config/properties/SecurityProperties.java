package com.evaluacion.config.properties;

/**
 * Properties utilizadas para jwt
 */
public class SecurityProperties {
    private String jwtSignatureKey;
    private Integer tokenValidityInMinutes;

    public String getJwtSignatureKey() {
        return jwtSignatureKey;
    }

    public void setJwtSignatureKey(String jwtSignatureKey) {
        this.jwtSignatureKey = jwtSignatureKey;
    }

    public Integer getTokenValidityInMinutes(){return tokenValidityInMinutes;}
    public void setTokenValidityInMinutes(Integer tokenValidity){ this.tokenValidityInMinutes = tokenValidity;}

}
