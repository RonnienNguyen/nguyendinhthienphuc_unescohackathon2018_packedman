package tabian.com.instagramclone.Camera;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import tabian.com.instagramclone.R;

/**
 * Created by dell on 2/25/2018.
 */


/**
 * Created by dell on 2/25/2018.
 */

public class Camera_camera_fragment extends Fragment {
    private static final String TAB = "Camera_camera_fragment";
    View v;
    ImageButton btnqr;


//    final int REQUEST_CODE = 123;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.camera_camera_fragment, container, false);




        btnqr = (ImageButton) v.findViewById(R.id.imgbutton);
        final Camera_camera_fragment activity = this;


//        btnqr.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i1 = new Intent(getActivity(), qrcodescan.class);
//                startActivity(i1);
//            }
//        });


        btnqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(getActivity());
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
        return v;




    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(getActivity(), "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getActivity(), result.getContents(),Toast.LENGTH_LONG).show();


//                FragmentTransaction transection = getFragmentManager().beginTransaction();



                String i1 = new String(result.getContents());
                Fragment fragment = new Fragment();
                Bundle bundle = new Bundle();
                bundle.putInt("1", Integer.parseInt(i1));
                fragment.setArguments(bundle);













            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}



