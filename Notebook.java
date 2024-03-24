package JAVA.JAVAProgect;

import java.util.Objects;

public class Notebook {
    public String name;
    public String RAM;
    public String os;
    public String color;
    public String GPU;
    public String CPU;

    public Notebook(String name, String RAM, String os, String color, String GPU, String CPU) {
        this.name = name;
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        this.color = color;
        this.os = os;
    }

    @Override
    public String toString() {
        return String.format(
                "%s процессор: %s, видеокарта: %s, обьем оперативной памяти: %s, операционная система: %s, цвет: %s",
                name, CPU, GPU, RAM, os, color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Notebook notebook = (Notebook) obj;

        return (name.equals(notebook.name) && CPU.equals(notebook.CPU)
                && GPU.equals(notebook.GPU) && RAM.equals(notebook.RAM)
                && color.equals(notebook.color) && os.equals(notebook.os));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, CPU, GPU, RAM, color, os);
    }

}
