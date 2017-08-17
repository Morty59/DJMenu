package yaism.djmenu.database.Entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrateur on 09/04/2017.
 */
@Entity
public class RecipeEntity {
    @Id
    private Long id;

    private String name;

    private String description;

    private int type;

    @Generated(hash = 885757899)
    public RecipeEntity(Long id, String name, String description, int type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    @Generated(hash = 1866254718)
    public RecipeEntity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        this.description = name;
    }

    public int getType(){
        return type;
    }

    public void setType(int recipeType){
        this.type = recipeType;
    }
}
