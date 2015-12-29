package app.akexorcist.numbermatching;

import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class Main extends Activity {
    DrawView dv;
    LinearLayout scene;

    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        scene = (LinearLayout)findViewById(R.id.scene);
        dv = new DrawView(Main.this, getWindowManager().getDefaultDisplay());
        draw();

        Button buttonReset = (Button)findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dv.reset();
            }
        });
    }

    public void draw() {
        try {
            scene.removeView(dv);
        } catch (Exception e) { }
        scene.addView(dv);
    }

    public void removeView() {
        try {
            scene.removeView(dv);
        } catch (Exception e) { }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
