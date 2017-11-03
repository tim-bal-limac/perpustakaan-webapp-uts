package limac.timbal.perpustakaanwebapputs.controller;

import limac.timbal.perpustakaanwebapputs.repo.BukuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private BukuRepo bukuRepo;

    @RequestMapping("/home")
    public void index() {}

    @RequestMapping("/daftar-buku")
    public void getDaftarBuku(Model model){
      model.addAttribute("daftarBuku",bukuRepo.findAll());
    }

}
