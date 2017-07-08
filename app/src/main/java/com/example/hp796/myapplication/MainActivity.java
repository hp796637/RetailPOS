package com.example.hp796.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;

import com.example.hp796.myapplication.CustomViews.LearningViews;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {
    private static final byte[] key = {108,97,98,111,120,45,97,108,116,105,99,101,45,117,115,97};
    EditText editText;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        editText= (EditText) findViewById(R.id.editText1);
//        editText2= (EditText) findViewById(R.id.editText);
//        findViewById(R.id.button).setOnClickListener(listener);
//        findViewById(R.id.button1).setOnClickListener(listener);
        LearningViews view= new LearningViews(this);
    }

    public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cipherText = cipher.doFinal(plainText.getBytes("UTF8"));
            String encryptedString = Base64.encodeToString(cipherText, Base64.NO_WRAP);
            return encryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encryptedText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] cipherText = Base64.decode(encryptedText, Base64.NO_WRAP);
            byte[] ciphervalue=cipher.doFinal(cipherText);
//            String decryptedString = new String(ciphervalue,"UTF-8");
            try {
                String decryptedString=new String(ciphervalue, "UTF-8");
                return decryptedString;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            if(view.getId()==R.id.button){
//               String encrptedText= encrypt(editText.getText().toString());
//                ((TextView) findViewById(R.id.textv1)).setText(encrptedText);
//                editText2.setText(encrptedText);
//            }else{
//              String  decryptedtext= decrypt(editText2.getText().toString());
//                ((TextView) findViewById(R.id.text2)).setText(decryptedtext);
//            }
        }
    };
}
