package com.example.pfma9.mascarainfo104;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventosFragment extends Fragment implements AsyncResponse{
    String response;
    String usr;
    TextView mostrarConsulta;
    Button btnConsultar;
    View view;

    public EventosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_eventos, container, false);

        mostrarConsulta = view.findViewById(R.id.resultadoConsulta);
        btnConsultar = view.findViewById(R.id.btnConsulta);


        return view;

    }

    @Override
    public void processFinish(JSONObject jsonObject) {
        try
        {
            response = jsonObject.getString("param1");
            usr = jsonObject.getString("usr");
            mostrarConsulta.setText("response: "+response+"\nuser: "+usr);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onClick(View v) {
        if(v.getId() == R.id.btnConsulta) {
            int length = 8;
            String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvwxyz"
                    + "0123456789";
            String generatedString = new Random().ints(length, 0, chars.length())
                    .mapToObj(i -> "" + chars.charAt(i))
                    .collect(Collectors.joining());
            int randomNum = ThreadLocalRandom.current().nextInt(0, 25 + 1);

            DataRequest dataRequest = new DataRequest(getActivity());
            dataRequest.delegate = this;
            dataRequest.execute("http://146.83.216.206/info104/prueba.php?param1="+generatedString+"&user="+randomNum);

        }

    }
}
