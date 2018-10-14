package tabian.com.instagramclone.Camera;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import tabian.com.instagramclone.R;


/**
 * Created by dell on 2/25/2018.
 */

public class Camera_album_fragment extends Fragment {
    private static final String TAB = "Camera_album_fragment";
    private ScrollView scllview;
    private TextView txtinfo;
    private Button btnchange;
    private TextView txtgetlocation;




    final int REQUEST_CODE = 123;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camera_fragment_album, container, false);
        scllview = (ScrollView)view.findViewById(R.id.scllgetcontent);
        txtinfo = (TextView)view.findViewById(R.id.txttextinfo) ;
        btnchange = (Button)view.findViewById(R.id.btnchange);
//        txtgetlocation = (TextView)view.findViewById(R.id.txtgetlocation);





        Bundle bundle = this.getArguments();
        if (bundle != null){
            int myInt = bundle.getInt("1");


            String i3 = new String(String.valueOf(myInt));

            txtinfo.setText(i3);

        }
//
//
//        Bundle bundle1 = this.getArguments();
//        if (bundle1 != null){
//            int myInt2 = bundle1.getInt("2");
//
//            String i4 = new String(String.valueOf(myInt2));
//            txtgetlocation.setText(i4);
//        }

//        btnchange.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = new String("http://128.199.154.180");
//
//
//
//            }
//        });







        return view;



    }

}
