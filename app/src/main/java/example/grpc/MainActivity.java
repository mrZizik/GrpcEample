package example.grpc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final TextView textView = (TextView) findViewById(R.id.textView);
    EditText editText = (EditText) findViewById(R.id.editText);
    ApiUser apiUser = new ApiUser();
    editText.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        if (apiUser.isUnique(s.toString())) {
          textView.setText("UNIQUE");
        } else {
          textView.setText("Not unique");
        }
      }
    });
  }
}
