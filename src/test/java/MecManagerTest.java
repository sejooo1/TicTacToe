import ba.unsa.etf.rpr.business.MecManager;
import ba.unsa.etf.rpr.dao.MecDAOSql;
import ba.unsa.etf.rpr.domain.Mec;
import ba.unsa.etf.rpr.exceptions.MojException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class MecManagerTest {
    private MecManager mecManager;
    private Mec mec;
    private MecDAOSql mecDAOSQLMock;
    private List<Mec> mecevi;

    @BeforeEach
    public void priprema() {
        mec = new Mec();
        mec.setIdX(1);
        mec.setIdX(2);
        mec.setIdTipa(1);

        mecDAOSQLMock = Mockito.mock(MecDAOSql.class);
        mecevi = new ArrayList<>();
        mecevi.addAll(Arrays.asList(mec));
        mecManager = new MecManager();
    }



    @Test
    public void testGetById(){
        try {
            Mec mec = mecManager.getById(1);
            assertEquals(1, mec.getIdX());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testDajPobjedeIgraca(){
        try {
            List<Mec> mecevi = mecManager.dajPobjedeIgraca(1);
            assertEquals(1, mecevi.get(0).getIdX());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testGetAllMock() throws MojException {
        when(mecDAOSQLMock.getAll()).thenReturn(mecevi);


        try {
            List<Mec> meceviNovi = mecDAOSQLMock.getAll();
            assertEquals(1, meceviNovi.size());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testUpdateMock() throws MojException {
        when(mecDAOSQLMock.getAll()).thenReturn(mecevi);


        try {
            List<Mec> noviMecevi = mecDAOSQLMock.getAll();
            noviMecevi.get(0).setIdTipa(2);
            mecDAOSQLMock.update(noviMecevi.get(0));
            List<Mec> novi = mecDAOSQLMock.getAll();
            assertEquals(2, novi.get(0).getIdTipa());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testAddMock() throws MojException {
        when(mecDAOSQLMock.getAll()).thenReturn(mecevi);


        try {
            mecDAOSQLMock.add(mec);
            mecevi.add(mec);
            List<Mec> novi = mecDAOSQLMock.getAll();
            assertEquals(2, novi.size());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testDeleteMock() throws MojException {
        when(mecDAOSQLMock.getAll()).thenReturn(mecevi);


        try {
            mecDAOSQLMock.delete(1);
            mecevi.remove(0);
            List<Mec> novi = mecDAOSQLMock.getAll();
            assertEquals(0, novi.size());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }
}
