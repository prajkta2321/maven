package app;

import entity.Designer;
import entity.Project;
import entity.Tool;

import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("graphicsPU");

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n🎨 Graphics Design Manager");
            System.out.println("1. Add Designer");
            System.out.println("2. Add Project");
            System.out.println("3. Add Tool");
            System.out.println("4. Assign Tool to Project");
            System.out.println("5. View Projects");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }

            switch (choice) {
                case 1:
                    addDesigner();
                    break;
                case 2:
                    addProject();
                    break;
                case 3:
                    addTool();
                    break;
                case 4:
                    assignToolToProject();
                    break;
                case 5:
                    viewProjects();
                    break;
                case 0:
                    emf.close();
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addDesigner() {
        System.out.print("Enter designer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter specialty: ");
        String specialty = scanner.nextLine();

        Designer designer = new Designer(name, specialty);
        persist(designer);
    }

    private static void addProject() {
        System.out.print("Enter project title: ");
        String title = scanner.nextLine();
        System.out.print("Enter designer ID: ");
        int designerId = Integer.parseInt(scanner.nextLine());

        EntityManager em = emf.createEntityManager();
        Designer designer = em.find(Designer.class, designerId);
        em.close();

        if (designer == null) {
            System.out.println("Designer not found.");
            return;
        }

        Project project = new Project(title, designer);
        persist(project);
    }

    private static void addTool() {
        System.out.print("Enter tool name: ");
        String name = scanner.nextLine();
        System.out.print("Enter tool version: ");
        String version = scanner.nextLine();

        Tool tool = new Tool(name, version);
        persist(tool);
    }

    private static void assignToolToProject() {
        System.out.print("Enter project ID: ");
        int projectId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter tool ID: ");
        int toolId = Integer.parseInt(scanner.nextLine());

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Project project = em.find(Project.class, projectId);
            Tool tool = em.find(Tool.class, toolId);
            if (project == null || tool == null) {
                System.out.println("Project or Tool not found.");
                tx.rollback();
                return;
            }

            project.getTools().add(tool);
            em.merge(project);
            tx.commit();
            System.out.println("Tool assigned to project.");
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static void viewProjects() {
        EntityManager em = emf.createEntityManager();
        List<Project> projects = em.createQuery("FROM Project", Project.class).getResultList();
        for (Project project : projects) {
            System.out.println(project);
        }
        em.close();
    }

    private static void persist(Object entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
            System.out.println("Saved: " + entity);
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

