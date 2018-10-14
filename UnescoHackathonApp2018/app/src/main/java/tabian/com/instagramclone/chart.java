package tabian.com.instagramclone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class chart extends AppCompatActivity {
    Button btn;

    public static TextView data;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);

        btn = (Button) findViewById(R.id.buttonchart);
        data = (TextView) findViewById(R.id.textviewchart);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                fetchdata process = new fetchdata();

                process.execute();

            }
        });



    }
}