package com.uax.accesodatos.AppFutbolApi.dto.equipos;

import java.util.ArrayList;

public class Root{
    public String get;
    public Parameters parameters;
    public ArrayList<Object> errors;
    public int results;
    public Paging paging;
    public ArrayList<Response> response;
}
