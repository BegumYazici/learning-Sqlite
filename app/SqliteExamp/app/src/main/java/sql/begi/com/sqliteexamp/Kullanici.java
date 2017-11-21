package sql.begi.com.sqliteexamp;

/**
 * Created by asus1 on 28.8.2017.
 */
public class Kullanici {   //gecici arayuz

    String isim;
    int id;

    public Kullanici(){
    }

    public Kullanici(String isim) {
        this.isim = isim;
    }

    public Kullanici(String isim, int id) {
        this.isim = isim;
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return ""+id+"-"+isim;
    }
}
