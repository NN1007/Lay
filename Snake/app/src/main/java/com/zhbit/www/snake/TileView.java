package com.zhbit.www.snake;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hy on 2017/5/7.
 */

public class TileView extends View {
    protected static int mTileSize;   //每个方块的尺寸大小

    protected static int mXTileCount;    //屏幕内能容纳的 X方向上方块的总数量
    protected static int mYTileCount;    //屏幕内能容纳的 Y方向上方块的总数量

    private static int mXOffset;      //起点坐标
    private static int mYOffset;

    private Bitmap[] mTileArray;      //将游戏中的方块加载到这个数组

    private int[][] mTileGrid;       //画布

    private final Paint mPaint = new Paint();    //画笔

    public TileView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        //使用TypedArray，获取在attrs.xml中为TileView定义的新属性tileSize
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TileView);

        mTileSize = a.getInt(R.styleable.TileView_tileSize, 12);

        a.recycle();
    }

    public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TileView);

        mTileSize = a.getInt(R.styleable.TileView_tileSize, 12);

        a.recycle();
    }


    //重置清零mTileArray，在游戏初始的时候使用
    public void resetTiles(int tilecount) {
        mTileArray = new Bitmap[tilecount];
    }


    //当改变屏幕大小尺寸时，同时修改tile的相关计数指标
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mXTileCount = (int) Math.floor(w / mTileSize);
        mYTileCount = (int) Math.floor(h / mTileSize);

        mXOffset = ((w - (mTileSize * mXTileCount)) / 2);
        mYOffset = ((h - (mTileSize * mYTileCount)) / 2);

        mTileGrid = new int[mXTileCount][mYTileCount];
        clearTiles();
    }

    //将对应的砖块的图片 对应的加载到 mTileArray数组中
    public void loadTile(int key, Drawable tile) {
        Bitmap bitmap = Bitmap.createBitmap(mTileSize, mTileSize,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        tile.setBounds(0, 0, mTileSize, mTileSize);
        tile.draw(canvas);

        mTileArray[key] = bitmap;
    }


    //清空图形显示以更新画面
    public void clearTiles() {
        for (int x = 0; x < mXTileCount; x++) {
            for (int y = 0; y < mYTileCount; y++) {
                setTile(0, x, y);
            }
        }
    }

    //在相应的坐标位置绘制相应的砖块
    public void setTile(int tileindex, int x, int y) {
        mTileGrid[x][y] = tileindex;
    }


    //将画布绘制在屏幕上
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int x = 0; x < mXTileCount; x += 1) {
            for (int y = 0; y < mYTileCount; y += 1) {
                if (mTileGrid[x][y] > 0) {
                    canvas.drawBitmap(mTileArray[mTileGrid[x][y]], mXOffset + x
                            * mTileSize, mYOffset + y * mTileSize, mPaint);
                }
            }
        }

    }


}
