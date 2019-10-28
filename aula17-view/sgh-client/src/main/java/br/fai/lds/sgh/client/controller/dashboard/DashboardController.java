/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.dashboard;

import br.fai.lds.sgh.database.dao.IUserDao;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author marcelo
 */
@Controller
public class DashboardController {

    private static final String NOT_FOUND_IMG = "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";
    private static final String UPLOADED_FOLDER = "C:/Users/Marcelo/Pictures/";

    @Autowired
    IUserDao userDao;

    /*
     *
     * Load from database
     */
//    @GetMapping("dashboard/list")
//    public String dashboard(Model model, HttpSession session) throws IOException {
//
//        model.addAttribute("msg", "SGH Dashboard");
//
//        User user = userDao.readById((Long) session.getAttribute("id"));
//
//        model.addAttribute("base64Image", user.getImg() != null ? user.getImg() : NOT_FOUND_IMG);
//
//        return "dashboard";
//
//    }
    /*
      *
      * Load from file
     */
    @GetMapping("dashboard/list")
    public String dashboard(Model model) throws IOException {

        model.addAttribute("msg", "SGH Dashboard");

        File file = new File(UPLOADED_FOLDER + "img.png");

        if (file.exists()) {

            byte[] fileContent = FileUtils.readFileToByteArray(new File(UPLOADED_FOLDER + "img.png"));

            String encodedString = Base64.getEncoder().encodeToString(fileContent);

            model.addAttribute("base64Image", encodedString);
        } else {
            
            model.addAttribute("base64Image", NOT_FOUND_IMG);
        }

        return "dashboard";

    }

    /**
     *
     * Save in database
     */
//    @PostMapping("dashboard/upload")
//    public String dashboardUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, HttpSession session) throws IOException {
//
//        if (!file.isEmpty()) {
//
//            try {
//
//                byte[] bytes = file.getBytes();
//                String encodedString = Base64.getEncoder().encodeToString(bytes);
//
//                User user = userDao.readById((Long) session.getAttribute("id"));
//                user.setImg(encodedString);
//                
//                userDao.update(user);
//                
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            return "redirect:/dashboard/list";
//        } else {
//
//        }
//
//        return "redirect:/error";
//    }
    /*
     *
     * Save in file
     */
    @PostMapping("dashboard/upload")
    public String dashboardUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

        if (!file.isEmpty()) {

            try {

                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + "img.png");
                Files.write(path, bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }

            return "redirect:/dashboard/list";
        } else {

        }

        return "redirect:/error";
    }
}
