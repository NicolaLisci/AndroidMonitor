package com.example.nicolalisci.fetchjson;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nicolalisci on 15/02/18.
 */

public class Whitebox implements Serializable{
    private String wb_id;
    private String wb_nome;
    private String wb_descrizione;
    private String wb_ip;
    private String wb_temp;
    private String wb_umid;
    private String wb_data;
    private String wb_ora;

    public Whitebox()
    {
        this.wb_id=wb_id;
        this.wb_nome=wb_nome;
        this.wb_descrizione=wb_descrizione;
        this.wb_ip=wb_ip;
        this.wb_temp=wb_temp;
        this.wb_umid=wb_umid;
        this.wb_data=wb_data;
        this.wb_ora=wb_ora;
    }
    private ArrayList<Whitebox> whiteboxes;

    public String getWb_id() {
        return wb_id;
    }

    public String getWb_nome() {
        return wb_nome;
    }

    public String getWb_descrizione() {
        return wb_descrizione;
    }

    public String getWb_ip() {
        return wb_ip;
    }

    public String getWb_temp() {
        return wb_temp;
    }

    public String getWb_umid() {
        return wb_umid;
    }

    public String getWb_data() {
        return wb_data;
    }

    public String getWb_ora() {
        return wb_ora;
    }

    public String setWb_id(String wb_id) {
        this.wb_id = wb_id;
        return wb_id;
    }

    public void setWb_nome(String wb_nome) {
        this.wb_nome = wb_nome;
    }

    public void setWb_descrizione(String wb_descrizione) {
        this.wb_descrizione = wb_descrizione;
    }

    public void setWb_ip(String wb_ip) {
        this.wb_ip = wb_ip;
    }

    public void setWb_temp(String wb_temp) {
        this.wb_temp = wb_temp;
    }

    public void setWb_umid(String wb_umid) {
        this.wb_umid = wb_umid;
    }

    public void setWb_data(String wb_data) {
        this.wb_data = wb_data;
    }

    public void setWb_ora(String wb_ora) {
        this.wb_ora = wb_ora;
    }
}




