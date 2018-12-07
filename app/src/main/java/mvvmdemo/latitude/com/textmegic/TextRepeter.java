package mvvmdemo.latitude.com.textmegic;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TextRepeter extends Fragment {
    Context mcontext;
    View rootView;

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

    }
}
