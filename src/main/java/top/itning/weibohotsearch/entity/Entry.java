package top.itning.weibohotsearch.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 词条
 *
 * @author wangn
 */
@Document(collection = "WeiBoHot")
public class Entry implements Serializable, Comparable<Entry> {
    @Field("hot")
    private int hot;
    @Id
    private String value;

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "hot=" + hot +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public int compareTo(Entry o) {
        return Integer.compare(this.hot, o.getHot());
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Entry) {
            return this.value.equals(((Entry) obj).value);
        }
        return super.equals(obj);
    }
}
