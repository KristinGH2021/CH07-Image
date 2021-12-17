package tw.tcnr10.m1010;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout Layout1;
    private LinearLayout Layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupComponent();

    }

    private void setupComponent() {
        Layout1 = (LinearLayout)findViewById(R.id.L1);
        Layout2 = (LinearLayout)findViewById(R.id.L2);
    }

    //---------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "禁用返回建!!", Toast.LENGTH_LONG).show();
//            super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {
            case R.id.Item01:
                Layout1.setVisibility(View.VISIBLE);
                Layout2.setVisibility(View.INVISIBLE);
                break;
            case  R.id.Item02:
                Layout1.setVisibility(View.INVISIBLE);
                Layout2.setVisibility(View.VISIBLE);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //---------------------------------------------------------


}