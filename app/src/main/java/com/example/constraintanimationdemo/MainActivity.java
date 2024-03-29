package com.example.constraintanimationdemo;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout root;
    ImageView imageView;
    boolean show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        root = findViewById(R.id.root);


        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    if (show)
                        revertAnimation();
                    else
                        showAnimation();
                }
            }
        });

    }

    private void showAnimation() {
        show = true;

        ConstraintSet constraint1 = new ConstraintSet();

        constraint1.clone(this, R.layout.activity_main_animation);


        TransitionManager.beginDelayedTransition(root);
        constraint1.applyTo(root);
    }

    private void revertAnimation() {
        show = false;

        ConstraintSet constraint2 = new ConstraintSet();
        constraint2.clone(this, R.layout.activity_main);

        TransitionManager.beginDelayedTransition(root);
        constraint2.applyTo(root);

    }

}
