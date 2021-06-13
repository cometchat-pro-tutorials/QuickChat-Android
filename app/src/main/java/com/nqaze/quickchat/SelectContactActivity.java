package com.nqaze.quickchat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import com.cometchat.pro.constants.CometChatConstants;
import com.cometchat.pro.models.User;
import com.cometchat.pro.uikit.ui_components.messages.message_list.CometChatMessageListActivity;
import com.cometchat.pro.uikit.ui_components.users.user_list.CometChatUserList;
import com.cometchat.pro.uikit.ui_resources.constants.UIKitConstants;
import com.cometchat.pro.uikit.ui_resources.utils.item_clickListener.OnItemClickListener;

public class SelectContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_contact);

        CometChatUserList.setItemClickListener(new OnItemClickListener<User>() {

            @Override
            public void OnItemClick(User user, int position) {
                Intent intent = new Intent(SelectContactActivity.this, CometChatMessageListActivity.class);
                intent.putExtra(UIKitConstants.IntentStrings.UID, user.getUid());
                intent.putExtra(UIKitConstants.IntentStrings.AVATAR, user.getAvatar());
                intent.putExtra(UIKitConstants.IntentStrings.STATUS, user.getStatus());
                intent.putExtra(UIKitConstants.IntentStrings.NAME, user.getName());
                intent.putExtra(UIKitConstants.IntentStrings.LINK,user.getLink());
                intent.putExtra(UIKitConstants.IntentStrings.TYPE, CometChatConstants.RECEIVER_TYPE_USER);
                startActivity(intent);
            }

            @Override
            public void OnItemLongClick(User var, int position) {
                super.OnItemLongClick(var, position);
            }
        });
    }
}