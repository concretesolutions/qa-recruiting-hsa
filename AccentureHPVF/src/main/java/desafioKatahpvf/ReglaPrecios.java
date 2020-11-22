package desafioKatahpvf;

import java.util.Optional;

interface ReglaPrecios extends precio {

  
    Optional<contPrecios> optimize(contPrecios total);
}
