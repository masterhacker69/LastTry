import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import static jdk.nashorn.tools.ShellFunctions.input;


public class FileRead {

        private ArrayList<Film> liste = new ArrayList();

        public static void main(String[] args) {
            new FileRead();
        }


        public FileRead() {
            String zeile = null;

            try {
                BufferedReader in = new BufferedReader(new FileReader("filmlist.txt"));

                while(in.ready()) {
                    if ((zeile = in.readLine()) != null) {
                        System.out.println(zeile);
                        this.importToList(zeile);
                    }
                }
            } catch (FileNotFoundException var4) {
                var4.printStackTrace();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            Iterator var3 = this.liste.iterator();

            while(var3.hasNext()) {
                Film f = (Film)var3.next();
                System.out.println("Titel: " + f.titel + "Kino: " + f.kino + "Datum: " + f.date + "Uhrzeit: " + f.time);
            }

        }

        private void importToList(String zeile) {
            String[] filmAttribute = zeile.split(";");
            Film neuerFilm = new Film();
            neuerFilm.titel = filmAttribute[0];
            neuerFilm.kino = filmAttribute[1];
            neuerFilm.date = filmAttribute[2];
            neuerFilm.time = filmAttribute[3];
            this.liste.add(neuerFilm);
            anzeige();
        }

        public static String input(String ausgabe)
    {
        System.out.println(ausgabe);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (Exception e) {
            return "";
        }
    }

        public void anzeige() {
        String eingabe;
        eingabe = input("Geben Sie ihre Suche ein");

        ArrayList<Film> founds = new ArrayList<Film>();
        for (Film f : liste) {
            if (f.titel == "Star Wars") {
                founds.add(f);
                System.out.println(founds);
            }
        }
        }
    }

