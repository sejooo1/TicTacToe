import ba.unsa.etf.rpr.business.IgracManager;
import ba.unsa.etf.rpr.dao.IgracDAOSql;
import ba.unsa.etf.rpr.domain.Igrac;
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

public class IgracManagerTest {
    private IgracManager igracManager;
    private Igrac igrac;
    private IgracDAOSql igracDAOSQLMock;
    private List<Igrac> igraci;

    @BeforeEach
    public void priprema() {
        igrac = new Igrac();
        igrac.setIme("Test");
        igrac.setId(4);

        igracDAOSQLMock = Mockito.mock(IgracDAOSql.class);
        igraci = new ArrayList<>();
        igraci.addAll(Arrays.asList(new Igrac("Igrac1"), new Igrac("Igrac2"), new Igrac("Igrac3"), new Igrac("Igrac4")));
        igracManager = new IgracManager();
    }

    @Test
    public void testGetAll(){
        try {
            List<Igrac> igraci = igracManager.getAll();
            assertEquals(3, igraci.size());
            assertEquals("Sead", igraci.get(0).getIme());
            assertEquals("Emir", igraci.get(1).getIme());
            assertEquals("Emina", igraci.get(2).getIme());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testGetById(){
        try {
            Igrac igrac = igracManager.getById(1);
            assertEquals("Sead", igrac.getIme());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testDajPoImenu(){
        try {
            List<Igrac> igrac = igracManager.dajPoImenu("Sead");
            assertEquals(1, igrac.size());
            assertEquals("Sead", igrac.get(0).getIme());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testGetAllMock() throws MojException {
        List<Igrac> mockedIgraci = new ArrayList<>();
        mockedIgraci.addAll(Arrays.asList(new Igrac("MockedIgrac1"), new Igrac("MockedIgrac2"), new Igrac("MockedIgrac3")));


            when(igracDAOSQLMock.getAll()).thenReturn(mockedIgraci);


        try {
            List<Igrac> igraci = igracDAOSQLMock.getAll();
            assertEquals(3, igraci.size());
            assertEquals("MockedIgrac1", igraci.get(0).getIme());
            assertEquals("MockedIgrac2", igraci.get(1).getIme());
            assertEquals("MockedIgrac3", igraci.get(2).getIme());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testUpdateMock() throws MojException {
        List<Igrac> mockedIgraci = new ArrayList<>();
        mockedIgraci.addAll(Arrays.asList(new Igrac("MockedIgrac1"), new Igrac("MockedIgrac2"), new Igrac("MockedIgrac3")));


        when(igracDAOSQLMock.getAll()).thenReturn(mockedIgraci);


        try {
            List<Igrac> igraci = igracDAOSQLMock.getAll();
            igraci.get(0).setIme("novo ime");
            igracDAOSQLMock.update(igraci.get(0));
            List<Igrac> novi = igracDAOSQLMock.getAll();
            assertEquals("novo ime", novi.get(0).getIme());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testAddMock() throws MojException {
        List<Igrac> mockedIgraci = new ArrayList<>();
        mockedIgraci.addAll(Arrays.asList(new Igrac("MockedIgrac1"), new Igrac("MockedIgrac2"), new Igrac("MockedIgrac3")));


        when(igracDAOSQLMock.getAll()).thenReturn(mockedIgraci);


        try {
            igracDAOSQLMock.add(igrac);
            mockedIgraci.add(igrac);
            List<Igrac> novi = igracDAOSQLMock.getAll();
            assertEquals("Test", novi.get(3).getIme());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void testDeleteMock() throws MojException {
        List<Igrac> mockedIgraci = new ArrayList<>();
        mockedIgraci.addAll(Arrays.asList(new Igrac("MockedIgrac1"), new Igrac("MockedIgrac2"), new Igrac("MockedIgrac3")));


        when(igracDAOSQLMock.getAll()).thenReturn(mockedIgraci);


        try {
            igracDAOSQLMock.delete(2);
            mockedIgraci.remove(2);
            List<Igrac> novi = igracDAOSQLMock.getAll();
            assertEquals(2, novi.size());
        } catch (MojException e) {
            Assertions.fail(e.getMessage());
        }
    }


}

