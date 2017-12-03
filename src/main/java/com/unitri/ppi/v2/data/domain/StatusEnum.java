package com.unitri.ppi.v2.data.domain;

public enum StatusEnum {

    GOING(  "GOING" ), FINISHED( "FINISHED" );

    private String url;

    StatusEnum( String url ) {
        this.url = url;
    }

    public String url() {
        return url;
    }
    }
