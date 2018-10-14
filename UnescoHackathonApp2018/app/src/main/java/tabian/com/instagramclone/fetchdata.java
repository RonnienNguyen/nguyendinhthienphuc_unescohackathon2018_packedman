package tabian.com.instagramclone;

import android.os.AsyncTask;
import android.support.annotation.MainThread;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchdata extends AsyncTask<Void, Void, Void> {
    String data = "";

    String dataParsed = "";
    String singleParsed = "";



    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL("https://api.myjson.com/bins/9hlxw");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";

            while (line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);
            for (int i = 0; i<JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Ngày mua sắm:" + JO.get("name") + "\n" +
                               "Giờ vào:" + JO.get("name") + "\n" +
                               "Giờ ra:" + JO.get("name") + "\n" +
                               "Số lượng sản phẩm:" + JO.get("name") + "\n";

                dataParsed = dataParsed + singleParsed;


            }




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        chart.data.setText(this.dataParsed);


    }
}
