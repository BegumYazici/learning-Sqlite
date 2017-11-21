package sql.begi.com.sqliteexamp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus1 on 28.8.2017.
 */
public class VeriKaynagi {  //db ye insert delete select islemlerinin yapıldıgı katman.

    SQLiteDatabase db;   //Veri kaynagi sınıfı aslında hem sql kendi dbsine hem de yazmıs oldugumuz bizim db erişim saglamalı.
    Sqlite_Katmani bdb;

    public VeriKaynagi(Context c){
        bdb= new Sqlite_Katmani(c);   //bdb yi initalize etmem gerektigi için bu islemi constructor ıcerısınde yapıyoruz.
    }

    public void ac(){
        db=bdb.getWritableDatabase();
    }

    public void kapat(){
        bdb.close();
    }

    public int kullaniciOlustur(String isim){   //insert
      //  String isim="begum yazici";
     //   Kullanici k = new Kullanici();
     //   k.setIsim(isim);

        ContentValues val = new ContentValues();  //db'ye kayıt geçmemizi sağlayan degisken
        val.put("isim", isim);  //isim alanına ekle.
        int sonid= (int) db.insert("kullanici", null, val);  //db ye val degiskenini ekle. Val degiskeni de icindeki veriyi isim kolonuna ekle.

        return sonid;
    }

    public void kullaniciSil(Kullanici k){   //delete
        int id =k.getId();
        db.delete("kullanici","id="+id, null);
    }

    public List<Kullanici> listele(){   //select
        List<Kullanici> liste = new ArrayList<Kullanici>();
        String[] kolonlar = {"id","isim"};
        Cursor c = db.query("kullanici",kolonlar,null,null,null,null,null,null);
        c.moveToFirst();
        if(!c.isAfterLast()){  //listede son elemana gelene kadar cursor ı hareket ettir.
            int id =c.getInt(0);
            String isim =c.getString(1);
            String eleman = ""+id+"-"+isim;
            Kullanici k = new Kullanici();
            k.setId(id);
            k.setIsim(isim);
            liste.add(k);
            c.moveToNext();
        }
        c.close();
        return liste;
    }
}
