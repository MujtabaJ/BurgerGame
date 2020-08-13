package com.example.codeplay.Games1D.burger;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.codeplay.R;
import com.example.codeplay.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class BurgerFragment extends Fragment implements View.OnTouchListener, View.OnDragListener {

    private BurgerViewModel viewModel;
    private LinearLayout problemLayout, playLayout, solutionLayout, playArea;
    private HorizontalScrollView playScrollView;
    ImageButton bottomBunButton, topBunButton, meatButton, cheeseButton, lettuceButton, tomatoButton;
    ImageButton playButton;
    List<Integer> solution;
    String clipData;

    public static BurgerFragment newInstance() {
        return new BurgerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.burger_fragment, container, false);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        solution = new ArrayList<>();

        problemLayout = view.findViewById(R.id.exercise);
        solutionLayout = view.findViewById(R.id.solution);
        bottomBunButton = view.findViewById(R.id.bottombun_btn);
        meatButton = view.findViewById(R.id.meat_btn);
        cheeseButton = view.findViewById(R.id.cheese_btn);
        topBunButton = view.findViewById(R.id.topbun_btn);
        tomatoButton = view.findViewById(R.id.tomato_btn);
        lettuceButton = view.findViewById(R.id.lettuce_btn);
        playLayout = view.findViewById(R.id.play_layout);
        playArea = view.findViewById(R.id.play_area);
        playButton = view.findViewById(R.id.play_button);
        playScrollView = view.findViewById(R.id.play_scroll_view);

        bottomBunButton.setOnTouchListener(this);
        meatButton.setOnTouchListener(this);
        cheeseButton.setOnTouchListener(this);
        topBunButton.setOnTouchListener(this);
        lettuceButton.setOnTouchListener(this);
        tomatoButton.setOnTouchListener(this);
//        playLayout.setOnDragListener(this);
        playScrollView.setOnDragListener(this);
        playButton.setOnClickListener(view1 -> viewModel.setSolutionList(solution));
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
        viewModel.getSolutionList().observe(this,this::onSolutionUpdated);
    }

    private void onSolutionUpdated(List<Integer> list) {
        solutionLayout.removeAllViews();
        int top_margin = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1 && list.get(i + 1) == 4) {
                top_margin = -14;
            }
            solutionLayout.addView(getComponent(list.get(i), top_margin), 0);
            top_margin = 0;
        }
    }

    private void onProblemUpdated(List<Integer> list) {
        int top_margin = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1 && list.get(i + 1) == 4) {
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
            case 6:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_lettuce));
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

    public ImageView getButton(String tag) {
        ImageView imageView = new ImageView(this.getContext());
        switch (tag) {
            case "BOTTOM_BUN":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_bottom_bun_button));
                break;
            case "TOP_BUN":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_top_bun_button));
                break;
            case "MEAT":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_meat_button));
                break;
            case "CHEESE":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_cheese_button));
                imageView.setElevation(2);
                break;
            case "TOMATO":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_tomato_button));
                break;
            case "LETTUCE":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_lettuce_button));
                break;
            default:
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_top_bun_button));
                break;
        }

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.height = Utils.dpToPx(32, this.getContext());
        lp.width = Utils.dpToPx(34, this.getContext());
        imageView.setLayoutParams(lp);
        return imageView;
    }

    public int getComponentId(String tag) {
        ImageView imageView = new ImageView(this.getContext());
        switch (tag) {
            case "BOTTOM_BUN":
                return 2;
            case "TOP_BUN":
                return 1;
            case "MEAT":
                return 3;
            case "CHEESE":
                return 4;
            case "TOMATO":
                return 5;
            case "LETTUCE":
                return 6;
            default:
                return 1;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                v.invalidate();
                return true;
            case DragEvent.ACTION_DRAG_ENTERED:
                 clipData = event.getClipDescription().getLabel().toString();
                playArea.setBackground(getResources().getDrawable(R.drawable.play_layout_bg_selected));
                v.invalidate();
                return true;
            case DragEvent.ACTION_DRAG_LOCATION:
                return true;
            case DragEvent.ACTION_DRAG_EXITED:
                playArea.setBackground(getResources().getDrawable(R.drawable.play_layout_bg));
                v.invalidate();
                return true;
            case DragEvent.ACTION_DROP:
                clipData = event.getClipDescription().getLabel().toString();
                playLayout.addView(getButton(clipData));
                v.invalidate();
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                playArea.setBackground(getResources().getDrawable(R.drawable.play_layout_bg));
                if (event.getResult()) {
                    solution.add(getComponentId(clipData));
                    clipData = null;
                }
//                else {
//                }
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View.DragShadowBuilder mShadow = new View.DragShadowBuilder(view);
        ClipData.Item item = new ClipData.Item(view.getTag().toString());
        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
        ClipData data = new ClipData(view.getTag().toString(), mimeTypes, item);

        switch (view.getId()) {
            case R.id.bottombun_btn:
            case R.id.topbun_btn:
            case R.id.meat_btn:
            case R.id.repeat_btn:
            case R.id.mirror_btn:
            case R.id.lettuce_btn:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.startDragAndDrop(data, mShadow, null, 0);
                } else {
                    view.startDrag(data, mShadow, null, 0);
                }
                break;
            case R.id.cheese_btn:
            case R.id.tomato_btn:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.startDragAndDrop(data, mShadow, null, 0);
                } else {
                    view.startDrag(data, mShadow, null, 0);
                }
                break;
        }
        return false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        solution.clear();
        viewModel.setSolutionList(solution);
    }
}