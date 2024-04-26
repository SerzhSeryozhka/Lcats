package Cats.Lcats;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CatController {
    @GetMapping("/cats_form")
    public String dodo(){
        System.out.println("asdfghjkl;");
        return "form_for_cat";
    }

    @PostMapping("/cats")
    public String getCatsFromFile(@RequestParam String fileName, Model model) throws IOException {
        System.out.println("загружаем из фвайла "+fileName);
        List<Cat> cats = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                long id = Long.parseLong(data[0]);
                String name = data[1];
                String color = data[2];
                int age = Integer.parseInt(data[3]);
                if (age >= 0 && age <= 25) {
                    cats.add(new Cat(id, name, color, age));
                }
            }
        } catch (FileNotFoundException e) {
            return "Такого файла нет или путь неправильный"; // Возвращаем null если файл не найден
        }
        model.addAttribute("koty",cats);
        return "cats";
    }
}