package sql.begi.com.sqliteexamp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asus1 on 21.11.2017.
 */

public class Sqlite_Katmani extends SQLiteOpenHelper {  //db yi tanımladıgımız katman

    public Sqlite_Katmani(Context c){
        super(c,"kullanici",null,1);   //db=kullanici, versiyon=1
    }
    @Override
    public void onCreate(SQLiteDatabase db) {  //db daha onceden olusturumadıysa
        String sql = ("create table kullanici(id INTEGER primary key AUTOINCREMENT, isim TEXT not null);");
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int eski, int yeni) {  //db de guncelleme yapılmak istendiginde
        db.execSQL("drop table if exists kullanici");
    }
}
