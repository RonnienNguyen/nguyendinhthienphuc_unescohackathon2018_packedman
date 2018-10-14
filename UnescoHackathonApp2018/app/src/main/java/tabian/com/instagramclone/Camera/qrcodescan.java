package tabian.com.instagramclone.Camera;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import tabian.com.instagramclone.R;



public class qrcodescan extends AppCompatActivity {


    private Button btnqrcode;
    private Intent data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrcodescan);

        crush();

//        @Override
//        public void onActivityResult(int requestCode, int resultCode, Intent data) {
//            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//            if(result != null){
//                if(result.getContents()==null){
//                    Toast.makeText(qrcodescan.this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(qrcodescan.this, result.getContents(),Toast.LENGTH_LONG).show();
//
//
////                FragmentTransaction transection = getFragmentManager().beginTransaction();
//
//
//
//                    String i1 = new String(result.getContents());
//                    Fragment fragment = new Fragment();
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("1", Integer.parseInt(i1));
//                    fragment.setArguments(bundle);
//
//
//
//
//
//
//
//
//
//
//
//
//
//                }
//            }
//            else {
//                super.onActivityResult(requestCode, resultCode, data);
//            }
//        }
    }

    private void crush() {
        btnqrcode = (Button)findViewById(R.id.btnqrcodescan);
        btnqrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(qrcodescan.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });



    }
}
