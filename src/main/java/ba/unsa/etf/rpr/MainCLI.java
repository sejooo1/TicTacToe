package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.IgracManager;
import ba.unsa.etf.rpr.domain.Igrac;
import org.apache.commons.cli.*;

import java.io.PrintWriter;
import java.util.List;

public class MainCLI {
    private static final Option novaIgra = new Option("n", "nova-igra", false, "Započinje novu igru!");
    private static final Option statistika = new Option("s", "statistika", false, "Statistika igrača");
    private static final Option dodajIgrace = new Option("d", "dodaj-igrace", false, "Dodaj nove igrače u bazu");

    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar TicTacToe.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }

    public static Options addOptions() {
        Options options = new Options();
        options.addOption(novaIgra);
        options.addOption(statistika);
        options.addOption(dodajIgrace);
        return options;
    }

    public static void main(String[] args) throws Exception{
        Options options = addOptions();

        CommandLineParser commandLineParser = new DefaultParser();

        try {
            CommandLine cl = commandLineParser.parse(options, args);

            if (cl.hasOption(novaIgra.getOpt()) || cl.hasOption(novaIgra.getLongOpt())) {

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

