package org.example.models;
import jakarta.validation.constraints.NotBlank;

/**
 * Reprezentuje úlohu s identifikátorom, názvom a popisom.
 */
public class Task {

    /** Identifikátor úlohy. */
    private Long id;

    /** Názov úlohy, nesmie byť prázdny. */
    @NotBlank(message = "Name cannot be empty")
    private String name;

    /** Popis úlohy. */
    private String description;

    /**
     * Konštruktor bez parametrov.
     */
    public Task() {
    }

    /**
     * Konštruktor na vytvorenie úlohy so zadanými hodnotami.
     *
     * @param id           identifikátor úlohy
     * @param name         názov úlohy
     * @param description  popis úlohy
     */
    public Task(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Získa identifikátor úlohy.
     *
     * @return identifikátor úlohy.
     */
    public Long getId() {
        return id;
    }

    /**
     * Nastaví identifikátor úlohy.
     *
     * @param id identifikátor úlohy
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * získa názov úlohy
     *
     * @return názov úlohy
     */
    public String getName() {
        return name;
    }

    /**
     * Nastaví názov úlohy
     *
     * @param name nový názov úlohy
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Získa popis úlohy.
     *
     * @return popis úlohy
     */
    public String getDescription() {
        return description;
    }

    /**
     * Nastaví popis úlohy.
     *
     * @param description nový popis úlohy
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
