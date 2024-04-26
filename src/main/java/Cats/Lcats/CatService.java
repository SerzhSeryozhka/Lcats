package Cats.Lcats;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class CatService {
@PostConstruct
    public swapColor(@RequestParam String s, Model model){


}
}
