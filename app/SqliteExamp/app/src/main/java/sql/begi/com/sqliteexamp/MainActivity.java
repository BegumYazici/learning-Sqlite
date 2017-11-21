package sql.begi.com.sqliteexamp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {  //baglantının saglandıgı ve kullanıcıya sunuldugu son katmandır.

    VeriKaynagi vk;
    Button btnAdd, btnDelete;

    private void init() {
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnDelete = (Button) findViewById(R.id.btnDelete);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        vk = new VeriKaynagi(this);
        vk.ac();
        List<Kullanici> kullanicilar = vk.listele();  //oncelikle listview daki verileri almalıyız. Ondan sonra ekleme silme butonlarına tıklayıp işlem yapmalıyız.
        final ArrayAdapter<Kullanici> adapter = new ArrayAdapter<Kullanici>(this, android.R.layout.simple_list_item_1, kullanicilar); //kullanıcılar olarak aldıgımız verileri simple_list_item1 tipine donustur.
        setListAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isimler [] = {"begum yazıcı", "ali demir","gokhan alıcı","ayse gulmez"};
                Random r = new Random();
                int rand =r.nextInt(4);
                Kullanici k = new Kullanici(isimler[rand]);
                int sonid=vk.kullaniciOlustur(k.getIsim());
                k.setId(sonid);
                adapter.add(k);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Kullanici kullanici = (Kullanici) getListAdapter().getItem(0);
                vk.kullaniciSil(kullanici);
                adapter.remove(kullanici);
            }
        });
    }

    protected void onResume() {
        vk.ac();
        super.onResume();
    }

    protected void onPause() {
        vk.kapat();
        super.onPause();
    }
}

