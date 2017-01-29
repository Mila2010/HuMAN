package com.example.human;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Millochka on 1/28/17.
 */
public class ContactUsFragment extends Fragment implements ViewGroup.OnClickListener {

    Button mSendMessage;
    RelativeLayout mContactUsForm;
    EditText mSubject;
    EditText mBody;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(
                R.layout.contact_us_form, container, false);

        return rootView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);

        mSendMessage = (Button) view.findViewById(R.id.send_button);
        mSendMessage.setOnClickListener(this);
        mContactUsForm = (RelativeLayout) view.findViewById(R.id.contact_us_form);
        mSubject=(EditText) view.findViewById(R.id.subject_of_message);
        mBody=(EditText) view.findViewById(R.id.message_to_send);


    }

    @Override
    public void onClick(View view) {

     if(mBody.getText().toString().trim().length()==0||mSubject.getText().toString().trim().length()==0){

         Toast.makeText(getContext(),"Please make sure 'Subject' and 'Message' fields are not empty", Toast.LENGTH_LONG).show();

     } else{
         sendMessage(mSubject.getText().toString(),mBody.getText().toString());
     }


    }


    public void sendMessage(String subject, String body){

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"liudmila.ura@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT   , body);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }
}
