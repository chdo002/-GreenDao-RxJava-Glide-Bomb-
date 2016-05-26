package android.wuliqing.com.lendphonesystemapp.DataBase;

import java.util.List;

/**
 * Created by 10172915 on 2016/5/26.
 */
public interface DataBaseAction<T> {
    public List<T> query();
    public void update(T note);
    public void remove(long id);
    public void add(T note);
}