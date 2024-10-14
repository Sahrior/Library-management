import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Book implements Serializable
{
    String Title;
    String Author;
    String Genre;
    String Section;
    int Floor;
    int AvailableCopy;
    int TotalCopy;

    Book(String Title,String Author,String Genre,String Section,int Floor,int AvailableCopy,int TotalCopy)
    {
        this.Title=Title;
        this.Author=Author;
        this.Genre=Genre;
        this.Section=Section;
        this.Floor=Floor;
        this.AvailableCopy=AvailableCopy;
        this.TotalCopy=TotalCopy;

    }
    public String getDetails()
    {

        return "<html>Title: " + Title + "<br>Author: " + Author + "<br>Genre: " + Genre  + "<br>Section:" +Section+ "<br>Floor:" +Floor+ "<br>Available copy:"+AvailableCopy+"</html>";
    }
}
