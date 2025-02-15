package com.galleryapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "gallery.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_PAINTINGS = "paintings";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_IMAGE_RESOURCE = "image_resource";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_ARTIST = "artist";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_CATEGORY = "category";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_PAINTINGS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_IMAGE_RESOURCE + " INTEGER, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_ARTIST + " TEXT, " +
                    COLUMN_YEAR + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT," +
                    COLUMN_CATEGORY + " TEXT" +
                    ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PAINTINGS);
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void insertPainting(Painting painting) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IMAGE_RESOURCE, painting.getImageResource());
        values.put(COLUMN_TITLE, painting.getTitle());
        values.put(COLUMN_ARTIST, painting.getArtist());
        values.put(COLUMN_YEAR, painting.getYear());
        values.put(COLUMN_DESCRIPTION, painting.getDescription());
        values.put(COLUMN_CATEGORY, painting.getCategory());

        db.insert(TABLE_PAINTINGS, null, values);
    }

    public List<Painting> getAllPaintings() {
        List<Painting> paintings = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PAINTINGS, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int imageResource = cursor.getInt(cursor.getColumnIndex(COLUMN_IMAGE_RESOURCE));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
                @SuppressLint("Range") String artist = cursor.getString(cursor.getColumnIndex(COLUMN_ARTIST));
                @SuppressLint("Range") String year = cursor.getString(cursor.getColumnIndex(COLUMN_YEAR));
                @SuppressLint("Range") String description = cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION));
                @SuppressLint("Range") String category = cursor.getString(cursor.getColumnIndex(COLUMN_CATEGORY));

                paintings.add(new Painting(imageResource, title, artist, year, description, category));
            } while (cursor.moveToNext());

            cursor.close();
        }
        return paintings;
    }

    public List<Painting> getPaintingsByCategory(String category) {
        List<Painting> paintings = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM paintings WHERE category = ?", new String[]{category});

        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        int imageResource = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_IMAGE_RESOURCE));
                        String title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE));
                        String artist = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ARTIST));
                        String year = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_YEAR));
                        String description = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DESCRIPTION));
                        String categoryValue = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CATEGORY));

                        Painting painting = new Painting(imageResource, title, artist, year, description, categoryValue);
                        paintings.add(painting);
                    } while (cursor.moveToNext());
                }
            } finally {
                cursor.close();
            }
        }
        return paintings;
    }
}