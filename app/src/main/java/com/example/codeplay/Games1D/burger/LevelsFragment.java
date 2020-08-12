package com.example.codeplay.Games1D.burger;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.codeplay.R;

public class LevelsFragment extends Fragment {

    private BurgerViewModel viewModel;

    public static LevelsFragment newInstance() {
        return new LevelsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_levels, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.level1).setOnClickListener(this::levelButtonClickListener);
        view.findViewById(R.id.level2).setOnClickListener(this::levelButtonClickListener);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this.getParentFragment()).get(BurgerViewModel.class);
        // TODO: Use the ViewModel
    }

    public void levelButtonClickListener(View view) {
        switch (view.getId()) {
            case R.id.level1:
                viewModel.setLevel(BurgerViewModel.LevelState.ONE);
                break;
            case R.id.level2:
                viewModel.setLevel(BurgerViewModel.LevelState.TWO);
                break;
        }
        Navigation.findNavController(
                this.getView()).navigate(R.id.action_levelsFragment_to_burgerFragment);
    }

}