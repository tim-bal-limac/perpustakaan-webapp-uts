package limac.timbal.perpustakaanwebapputs.controller;

import limac.timbal.perpustakaanwebapputs.entitiy.Buku;
import limac.timbal.perpustakaanwebapputs.repo.BukuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    @RequestMapping(value = "/tambah-data", method = RequestMethod.GET)
    public void getTambahData(@ModelAttribute("buku")Buku buku, BindingResult binding){
    }
    
    @RequestMapping(value = "/tambah-data", method = RequestMethod.POST)
    public String saveTambahData(@ModelAttribute("buku")Buku buku, BindingResult binding) {
        System.out.println(buku.getId());
        bukuRepo.save(buku);
        return "redirect:/daftar-buku";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public void getEditData(@RequestParam(name = "id", required = false) String id,
            @ModelAttribute("buku") Buku buku, BindingResult binding) {
        Buku ebuku = bukuRepo.findById(id);
        buku.setId(ebuku.getId());
        buku.setJudul_buku(ebuku.getJudul_buku());
        buku.setPenulis(ebuku.getPenulis());
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditData(@ModelAttribute("buku") Buku buku, BindingResult binding) {
    bukuRepo.save(buku);
    return "redirect:/daftar-buku";
    }
    
    @RequestMapping("/delete")
    public String deleteData(@RequestParam(name = "id", required = true) String id) {
        bukuRepo.delete(id);
        return "redirect:/daftar-buku";
    }

}
