package JAVA.JAVAProgect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class NotebookFilters {
    public static HashSet<Notebook> notebooks;

    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("notebook1", "16", "Linux", "Оранжевый", "Intel", "Intel");
        Notebook notebook2 = new Notebook("notebook2", "32", "Windows", "Черный", "Intel", "AMD");
        Notebook notebook3 = new Notebook("notebook3", "64", "Windows", "Голубой", "Nvidia", "Intel");
        Notebook notebook4 = new Notebook("notebook4", "8", "Linux", "Черный", "Intel", "Intel");
        Notebook notebook5 = new Notebook("notebook5", "32", "Linux", "Белый", "Radeon", "AMD");
        Notebook notebook6 = new Notebook("notebook6", "64", "Windows", "Черный", "Intel", "Intel");
        Notebook notebook7 = new Notebook("notebook7", "16", "Windows", "Зеленый", "Nvidia", "Intel");
        Notebook notebook8 = new Notebook("notebook8", "8", "Linux", "Черный", "Intel", "Intel");
        Notebook notebook9 = new Notebook("notebook9", "8", "Windows", "Черный", "Radeon", "AMD");
        Notebook notebook10 = new Notebook("notebook10", "128", "Windows", "Белый", "Rageon", "AMD");
        Notebook notebook11 = new Notebook("notebook11", "32", "Linux", "Черный", "Intel", "Intel");
        // Notebook notebook11 = new Notebook("notebook10", 128, "Windows", "White",
        // "Rageon", "Intel");

        notebooks = new HashSet<>(Arrays.asList(
                notebook1, notebook2, notebook3, notebook4, notebook5, notebook6,
                notebook7, notebook8, notebook9, notebook10, notebook11));

        for (Notebook notebook : notebooks) {
            System.out.println(notebook);
        }
        System.out.println();

        LinkedHashMap<String, String> filters = getFilters();
        HashSet<Notebook> filtered = filter(filters, notebooks);

        if (!filtered.isEmpty()) {
            for (Notebook notebook : filtered) {
                System.out.println(notebook);
            }
        } else
            System.out.println("Ничего не было нйдено");

    }

    public static LinkedHashMap<String, String> getFilters() {
        LinkedHashMap<String, String> filters = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите производителя процессора: Intel или AMD");
        String CPU = sc.nextLine();

        System.out.println("Введите производителя видеокарты: Intel, Nvidia или Radeon");
        String GPU = sc.nextLine();

        System.out.println("Введите минимальный обьем ОЗУ: 8, 16 ,32, 64 или 128");
        String RAM = sc.nextLine();

        System.out.println("Введите Операционную систему: Windows или Linux");
        String os = sc.nextLine();

        String color = "любой";

        sc.close();

        filters.put("CPU", CPU);
        filters.put("GPU", GPU);
        filters.put("RAM", RAM);
        filters.put("os", os);
        filters.put("color", color);

        return filters;

    }

    public static HashSet<Notebook> filter(LinkedHashMap<String, String> filters, HashSet<Notebook> notebooks) {
        HashSet<Notebook> filtered_notebooks = new HashSet<>();
        for (Notebook notebook : notebooks) {
            if (notebook.CPU.equals(filters.get("CPU")) && notebook.GPU.equals(filters.get("GPU"))
                    && Integer.parseInt(notebook.RAM) >= Integer.parseInt(filters.get("RAM"))
                    && notebook.os.equals(filters.get("os"))
                    && (notebook.color.toLowerCase().equals(filters.get("color").toLowerCase())
                            || filters.get("color").toLowerCase().equals("любой"))) {
                filtered_notebooks.add(notebook);
            }
        }
        return filtered_notebooks;
    }
}
