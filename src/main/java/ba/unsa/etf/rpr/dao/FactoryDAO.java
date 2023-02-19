package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs.
 */
public class FactoryDAO {
    private static final IgracDAO igracDAO = IgracDAOSql.getInstance();
    private static final MecDAO mecDAO = MecDAOSql.getInstance();
    private static final TipDAO tipDAO = TipDAOSql.getInstance();
    private FactoryDAO(){
    }

    /**
     * Igrac dao igrac dao.
     *
     * @return the igrac dao
     */
    public static IgracDAO igracDAO(){
        return igracDAO;
    }

    /**
     * Mec dao mec dao.
     *
     * @return the mec dao
     */
    public static MecDAO mecDAO(){
        return mecDAO;
    }

    /**
     * Tip dao tip dao.
     *
     * @return the tip dao
     */
    public static TipDAO tipDAO(){
        return tipDAO;
    }
}
