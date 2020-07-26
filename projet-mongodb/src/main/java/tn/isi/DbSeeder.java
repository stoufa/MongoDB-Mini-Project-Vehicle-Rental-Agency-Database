package tn.isi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tn.isi.dao.AdministrateurRepository;
import tn.isi.dao.ClientRepository;
import tn.isi.dao.CompteRepository;
import tn.isi.dao.LocaliteRepository;
import tn.isi.dao.ReservationRepository;
import tn.isi.dao.Type_vehRepository;
import tn.isi.dao.VehiculeRepository;
import tn.isi.entities.Administrateur;
import tn.isi.entities.Client;
import tn.isi.entities.Compte;
import tn.isi.entities.Localite;
import tn.isi.entities.QCompte;
import tn.isi.entities.QLocalite;
import tn.isi.entities.QReservation;
import tn.isi.entities.QType_veh;
import tn.isi.entities.QVehicule;
import tn.isi.entities.Reservation;
import tn.isi.entities.Type_veh;
import tn.isi.entities.Vehicule;

import com.querydsl.core.types.dsl.BooleanExpression;

@Component
public class DbSeeder implements CommandLineRunner {

    private AdministrateurRepository administrateurRepository;
    private ClientRepository         clientRepository;
    private CompteRepository         compteRepository;
    private LocaliteRepository       localiteRepository;
    private ReservationRepository    reservationRepository;
    private Type_vehRepository       type_vehRepository;
    private VehiculeRepository       vehiculeRepository;

    public DbSeeder(
            AdministrateurRepository administrateurRepository,
            ClientRepository clientRepository,
            CompteRepository compteRepository,
            LocaliteRepository localiteRepository,
            ReservationRepository reservationRepository,
            Type_vehRepository type_vehRepository,
            VehiculeRepository vehiculeRepository ) {
        this.administrateurRepository = administrateurRepository;
        this.compteRepository = compteRepository;
        this.localiteRepository = localiteRepository;
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.type_vehRepository = type_vehRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @Override
    public void run( String... args ) throws Exception {
        // drop all of the data
        this.type_vehRepository.deleteAll();
        this.localiteRepository.deleteAll();
        this.vehiculeRepository.deleteAll();
        this.reservationRepository.deleteAll();
        this.clientRepository.deleteAll();
        this.administrateurRepository.deleteAll();
        this.compteRepository.deleteAll();

        // Compte -------------------
        Compte c1 = new Compte( "l1", "m1" );
        Compte c2 = new Compte( "l2", "m2" );
        Compte c3 = new Compte( "l3", "m3" );

        // Type_veh -------------------
        Type_veh t1 = new Type_veh( "t1", 50 );
        Type_veh t2 = new Type_veh( "t2", 60 );
        Type_veh t3 = new Type_veh( "t3", 70 );

        // Localite -------------------
        Localite l1 = new Localite( "l1" );
        Localite l2 = new Localite( "l2" );
        Localite l3 = new Localite( "l3" );

        // add to the database
        this.type_vehRepository.save( Arrays.asList( t1, t2, t3 ) );
        this.localiteRepository.save( Arrays.asList( l1, l2, l3 ) );
        this.compteRepository.save( Arrays.asList( c1, c2, c3 ) );

        // Administrateur -------------------
        QCompte qCompte = new QCompte( "3" );
        BooleanExpression b3 = qCompte.login.eq( "l1" );
        BooleanExpression b4 = qCompte.login.eq( "l2" );
        BooleanExpression b5 = qCompte.login.eq( "l3" );
        c1 = this.compteRepository.findOne( b3 );
        c2 = this.compteRepository.findOne( b4 );
        c3 = this.compteRepository.findOne( b5 );
        Administrateur a1 = new Administrateur( "a1", "a1", "m1", "t1", c1.getCode_compte() );
        Administrateur a2 = new Administrateur( "a2", "a2", "m2", "t2", c2.getCode_compte() );
        Administrateur a3 = new Administrateur( "a3", "a3", "m3", "t3", c3.getCode_compte() );

        // add to the database
        this.administrateurRepository.save( Arrays.asList( a1, a2, a3 ) );

        // Vehicule -------------------
        QType_veh qType_veh = new QType_veh( "1" );
        BooleanExpression b1 = qType_veh.nom_type.eq( "t1" );
        t1 = this.type_vehRepository.findOne( b1 );

        QLocalite qLocalite = new QLocalite( "2" );
        BooleanExpression b2 = qLocalite.nom_local.eq( "l1" );
        l1 = this.localiteRepository.findOne( b2 );
        Vehicule v1 = new Vehicule( "m1", "p1", 4, t1.getCode_type(), l1.getCode_local() );

        this.vehiculeRepository.save( v1 );

        // Reservation -------------------
        DateFormat df = new SimpleDateFormat( "dd/MM/yyyy" );
        QVehicule qVehicule = new QVehicule( "7" );
        BooleanExpression b7 = qVehicule.nombre_places.gt( 2 );
        List<String> res = new ArrayList<>();
        List<Vehicule> vList = (List<Vehicule>) this.vehiculeRepository.findAll( b7 );
        for ( Vehicule v : vList ) {
            res.add( v.getCode_local() );
        }
        Reservation r1 = new Reservation( df.parse( "31/12/2017" ), "e1", "d1", df.parse( "31/12/2017" ), "", 2,
                res );
        this.reservationRepository.save( r1 );

        // Client -------------------
        QReservation qReservation = new QReservation( "4" );
        BooleanExpression b6 = qReservation.nbr_voyageur.eq( 2 );
        List<String> res2 = new ArrayList<>();
        List<Reservation> vList2 = (List<Reservation>) this.reservationRepository.findAll( b6 );
        for ( Reservation r : vList2 ) {
            res2.add( r.getCode_res() );
        }
        Client cl1 = new Client( "c1", "a1", "t1", "m1", res2 );
        this.clientRepository.save( cl1 );

    }
}
