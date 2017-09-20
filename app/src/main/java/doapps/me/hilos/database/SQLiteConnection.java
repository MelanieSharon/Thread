package doapps.me.hilos.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import doapps.me.hilos.database.table.TableContent;

/**
 * Created by Melanie Veliz on 19/09/2017.
 */

public class SQLiteConnection extends SQLiteOpenHelper {
    public SQLiteConnection(Context context) {
        super(context, "db.hilo", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TableContent.sqlCreatePerson);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(TableContent.sqlCreatePerson);
        db.execSQL(TableContent.sqlDropTablePerson);
    }
}
