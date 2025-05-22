package com.PDMG3.lifechat.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.PDMG3.lifechat.databinding.ActivityChatBinding;
import com.PDMG3.lifechat.models.User;
import com.PDMG3.lifechat.utilities.Constants;

public class ChatActivity extends AppCompatActivity {

    private ActivityChatBinding binding;
    private User receiverUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
        loadReceiverDetails();
    }

    private void loadReceiverDetails(){
        receiverUser = (User) getIntent().getSerializableExtra(Constants.KEY_USER);
        binding.textName.setText(receiverUser.name);
    }

    private void setListeners(){
        binding.imageBack.setOnClickListener(v -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }
}