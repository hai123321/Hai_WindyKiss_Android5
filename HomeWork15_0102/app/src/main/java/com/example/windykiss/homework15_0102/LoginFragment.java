package com.example.windykiss.homework15_0102;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.windykiss.homework15_0102.Services.Foo;
import com.example.windykiss.homework15_0102.models.LoginModel;
import com.example.windykiss.homework15_0102.models.PostModel;
import com.google.gson.Gson;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    @BindView(R.id.et_username)
    EditText et_username;

    @BindView(R.id.et_password)
    EditText et_password;

    @BindView(R.id.btn)
    Button btn;
    private static final String TAG = LoginFragment.class.getName();

    private String URL = "https://a5-tumblelog.herokuapp.com";
    String responseBodyString;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, v);
        addListeners();
        return v;
    }

    private void addListeners() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
//                sendPOSTRequest("json", username, password);
                sendPostRequestRetrofit(username, password);
            }
        });
    }

    private void sendPostRequestRetrofit(String username, String password) {
        Retrofit loginRetrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginPostJsonModel loginPostJsonModel = new LoginPostJsonModel(username, password);

        String body = new Gson().toJson(loginPostJsonModel);

        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"),
                body
        );

        Foo foo = loginRetrofit.create(Foo.class);
        foo
                .postJson(requestBody)
                .enqueue(new retrofit2.Callback<LoginModel>() {
                    @Override
                    public void onResponse(retrofit2.Call<LoginModel> call, retrofit2.Response<LoginModel> response) {
                        Log.d(TAG, "onResponse");
                        LoginModel login = response.body();
                        if(login.getCode().equals("1"))
                            makeToats("Login success!!");
                        else
                            makeToats("Login failed!!");
                    }

                    @Override
                    public void onFailure(retrofit2.Call<LoginModel> call, Throwable t) {
                        Log.d(TAG, "onFailure");
                    }
                });
    }

    private void sendPOSTRequest(String type, String username, String password) {

        // by form
        FormBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();

        // by json
        LoginPostJsonModel newPost = new LoginPostJsonModel(username, password);
        final Gson gson = new Gson();
        String jsonBody = gson.toJson(newPost);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonBody);

        Request request = new Request.Builder()
                .url(URL)
                .post("form".equals(type) ? formBody : requestBody)
                .build();

        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                responseBodyString = response.body().string();
                Log.d(TAG, responseBodyString);
                LoginModel login = gson.fromJson(responseBodyString, LoginModel.class);
                if(login.getCode().equals("1"))
                    makeToats("Login success!!");
                else
                    makeToats("Login failed!!");
            }
        });
    }

    private void makeToats(final String mess){
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getContext(), mess, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
