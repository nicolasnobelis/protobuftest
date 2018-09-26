import com.google.protobuf.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;

public class ProtoBufTest {
    private static final Logger logger = LoggerFactory.getLogger( ProtoBufTest.class );

    public static void main(String[] args) {
        logger.info( "Creating the artist" );

        LocalDate birthdate = LocalDate.of( 1977, Month.JANUARY, 12 );
        long birthDateMillis = Instant.from( birthdate.atStartOfDay().atOffset( ZoneOffset.UTC ) ).toEpochMilli();
        Timestamp birthDateBuilder = Timestamp.newBuilder()
                .setSeconds( birthDateMillis / 1000 )
                .build();

        MusicProto.Artist artist = MusicProto.Artist.newBuilder()
                .setLastname( "Batlik" )
                .setBirthDate( birthDateBuilder )
                .build();
        logger.info( "Artist built : {}", artist );

        byte[] serialized = artist.toByteArray();

    }
}
