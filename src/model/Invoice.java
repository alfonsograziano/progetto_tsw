package model;

import model.bean.Order;
import model.bean.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

public class Invoice {
	public Order o;
	public User user;
	public Invoice(Order o, User u) {
		this.o = o;
		this.user = u;
	}
	
	public void print() {
		try {
			PdfDocument pdfDoc =
				    new PdfDocument(new PdfReader(""), new PdfWriter("prova"));
			PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(59, 857)
			        .showText(user.getName()+" "+user.getSurname()+"\n"+o.getAddress()+"\n"+o.getCity()+" "+o.getZipCode()+" "+o.getState())
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(59, 654)
			        .showText(String.valueOf(o.getId()))
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(59, 579)
			        .showText(o.getDate().toString())
			        .endText();
			double total=0;
			for(int i=0; i<o.getProducts().size(); i++) {
				canvas.beginText().setFontAndSize(
				        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
				        .moveText(246, (686-(i*38)))
				        .showText(o.getProducts().get(i).getProduct().getName())
				        .endText();
				canvas.beginText().setFontAndSize(
				        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
				        .moveText(534, (686-(i*38)))
				        .showText(String.valueOf(o.getProducts().get(i).getProduct().getPrice()))
				        .endText();
				canvas.beginText().setFontAndSize(
				        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
				        .moveText(641, (686-(i*38)))
				        .showText(String.valueOf(o.getProducts().get(i).getQuantity()))
				        .endText();
				canvas.beginText().setFontAndSize(
				        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
				        .moveText(246, (686-(i*38)))
				        .showText(String.valueOf(o.getProducts().get(i).getProduct().getPrice()*o.getProducts().get(i).getQuantity()))
				        .endText();
				total = total + o.getProducts().get(i).getProduct().getPrice()*o.getProducts().get(i).getQuantity();
			}
			double subTotal = (total*78)/100;
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(738, 387)
			        .showText(String.valueOf(subTotal))
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(738, 362)
			        .showText("0")
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(738, 312)
			        .showText(String.valueOf(total-subTotal))
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 20)
			        .moveText(638, 207)
			        .showText(String.valueOf(total))
			        .endText();
			pdfDoc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
