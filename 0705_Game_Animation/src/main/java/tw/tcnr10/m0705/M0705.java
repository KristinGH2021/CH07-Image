package tw.tcnr10.m0705;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;


public class M0705 extends AppCompatActivity implements ViewSwitcher.ViewFactory{

    private TextView s001;
    private TextView f000;
    private String user_select;
    private String answer;
    private ImageButton b001,b002,b003;
    private ImageView c001;
    private MediaPlayer startmusic;
    private MediaPlayer mediaWin;
    private MediaPlayer mediaLose;
    private MediaPlayer mediaDraw;
    private MediaPlayer goodnightmusic;
    private RelativeLayout r_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0705);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001=(ImageButton)findViewById(R.id.m0705_b001);
        b002=(ImageButton)findViewById(R.id.m0705_b002);
        b003=(ImageButton)findViewById(R.id.m0705_b003);
        c001=(ImageView)findViewById(R.id.m0705_c001);
        s001=(TextView)findViewById(R.id.m0705_s001);
        f000=(TextView)findViewById(R.id.m0705_f000);

        startmusic= MediaPlayer.create(getApplication(), R.raw.guess);
        startmusic.start();
        goodnightmusic=MediaPlayer.create(getApplication(), R.raw.goodnight);

        mediaWin= MediaPlayer.create(getApplication(), R.raw.vctory);
        mediaLose= MediaPlayer.create(getApplication(), R.raw.lose);
        mediaDraw= MediaPlayer.create(getApplication(), R.raw.haha);

        // --開啟片頭音樂-----
//        startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
//        startmusic.start();
        // ---開機動畫---
        r_layout = (RelativeLayout) findViewById(R.id.m0705_r001);
        r_layout.setBackgroundResource(R.drawable.back01);
//        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_out));
        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_trans_bouncemix));
        r_layout.setBackgroundResource(R.drawable.back01);



//
        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
    }

    private View.OnClickListener b001on=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1); //亂數1剪刀2石頭3布
            // 1 - scissors, 2 - stone, 3 - net.

            switch (v.getId()){
                case R.id.m0705_b001:  //選擇剪刀
                    user_select +=getString(R.string.m0705_s001)+getString(R.string.m0705_b001);
                    u_setalpha();
                    b001.getBackground().setAlpha(130);  //0-255

                    switch (iComPlay){
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
//                            answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f003); //平手
//                            f000.setTextColor(Color.YELLOW);
                            music(2);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
//                            answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f002);  //輸
//                            f000.setTextColor(Color.RED);
                            music(3);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
//                            answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f001);  //贏
//                            f000.setTextColor(Color.GREEN);
                            music(1);
                            break;
                    }
                    user_select=getString(R.string.m0705_s001)+" "+getString(R.string.m0705_b001);
                    break;

                case R.id.m0705_b002:  //選擇石頭
                    user_select +=getString(R.string.m0705_s001)+getString(R.string.m0705_b002);
                    u_setalpha();
                    b002.getBackground().setAlpha(100);

                    switch (iComPlay){
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
//                            answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f001); //贏
//                            f000.setTextColor(Color.GREEN);
                            music(1);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
//                            answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f003);  //平
//                            f000.setTextColor(Color.YELLOW);
                            music(2);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
//                            answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f002);  //輸
//                            f000.setTextColor(Color.RED);
                            music(3);
                            break;
                    }
                    user_select=getString(R.string.m0705_s001)+" "+getString(R.string.m0705_b002);
                    break;

                case R.id.m0705_b003:  //選擇布
                    user_select +=getString(R.string.m0705_s001)+getString(R.string.m0705_b003);
                    u_setalpha();
                    b003.getBackground().setAlpha(200);

                    switch (iComPlay){
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
//                            answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f002); //輸
//                            f000.setTextColor(Color.RED);
                            music(3);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
//                            answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f001);  //贏
//                            f000.setTextColor(Color.GREEN);
                            music(1);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
//                            answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f003);  //平
//                            f000.setTextColor(Color.YELLOW);
                            music(2);
                            break;
                    }
                    user_select=getString(R.string.m0705_s001)+" "+getString(R.string.m0705_b003);
                    break;
            }
            s001.setText(user_select);
            f000.setText(answer);
        }

    };
    private void u_setalpha(){
        //imageButton 背景為銀色且為全透明
          b001.setBackgroundColor(Color.GRAY);
          b001.getBackground().setAlpha(0);  //0-255
          b002.setBackgroundColor(Color.GRAY);
          b002.getBackground().setAlpha(0);
          b003.setBackgroundColor(Color.GRAY);
          b003.getBackground().setAlpha(0);
    }
    //imageButton 背景為銀色且為全透明
    //    btnScissors.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
    //   btnScissors.getBackground().setAlpha(0); //0-255
    //  btnStone.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
    //   btnStone.getBackground().setAlpha(0);
    //    btnNet.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
    //   btnNet.getBackground().setAlpha(0);


    private void music(int i) {
        if(startmusic.isPlaying())  startmusic.stop();
        if(mediaWin.isPlaying())  mediaWin.pause();
        if(mediaDraw.isPlaying())   mediaDraw.pause();
        if(mediaLose.isPlaying())   mediaLose.pause();
        switch (i){
            case 1:  //贏
                answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f001);  //贏
                f000.setTextColor(Color.GREEN);
                mediaWin.start();
                Toast.makeText(getApplicationContext(),getString(R.string.m0705_f001), Toast.LENGTH_SHORT).show();
                break;
            case 2:  //平
                answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f003); //平手
                f000.setTextColor(Color.YELLOW);
                mediaDraw.start();
                Toast.makeText(getApplicationContext(),getString(R.string.m0705_f003), Toast.LENGTH_SHORT).show();
                break;
            case 3:  //輸
                answer=getString(R.string.m0705_f000)+getString(R.string.m0705_f002);  //輸
                f000.setTextColor(Color.RED);
                mediaLose.start();
                Toast.makeText(getApplicationContext(),getString(R.string.m0705_f002), Toast.LENGTH_SHORT).show();
                break;
            case 4:  //結束程式
                goodnightmusic.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        music(4);
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
            if(startmusic.isPlaying())  startmusic.stop();
    }


    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        // v.setBackgroundColor(0xFF000000);
        v.setScaleType(ImageView.ScaleType.FIT_CENTER);
        v.setLayoutParams(new
                ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;
    }
}