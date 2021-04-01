package com.kumarrittik99.gutenbergproject.models;


import com.google.gson.annotations.SerializedName;

public class Formats {

    @SerializedName("application/x-mobipocket-ebook")
    private String applicationXMobipocketEbook;

    @SerializedName("application/pdf")
    private String applicationPdf;

    @SerializedName("text/plain; charset=us-ascii")
    private String textPlainCharsetUsAscii;

    @SerializedName("text/plain; charset=utf-8")
    private String textPlainCharsetUtf8;

    @SerializedName("application/rdf+xml")
    private String applicationRdfXml;

    @SerializedName("application/zip")
    private String applicationZip;

    @SerializedName("application/epub+zip")
    private String applicationEpubZip;

    @SerializedName("text/html; charset=utf-8")
    private String textHtmlCharsetUtf8;

    @SerializedName("text/plain; charset=iso-8859-1")
    private String textPlainCharsetIso88591;

    @SerializedName("image/jpeg")
    private String imageJpeg;

    @SerializedName("text/plain")
    private String textPlain;

    @SerializedName("text/html; charset=us-ascii")
    private String textHtmlCharsetUsAscii;

    @SerializedName("text/html")
    private String textHtml;

    @SerializedName("text/rtf")
    private String textRtf;

    @SerializedName("text/html; charset=iso-8859-1")
    private String textHtmlCharsetIso88591;

    @SerializedName("application/prs.tex")
    private String applicationPrsTex;

    public Formats() {
    }

    public Formats(String applicationXMobipocketEbook, String applicationPdf, String textPlainCharsetUsAscii, String textPlainCharsetUtf8, String applicationRdfXml, String applicationZip, String applicationEpubZip, String textHtmlCharsetUtf8, String textPlainCharsetIso88591, String imageJpeg, String textPlain, String textHtmlCharsetUsAscii, String textHtml, String textRtf, String textHtmlCharsetIso88591, String applicationPrsTex) {
        super();
        this.applicationXMobipocketEbook = applicationXMobipocketEbook;
        this.applicationPdf = applicationPdf;
        this.textPlainCharsetUsAscii = textPlainCharsetUsAscii;
        this.textPlainCharsetUtf8 = textPlainCharsetUtf8;
        this.applicationRdfXml = applicationRdfXml;
        this.applicationZip = applicationZip;
        this.applicationEpubZip = applicationEpubZip;
        this.textHtmlCharsetUtf8 = textHtmlCharsetUtf8;
        this.textPlainCharsetIso88591 = textPlainCharsetIso88591;
        this.imageJpeg = imageJpeg;
        this.textPlain = textPlain;
        this.textHtmlCharsetUsAscii = textHtmlCharsetUsAscii;
        this.textHtml = textHtml;
        this.textRtf = textRtf;
        this.textHtmlCharsetIso88591 = textHtmlCharsetIso88591;
        this.applicationPrsTex = applicationPrsTex;
    }

    public String getApplicationXMobipocketEbook() {
        return applicationXMobipocketEbook;
    }

    public void setApplicationXMobipocketEbook(String applicationXMobipocketEbook) {
        this.applicationXMobipocketEbook = applicationXMobipocketEbook;
    }

    public String getApplicationPdf() {
        return applicationPdf;
    }

    public void setApplicationPdf(String applicationPdf) {
        this.applicationPdf = applicationPdf;
    }

    public String getTextPlainCharsetUsAscii() {
        return textPlainCharsetUsAscii;
    }

    public void setTextPlainCharsetUsAscii(String textPlainCharsetUsAscii) {
        this.textPlainCharsetUsAscii = textPlainCharsetUsAscii;
    }

    public String getTextPlainCharsetUtf8() {
        return textPlainCharsetUtf8;
    }

    public void setTextPlainCharsetUtf8(String textPlainCharsetUtf8) {
        this.textPlainCharsetUtf8 = textPlainCharsetUtf8;
    }

    public String getApplicationRdfXml() {
        return applicationRdfXml;
    }

    public void setApplicationRdfXml(String applicationRdfXml) {
        this.applicationRdfXml = applicationRdfXml;
    }

    public String getApplicationZip() {
        return applicationZip;
    }

    public void setApplicationZip(String applicationZip) {
        this.applicationZip = applicationZip;
    }

    public String getApplicationEpubZip() {
        return applicationEpubZip;
    }

    public void setApplicationEpubZip(String applicationEpubZip) {
        this.applicationEpubZip = applicationEpubZip;
    }

    public String getTextHtmlCharsetUtf8() {
        return textHtmlCharsetUtf8;
    }

    public void setTextHtmlCharsetUtf8(String textHtmlCharsetUtf8) {
        this.textHtmlCharsetUtf8 = textHtmlCharsetUtf8;
    }

    public String getTextPlainCharsetIso88591() {
        return textPlainCharsetIso88591;
    }

    public void setTextPlainCharsetIso88591(String textPlainCharsetIso88591) {
        this.textPlainCharsetIso88591 = textPlainCharsetIso88591;
    }

    public String getImageJpeg() {
        return imageJpeg;
    }

    public void setImageJpeg(String imageJpeg) {
        this.imageJpeg = imageJpeg;
    }

    public String getTextPlain() {
        return textPlain;
    }

    public void setTextPlain(String textPlain) {
        this.textPlain = textPlain;
    }

    public String getTextHtmlCharsetUsAscii() {
        return textHtmlCharsetUsAscii;
    }

    public void setTextHtmlCharsetUsAscii(String textHtmlCharsetUsAscii) {
        this.textHtmlCharsetUsAscii = textHtmlCharsetUsAscii;
    }

    public String getTextHtml() {
        return textHtml;
    }

    public void setTextHtml(String textHtml) {
        this.textHtml = textHtml;
    }

    public String getTextRtf() {
        return textRtf;
    }

    public void setTextRtf(String textRtf) {
        this.textRtf = textRtf;
    }

    public String getTextHtmlCharsetIso88591() {
        return textHtmlCharsetIso88591;
    }

    public void setTextHtmlCharsetIso88591(String textHtmlCharsetIso88591) {
        this.textHtmlCharsetIso88591 = textHtmlCharsetIso88591;
    }

    public String getApplicationPrsTex() {
        return applicationPrsTex;
    }

    public void setApplicationPrsTex(String applicationPrsTex) {
        this.applicationPrsTex = applicationPrsTex;
    }

}
