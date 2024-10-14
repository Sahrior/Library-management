import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LIBRARY {

    static ArrayList<Book> books=new ArrayList<>();
    private static final String FILE_NAME="Books.dot";

    public static void main(String[] args) {
        loadBooks();
        if (books.isEmpty()) {
            PlusBook();
        }
        JFrame frame=new JFrame("Library Management with Sahrior");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel label=new JLabel("Kindly Make A Selection");
        label.setBounds(70,40,250,30);
        label.setFont(new Font("Arial",Font.CENTER_BASELINE,21));
        frame.add(label);
        frame.getContentPane().setBackground(Color.decode("#D8E2DC"));

        JButton b1=new JButton("ADD BOOK");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.decode("#CDC2B6"));
        b1.setBounds(110,90,180,30);
        frame.add(b1);

        JButton viewBooksButton = new JButton("VIEW BOOK");
        viewBooksButton.setForeground(Color.BLACK);
        viewBooksButton.setBackground(Color.decode("#CDC2B6"));
        viewBooksButton.setBounds(110, 130, 180, 30);
        frame.add(viewBooksButton);

        JButton b2=new JButton("SEARCH BOOK");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.decode("#CDC2B6"));
        b2.setBounds(110,170,180,30);
        frame.add(b2);

        JButton b3=new JButton("BORROWING/RETURNING");
        b3.setForeground(Color.black);
        b3.setBackground(Color.decode("#CDC2B6"));
        b3.setBounds(110,210,180,30);
        frame.add(b3);

        JButton b4=new JButton("EXIT");
        b4.setForeground(Color.black);
        b4.setBackground(Color.decode("#CDC2B6"));
        b4.setBounds(110,250,180,30);
        frame.add(b4);
        loadBooks();

        ActionListener ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command=e.getActionCommand();
                if(command.equals("ADD BOOK"))
                {
                    addBook();
                }
                else if(command.equals("VIEW BOOK"))
                {
                    viewBooks();
                }
                else if (command.equals("SEARCH BOOK")) {
                    library();

                }
                else if (command.equals("BORROWING/RETURNING")) {
                    BorrowingBook();

                }
                else if (command.equals("EXIT")) {
                    saveBooks();
                    System.exit(0);
                }

            }
        } ;
        b1.addActionListener(ac);
        b2.addActionListener(ac);
        b3.addActionListener(ac);
        b4.addActionListener(ac);
        viewBooksButton.addActionListener(ac);

        frame.setVisible(true);



    }
    private static void library()
    {
        //  PlusBook();

        JFrame frame=new JFrame("SEARCH! SEARCH!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,300);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(Color.decode("#F2EBDC"));
        frame.setLayout(null);

        JTextField textField=new JTextField();

        textField.setBounds(60,20,170,30);

        textField.setBackground(Color.decode("#F1F1F1"));

        frame.add(textField);

        JButton b=new JButton("SEARCH");
        b.setForeground(Color.BLACK);
        b.setBounds(95,60,100,30);
        b.setBackground(Color.decode("#F1F1F1"));
        frame.add(b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title=textField.getText().trim();
                if(title.isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"Please fill out the required field");
                }
                else {
                    SEARCHBOOK(title);
                }

            }
        });
        frame.setVisible(true);
    }
    private static void SEARCHBOOK(String Title)
    {
        boolean found=false;
        for(Book b:books) {
            if (b.Title.equalsIgnoreCase(Title)) {
                JOptionPane.showMessageDialog(null, b.getDetails(), "Book Details", JOptionPane.INFORMATION_MESSAGE);
                found = true;
                break;
            }
        }
        if(!found) {
            JOptionPane.showMessageDialog(null,"Sorry! Book not found!");

        }

    }


    private static void PlusBook()
    {

        books.add(new Book("Rasha","M.D Jafar Iqbal","Fiction","A",1,5,5));
        books.add(new Book("The Al-Chemist","Paulo Coelho","Philosophic","A",1,4,4));

    }
    private static void ReturnBook(String name) {


        boolean found = false;
        String searchTitle = name.trim().toLowerCase();


        for (Book b : books) {


            String bookTitle = b.Title.trim().toLowerCase();

            if (bookTitle.equalsIgnoreCase(searchTitle)) {
                found = true;

                if (b.AvailableCopy < b.TotalCopy) {
                    b.AvailableCopy++;


                    JOptionPane.showMessageDialog(null, "You have Returned the book: " + b.Title + "\n Available copies after returning: \n" + b.AvailableCopy, "RETURNED book", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    JOptionPane.showMessageDialog(null, "Something went wrong");
                }

                break;
            }

        }


        if(!found)
        {
            JOptionPane.showMessageDialog(null,"Sorry Not Found!","Error",JOptionPane.WARNING_MESSAGE );

        }

    }
    private static void borrowBOOK(String Name)
    {
        boolean found=false;
        String searchTitle = Name.trim().toLowerCase();


        for(Book b:books) {

            String bookTitle = b.Title.trim().toLowerCase();

            if (bookTitle.equalsIgnoreCase(searchTitle))
            {
                found=true;
                if (b.AvailableCopy > 0) {
                    b.AvailableCopy--;

                    JOptionPane.showMessageDialog(null, "You have Borrowed the book: " + b.Title + "\n Available copies after Borrowing: " + b.AvailableCopy , "Borrowed book", JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Sorry! No copies available for borrowing");
                }
                break;

            }


        }

        if(!found)
        {
            JOptionPane.showMessageDialog(null,"Book Not Found!","Error",JOptionPane.WARNING_MESSAGE );


        }

    }



    private static void BorrowingBook()
    {


        JFrame frame=new JFrame("Borrow Book");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel label=new JLabel("Enter the name of the book you want");
        label.setBounds(40,20,250,30);
        frame.getContentPane().setBackground(Color.decode("#faf9f5"));
        frame.add(label);

        JTextField textField=new JTextField();
        textField.setBounds(60,60,170,30);
        frame.add(textField);

        JButton b=new JButton("BORROW");
        b.setForeground(Color.BLACK);
        b.setBounds(100,110,100,30);
        frame.add(b);

        JButton b2=new JButton("RETURN");
        b2.setForeground(Color.BLACK);
        b2.setBounds(100,150,100,30);
        frame.add(b2);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=textField.getText().trim();
                if(!str.isEmpty())
                {
                    borrowBOOK(str);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please required the field");
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str2=textField.getText().trim();
                if(!str2.isEmpty())
                {
                    ReturnBook(str2);                 }
            }
        });
        frame.setVisible(true);
    }
    private static void addBook() {
        JFrame addFrame = new JFrame("Add Book");
        addFrame.setSize(400, 400);
        addFrame.setLayout(null);
        addFrame.setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(20, 20, 100, 30);
        addFrame.getContentPane().setBackground(Color.decode("#F3F3F3"));
        addFrame.add(titleLabel);

        JTextField TitleField = new JTextField();
        TitleField.setBounds(120, 20, 150, 30);
        addFrame.add(TitleField);

        JLabel authorLabel = new JLabel("Author Name:");
        authorLabel.setBounds(20, 60, 100, 30);
        addFrame.add(authorLabel);

        JTextField AuthorField = new JTextField();
        AuthorField.setBounds(120, 60, 150, 30);
        addFrame.add(AuthorField);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(20, 100, 100, 30);
        addFrame.add(genreLabel);

        JTextField genreField = new JTextField();
        genreField.setBounds(120, 100, 150, 30);
        addFrame.add(genreField);

        JLabel Sectionlabel=new JLabel("Section");
        Sectionlabel.setBounds(20,140,100,30);
        addFrame.add(Sectionlabel);

        JTextField SectionTextField=new JTextField();
        SectionTextField.setBounds(120,140,150,30);
        addFrame.add(SectionTextField);

        JLabel FloorLabel=new JLabel("Floor:");
        FloorLabel.setBounds(20,180,100,30);
        addFrame.add(FloorLabel);

        JTextField FloorText=new JTextField();
        FloorText.setBounds(120,180,150,30);
        addFrame.add(FloorText);



        JLabel AvailLabel=new JLabel("Available Copy:");
        AvailLabel.setBounds(20,220,100,30);
        addFrame.add(AvailLabel);

        JTextField Availtext=new JTextField();
        Availtext.setBounds(120,220,150,30);
        addFrame.add(Availtext);



        JButton saveButton = new JButton("Save");
        saveButton.setBounds(130, 280, 120, 30);
        saveButton.setBackground(Color.decode("#F3F3F3"));
        addFrame.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Title = TitleField.getText();
                String author = AuthorField.getText();
                String Genre = genreField.getText();
                String Section=SectionTextField.getText();
                int Floor=Integer.parseInt(FloorText.getText());
                int Availablecopy=Integer.parseInt(Availtext.getText());
                int Totalcopy=Availablecopy;

                books.add(new Book(Title,author,Genre,Section,Floor,Availablecopy,Totalcopy));
                JOptionPane.showMessageDialog(null, "Book Added Successfully!");
                addFrame.dispose();
            }
        });

        addFrame.setVisible(true);
    }
    private static void viewBooks() {

        JFrame viewFrame = new JFrame("Books List");
        viewFrame.setSize(600, 400);
        viewFrame.setLayout(new BorderLayout());
        viewFrame.setLocationRelativeTo(null);


        String[] columnNames = { "Title", "Author", "Genre", "Section", "Floor", "Available Copies" };

        String[][] data = new String[books.size()][6];

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            data[i][0] = book.Title;
            data[i][1] = book.Author;
            data[i][2] = book.Genre;
            data[i][3] = book.Section;
            data[i][4] = String.valueOf(book.Floor);
            data[i][5] = String.valueOf(book.AvailableCopy);
        }


        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        viewFrame.add(scrollPane, BorderLayout.CENTER);

        viewFrame.setVisible(true);
    }


    private static void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            books = (ArrayList<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            books = new ArrayList<>();
        }
    }


}

