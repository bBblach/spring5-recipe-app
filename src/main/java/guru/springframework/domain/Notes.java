package guru.springframework.domain;

import javax.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne // we dont add cascade because f.e if we delete notes we dont want to delete recepie
    private  Recipe recipe;
    @Lob // normaly in spring you can storne like 250 characters max, with Lob annotation limitation is removed
    private String recepieNotes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecepieNotes() {
        return recepieNotes;
    }

    public void setRecepieNotes(String recepieNotes) {
        this.recepieNotes = recepieNotes;
    }
}
