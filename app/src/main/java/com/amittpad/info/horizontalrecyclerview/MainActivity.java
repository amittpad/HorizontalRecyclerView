package com.amittpad.info.horizontalrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_beauty_health_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_business_service_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_dth_recharge_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_event_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_flight_ticket_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_giftcard_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_home_service_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_insurance_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_lessons_hobbies_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_money_transfer_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_movers_packers_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_online_booking_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_reminder_white;
import static com.amittpad.info.horizontalrecyclerview.R.drawable.ic_shopping_white;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<RecyclerPojo> recyclerPojoList = new ArrayList<>();;
    private RecyclerPojo recyclerPojo;
    private int[] images ={ic_home_service_white, ic_online_booking_white, ic_flight_ticket_white, ic_reminder_white, ic_dth_recharge_white, ic_shopping_white, ic_movers_packers_white, ic_event_white, ic_beauty_health_white, ic_insurance_white, ic_money_transfer_white, ic_lessons_hobbies_white, ic_giftcard_white, ic_business_service_white};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        String[] strName = getResources().getStringArray(R.array.main_category);
        int strNameArrayLength = strName.length;
        for (int i = 0; i<strNameArrayLength; i++){
            recyclerPojo = new RecyclerPojo(""+i, strName[i], images[i]);
            recyclerPojoList.add(recyclerPojo);
        }
        RecyclerAdapter adapter = new RecyclerAdapter(recyclerPojoList,getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this,recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 0){
                    onClickHomeServiceBtn(view);
                }

            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }
    public void onClickHomeServiceBtn(View view) {
        Toast.makeText(this, "Home service", Toast.LENGTH_SHORT).show();
    }
}
