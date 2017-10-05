package com.example.glas0050.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends Activity {
    protected static final String ACTIVITY_NAME = "ChatActivityxxx";
    ListView lvText;
    EditText etText;
    Button btText;
    ArrayList <String> chatHistory;
    ChatAdapter messageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(ACTIVITY_NAME, "In onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);

        btText = (Button) findViewById(R.id.btnEditText);

        btText.setOnClickListener(btHandle);
        lvText = (ListView) findViewById(R.id.lvChat);
        etText = (EditText) findViewById(R.id.etxChat);

        chatHistory = new ArrayList<>();
        messageAdapter =new ChatAdapter( this );

        lvText.setAdapter (messageAdapter);



    }

    View.OnClickListener btHandle = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chatHistory.add(etText.getText().toString());
            Log.i(ACTIVITY_NAME, "User clicked Edit Text");
            messageAdapter.notifyDataSetChanged(); //this restarts the process of getCount()/ getView()
            etText.setText("");
        }
    };

    private class ChatAdapter extends ArrayAdapter<String> {
        public ChatAdapter(Context ctx) {
            super(ctx, 0);
        }

        public int getCount() {
            return chatHistory.size();
        }

        public String getItem(int position) {
            return chatHistory.get(position);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();

            View result = null ;
            if(position%2 == 0)
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            else
                result = inflater.inflate(R.layout.chat_row_outgoing, null);

            TextView message = (TextView)result.findViewById(R.id.message_text);
            message.setText(   getItem(position)  ); // get the string at position
            return result;

        }


    }
}
