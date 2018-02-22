package Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nicolalisci on 20/02/18.
 */

public class Bisettimanale implements Serializable {


    private String wb_name;
    private String wb_data;
    private String wb_ora;
    private String wb_temp;
    private String wb_umid;
    private String wb_id;


    public Bisettimanale() {

        this.wb_name = wb_name;
        this.wb_data = wb_data;
        this.wb_ora = wb_ora;
        this.wb_temp = wb_temp;
        this.wb_umid = wb_umid;
        this.wb_id = wb_id;

    }

    private ArrayList<Bisettimanale> bisettimanaleArrayList;

    public String getWb_name() {
        return wb_name;
    }

    public void setWb_name(String wb_name) {
        this.wb_name = wb_name;
    }

    public String getWb_data() {
        return wb_data;
    }

    public void setWb_data(String wb_data) {
        this.wb_data = wb_data;
    }

    public String getWb_ora() {
        return wb_ora;
    }

    public void setWb_ora(String wb_ora) {
        this.wb_ora = wb_ora;
    }

    public String getWb_temp() {
        return wb_temp;
    }

    public void setWb_temp(String wb_temp) {
        this.wb_temp = wb_temp;
    }

    public String getWb_umid() {
        return wb_umid;
    }

    public void setWb_umid(String wb_umid) {
        this.wb_umid = wb_umid;
    }

    public String getWb_id() {
        return wb_id;
    }

    public void setWb_id(String wb_id) {
        this.wb_id = wb_id;
    }
}





