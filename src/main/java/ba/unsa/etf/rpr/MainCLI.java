package ba.unsa.etf.rpr;

import org.apache.commons.cli.*;

import java.io.PrintWriter;

public class MainCLI {
    private static final Option novaIgra = new Option("ni", "nova-igra", false, "Započinje novu igru!");
    private static final Option statistika = new Option("s", "statistika", false, "Statistika igrača");
    private static final Option dodajIgrace = new Option("di", "dodaj-igrace", false, "Dodaj nove igrače u bazu");

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

    }
}
