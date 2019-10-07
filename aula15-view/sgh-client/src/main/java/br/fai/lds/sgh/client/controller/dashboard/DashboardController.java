/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.dashboard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
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

    private static String UPLOADED_FOLDER = "/home/marcelo/Pictures/";

    @GetMapping("dashboard/list")
    public String dashboard(Model model) throws IOException {

        model.addAttribute("msg", "SGH Dashboard");
        
        byte[] fileContent = FileUtils.readFileToByteArray(new File(UPLOADED_FOLDER + "img.png"));

        String encodedString = Base64.getEncoder().encodeToString(fileContent);

        model.addAttribute("base64Image", encodedString);

        
        return "dashboard";

    }

    @PostMapping("dashboard/upload")
    public String dashboardUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

        if (!file.isEmpty()) {

            try {

                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
//                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Path path = Paths.get(UPLOADED_FOLDER + "img.png");
                Files.write(path, bytes);

                //redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "redirect:/dashboard/list";
        } else {

        }

        return "redirect:/error";

    }

}
