package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.IgracManager;
import ba.unsa.etf.rpr.business.MecManager;
import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.domain.Mec;
import ba.unsa.etf.rpr.exceptions.MojException;
import org.apache.commons.cli.*;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * Main class using Command Line Interface.
 */
public class MainCLI {
    private static final Option novaIgra = new Option("n", "nova-igra", false, "Započinje novu igru!");
    private static final Option statistika = new Option("s", "statistika", false, "Statistika igrača");
    private static final Option dodajIgrace = new Option("d", "dodaj-igrace", false, "Dodaj nove igrače u bazu");

    private static final int vel = 3;

    private static final char[][] matrica = new char[vel][vel];

    private static char trenutni = 'X';

    /**
     * Print formatted options.
     *
     * @param options the options
     */
    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar TicTacToe.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }

    /**
     * Add options options.
     *
     * @return the options
     */
    public static Options addOptions() {
        Options options = new Options();
        options.addOption(novaIgra);
        options.addOption(statistika);
        options.addOption(dodajIgrace);
        return options;
    }

    private static void postaviMatricu() {
        for (int i = 0; i < vel; i++) {
            for (int j = 0; j < vel; j++) {
                matrica[i][j] = '-';
            }
        }
    }

    private static void prikaziMatricu() {
        System.out.println("-------------");
        for (int i = 0; i < vel; i++) {
            System.out.print("| ");
            for (int j = 0; j < vel; j++) {
                System.out.print(matrica[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static boolean daLiJePuna() {
        for (int i = 0; i < vel; i++) {
            for (int j = 0; j < vel; j++) {
                if (matrica[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void red(Igrac igracX, Igrac igracO) {
        if (trenutni == 'X') System.out.println(igracX.getIme() + " je na redu:");
        if (trenutni == 'O') System.out.println(igracO.getIme() + " je na redu:");
        Scanner scanner = new Scanner(System.in);
        int row, col;
        do {
            System.out.print("Unesi broj reda (1-" + vel + "): ");
            row = scanner.nextInt() - 1;
            System.out.print("Unesi broj kolone (1-" + vel + "): ");
            col = scanner.nextInt() - 1;
        } while (row < 0 || col < 0 || row >= vel || col >= vel || matrica[row][col] != '-');
        matrica[row][col] = trenutni;
    }

    private static boolean provjeriPobjedu() {

        for (int i = 0; i < vel; i++) {
            if (matrica[i][0] == matrica[i][1] && matrica[i][1] == matrica[i][2] && matrica[i][0] != '-') {
                return true;
            }
        }

        for (int j = 0; j < vel; j++) {
            if (matrica[0][j] == matrica[1][j] && matrica[1][j] == matrica[2][j] && matrica[0][j] != '-') {
                return true;
            }
        }

        if (matrica[0][0] == matrica[1][1] && matrica[1][1] == matrica[2][2] && matrica[0][0] != '-') {
            return true;
        }
        if (matrica[2][0] == matrica[1][1] && matrica[1][1] == matrica[0][2] && matrica[2][0] != '-') {
            return true;
        }
        return false;
    }

    private static void zamjenaIgraca() {
        trenutni = trenutni == 'X' ? 'O' : 'X';
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception{
        Options options = addOptions();

        CommandLineParser commandLineParser = new DefaultParser();

        try {
            CommandLine cl = commandLineParser.parse(options, args);

            if (cl.hasOption(novaIgra.getOpt()) || cl.hasOption(novaIgra.getLongOpt())) {
                IgracManager igracManager = new IgracManager();
                MecManager mecManager = new MecManager();
                List<Igrac> igraci = igracManager.getAll();
                System.out.println("Izaberi prvog igrača!");
                for (int i = 0; i < igraci.size(); i++) {
                    System.out.println(i+1 + ". " + igraci.get(i).getIme());
                }
                int idX = Integer.parseInt(System.console().readLine());
                int idO;
                Igrac igracX = igracManager.getById(idX);
                do {
                    System.out.println("Izaberi drugog igrača!");
                    for (int i = 0; i < igraci.size(); i++) {
                        System.out.println(i+1 + ". " + igraci.get(i).getIme());
                    }
                    idO = Integer.parseInt(System.console().readLine());
                    if (idX == idO) System.out.println("Ne možete odabrati istog igrača!");
                }while (idX == idO);
                Igrac igracO = igracManager.getById(idO);
                postaviMatricu();
                prikaziMatricu();
                while (!daLiJePuna()) {
                    red(igracX, igracO);
                    prikaziMatricu();
                    if (provjeriPobjedu()) {
                        if (trenutni == 'X'){
                            System.out.println(igracX.getIme() + " je pobijedio!");
                            igracX.uvecajPobjedu();
                            igracO.uvecajPoraz();
                            Mec mec = new Mec();
                            mec.setIdX(igracX.getId());
                            mec.setIdO(igracO.getId());
                            mec.setIdTipa(1);
                            try {
                                igracManager.update(igracX);
                                igracManager.update(igracO);
                                mecManager.add(mec);
                            } catch (MojException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (trenutni == 'O'){
                            System.out.println(igracO.getIme() + " je pobijedio!");
                            igracX.uvecajPoraz();
                            igracO.uvecajPobjedu();
                            Mec mec = new Mec();
                            mec.setIdX(igracX.getId());
                            mec.setIdO(igracO.getId());
                            mec.setIdTipa(2);
                            try {
                                igracManager.update(igracX);
                                igracManager.update(igracO);
                                mecManager.add(mec);
                            } catch (MojException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        return;
                    }
                    zamjenaIgraca();
                }
                System.out.println("Neriješeno!");
                igracX.uvecajNerijesene();
                igracO.uvecajNerijesene();
                Mec mec = new Mec();
                mec.setIdX(igracX.getId());
                mec.setIdO(igracO.getId());
                mec.setIdTipa(3);
                try {
                    igracManager.update(igracX);
                    igracManager.update(igracO);
                    mecManager.add(mec);
                } catch (MojException e) {
                    throw new RuntimeException(e);
                }

            } else if (cl.hasOption(statistika.getOpt()) || cl.hasOption(statistika.getLongOpt())) {
                IgracManager igracManager = new IgracManager();
                List<Igrac> igraci = igracManager.getAll();
                System.out.println("Statistika igrača:");
                System.out.println("------------------");
                for (Igrac igrac : igraci) {
                    System.out.println(igrac.getIme() + ": " + igrac.getBrojPobjeda() + " pobjeda, " + igrac.getBrojNerijesenih() + " neriješenih, " + igrac.getBrojPoraza() + " poraza");
                }
            } else if (cl.hasOption(dodajIgrace.getOpt()) || cl.hasOption(dodajIgrace.getLongOpt())) {
                IgracManager igracManager = new IgracManager();
                System.out.println("Unesite podatke za novog igrača:");
                System.out.print("Ime: ");
                String name = System.console().readLine();
                Igrac igrac = new Igrac();
                igrac.setIme(name);
                igrac.setBrojPobjeda(0);
                igrac.setBrojPoraza(0);
                igrac.setBrojNerijesenih(0);
                igracManager.add(igrac);
                System.out.println("Igrač " + name + " uspješno dodan u bazu!");
            } else {
                printFormattedOptions(options);
            }
        } catch (ParseException e) {
            System.err.println("Neispravan argument!");
            printFormattedOptions(options);
        }
    }

}

