package entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Designer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String specialty;

    @OneToMany(mappedBy = "designer", cascade = CascadeType.ALL)
    private List<Project> projects;

    public Designer() {}

    public Designer(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    // Getters & Setters

    @Override
    public String toString() {
        return "Designer{id=" + id + ", name='" + name + "', specialty='" + specialty + "'}";
    }

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

