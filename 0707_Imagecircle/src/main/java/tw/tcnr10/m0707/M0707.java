package tw.tcnr10.m0707;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0707 extends AppCompatActivity implements View.OnClickListener {

    private ImageView img01;
    private ImageButton img02;
    private TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0707);
        setupViewComponent();
    }

    private void setupViewComponent() {
        img01 = (ImageView) findViewById(R.id.m0707_ImgView);
        img02 = (ImageButton) findViewById(R.id.m0707_Imgbutton);
        ans = (TextView) findViewById(R.id.m0707_t001);
        // ---啟動監聽事件----
        img01.setOnClickListener(this);
        img02.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.m0707_ImgView:
                ans.setText(getString(R.string.m0707_t001) + getString(R.string.m0707_img01));
                break;
            case R.id.m0707_Imgbutton:
                ans.setText(getString(R.string.m0707_t001) + getString(R.string.m0707_imgbutton));
                break;
        }
    }
}
