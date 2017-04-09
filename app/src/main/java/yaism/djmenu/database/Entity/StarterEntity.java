package yaism.djmenu.database.Entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrateur on 06/04/2017.
 */
@Entity
public class StarterEntity {
    @Id
    private Long id;

    private String name;

    @Transient
    private int tempUsageCount; // not persisted

    @Generated(hash = 921003961)
    public StarterEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 158367143)
    public StarterEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
