package ru.edittext.transparent;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class MainActivity extends AppCompatActivity {

    BlurView bottomBlurView;
    BlurView topBlurView;
    BlurView middleBlurView;
    ViewGroup root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBlurView = findViewById(R.id.bottomBlurView);
        topBlurView = findViewById(R.id.topBlurView);
        middleBlurView = findViewById(R.id.middleBlurView);
        root = findViewById(R.id.root);
        setupBlurView();
    }

    private void setupBlurView() {
        final float radius = 10f;

        //set background, if your root layout doesn't have one
        final Drawable windowBackground = getWindow().getDecorView().getBackground();

        topBlurView.setupWith(root)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setHasFixedTransformationMatrix(true);

        bottomBlurView.setupWith(root)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setHasFixedTransformationMatrix(true);

        middleBlurView.setupWith(root)
                .setFrameClearDrawable(windowBackground)
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setHasFixedTransformationMatrix(true);
    }
}
