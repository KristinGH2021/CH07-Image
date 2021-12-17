package tw.tcnr10.m0704;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class M0704 extends ListActivity {
    private TextView mTxtResult;
    private ArrayList<Map<String, Object>> mList;
    private String[] listFromResource;
    private String[] listFromResource2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0704);
        setupViewComponent();
    }

    private void setupViewComponent() {
        mTxtResult = (TextView) findViewById(R.id.m0704_t001);
        listFromResource = getResources().getStringArray(R.array.weekday);
        listFromResource2 = getResources().getStringArray(R.array.weekdaydo);
//---------------------------------------------------------------
        mList = new ArrayList<Map<String, Object>>();
//---------------------------------------------------------------
//
        for (int i = 0; i < listFromResource.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            String idName="img"+String.format("%02d"+"th",i+1); //
            int resID = getResources().getIdentifier(idName,"drawable",getPackageName()); //靠圖片抓取drawable/img01th.jpg(name)
            item.put("imgView",resID);
//            item.put("imgView", R.drawable.img01th);  //week=7days
            item.put("txtView", listFromResource[i]);
            item.put("txtView2", listFromResource2[i]);
            
            mList.add(item);  //資料庫列中增加一筆
            
            //-------------------------------------------------------------
            SimpleAdapter adapter = new SimpleAdapter(
                    this, mList, R.layout.list_item,
                    new String[]{"imgView", "txtView","txtView2"},
                    new int[]{R.id.m0704_img01, R.id.textView,R.id.textView2});

            setListAdapter(adapter);
            ListView listview = getListView();
            listview.setTextFilterEnabled(true);
            listview.setOnItemClickListener(listviewOnItemClkLis);
            
            //----------------------------------------------------------------

        }
    }

    AdapterView.OnItemClickListener listviewOnItemClkLis = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            // When clicked, show a toast with the TextView text
            mTxtResult.setText(listFromResource[position]);
        }
    };
}