/**
 * @author Michal Dettlaff
 * @version 1.8
 */

/*
<applet width="700" height="380"
	code="TypingTest.class"
	archive="TypingTest.jar">
  <param name="txtSourceDir" value="txt">
  <param name="autoGeneratedText" value="true">
  <param name="autoGenTextSizeInLines" value="12">
</applet>
*/

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.jar.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;

/**
 * Test szybkosci pisania.
 */
public class TypingTest extends Applet
    implements KeyListener, MouseListener {

  static final int FONT_SIZE=16;
  final int X_MAR=25;
  final int Y_MAR=25;
  final int LINE_HEIGHT=18;
  final int MAX_LINES=9; // ile pelnych wierszy sie zmiesci na ekranie
  Graphics buffer; // grafike bedziemy rysowac w buforze, zeby nie migalo
  Image bufferImage; // pojedyncza klatka, do ktorej wrzucamy gotowy bufor
  static String txtDir; // katalog z plikami do przepisywania
  static boolean autoGeneratedText;
  static int autoGeneratedTextSizeInLines;
  static int maxCharsInLine;
  String currentTxtFile;
  int width, height; // rozmiary apletu
  boolean showPolishChars;
  boolean showResults;
  boolean isTimerOn;
  boolean showWelcome;
  long timeStarted;
  long timeFinished;
  int charsTyped;
  int mistakesCount;
  Text text;
  Text typedText;
  Text mistakes;
  Font font;
  Font fontBig;
  Font fontSmall;

  public void init() {
    showPolishChars=true;
    isTimerOn=false;
    showResults=false;
    showWelcome=true;
    charsTyped=0;
    mistakesCount=0;
    maxCharsInLine=65;
    txtDir = getParameter("txtSourceDir");
    if (getParameter("autoGeneratedText").equals("true")) {
      autoGeneratedText = true;
    }
    autoGeneratedTextSizeInLines = Integer.parseInt(
	getParameter("autoGenTextSizeInLines"));
    loadNewTextToType(txtDir);

    width=getWidth();
    height=getHeight();
    setBackground(Color.WHITE);
    setForeground(Color.BLACK);
    font = new Font("Monospaced", Font.PLAIN, FONT_SIZE);
    fontBig = new Font("Serif", Font.PLAIN, 18);
    fontSmall = new Font("Serif", Font.PLAIN, 16);
    bufferImage = createImage(width, height);
    buffer = bufferImage.getGraphics();
    paintBuffer();

    addKeyListener(this);
    addMouseListener(this);
  }

  public void destroy() {
    removeKeyListener(this);
    removeMouseListener(this);
  }

  public void paint(Graphics g) {
    update(g);
  }

  void paintBuffer() {
    drawInBuffer();
    repaint();
  }

  public void update(Graphics g) {
    g.drawImage(bufferImage, 0, 0, this);
    getToolkit().sync(); // ponoc polepsza wyglad w niektorych systemach
  }

  void drawInBuffer() {
    buffer.clearRect(0, 0, width, height);

    if (showWelcome) {
      buffer.setColor(Color.BLACK);
      buffer.setFont(fontBig);
      buffer.drawString("Test predkosci pisania", width/2-90, height/2-100);
      buffer.setFont(fontSmall);
      buffer.drawString("Po przepisaniu kazdej linii nacisnij ENTER",
		           width/2-137, height/2-40);
      buffer.drawString("Czas zacznie byc mierzony, kiedy zaczniesz pisac",
		           width/2-158, height/2-15);
      buffer.drawString("F2 wylacza/wlacza polskie znaki",
		           width/2-108, height/2+10);
      buffer.setFont(fontBig);
      buffer.drawString("Kliknij, aby rozpoczac", width/2-90, height/2+50);
      buffer.setColor(Color.BLUE);
      buffer.drawString("autor: Michal Dettlaff", width/2-88, height/2+112);
      buffer.setColor(Color.BLACK);

    } else {

      buffer.setFont(font);
      int scrollLines=0; // o ile przesunac tekst w gore
      if (typedText.size() > MAX_LINES) {
	scrollLines=typedText.size() - MAX_LINES;
      }

      if (showResults) {
	long typingTime = timeFinished - timeStarted; // w milisekundach
	double tt = ((double) typingTime) / 1000;
	double ct = charsTyped;
	double speed = 60 * ct / tt;
	long typingTimeS = typingTime / 1000; // w sekundach
	int minutes = (int) typingTimeS / 60;
	int seconds = (int) typingTimeS % 60;
	if (minutes > 0) {
	buffer.drawString("Wynik: " + String.format("%.1f", speed) +
	  " znak�w/min, " + mistakesCount + " bled�w (" + charsTyped +
	    " znak�w w " + minutes + " min " + seconds + " s)",
	      X_MAR, Y_MAR+((typedText.size()-scrollLines)*2-1)*LINE_HEIGHT);
	} else {
	buffer.drawString("Wynik: " + String.format("%.1f", speed) +
	  " znak�w/min, " + mistakesCount + " bled�w (" + charsTyped +
	    " znak�w w " + seconds + " sekund)",
	      X_MAR, Y_MAR+((typedText.size()-scrollLines)*2-1)*LINE_HEIGHT);
	}
	buffer.drawString("Nacisnij ENTER, aby rozpoczac kolejny test",
	  X_MAR, Y_MAR+(typedText.size()-scrollLines)*2*LINE_HEIGHT);
      }

      buffer.setColor(Color.BLUE);
      for (int i=scrollLines; i < typedText.size()
				  && i < (scrollLines+MAX_LINES); i++) {
	buffer.drawString(typedText.get(i), X_MAR, Y_MAR+(2*(i-scrollLines)+1)*
								LINE_HEIGHT);
      }
      buffer.setColor(Color.BLACK);

      for (int j=scrollLines; j < text.size()
				  && j < (scrollLines+MAX_LINES+1); j++) {
	buffer.drawString(text.get(j), X_MAR, Y_MAR+2*(j-scrollLines)*
								LINE_HEIGHT);
      }

      buffer.setColor(Color.RED);
      for (int k=scrollLines; k < mistakes.size()
				  && k < (scrollLines+MAX_LINES); k++) {
	buffer.drawString(mistakes.get(k), X_MAR, Y_MAR+(2*(k-scrollLines)+1)*
								LINE_HEIGHT);
      }
      buffer.setColor(Color.BLACK);
    }
    buffer.drawRect(0, 0, width-1, height-1);
  }

  public void mouseClicked(MouseEvent e) {
    showWelcome=false;
    paintBuffer();
    e.consume();
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void keyReleased(KeyEvent e) {
  }

  public void keyPressed(KeyEvent e) {
    int ch=e.getKeyCode();

    if (ch == KeyEvent.VK_F2) {
      if (!isTimerOn && !showResults) { // widac tekst, ale jeszcze nie piszemy
	if (showPolishChars) {
	  text.removePolishChars();
	} else {
	  text = new Text();
	  read(text, currentTxtFile);
	  text.breakLines(maxCharsInLine);
	}
	paintBuffer();
      }
      showPolishChars=!showPolishChars;
    }
    e.consume();
  }

  public void keyTyped(KeyEvent e) {
    char ch=e.getKeyChar();

    if (!showResults && !showWelcome) {
      if (ch == KeyEvent.VK_BACK_SPACE) {
	if (typedText.getLast().length() > 0) { // inaczej RuntimeException
	  String s = typedText.getLast();
	  s = s.substring(0, s.length()-1);
	  typedText.setLast(s);
	  charsTyped--;
	  // wymazujemy tez z tablicy przechowujacej pomylki
	  s = mistakes.getLast();
	  if (s.charAt(s.length()-1) != ' ') {
	    mistakesCount--;
	  }
	  s = s.substring(0, s.length()-1);
	  mistakes.setLast(s);
	}
      } else if (ch == KeyEvent.VK_ENTER) {
	if (charsTyped > 0) {
	  // sprawdza, czy nie wpisalismy za krotkiej linii, bo to blad
	  // jesli tak, to dodajemy podkreslenie az do konca linii
	  if (typedText.getLast().length() < text.get(
				     typedText.size()-1).length()) {
	    String underline = "";
	    int gapSize=text.get(typedText.size()-1).length()
				- typedText.getLast().length();
	    for (int i=0; i < gapSize; i++) {
	      underline += '_';
	      mistakesCount++;
	    }
	    mistakes.setLast(mistakes.getLast().concat(underline));
	  }
	  mistakes.add(""); // nowa linia do zapamietywania bledow
	  typedText.add("");
	  charsTyped++; // ENTER to tez znak
	  if (typedText.size() > text.size()) { // jesli to byla ostatnia linia
	    charsTyped--; // ostatniego entera nie liczymy
	    timeFinished=(new Date()).getTime();
	    showResults=true;
	    isTimerOn=false;
	  }
	}
      } else {
	if (!isTimerOn) {
	  timeStarted=(new Date()).getTime();
	  isTimerOn=true;
	}
	String s = typedText.getLast();
        s += ch;
	typedText.setLast(s);
	charsTyped++;
	// jesli jest blad, zapisujemy go w tablicy mistakes
	s = text.get(typedText.size()-1);
	if (typedText.getLast().length() > s.length() // przekroczona linia
	    || ch != s.charAt(typedText.getLast().length()-1)) {
	  s = mistakes.getLast();
	  s += '_';
	  mistakes.setLast(s);
	  mistakesCount++;
	} else {
	  s = mistakes.getLast();
	  s += ' ';
	  mistakes.setLast(s);
	}
      }
      paintBuffer();
    } else if (!showWelcome) {
      if (ch == KeyEvent.VK_ENTER) { // restart, nowy tekst
	showResults=false;
	charsTyped=0;
	loadNewTextToType(txtDir);
        paintBuffer();
      }
    } else {
      showWelcome=false;
      paintBuffer();
    }
    e.consume();
  }

  /**
   * Wczytuje nowy losowo wybrany plik tekstowy z danego katalogu,
   * lub tekst wygenerowany na podstawie plikow tekstowych z danego katalogu.
   */
  void loadNewTextToType(String directory) {
    File[] files = new File(directory).listFiles(new TextfileFilter());
    Random rand = new Random(new Date().getTime());

    text = new Text();

    try {
      if (autoGeneratedText) {
	List<String> corpus = new ArrayList<String>();
	for (File file : files) {
	  for (String line : readFileAsString(file).replaceAll(" +", " ").
	      replace(")", "").replace("(", "").replace("\"", "").
	      trim().split("\n")) {
	    for (String word : line.split(" ")) {
	      corpus.add(word.trim());
	    }
	  }
	}
	int minGenTextLength = (autoGeneratedTextSizeInLines-1)*maxCharsInLine;
	currentTxtFile = generateMarkovChain(corpus, minGenTextLength);
      } else {
	currentTxtFile = readFileAsString(files[rand.nextInt(files.length)]);
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
    read(text, currentTxtFile);
    text.breakLines(maxCharsInLine);

    if (!showPolishChars) {
      text.removePolishChars();
    }

    typedText = new Text();
    typedText.add("");
    mistakesCount=0;
    mistakes = new Text();
    mistakes.add("");
  }

  /**
   * Generuje automatycznie tekst na podstawie podanej listy sl�w.
   * Wygenerowany tekst jest tworzony przy pomocy lancucha Markowa.
   *
   * @param  corpus     Tekst jako ciag sl�w, na podstawie kt�rego generowany
   *                    jest lancuch Markowa.
   * @param  minTextLen Minimalna dlugosc (w znakach) tekstu do wygenerowania.
   * @return            Wygenerowany za pomoca lancucha Markowa tekst.
   */
  public String generateMarkovChain(List<String> corpus, int minTextLen)
  {
    List<String> markovChain = new LinkedList<String>();
    String markovText = new String(); // tekst, kt�ry zwr�ci metoda
    Random rand = new Random(new Date().getTime());

    // zaczynamy od slowa z poczatku zdania
    List<String> firstWords = new LinkedList<String>(); // poczatki zdan
    for (int i=0; i < corpus.size()-1; i++) {
      if (corpus.get(i).endsWith(".")) {
	firstWords.add(corpus.get(i+1));
      }
    }
    markovChain.add(firstWords.get(rand.nextInt(firstWords.size())));
    markovText += markovChain.get(0) + " ";

    while (!(markovText.length() > minTextLen && markovText.endsWith(". "))) {
      // slowa wystepujace w danym tekscie zaraz po ostatnim slowie z lancucha
      List<String> words = new LinkedList<String>();
      // slowa wystepujace w danym tekscie zaraz po dw�ch ostatnich slowach
      // z lancucha
      List<String> doubleWords = new LinkedList<String>();
      for (int i=0; i < corpus.size()-1; i++) {
	if (corpus.get(i).equals(markovChain.get(markovChain.size()-1))) {
	  words.add(corpus.get(i+1));
	  if (i > 0 && markovChain.size() > 1 && corpus.get(i-1).
	      equals(markovChain.get(markovChain.size()-2))) {
	    doubleWords.add(corpus.get(i+1));
	  }
	}
      }
      if (doubleWords.size() > 1) {
	markovChain.add(doubleWords.get(rand.nextInt(doubleWords.size())));
      } else if (words.size() > 0) {
	markovChain.add(words.get(rand.nextInt(words.size())));
      } else {
	markovChain.add(firstWords.get(rand.nextInt(firstWords.size())));
      }
      markovText += markovChain.get(markovChain.size()-1) + " ";
    }

    return markovText.trim();
  }

  /**
   * Czyta tresc pliku i zwraca ja jako napis.
   *
   * @param file Plik kt�ry chcemy odczytac.
   * @return     Zawartosc pliku jako napis.
   */
  public static String readFileAsString(File file)
      throws IOException {
    StringBuffer fileData = new StringBuffer(1000);
    BufferedReader reader = new BufferedReader(
	new FileReader(file));
    char[] buf = new char[1024];
    int numRead=0;
    while((numRead = reader.read(buf)) != -1){
      fileData.append(buf, 0, numRead);
    }
    reader.close();
    return fileData.toString();
  }

  /** Wczytuje kolejne linie z podanego napisu do tablicy lines */
  public void read(Text text, String str) {
    for (String line : str.split("\n")) {
      text.add(line);
    }
  }

  public String getAppletInfo() {
    return "Test predkosci pisania. Uzywa plik�w tekstowych z katalogu okreslonego parametrem.";
  }
}

/**
 * Tekst w postaci kolejnych linii umieszczonych w tablicy ArrayList
 */
class Text extends ArrayList<String> {

  public void removePolishChars() {
    for (int i=0; i < size(); i++) {
      set(i, get(i).replace('a', 'a'));
      set(i, get(i).replace('c', 'c'));
      set(i, get(i).replace('e', 'e'));
      set(i, get(i).replace('l', 'l'));
      set(i, get(i).replace('n', 'n'));
      set(i, get(i).replace('�', 'o'));
      set(i, get(i).replace('s', 's'));
      set(i, get(i).replace('z', 'z'));
      set(i, get(i).replace('z', 'z'));

      set(i, get(i).replace('A', 'A'));
      set(i, get(i).replace('C', 'C'));
      set(i, get(i).replace('E', 'E'));
      set(i, get(i).replace('L', 'L'));
      set(i, get(i).replace('N', 'N'));
      set(i, get(i).replace('�', 'O'));
      set(i, get(i).replace('S', 'S'));
      set(i, get(i).replace('Z', 'Z'));
      set(i, get(i).replace('Z', 'Z'));
    }
  }

  public void breakLines(int lineLength) {
    int eolIndex=0;
    for (int i=0; i < size(); i++) {
      for (int j=1; j < get(i).length() && j <= lineLength; j++) {
	if (get(i).charAt(j) == ' ' || get(i).charAt(j) == '\t') {
	  eolIndex=j;
	}
	if (j == lineLength) { // lamiemy linie
	  add(i+1, get(i).substring(eolIndex+1));
	  set(i, get(i).substring(0, eolIndex));
	}
      }
    }
  }

  /** Dlaczego takiej metody nie ma w bibliotece standardowej? */
  public String getLast() {
    return get(size()-1);
  }

  public void setLast(String s) {
    set(size()-1, s);
  }
}
