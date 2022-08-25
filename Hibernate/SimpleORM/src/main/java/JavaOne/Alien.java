package JavaOne;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="alien_tables")
public class Alien {
    @Id
    private int aId;
    private AlienName aName;
    @Column(name="alien_color")
    private String aColor;

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public AlienName getaName() {
        return aName;
    }

    public void setaName(AlienName aName) {
        this.aName = aName;
    }

    public String getaColor() {
        return aColor;
    }

    public void setaColor(String aColor) {
        this.aColor = aColor;
    }

    @Override
    public String toString() {
        return "JavaOne.Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aColor='" + aColor + '\'' +
                '}';
    }
}
