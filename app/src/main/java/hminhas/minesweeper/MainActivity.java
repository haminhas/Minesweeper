package hminhas.minesweeper;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int rows;
    private int col;
    private int mines;
    private Board board;
    private squares square;
    private LinearLayout main;
    private LinearLayout top;
    private ArrayList<LinearLayout> layout = new ArrayList<LinearLayout>();
    private Context context = this;
    private Boolean clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rows= 8;
        col= 8;
        mines= 10;
        clicked = false;


        main = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        main.setLayoutParams(layoutParams);
        main.setOrientation(LinearLayout.VERTICAL);




        top = new LinearLayout(this);
        top.setGravity(LinearLayout.HORIZONTAL);
        Button tmep = new Button(this);
        tmep.setText("temp");
        //top.addView(tmep);

        main.addView(top);
        createGame();
        Button reset = new Button(this);
        reset.setText("Reset");
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        main.addView(reset);
        main.setBackgroundColor(Color.parseColor("#E8ECEE"));
        setContentView(main, layoutParams);
    }

    public void createGame(){
        final Board board = new Board(rows,col,mines);
        final Button[][] buttons = new Button[rows][col];

        for(int i = 0;i<rows;i++){
            LinearLayout.LayoutParams k = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,1);
            LinearLayout l = new LinearLayout(this);
            l.setOrientation(LinearLayout.HORIZONTAL);
            l.setLayoutParams(k);

            layout.add(l);
        }

        for(int i=0;i<rows;i++){
            LinearLayout l = layout.get(i);
            for(int j=0;j<col;j++){
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,1);
                p.setMargins(5, 5, 5, 5);
                final Button temp =  new Button(this);
                temp.setBackgroundColor(Color.parseColor("#8E8E8E"));
                buttons[i][j] = temp;
                temp.setLayoutParams(p);
                temp.setMinWidth(134);
                temp.setMinimumWidth(134);
                final squares value = board.getValue(i, j);
                l.addView(temp);
                final Drawable mine = this.getDrawable(R.drawable.minesweepericon);
                temp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (value == square.MINE) {
                            temp.setBackground(mine);
                            for (int x = 0; x < col; x++) {
                                for (int y = 0; y < rows; y++) {
                                    Button child = buttons[x][y];
                                    squares vq = board.getValue(x, y);
                                    setImages(child,vq);
                                    child.setEnabled(false);
                                }

                            }
                        } else {
                            Button button = (Button) v;
                            setImages(button,value);
                        }
                    }
                });

                temp.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                    if(!clicked){
                        Button b = (Button) v;
                        //b.setBackgroundResource(R.drawable.flag);
                        Drawable obj = context.getDrawable(R.drawable.flag);
                        b.setBackground(obj);
                    } else {
                        Button b = (Button) v;
                        b.setBackgroundResource(0);
                    }



                        return true;
                    }
                });
            }
        main.addView(l);
        }
    }

    public void setImages(Button b,squares s){
        if (s == squares.ONE) {
            Drawable obj = context.getDrawable(R.drawable.one);
            b.setBackground(obj);
        } else if (s == squares.TWO) {
            Drawable obj = context.getDrawable(R.drawable.two);
            b.setBackground(obj);
        } else if (s == squares.THREE) {
            Drawable obj = context.getDrawable(R.drawable.three);
            b.setBackground(obj);
        } else if (s == squares.FOUR) {
            Drawable obj = context.getDrawable(R.drawable.four);
            b.setBackground(obj);
        } else if (s == squares.FIVE) {
            Drawable obj = context.getDrawable(R.drawable.five);
            b.setBackground(obj);
        } else if (s == squares.MINE) {
            Drawable obj = context.getDrawable(R.drawable.minesweepericon);
            b.setBackground(obj);
        } else if (s == squares.ZERO) {
            Drawable obj = context.getDrawable(R.drawable.blank);
            b.setBackground(obj);
        }

    }

}
