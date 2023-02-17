package ba.unsa.etf.rpr.dao;

public class FactoryDAO {
    private static final IgracDAO igracDAO = IgracDAOSql.getInstance();
    private static final MecDAO mecDAO = MecDAOSql.getInstance();
    private static final TipDAO tipDAO = TipDAOSql.getInstance();
    private FactoryDAO(){
    }

    public static IgracDAO igracDAO(){
        return igracDAO;
    }

    public static MecDAO mecDAO(){
        return mecDAO;
    }

    public static TipDAO tipDAO(){
        return tipDAO;
    }
}
