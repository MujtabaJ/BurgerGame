package com.example.codeplay.Games1D.burger;

import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BurgerViewModel extends ViewModel {
    // topbun:1, bottombun: 2, meat:3, cheese: 4, tomato: 5, lettuce: 6

    private MutableLiveData<LevelState> level;
    private MutableLiveData<List<Integer>> problemList;
    private MutableLiveData<List<Integer>> solutionList;

    public BurgerViewModel() {
        this.level = new MutableLiveData<>();
        this.problemList = new MutableLiveData<>();
        this.solutionList = new MutableLiveData<>();
    }

    public LiveData<LevelState> getLevel() {
        return level;
    }

    public void setLevel(LevelState level) {
        switch (level) {
            case ONE:
                problemList.setValue(createLevel1Problem());
                break;
            case TWO:
                problemList.setValue(createLevel2Problem());
                break;
            case THREE:
                problemList.setValue(createLevel3Problem());
                break;
        }
        this.level.setValue(level);
    }

    public MutableLiveData<List<Integer>> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<Integer> problemList) {
        this.problemList.setValue(problemList);
    }

    public MutableLiveData<List<Integer>> getSolutionList() {
        return solutionList;
    }

    public void setSolutionList(List<Integer> solutionList) {
        this.solutionList.setValue(solutionList);
    }

    public List<Integer> createLevel1Problem() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(new Random().nextInt(3) + 3);
        list.add(1);
        return list;
    }

    public List<Integer> createLevel2Problem() {
        List<Integer> list = new ArrayList<>();
        List<Integer> mct = new ArrayList<>();
        mct.add(3);
        mct.add(4);
        mct.add(5);
        list.add(2);
        Collections.shuffle(mct);
        list.addAll(mct);
        list.add(2);
        Collections.shuffle(mct);
        list.addAll(mct);
        list.add(1);
        return list;
    }

    public List<Integer> createLevel3Problem() {
        int numberOfStacks = new Random().nextInt(2) + 2;
        List<Integer> list = new ArrayList<>();
        List<Integer> mct = new ArrayList<>();
        mct.add(3);
        mct.add(4);
        mct.add(5);
        for (int i = 0; i < numberOfStacks; i++) {
            list.add(2);
            Collections.shuffle(mct);
            list.addAll(mct);
        }
        list.add(1);
        return list;
    }

    public enum LevelState {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN
    }
}