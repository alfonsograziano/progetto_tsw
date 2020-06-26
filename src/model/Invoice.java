package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;

import model.bean.Contains;
import model.bean.Order;
import model.bean.User;

public class Invoice {
	private Order o;
	private User user;
	private String pathIn;
	private String pathOut;
	private ArrayList<Contains> contains;
	private DecimalFormat df;
	
	public Invoice(Order o, User u, String pathIn, String pathOut) {
		this.o = o;
		this.user = u;
		this.pathIn = pathIn;
		this.pathOut = pathOut;
		df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
	}
	
	public void print() {
		try {
			File f = new File(pathOut);
			f.createNewFile();
			PdfDocument pdfDoc =
				    new PdfDocument(new PdfReader(pathIn), new PdfWriter(pathOut));
			PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(44, 620)
			        .showText(user.getName()+" "+user.getSurname()+", "+o.getAddress()+", "+o.getCity()+" "+o.getZipCode()+", "+o.getState())
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(44, 474)
			        .showText(String.valueOf(o.getId()))
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(44, 424)
			        .showText(o.getDate().toString())
			        .endText();
			double total=0;
			double iva=0;
			for(int i=0; i<o.getProducts().size(); i++) {
				canvas.beginText().setFontAndSize(
				        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
				        .moveText(184, (495-(i*25)))
				        .showText(o.getProducts().get(i).getProduct().getName())
				        .endText();
				canvas.beginText().setFontAndSize(
				        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
				        .moveText(394, (495-(i*25)))
				        .showText(String.valueOf(o.getProducts().get(i).getProduct().getPrice()))
				        .endText();
				canvas.beginText().setFontAndSize(
				        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
				        .moveText(470, (495-(i*25)))
				        .showText(String.valueOf(o.getProducts().get(i).getQuantity()))
				        .endText();
				canvas.beginText().setFontAndSize(
				        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
				        .moveText(528, (495-(i*25)))
				        .showText(String.valueOf(o.getProducts().get(i).getProduct().getPrice()*o.getProducts().get(i).getQuantity()))
				        .endText();
				total = total + o.getProducts().get(i).getProduct().getPrice()*o.getProducts().get(i).getQuantity();
				iva = iva + ((o.getProducts().get(i).getProduct().getPrice()*o.getProducts().get(i).getProduct().getIva())/100)*o.getProducts().get(i).getQuantity();
			}
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(523, 277)
			        .showText(String.valueOf(df.format(total)))
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(523, 262)
			        .showText("0")
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
			        .moveText(523, 222)
			        .showText(String.valueOf(df.format(iva)))
			        .endText();
			canvas.beginText().setFontAndSize(
			        PdfFontFactory.createFont(FontConstants.HELVETICA), 20)
			        .moveText(465, 147)
			        .showText(String.valueOf(df.format(total+iva)))
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
	public void deleteInvoice() {
		File f = new File(pathOut);
		f.delete();
	}
}
