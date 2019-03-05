package com.example.veintiuno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txt1,txt2;
    int i=0;
    Integer valor=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);





    }

    @Override
    public void onClick(View v) {

        Random random =new Random();
        Integer rand=random.nextInt(9)+1;
        txt1.setText(rand.toString());
        valor+=rand;
        txt2.setText(valor.toString());
        v.setEnabled(false);
        boolean st=Statusbotones();


        if (valor>21)
        {
            Toast.makeText(this,"perdiste",Toast.LENGTH_SHORT).show();
        }
        if (!st && valor<=21)
        {
            Toast.makeText(this,"Ganaste",Toast.LENGTH_SHORT).show();
        }if (valor==21)
        {
            Toast.makeText(this,"Ganaste",Toast.LENGTH_SHORT).show();
        }

    }
    public  boolean Statusbotones()
    {
        boolean r=false;
        ViewGroup vp=(ViewGroup) findViewById(R.id.contbotones);
        int t=vp.getChildCount();
        for (int i=0;i<t;i++)
        {
            View view =vp.getChildAt(i);
            if (view instanceof Button)
            {
                if (!view.isEnabled())
                {
                    r= true;
                }
            }
        }

        return r;
    }
}
