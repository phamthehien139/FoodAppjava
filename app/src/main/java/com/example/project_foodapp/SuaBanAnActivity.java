package com.example.project_foodapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project_foodapp.DAO.BanAnDAO;


public class SuaBanAnActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnDongYSua;
    private EditText edSuaTenBan;
    private BanAnDAO banAnDAO;

    int maban;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_ban_an);

        btnDongYSua = findViewById(R.id.btnDongYSuaBanAn);
        edSuaTenBan = findViewById(R.id.edSuaTenBanAn);

        banAnDAO = new BanAnDAO(this);

        maban = getIntent().getIntExtra("maban", 0);

        btnDongYSua.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String tenban = edSuaTenBan.getText().toString();
        if (tenban.trim().equals("") || tenban.trim() != null){
            boolean kiemtra = banAnDAO.CapNhatTenBan(maban, tenban);
            Intent intent = new Intent();
            intent.putExtra("kiemtra", kiemtra);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }else
            Toast.makeText(SuaBanAnActivity.this, getResources().getString(R.string.vuilongnhapdulieu), Toast.LENGTH_SHORT).show();
    }

}
