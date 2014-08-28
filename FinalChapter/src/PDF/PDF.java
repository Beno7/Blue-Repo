package PDF;

import Logic.Office;
import Logic.Item;
import Logic.Transaction;
import Logic.OfficeTransaction;
import Implementation.PriceImpl;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDF {

    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.BLACK);
    private static Font text = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.NORMAL, BaseColor.BLACK);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 11,
            Font.BOLD);
    private static Font underlined = new Font(Font.FontFamily.TIMES_ROMAN, 10,
            Font.UNDERLINE, BaseColor.BLACK);
    private PriceImpl pI = new PriceImpl();

    public void addStockTransferReceipt(ArrayList<Item> b, Office o, OfficeTransaction ot, ArrayList<Double> prices, ArrayList<Integer> quantity)
            throws DocumentException {
        String FILE = "C:\\Users\\John Adriel\\Documents\\GitHub\\"+new Date()+ot.getTransactor()+ot.getInVoice()+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        Date date = new Date();
        PdfPTable table = new PdfPTable(2);
        PdfPTable table2 = new PdfPTable(1);
        PdfPTable table3 = new PdfPTable(2);
        PdfPTable table4 = new PdfPTable(6);
        Paragraph linespace = new Paragraph();
        addEmptyLine(linespace, 1);
        document.add(linespace);
        Paragraph paragraph = new Paragraph("Stock transfer Receipt", catFont);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
        document.add(linespace);
        Phrase phrase = new Phrase("Date", text);
        table.addCell(phrase);
        phrase = new Phrase("Stock\nTransfer No.", text);
        table.addCell(phrase);
        table.setWidthPercentage(33);
        table.setHorizontalAlignment(2);
        table.addCell(ot.getDateRecorded().toString());
        table.addCell(" ");
        table.setSpacingAfter(0);
        document.add(table);
        table2.addCell(new Phrase("Bill To", text));
        table2.addCell(new Phrase("Company name: " + o.getName() + "\nCompany Address: " + o.getAddress() + "\n \n \n \n", text));
        table2.setWidthPercentage(37);
        table2.setHorizontalAlignment(0);
        document.add(table2);
        table3.addCell(new Phrase("Reo", text));
        table3.addCell(new Phrase("Terms", text));
        table3.addCell(" ");
        table3.addCell(Integer.toString(ot.getTerms()));
        table3.setWidthPercentage(20);
        table3.setHorizontalAlignment(2);
        document.add(table3);
        PdfPCell c1 = new PdfPCell(new Phrase("Item", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table4.addCell(c1);
        c1 = new PdfPCell(new Phrase("Count", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c1);
        c1 = new PdfPCell(new Phrase("Unit", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c1);
        c1 = new PdfPCell(new Phrase("Description", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c1);
        c1 = new PdfPCell(new Phrase("Unit price", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c1);
        c1 = new PdfPCell(new Phrase("Total", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table4.addCell(c1);
        for (int i = 0; i < b.size(); i++) {
            table4.addCell(b.get(i).getName()+" "+b.get(i).getBrandName());
            table4.addCell(quantity.get(i).toString());
            table4.addCell(b.get(i).getUnit());
            table4.addCell(" ");
            table4.addCell(prices.get(i).toString());
            Double total = (quantity.get(i)*prices.get(i));
            table4.addCell(total.toString());
        }
        c1 = new PdfPCell(new Phrase("Receive items in good order and condition by:", text));
        c1.setColspan(4);
        table4.addCell(c1);
        c1 = new PdfPCell(new Phrase("Total:", text));
        c1.setColspan(2);
        table4.addCell(c1);
        table4.setHorizontalAlignment(0);
        table4.setWidthPercentage(100);
        document.add(linespace);
        document.add(table4);
        document.close();
    }

    public void addStatementsOfAccount(Office o, ArrayList<OfficeTransaction> ot) throws DocumentException {
        String FILE = "C:\\Users\\John Adriel\\Documents\\GitHub\\"+new Date()+o.getName()+ot.get(0).getInVoice()+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
        Paragraph linespace = new Paragraph();
        addEmptyLine(linespace, 1);
        document.add(linespace);
        PdfPTable table = new PdfPTable(4);
        Paragraph paragraph = new Paragraph("Statements of Account", catFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        document.add(linespace);
        paragraph = new Paragraph(o.getName(), catFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
        PdfPCell c1 = new PdfPCell(new Phrase("Invoice #", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Date", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Terms", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Amount", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        double total = 0.0;
        for (int i = 0; i < ot.size(); i++) {
            table.addCell(ot.get(i).getInVoice());
            table.addCell(ot.get(i).getDateRecorded().toString());
            table.addCell(Integer.toString(ot.get(i).getTerms()));
            table.addCell(Double.toString(ot.get(i).getTotal()));
            total += ot.get(i).getTotal();
        }
        c1 = new PdfPCell(new Phrase("Total: " + total, text));
        c1.setColspan(2);
        table.addCell(c1);
        table.setHorizontalAlignment(0);
        table.setWidthPercentage(100);
        document.add(linespace);
        document.add(table);
        document.close();
    }

    public void addPurchaseOrder(Office o, ArrayList<Item> b, ArrayList<Integer> quantity, ArrayList<Double> unitPrice) throws DocumentException {
        String FILE = "C:\\Users\\John Adriel\\Documents\\GitHub\\"+new Date()+o.getName()+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
        Paragraph linespace = new Paragraph();
        addEmptyLine(linespace, 1);
        document.add(linespace);
        Paragraph paragraph = new Paragraph("Purchase Order Form", catFont);
        document.add(paragraph);
        paragraph = new Paragraph("To: " + o.getName(), normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        paragraph = new Paragraph("Address: " + o.getAddress(), normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        PdfPTable table = new PdfPTable(5);
        PdfPCell c1 = new PdfPCell(new Phrase("Quantity", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Unit", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Description", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Unit Price", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Amount", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        for (int i = 0; i < b.size(); i++) {
            table.addCell(Integer.toString(quantity.get(i)));
            table.addCell(b.get(i).getUnit());
            table.addCell(" ");
            table.addCell(Double.toString(unitPrice.get(i)));
            table.addCell(Double.toString(quantity.get(i) * unitPrice.get(i)));
        }
        table.setHorizontalAlignment(0);
        table.setWidthPercentage(100);
        document.add(linespace);
        document.add(table);
        document.close();

    }

    public void addDeliveryReceipt(ArrayList<Item> b, Office o, int terms, ArrayList<Integer> quantity) throws DocumentException {
        String FILE = "C:\\Users\\John Adriel\\Documents\\GitHub\\"+new Date()+o.getName()+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
        Paragraph linespace = new Paragraph();
        addEmptyLine(linespace, 1);
        document.add(linespace);
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        Date date = new Date();
        Paragraph paragraph = new Paragraph("Delivery Receipt", catFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        paragraph = new Paragraph("D.R. NO.:", normalFont);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
        PdfPTable table = new PdfPTable(3);
        PdfPCell c1 = new PdfPCell(new Phrase("SOLD TO:   \nTIN NO.:    \nADDRESS: " + o.getAddress() + "\nTEL. NO.: " + o.getContact() + "P.O.NO.:    \n\n\n", text));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setExtraParagraphSpace(5);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("SALESMAN: \nD.R. NO.:\n\n\n\n\n"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("DATE: " + dateFormat.format(date) + "\nTerms: " + terms + "\nENC BY:\n\n\n\n"));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("QUANTITY", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("UNIT", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("ARTICLES", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        for (int i = 0; i < b.size(); i++) {
            table.addCell(Integer.toString(quantity.get(i)));
            table.addCell(b.get(i).getUnit());
            table.addCell(" ");
        }

        document.add(linespace);
        table.setHorizontalAlignment(0);
        table.setWidthPercentage(100);
        document.add(table);
        paragraph = new Paragraph("APPROVED BY: \t\tRECEIVED ABOVE MERCHANDISE IN GOOD ORDER AND CONDITION", normalFont);
        document.add(paragraph);
        paragraph = new Paragraph("________________\t\t______________", normalFont);
        document.add(paragraph);
        paragraph = new Paragraph("CASHIER/AUTHORIZED REPRESENTATIVE");
        document.add(paragraph);
        paragraph = new Paragraph("CHECKED BY: \t\tGUARD ON DUTY:\t TRUCK DRIVER:\t PLATE NO.:");
        document.add(paragraph);
        paragraph = new Paragraph("___________ \t\t______________\t______________\t __________");
        document.add(paragraph);
        document.close();

    }

    public void addOfficeReceipt(OfficeTransaction ot, ArrayList<Item> b, ArrayList<Integer> quantity, ArrayList<Double> price) throws DocumentException {
        String FILE = "C:\\Users\\John Adriel\\Documents\\GitHub\\"+new Date()+ot.getTransactor()+ot.getInVoice()+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
        Paragraph linespace = new Paragraph();
        addEmptyLine(linespace, 1);
        document.add(linespace);
        Paragraph paragraph = new Paragraph("Receipt", catFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        document.add(linespace);
        paragraph = new Paragraph("Office", catFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        paragraph = new Paragraph("Invoice No.: " + ot.getInVoice() + "\t\t\tDate Paid: " + ot.getDateRecorded(), normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        paragraph = new Paragraph("Terms: " + ot.getTerms() + "\t\t\tDate Delivered: " + ot.getDateOfDelivery());
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        PdfPTable table = new PdfPTable(5);
        PdfPCell c1 = new PdfPCell(new Phrase("Name", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Brand", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Quantity per Bundle", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Unit", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Price", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Amount", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        for (int i = 0; i < b.size(); i++) {
            table.addCell(b.get(i).getName());
            table.addCell(b.get(i).getBrandName());
            table.addCell(quantity.get(i).toString());
            table.addCell(b.get(i).getUnit());
            table.addCell(price.get(i).toString());
            table.addCell(Double.toString(price.get(i) * (quantity.get(i).doubleValue())));
        }
        c1 = new PdfPCell(new Phrase("\t\t\tTotal:"+Double.toString(ot.getTotal()), text));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setColspan(6);
        table.addCell(c1);
        table.setHorizontalAlignment(0);
        table.setWidthPercentage(100);
        document.add(table);
        document.close();

    }

    public void addWalkInReceipt(Transaction wt, ArrayList<Item> b, ArrayList<Integer> quantity, ArrayList<Double> price) throws DocumentException {
        String FILE = "C:\\Users\\John Adriel\\Documents\\GitHub\\SJT_Tirados_WalkInTransactions-"+new Date()+".pdf";
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
        Paragraph linespace = new Paragraph();
        addEmptyLine(linespace, 1);
        document.add(linespace);

        Paragraph paragraph = new Paragraph("Receipt", catFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        document.add(linespace);
        paragraph = new Paragraph("Office", catFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        paragraph = new Paragraph("Invoice No.: " + wt.getInVoice() + "\t\t\tDate Paid: " + wt.getDateRecorded(), normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        paragraph = new Paragraph("\t\t\t\tDate Delivered: " + wt.getDateRecorded(), normalFont);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        document.add(paragraph);
        PdfPTable table = new PdfPTable(5);
        PdfPCell c1 = new PdfPCell(new Phrase("Name", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Brand", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Quantity per Bundle", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Price", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("Amount", text));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        for (int i = 0; i < b.size(); i++) {
            table.addCell(b.get(i).getName());
            table.addCell(b.get(i).getBrandName());
            table.addCell(quantity.get(i).toString());
            table.addCell(price.get(i).toString());
            table.addCell(Double.toString(price.get(i) * (quantity.get(i).doubleValue())));
        }

        c1 = new PdfPCell(new Phrase(Double.toString(wt.getTotal()), text));
        c1.setHorizontalAlignment(Element.ALIGN_LEFT);
        c1.setColspan(5);
        table.addCell(c1);
        table.setHorizontalAlignment(0);
        table.setWidthPercentage(100);
        document.add(table);
        document.close();

    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

}
