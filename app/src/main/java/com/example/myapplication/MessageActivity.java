package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {

    private String room_num;
    private Button button;
    private EditText editText;
    private ListView listView;
    private String userName;

    private String uid;
    private String chatRoomUid;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();
    private static ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        uid = "0";  //채팅을 요구 하는 아아디 즉 단말기에 로그인된 UID
        listView = (ListView) findViewById(R.id.listview);
        editText = (EditText) findViewById(R.id.messageActivity_editText);
        button = (Button) findViewById(R.id.messageActivity_button);

        userName = "user1234";

// 기본 Text를 담을 수 있는 simple_list_item_1을 사용해서 ArrayAdapter를 만들고 listview에 설정
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatModel chat = new ChatModel("0", editText.getText().toString()); //ChatDTO를 이용하여 데이터를 묶는다.
                FirebaseDatabase.getInstance().getReference().child("chatrooms").push().setValue(chat);
                databaseReference.child("chat").push().setValue(chat); //databaseReference를 이용해 데이터 푸쉬
                editText.setText(""); //입력창 초기화
/*
                if(chatRoomUid == null){
                    FirebaseDatabase.getInstance().getReference().child("chatrooms").push().setValue(chatModel);
                }else {

                    ChatModel.Comment comment = new ChatModel.Comment();
                    comment.uid = uid;
                    comment.message = editText.getText().toString();
                    FirebaseDatabase.getInstance().getReference().child("chatrooms").child(chatRoomUid).child("comments").push().setValue(comment);
                }
*/

            }
        });
        //checkChatRoom();


    }
}
/*
    void  checkChatRoom(){

        FirebaseDatabase.getInstance().getReference().child("chatrooms").orderByChild("users/"+uid).equalTo(true).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot item : dataSnapshot.getChildren()){
                    ChatModel  chatModel = item.getValue(ChatModel.class);
                    if(chatModel.users.containsKey(room_num)){
                        chatRoomUid = item.getKey();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
*/