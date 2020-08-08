package com.example.codeplay.Games1D.burger;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.codeplay.R;

public class LevelsFragment extends Fragment {

    private BurgerViewModel mViewModel;
    Button level1Button;

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
        level1Button = view.findViewById(R.id.level1);
        level1Button.setOnClickListener(v -> {
            Navigation.findNavController(
                    v).navigate(R.id.action_levelsFragment_to_burgerFragment);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BurgerViewModel.class);
        // TODO: Use the ViewModel
    }

}