package com.example.adsl4.aarogya;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DoctorInformation extends AppCompatActivity {
    int[] IMAGES= {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e,R.drawable.f,R.drawable.g};
    String[] NAMES={"Dr. Ram","Dr. Shyam","Dr. Sheetal","Dr. Subina","Dr. Bhagwan","Dr Amita","Dr Sunita"};
    String[] DESCRIPTION={"Gynaecologist","Child Care","General Physician","Internal Medicine","Surgeon","Gynaecologist","Surgeon"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_information);
        listView=findViewById(R.id.lstDoctor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(DoctorInformation.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(DoctorInformation.this);
                }
                builder.setTitle("Call Doctor?")
                        .setMessage("Are you sure you want to call Doctor?")
                        .setIcon(R.drawable.ic_call_black_24dp)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9849823323"));
                                startActivity(intent);
                                Toast.makeText(DoctorInformation.this, "Calling: 9849823323", Toast.LENGTH_SHORT).show();
                                if (ActivityCompat.checkSelfPermission(DoctorInformation.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                    // TODO: Consider calling
                                    //    ActivityCompat#requestPermissions
                                    // here to request the missing permissions, and then overriding
                                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                    //                                          int[] grantResults)
                                    // to handle the case where the user grants the permission. See the documentation
                                    // for ActivityCompat#requestPermissions for more details.
                                    return;
                                }
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .show();
            }
        });

    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.customlayout,null);
            ImageView imageView=view.findViewById(R.id.imageView2);
            TextView txt1=view.findViewById(R.id.textView2);
            TextView txt2=view.findViewById(R.id.textView3);

            imageView.setImageResource(IMAGES[i]);
            txt1.setText(NAMES[i]);
            txt2.setText(DESCRIPTION[i]);

            return view;
        }
    }
}
