import java.util.HashMap;
import java.util.TreeMap;

public class Model {
    TreeMap<Integer, String> data = new TreeMap<>();
    public void addData(String value) {
        data.put(data.size(), value);
    }
    public String getData(int key) {
        return data.get(key);
    }
    public void removeData(int key) {
        data.remove(key);
    }
    public void updateData(int key, String value) {
        data.put(key, value);
    }
    public TreeMap<Integer, String> getAllData() {
        return data;
    }
    public void clearData() {
        data.clear();
    }
}
