package doapps.me.hilos.database.process;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import doapps.me.hilos.database.SQLiteConnection;
import doapps.me.hilos.database.listener.PersonInterface;
import doapps.me.hilos.database.table.PersonTable;
import doapps.me.hilos.model.Person;

/**
 * Created by Melanie Veliz on 19/09/2017.
 */

public class PersonProcess implements PersonInterface<Person> {
    private Context context;
    private SQLiteConnection connection;
    private SQLiteDatabase db;

    public PersonProcess(Context context) {
        connection = new SQLiteConnection(context);
        db = connection.getWritableDatabase();
        this.context = context;
    }

    @Override
    public void insert(Person person) {
        ContentValues values = new ContentValues();

        values.put(PersonTable.NAME, person.getName());
        values.put(PersonTable.LAST_NAME, person.getLastName());
        values.put(PersonTable.AGE, person.getAge());
        values.put(PersonTable.HOBBY, person.getHobby());
        values.put(PersonTable.CAREER, person.getCareer());
        values.put(PersonTable.CITY, person.getCity());

        db.insert(PersonTable.TABLE_NAME, null, values);
    }

    @Override
    public Person find(String id) {
        return null;
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM " + PersonTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                personList.add(new Person(c.getString(1), c.getString(2), c.getInt(3), c.getString(4),
                        c.getString(5), c.getString(6)));

                Log.e("name", c.getString(1));
                Log.e("lastname", c.getString(2));
                Log.e("edad", c.getString(3));
                Log.e("hobby", c.getString(4));
                Log.e("carrera", c.getString(5));
                Log.e("city", c.getString(6));

            } while (c.moveToNext());
        }
        return personList;
    }

    public void showLengt() {
        long size = new File(db.getPath()).length();

        Log.e("size db", size + "");
    }
}
