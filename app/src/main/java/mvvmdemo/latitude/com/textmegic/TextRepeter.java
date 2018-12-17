package mvvmdemo.latitude.com.textmegic;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TextRepeter extends Fragment {
    Context mcontext;
    EditText edt_text, edt_number;
    View rootView;
    TextView genreatedtext, txt_reset, txt_generate;
    CheckBox checkNewLine;
    ImageView settings, imgcopy, imgshare;
    String newline, whitespace, verticalspace, bold;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mcontext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.text_repeter, container,
                false);
        setupView();
        return rootView;
    }

    private void setupView() {
        edt_text = rootView.findViewById(R.id.edt_text);
        edt_number = rootView.findViewById(R.id.edt_number);
        genreatedtext = rootView.findViewById(R.id.genreatedtext);
        txt_reset = rootView.findViewById(R.id.txt_reset);
        settings = rootView.findViewById(R.id.settings);
        checkNewLine = rootView.findViewById(R.id.checkNewLineF);
        txt_generate = rootView.findViewById(R.id.txt_generate);
        imgcopy = rootView.findViewById(R.id.imgcopy);
        imgshare = rootView.findViewById(R.id.imgshare);
        imgcopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cm = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(genreatedtext.getText());
                Toast.makeText(getActivity(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        imgshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, genreatedtext.getText());
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SettingActivity.class);
                startActivityForResult(i, 1);
            }
        });
        txt_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_number.setText("");
                edt_text.setText("");
                genreatedtext.setText("");
                checkNewLine.setChecked(false);

            }
        });


        txt_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isValid())
                    if (newline != null) {
                        int ab = Integer.parseInt(edt_number.getText().toString());
                        String a = edt_text.getText().toString().trim();
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < ab; i++) {
                            stringBuilder.append(a + "\n");
                        }
                        String resultString = stringBuilder.toString();
                        genreatedtext.setTypeface(null, Typeface.NORMAL);
                        genreatedtext.setText(resultString);

                    } else if (whitespace != null) {
                        int ab = Integer.parseInt(edt_number.getText().toString());
                        String a = edt_text.getText().toString().trim();
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < ab; i++) {
                            stringBuilder.append(a + " ");
                        }
                        String resultString = stringBuilder.toString();
                        genreatedtext.setTypeface(null, Typeface.NORMAL);
                        genreatedtext.setText(resultString);
                    } else if (verticalspace != null) {
                        int ab = Integer.parseInt(edt_number.getText().toString());
                        String a = edt_text.getText().toString().trim();
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < ab; i++) {

                            stringBuilder.append(a + "\n\n");
                        }
                        String resultString = stringBuilder.toString();
                        genreatedtext.setTypeface(null, Typeface.NORMAL);
                        genreatedtext.setText(resultString);
                    } else if (bold != null) {
                        int ab = Integer.parseInt(edt_number.getText().toString());
                        String a = edt_text.getText().toString().trim();
                        StringBuilder stringBuilder = new StringBuilder();

                        for (int i = 0; i < ab; i++) {

                            stringBuilder.append(a);
                        }
                        String resultString = stringBuilder.toString();
                        genreatedtext.setTypeface(null, Typeface.BOLD);
                        genreatedtext.setText(resultString);

                    } else {
                        int ab = Integer.parseInt(edt_number.getText().toString());
                        String a = edt_text.getText().toString().trim();
                        StringBuilder stringBuilder = new StringBuilder();

                        for (int i = 0; i < ab; i++) {

                            stringBuilder.append(a);
                        }
                        String resultString = stringBuilder.toString();
                        genreatedtext.setTypeface(null, Typeface.BOLD);
                        genreatedtext.setText(resultString);
                    }

            }
        });

    }

    private boolean isValid() {
        if (TextUtils.isEmpty(edt_text.getText().toString().trim())) {
            Snackbar.make(edt_text, "Please enter text", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(edt_number.getText().toString().trim())) {
            Snackbar.make(edt_text, "Please enter number", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                newline = data.getStringExtra("newline");
            }
            if (resultCode == Activity.RESULT_OK) {
                whitespace = data.getStringExtra("whitespace");
            }
            if (resultCode == Activity.RESULT_OK) {
                verticalspace = data.getStringExtra("verticalspace");
            }
            if (resultCode == Activity.RESULT_OK) {
                bold = data.getStringExtra("bold");
            }
        }

    }//onAct
}
