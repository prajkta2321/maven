package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @ManyToOne
    private Designer designer;

    @ManyToMany
    @JoinTable(name = "project_tools",
               joinColumns = @JoinColumn(name = "project_id"),
               inverseJoinColumns = @JoinColumn(name = "tool_id"))
    private List<Tool> tools;

    public Project() {}

    public Project(String title, Designer designer) {
        this.title = title;
        this.designer = designer;
    }

    // Getters & Setters

    @Override
    public String toString() {
        return "Project{id=" + id + ", title='" + title + "', designer=" + designer.getName() + "}";
    }

	public List<Project> getTools() {
		// TODO Auto-generated method stub
		return null;
	}
}
