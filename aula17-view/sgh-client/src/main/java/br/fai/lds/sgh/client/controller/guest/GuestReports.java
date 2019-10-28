/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fai.lds.sgh.client.controller.guest;

import br.fai.lds.sgh.database.dao.IGuestDao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Marcelo
 */
@Controller
public class GuestReports {

    @Autowired
    IGuestDao guestDao;

    @GetMapping("guest/report")
    public String getGuestReport() throws FileNotFoundException, DRException {

        JasperReportBuilder report = DynamicReports.report();
        
        report.columns(Columns.column("Id", "id", DataTypes.longType()));
        report.columns(Columns.column("Id room", "idRoom", DataTypes.longType()));
        report.columns(Columns.column("Name", "name", DataTypes.stringType()));
        report.columns(Columns.column("Age", "age", DataTypes.integerType()));
        report.columns(Columns.column("Phone", "phone", DataTypes.stringType()));
        
        report.title(Components.text("Guest Report").setHorizontalAlignment(HorizontalAlignment.LEFT));
        
        report.pageFooter(Components.pageXofY());

        report.setDataSource(guestDao.readAll());
        
        report.toPdf(new FileOutputStream("c:\\Users\\Marcelo\\report.pdf"));
        
        return "report/download";
    }

}
