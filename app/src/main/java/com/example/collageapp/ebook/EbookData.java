package com.example.collageapp.ebook;

public class EbookData {
    private String pdftitle,pdfurl;

    public EbookData() {
    }

    public EbookData(String pdftitle, String pdfurl) {
        this.pdftitle = pdftitle;
        this.pdfurl = pdfurl;
    }

    public String getPdftitle() {
        return pdftitle;
    }

    public void setName(String pdftitle) {
        this.pdftitle = pdftitle;
    }

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl;
    }
}
