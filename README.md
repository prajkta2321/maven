 # 🎨 Graphics Design Management System

A simple Java console application using **Jakarta Persistence (JPA)** to manage Designers, Projects, and Tools for a digital design studio.

## 📦 Features

- Add new **Designers**, **Projects**, and **Tools**
- Assign Tools to Projects
- View all Projects with associated information
- Persistent storage using **JPA** (Jakarta Persistence API)

## 🛠️ Technologies Used

- Java
- JPA (Jakarta Persistence API)
- Hibernate (as JPA implementation)
- H2 / MySQL / other JPA-supported databases (configurable via `persistence.xml`)
- Maven (recommended for dependency management)

🖥 Example Menu

🎨 Graphics Design Manager
1. Add Designer
2. Add Project
3. Add Tool
4. Assign Tool to Project
5. View Projects
0. Exit

## 🧰 Entities

### 👤 Designer
- `id` (auto-generated)
- `name`
- `specialty`


### 🗂️ Project
- `id` (auto-generated)
- `title`
- `designer` (Many-to-One)
- `tools` (Many-to-Many)


### 🧪 Tool
- `id` (auto-generated)
- `name`
- `version`

📁 Project Structure
css
Copy code
graphics-design-manager/
├── src/

│   ├── main/

│   │   ├── java/

│   │   │   └── app/

│   │   │       └── Main.java

│   │   │
│   │   │   └── entity/

│   │   │       ├── Designer.java

│   │   │       ├── Project.java

│   │   │       └── Tool.java

│   │   │
│   │   └── resources/


│   │       └── META-INF/

│   │           └── persistence.xml

│   │
│   └── test/

│       └── java/

│           └── (optional test classes)

│
├── .gitignore

├── pom.xml

└── README.md


📦 Maven Dependencies

<dependencies>

    <dependency>
        <groupId>jakarta.persistence</groupId>
        <artifactId>jakarta.persistence-api</artifactId>
        <version>3.1.0</version>
    </dependency>
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>6.2.7.Final</version>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <version>2.2.224</version>
    </dependency>
</dependencies>

🗄 Database Schema

•	designer

•	project

•	tool

•	project_tools (join table for many-to-many)


🧑 designer

CREATE TABLE designer (

    id SERIAL PRIMARY KEY,
    
    name VARCHAR(255),
    
    specialty VARCHAR(255)
    
);



📁 project

CREATE TABLE project (

    id SERIAL PRIMARY KEY,
    
    title VARCHAR(255),
    
    designer_id INTEGER,
    
    FOREIGN KEY (designer_id) REFERENCES designer(id)
    
);



🛠 tool

CREATE TABLE tool (

    id SERIAL PRIMARY KEY,
    
    name VARCHAR(255),
    
    version VARCHAR(255)
    
);



🔗 project_tools (join table)

CREATE TABLE project_tools (

    project_id INTEGER,
    
    tool_id INTEGER,
    
    PRIMARY KEY (project_id, tool_id),
    
    FOREIGN KEY (project_id) REFERENCES project(id),
    
    FOREIGN KEY (tool_id) REFERENCES tool(id)
    
);


📞Contact:-
For any questions or feedback, feel free to reach out:

Your Name : Prajkta more,Pornima kavade

Email: prajktamore63@gmail.com

GitHub: https://github.com/prajkta2321/maven.git

## 🚀 Getting Started


## Screenshot for Outpot

<img width="794" height="763" alt="Screenshot 2025-07-15 160627" src="https://github.com/user-attachments/assets/56efed0e-f7d6-4c13-a600-e8432b6cab5c" />
<img width="954" height="696" alt="Screenshot 2025-07-15 160654" src="https://github.com/user-attachments/assets/c3514a57-8406-4254-bee7-ad9c91e42510" />
<img width="1122" height="734" alt="Screenshot 2025-07-15 160600" src="https://github.com/user-attachments/assets/62245f02-6bfd-491d-bb5e-0bb73a8587fe" />



