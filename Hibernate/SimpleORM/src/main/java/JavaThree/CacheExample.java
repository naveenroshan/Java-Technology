package JavaThree;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import JavaThree.AlienName;

@Entity
@Table(name="cache_tables")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class CacheExample {
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
