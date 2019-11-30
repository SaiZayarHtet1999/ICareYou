package com.cu.sai.saiboommenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cu.sai.saiboommenu.R.id;
import com.github.barteksc.pdfviewer.PDFView;

import static com.cu.sai.saiboommenu.R.id.boomCalorie;

public class CaloriePdf extends AppCompatActivity {

        private boolean jumptofit;
        private int num=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_pdf);
        PDFView pdfView=findViewById(id.CaloriePDF);
        pdfView.fromAsset("calorie.pdf").load();

    }
}
