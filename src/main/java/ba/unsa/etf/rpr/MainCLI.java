package ba.unsa.etf.rpr;

import org.apache.commons.cli.Option;

public class MainCLI {
    private static final Option novaIgra = new Option("ni", "nova-igra", false, "Započinje novu igru!");
    private static final Option statistika = new Option("s", "statistika", false, "Statistika igrača");
    private static final Option dodajIgrace = new Option("di", "dodaj-igrace", false, "Dodaj nove igrače u bazu");
}
