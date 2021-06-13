package com.nqaze.quickchat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import com.cometchat.pro.constants.CometChatConstants;
import com.cometchat.pro.models.Conversation;
import com.cometchat.pro.models.User;
import com.cometchat.pro.uikit.ui_components.chats.CometChatConversationList;
import com.cometchat.pro.uikit.ui_components.messages.message_list.CometChatMessageListActivity;
import com.cometchat.pro.uikit.ui_resources.constants.UIKitConstants;
import com.cometchat.pro.uikit.ui_resources.utils.item_clickListener.OnItemClickListener;

public class ConversationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversations);

        CometChatConversationList.setItemClickListener(new OnItemClickListener<Conversation>() {
            @Override
            public void OnItemClick(Conversation var, int position) {
                User user = (User)var.getConversationWith();
                Intent intent = new Intent(ConversationsActivity.this, CometChatMessageListActivity.class);
                intent.putExtra(UIKitConstants.IntentStrings.UID, user.getUid());
                intent.putExtra(UIKitConstants.IntentStrings.AVATAR, user.getAvatar());
                intent.putExtra(UIKitConstants.IntentStrings.STATUS, user.getStatus());
                intent.putExtra(UIKitConstants.IntentStrings.NAME, user.getName());
                intent.putExtra(UIKitConstants.IntentStrings.LINK,user.getLink());
                intent.putExtra(UIKitConstants.IntentStrings.TYPE, CometChatConstants.RECEIVER_TYPE_USER);
                startActivity(intent);
            }

            @Override
            public void OnItemLongClick(Conversation var, int position) {
                super.OnItemLongClick(var, position);
            }
        });
    }

    public void newChatTapped(View view) {
        startActivity(new Intent(ConversationsActivity.this, SelectContactActivity.class));
    }
}