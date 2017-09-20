package doapps.me.hilos.database.table;

/**
 * Created by Melanie Veliz on 19/09/2017.
 */

public class TableContent {
    public static String sqlCreatePerson = "CREATE TABLE " +
            PersonTable.TABLE_NAME + " ( " +
            PersonTable.COD + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            PersonTable.NAME + " TEXT, " +
            PersonTable.LAST_NAME + " TEXT, " +
            PersonTable.AGE + " INTEGER, " +
            PersonTable.HOBBY + " TEXT, " +
            PersonTable.CAREER + " TEXT, " +
            PersonTable.CITY + " TEXT " + " ) ";

    public final static String sqlDropTablePerson = "DROP TABLE IF EXISTS " + PersonTable.TABLE_NAME;
}
