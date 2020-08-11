package com.example.codeplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.codeplay.utils.Utils.showToastMessage;

public class BurgerMakerPlay extends AppCompatActivity implements View.OnClickListener {

    Button meetButton, bunButton, cheeseButton, repeatButton, tomatoButton, lettuceButton, topBunButton, mirroButton;
    Button headerButton1, headerButton2, headerButton3, headerButton4, headerButton5;
    Button btnFOne, btnPlay;
    ImageView image1, image2, image3, image4, image5, image6, image7, image8;
    ListView makeburgerlist, executionlist, basicrepeatedlist;
    SeekBar seekBar;

    String[] from = {"image"};//string array
    int[] to = {R.id.imageView};//int array of views id's
    ArrayList<HashMap<String, String>> arrayList, myImageList, basicMyImageList, executionArrayList, basicArrayList, executionMyImageList;

    //Part of the code for animation
    ClipData clipData;
    int flags[] = {0};
    View.DragShadowBuilder dragShadowBuilder;
    Object object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_maker_play);

        init();
    }

    @Override
    public void onClick(View view) {
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToastMessage("Testing of Play button", getApplicationContext());
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            meetButton.startDragAndDrop(clipData, dragShadowBuilder, object, flags[0]);
        }

    }

    public void clickListner(View view) {

        if (view.getId() == R.id.playburgermaker) {
            // button1 action
            Intent mainIntent = new Intent(BurgerMakerPlay.this, BurgerMakerPlay.class);
            BurgerMakerPlay.this.startActivity(mainIntent);
            BurgerMakerPlay.this.finish();
        } else if (view.getId() == R.id.playbuildingmaker) {
            Intent mainIntent = new Intent(BurgerMakerPlay.this, BuildingMakerPlay.class);
            BurgerMakerPlay.this.startActivity(mainIntent);
            BurgerMakerPlay.this.finish();
        } else if (view.getId() == R.id.layout_burger_play_action_perform_row1_button1) {
            addImage(R.drawable.ic_bottom_bun + "");
            addBasicImage(R.drawable.ic_bottom_bun + "");
            addExecutionImage(R.drawable.ic_bottom_bun + "");
        } else if (view.getId() == R.id.layout_burger_play_action_perform_row1_button2) {
            addImage(R.drawable.ic_meat + "");
            addBasicImage(R.drawable.ic_meat + "");
            addExecutionImage(R.drawable.ic_meat + "");
        } else if (view.getId() == R.id.layout_burger_play_action_perform_row1_button3) {
            addImage(R.drawable.ic_cheese + "");
            addBasicImage(R.drawable.ic_cheese + "");
            addExecutionImage(R.drawable.ic_cheese + "");
        } else if (view.getId() == R.id.layout_burger_play_action_perform_row1_button4) {
            repeatAction();
        } else if (view.getId() == R.id.layout_burger_play_action_perform_row2_button1) {
            addImage(R.drawable.ic_tomato + "");
            addBasicImage(R.drawable.ic_tomato + "");
            addExecutionImage(R.drawable.ic_tomato + "");
        } else if (view.getId() == R.id.layout_burger_play_action_perform_row2_button2) {
            addImage(R.drawable.ic_lettuce + "");
            addBasicImage(R.drawable.ic_lettuce + "");
            addExecutionImage(R.drawable.ic_lettuce + "");
        } else if (view.getId() == R.id.layout_burger_play_action_perform_row2_button3) {
            addImage(R.drawable.ic_top_bun + "");
            addBasicImage(R.drawable.ic_top_bun + "");
            addExecutionImage(R.drawable.ic_top_bun + "");
        } else if (view.getId() == R.id.layout_burger_play_action_perform_row2_button4) {
            mirrorAction();
        }

    }

    private void addImage(String image) {

        if (arrayList.size() < 8) {
            HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("image", image);
            arrayList.add(hashMap);//add the hashmap into arrayList

            try {
                for (int i = 0; i < arrayList.size(); i++) {

                    if (arrayList != null && !arrayList.isEmpty()) {
                        myImageList.add(arrayList.get(arrayList.size() - i));
                    } else {
                        myImageList.add(arrayList.get(arrayList.size() - 1));
                    }
                }
            } catch (Exception e) {
                myImageList.add(arrayList.get(arrayList.size() - 1));
            }

            displayBurgerList();

        } else {
            showToastMessage("You can add only 8 items in burger", getApplicationContext());
        }
    }

    private void addBasicImage(String image) {

        if (executionArrayList.size() < 8) {
            HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("image", image);
            executionArrayList.add(hashMap);

            try {
                for (int i = 0; i < executionArrayList.size(); i++) {

                    if (executionArrayList != null && !executionArrayList.isEmpty()) {
                        executionArrayList.add(executionArrayList.get(executionArrayList.size() - i));
                    } else {
                        executionArrayList.add(executionArrayList.get(executionArrayList.size() - 1));
                    }
                }
            } catch (Exception e) {
                executionArrayList.add(executionArrayList.get(executionArrayList.size() - 1));
            }

            displayExecutionList();

        } else {
            //showToastMessage("You can add only 8 items in burger");
        }
    }

    private void addExecutionImage(String image) {

        if (basicArrayList.size() < 8) {
            HashMap<String, String> hashMap = new HashMap<>();//create a hashmap to store the data in key value pair
            hashMap.put("image", image);
            basicArrayList.add(hashMap);//add the hashmap into arrayList

            try {
                for (int i = 0; i < basicArrayList.size(); i++) {

                    if (basicArrayList != null && !basicArrayList.isEmpty()) {
                        basicArrayList.add(basicArrayList.get(basicArrayList.size() - i));
                    } else {
                        basicArrayList.add(basicArrayList.get(basicArrayList.size() - 1));
                    }

                }
            } catch (Exception e) {
                basicArrayList.add(basicArrayList.get(basicArrayList.size() - 1));
            }

            displayBasicActionList();

        } else {
            //showToastMessage("You can add only 8 items in burger");
        }
    }

    private void mirrorAction() {

    }

    private void repeatAction() {

        try {

            if (arrayList != null && !arrayList.isEmpty()) {
                arrayList.remove(arrayList.size() - 1);
                myImageList.remove(myImageList.size() - 1);
                displayBurgerList();
            } else {
                //showToastMessage("You can add only 8 items in burger");
            }

        } catch (Exception e) {

        }

    }

    private void displayBurgerList() {
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, myImageList, R.layout.row_burger_image_list, from, to);//Create object and set the parameters for simpleAdapter
        makeburgerlist.setAdapter(simpleAdapter);//sets the adapter for listView
    }
    private void displayBasicActionList(){
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, basicArrayList, R.layout.row_basic_repeated_item_list, from, to);//Create object and set the parameters for simpleAdapter
        basicrepeatedlist.setAdapter(simpleAdapter);//sets the adapter for listView
    }
    private void displayExecutionList(){
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, executionArrayList, R.layout.row_execution_burger_list, from, to);//Create object and set the parameters for simpleAdapter
        executionlist.setAdapter(simpleAdapter);//sets the adapter for listView
    }

    public void init() {

        arrayList = new ArrayList<>();
        basicArrayList = new ArrayList<>();
        myImageList = new ArrayList<>();
        basicMyImageList = new ArrayList<>();
        executionArrayList = new ArrayList<>();
        executionMyImageList= new ArrayList<>();

        seekBar = findViewById(R.id.seekBar);

        makeburgerlist = findViewById(R.id.makeburgerlist);
        basicrepeatedlist = findViewById(R.id.basicrepeatedlist);
        executionlist = findViewById(R.id.executionlist);

        btnPlay = findViewById(R.id.layout_burger_play_action_progress_rows_1_button);
        btnFOne = findViewById(R.id.layout_burger_play_action_progress_rows_2_button);

        headerButton1 = findViewById(R.id.expandButton);
        headerButton2 = findViewById(R.id.repeatButton);
        headerButton3 = findViewById(R.id.emptyStarButton);
        headerButton4 = findViewById(R.id.filledStarButton);
        headerButton5 = findViewById(R.id.forwordButton);

        meetButton = findViewById(R.id.layout_burger_play_action_perform_row1_button1);
        bunButton = findViewById(R.id.layout_burger_play_action_perform_row1_button2);
        cheeseButton = findViewById(R.id.layout_burger_play_action_perform_row1_button3);
        repeatButton = findViewById(R.id.layout_burger_play_action_perform_row1_button4);
        tomatoButton = findViewById(R.id.layout_burger_play_action_perform_row2_button1);
        lettuceButton = findViewById(R.id.layout_burger_play_action_perform_row2_button2);
        topBunButton = findViewById(R.id.layout_burger_play_action_perform_row2_button3);
        mirroButton = findViewById(R.id.layout_burger_play_action_perform_row2_button4);

    }


}