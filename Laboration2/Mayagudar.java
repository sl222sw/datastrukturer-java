package Laboration2;

import java.util.Objects;

public class Mayagudar implements Comparable<Mayagudar> {

    private String name;
    private String type;
    private String desc;

    public Mayagudar(String name, String type, String desc) {
        this.name = name;
        this.type = type;
        this.desc = desc;
    }

    public Mayagudar() {
    }

    public Mayagudar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = 31 * result + name.hashCode();
        /*if (result < 0 ) {
            result = -result;
        }*/
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mayagudar mayagudar = (Mayagudar) o;
        return Objects.equals(name, mayagudar.name);
    }

    @Override
    public int compareTo(Mayagudar e) {
        return this.getName().compareTo(e.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}
