package ir.harmonyapp.gity.naildesign;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DbHelper extends SQLiteOpenHelper {
    static String db_name = "DbFvorite";
    static int db_version = 1;
    static String table_name = "tbFavorite";
    static String id_field = "_id";
    static String type_field = "type";
    static String title_field = "title";
    static String position_field = "position";


    Context context;
    SQLiteDatabase db;
    ContentValues cv;
    Cursor c;

    public DbHelper(Context context) {
        super(context, db_name, null, db_version);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QueryCreateTable = "create table " + table_name + "( "
                + id_field + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + title_field + " text, "
                + position_field + " text, "
                + type_field + " text )";
        try {
            db.execSQL(QueryCreateTable);
            //Toast.makeText(context, "CREATED TABLE", Toast.LENGTH_SHORT).show();
        } catch (Exception EX) {
            Toast.makeText(context, EX + "", Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void InsertFavorite(String type, String title, String position) {
        db = this.getWritableDatabase();
        cv = new ContentValues();
        cv.put(title_field, title);
        cv.put(type_field, type);
        cv.put(position_field, position);


        try {
            db.insert(table_name, null, cv);
            Toast.makeText(context, "به لیست علاقه مندی ها افزوده شد.", Toast.LENGTH_SHORT).show();
        } catch (Exception EX) {
            Toast.makeText(context, EX + "", Toast.LENGTH_SHORT).show();
        }

        db.close();

    }

    Cursor selectall() {
        db = this.getReadableDatabase();
        c = db.rawQuery("select * from " + table_name, null);
        return c;
    }


    Cursor findfavorite(String position, String type) {


        db = this.getReadableDatabase();
        c = db.query(
                false, table_name, new String[]{title_field}, position_field + "=? AND " + type_field + "=?",
                new String[]{position, type}, null, null, null, null
        );
        return c;
    }

    void delete_field(String position, String type) {
        db = this.getWritableDatabase();
        try {
            db.delete(table_name, position_field + "=? AND " + type_field + "=?", new String[]{position, type});
            Toast.makeText(context, "از لیست علاقه مندی ها حذف شد.", Toast.LENGTH_SHORT).show();

        } catch (Exception EX) {
            Toast.makeText(context, "CANT DELETE" + EX, Toast.LENGTH_SHORT).show();
        }


    }

}
