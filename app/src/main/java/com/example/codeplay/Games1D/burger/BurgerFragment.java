package com.example.codeplay.Games1D.burger;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.codeplay.R;
import com.example.codeplay.utils.Utils;

import java.util.List;

public class BurgerFragment extends Fragment {

    private BurgerViewModel viewModel;
    private LinearLayout problemLayout;

    public static BurgerFragment newInstance() {
        return new BurgerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.burger_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        problemLayout = view.findViewById(R.id.exercise);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this.getParentFragment()).get(BurgerViewModel.class);
        this.subscribeViewModel();
        // TODO: Use the ViewModel
    }

    public void subscribeViewModel() {
//        viewModel.getLevel().observe(this, this::onLevelSelected);
        viewModel.getProblemList().observe(this, this::onProblemUpdated);
    }

    private void onProblemUpdated(List<Integer> list) {
        int top_margin = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1  && list.get(i + 1) == 4) {
                top_margin = -14;
            }
            problemLayout.addView(getComponent(list.get(i), top_margin), 0);
            top_margin = 0;
        }
    }

    public void onLevelSelected(BurgerViewModel.LevelState level) {
        switch (level) {
            case ONE:
                break;
            case TWO:
                break;
            default:
                break;
        }
    }

    public ImageView getComponent(int i, int margin_top) {
        ImageView imageView = new ImageView(this.getContext());
        switch (i) {
            case 1:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_top_bun));
                break;
            case 2:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_bottom_bun));
                break;
            case 3:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_meat));
                break;
            case 4:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_cheese));
                imageView.setElevation(2);
                break;
            case 5:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_tomato));
                break;
            default:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_top_bun));
                break;
        }
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(lp.leftMargin, Utils.dpToPx(margin_top, this.getContext()), lp.rightMargin, lp.bottomMargin);
            imageView.setLayoutParams(lp);
            return imageView;
    }

}