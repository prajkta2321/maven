package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String version;

    @ManyToMany(mappedBy = "tools")
    private List<Project> projects;

    public Tool() {}

    public Tool(String name, String version) {
        this.name = name;
        this.version = version;
    }

    // Getters & Setters

    @Override
    public String toString() {
        return "Tool{id=" + id + ", name='" + name + "', version='" + version + "'}";
    }
}
