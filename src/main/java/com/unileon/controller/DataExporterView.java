/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.controller;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.unileon.EJB.ButacasFacadeLocal;
import com.unileon.modelo.Butacas;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;
import org.primefaces.component.export.PDFOptions;
import org.primefaces.component.export.PDFOrientationType;

/**
 *
 * @author javia
 */
@Named
@ViewScoped
public class DataExporterView implements Serializable {

    private List<Butacas> butacas;
    
    private PDFOptions pdfOpt;

    private Exporter<DataTable> textExporter;

    @EJB
    private ButacasFacadeLocal butacaEJB;

    @PostConstruct
    public void init() {
        butacas = butacaEJB.findAll();
        textExporter = new TextExporter();
    }

    public List<Butacas> getButacas() {
        return butacas;
    }

    public Exporter<DataTable> getTextExporter() {
        return textExporter;
    }

    public void setTextExporter(Exporter<DataTable> textExporter) {
        this.textExporter = textExporter;
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" + File.separator + "images" + File.separator + "prime_logo.png";

	pdf.add(Image.getInstance(logo));
    }
    
    public PDFOptions getPdfOpt() {
        return pdfOpt;
    }

    public void setPdfOpt(PDFOptions pdfOpt) {
        this.pdfOpt = pdfOpt;
    }
    
    public void customizationOptions() {

        pdfOpt = new PDFOptions();
        pdfOpt.setFacetBgColor("#F88017");
        pdfOpt.setFacetFontColor("#0000ff");
        pdfOpt.setFacetFontStyle("BOLD");
        pdfOpt.setCellFontSize("12");
        pdfOpt.setFontName("Courier");
        pdfOpt.setOrientation(PDFOrientationType.LANDSCAPE);
    }
}