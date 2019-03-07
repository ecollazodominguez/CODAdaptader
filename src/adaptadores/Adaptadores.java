package adaptadores;

public class Adaptadores {

    public static void main(String[] args) {
        MediaPlayer player = new MP3();
        player.play("file.mp3");
        player = new FormatAdapter(new MP4());
        player.play("file.mp4");
        player = new FormatAdapter(new VLC());
        player.play("file.avi");
        player = new FormatAdapter(new MKV());
        player.play("file.mkv");
    }

    private static class FormatAdapter implements MediaPlayer {

        private MediaPackage media;
        //instanciamos MediaDivX
        private MediaDivX mediaX;

        public FormatAdapter(MediaPackage m) {
            media = m;
        }
        //creamos constructor que reciba el objeto MediaDivX a convertir
        public FormatAdapter(MediaDivX x) {
            mediaX = x;
        }

        @Override
        //si media es nulo aplica la otra propiedad, en este caso la unica que es el convertidor DivX
        public void play(String filename) {
            if (media != null){
            System.out.print("Using Adapter --> ");
            media.playFile(filename);
            }else{
            System.out.print("Using Adapter DivX --> ");
            mediaX.playFilm(filename);
            }
        }
        
    }
}
